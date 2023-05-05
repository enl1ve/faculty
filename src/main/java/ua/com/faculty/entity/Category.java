package ua.com.faculty.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "categories")
    private List<Faculty> routesList;
}
