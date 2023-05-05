package ua.com.faculty.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data

@Entity
@Table(name = "faculty")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String teacher;
    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categories;

    @OneToMany(mappedBy = "faculty")
    private List<RateHasFaculty> rateHasFaculties;
}
