package ua.com.faculty.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String phone;

    private String email;

    @OneToOne
    @MapKey
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    @OneToMany(mappedBy = "student")
    private List<Rate> rateList;
}
