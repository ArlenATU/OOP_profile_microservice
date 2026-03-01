package atu.ie.dands_project.repository;

// Importing the User entity
import atu.ie.dands_project.model.User;

// Importing JpaRepository which provides built-in CRUD operations
import org.springframework.data.jpa.repository.JpaRepository;

// Importing Optional to safely handle possible null values
import java.util.Optional;

/*
 * This interface represents the Repository layer for User.
 *
 * It extends JpaRepository, which means:
 * Spring automatically provides standard database operations such as:
 * - save()
 * - findById()
 * - findAll()
 * - deleteById()
 * - update()
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /*
     * Custom query method.
     *
     * Spring Data JPA automatically generates a SQL query
     * based on the method name.
     *
     * This method searches for a user by their email.
     *
     * It returns Optional<User> to avoid NullPointerException
     * if no user is found.
     */
    Optional<User> findByEmail(String email);
}