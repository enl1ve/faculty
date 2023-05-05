package ua.com.faculty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.faculty.entity.Student;
import ua.com.faculty.entity.User;
import ua.com.faculty.repository.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getStudentByUser(User users) {
        return studentRepository.findByUser(users);
    }
}
