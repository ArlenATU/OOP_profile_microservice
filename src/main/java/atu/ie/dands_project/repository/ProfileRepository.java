package atu.ie.dands_project.repository;

// Importing the Profile entity
import atu.ie.dands_project.model.Profile;

// Importing JpaRepository from Spring Data JPA
import org.springframework.data.jpa.repository.JpaRepository;

// Importing Optional to safely handle possible null results
import java.util.Optional;

/*
 * This interface represents the Repository layer.
 * It is responsible for communicating with the database.
 *
 * By extending JpaRepository, we automatically get:
 * - save()
 * - findById()
 * - findAll()
 * - deleteById()
 * and many more built-in CRUD operations.
 */
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    /*
     * Custom query method.
     *
     * Spring Data JPA automatically generates the SQL query
     * based on the method name.
     *
     * This method finds a Profile by its associated userId.
     *
     * It returns Optional<Profile> to safely handle
     * the case where no profile is found.
     */
    Optional<Profile> findByUserId(Long userId);
}