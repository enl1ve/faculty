package ua.com.faculty.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
@Table(name = "rate_has_faculty")
public class RateHasFaculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @ManyToOne
    @JoinColumn(name = "rate_id")
    private Rate rate;

    public RateHasFaculty(Faculty faculty, Rate rate) {
        this.faculty = faculty;
        this.rate = rate;
    }
}
