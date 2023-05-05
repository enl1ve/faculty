package ua.com.faculty.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data

@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> usersSet;
}
