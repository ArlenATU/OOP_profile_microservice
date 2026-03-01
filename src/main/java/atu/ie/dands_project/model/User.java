package atu.ie.dands_project.model;

// Importing JPA annotations to map this class to a database table
import jakarta.persistence.*;

// Importing LocalDateTime to store date and time
import java.time.LocalDateTime;

/*
 * @Entity
 * Marks this class as a JPA entity.
 * This means it will be mapped to a table in the database.
 */
@Entity

/*
 * @Table(name = "users")
 * Specifies the name of the database table.
 * We use "users" instead of "user" because "user" is a reserved SQL keyword.
 */
@Table(name = "users")
public class User {

    /*
     * @Id
     * Marks this field as the primary key of the table.
     */
    @Id

    /*
     * @GeneratedValue
     * Automatically generates the ID value using database identity strategy.
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * Username of the user.
     * Stored as a column in the database.
     */
    private String username;

    /*
     * Email of the user.
     */
    private String email;

    /*
     * Password of the user.
     */
    private String password;

    /*
     * @Column(name = "created_at")
     * Maps this Java field to a database column named "created_at".
     */
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    /*
     * REQUIRED empty constructor.
     * JPA requires a no-argument constructor to create objects dynamically.
     */
    public User() {
    }

    // ===== GETTERS =====
    // Getters allow other classes to read private fields.

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // ===== SETTERS =====
    // Setters allow other classes to modify private fields.

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}