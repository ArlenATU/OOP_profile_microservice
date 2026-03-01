package atu.ie.dands_project.service;

// Importing model classes
import atu.ie.dands_project.model.Profile;
import atu.ie.dands_project.model.User;

// Importing repository interfaces
import atu.ie.dands_project.repository.ProfileRepository;
import atu.ie.dands_project.repository.UserRepository;

// Lombok annotation for constructor injection
import lombok.RequiredArgsConstructor;

// Marks this class as a Service component in Spring
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/*
 * @Service
 * Marks this class as part of the Service layer.
 * It contains business logic of the application.
 */
@Service

/*
 * @RequiredArgsConstructor
 * Lombok automatically creates a constructor
 * for all final fields (dependency injection).
 */
@RequiredArgsConstructor
public class UserService {

    /*
     * Repository dependencies.
     * Spring injects these automatically.
     */
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    /*
     * REGISTER METHOD
     * Handles user registration logic.
     */
    public User register(User user) {

        // Set the current date and time when user registers
        user.setCreatedAt(LocalDateTime.now());

        // Save the user to the database
        User savedUser = userRepository.save(user);

        // Automatically create a profile for the new user
        Profile profile = Profile.builder()
                .userId(savedUser.getId())
                .bio("")
                .location("")
                .profilePictureUrl("")
                .build();

        // Save profile in database
        profileRepository.save(profile);

        // Remove password before returning response (security measure)
        savedUser.setPassword(null);

        return savedUser;
    }

    /*
     * LOGIN METHOD
     * Checks if user exists and validates password.
     */
    public String login(String email, String password) {

        return userRepository.findByEmail(email)
                .map(user -> {
                    // Check if password matches
                    if (user.getPassword().equals(password)) {
                        return "Login successful";
                    }
                    return "Invalid password";
                })
                // If user not found
                .orElse("User not found");
    }

    /*
     * GET PROFILE METHOD
     * Retrieves profile by userId.
     */
    public Profile getProfile(Long userId) {

        return profileRepository.findByUserId(userId)
                .orElse(null);
    }

    /*
     * UPDATE PROFILE METHOD
     * Updates existing profile fields.
     */
    public Profile updateProfile(Long userId, Profile updatedProfile) {

        // Find profile by userId
        Profile profile = profileRepository.findByUserId(userId)
                .orElse(null);

        if (profile == null) return null;

        // Update fields
        profile.setBio(updatedProfile.getBio());
        profile.setLocation(updatedProfile.getLocation());
        profile.setProfilePictureUrl(updatedProfile.getProfilePictureUrl());

        // Save updated profile
        return profileRepository.save(profile);
    }

    /*
     * GET ALL USERS METHOD
     * Returns list of all users.
     */
    public List<User> getAllUsers() {

        List<User> users = userRepository.findAll();

        // Remove passwords before returning data
        users.forEach(user -> user.setPassword(null));

        return users;
    }
}