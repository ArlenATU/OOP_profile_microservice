package atu.ie.dands_project.model;

import jakarta.persistence.*;
import lombok.*;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String bio;

    private String location;

    private String profilePictureUrl;
}
