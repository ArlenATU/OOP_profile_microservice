package atu.ie.dands_project.model;

// Importing JPA annotations for database mapping
import jakarta.persistence.*;

// Importing Lombok annotations to reduce boilerplate code
import lombok.*;

/*
 * @Entity
 * Marks this class as a JPA entity.
 * This means it will be mapped to a database table.
 */
@Entity

/*
 * @Getter and @Setter
 * Lombok automatically generates getters and setters
 * for all fields at compile time.
 */
@Getter
@Setter

/*
 * @NoArgsConstructor
 * Generates an empty constructor.
 * Required by JPA to create objects dynamically.
 */
@NoArgsConstructor

/*
 * @AllArgsConstructor
 * Generates a constructor with all fields.
 */
@AllArgsConstructor

/*
 * @Builder
 * Enables the Builder pattern, allowing object creation like:
 * Profile.builder().bio("text").location("city").build();
 */
@Builder
public class Profile {

    /*
     * @Id
     * Marks this field as the primary key.
     */
    @Id

    /*
     * @GeneratedValue
     * Automatically generates the ID value in the database.
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * Stores the ID of the associated user.
     * This links the profile to a specific user.
     */
    private Long userId;

    /*
     * Short biography text of the user.
     */
    private String bio;

    /*
     * User's location (city, country, etc.)
     */
    private String location;

    /*
     * URL of the user's profile picture.
     */
    private String profilePictureUrl;
}
