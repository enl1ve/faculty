package ua.com.faculty.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data

@Entity
@Table(name = "rate")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int grate;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToMany(mappedBy = "rate")
    private List<RateHasFaculty> rateHasFaculties;
}
