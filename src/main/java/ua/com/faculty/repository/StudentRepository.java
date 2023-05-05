package ua.com.faculty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.faculty.entity.Student;
import ua.com.faculty.entity.User;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByUser (User user);
}
