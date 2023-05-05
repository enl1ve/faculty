package ua.com.faculty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.faculty.entity.Student;
import ua.com.faculty.repository.StudentRepository;

@Service
public class CustomerManagerService {
    private final StudentRepository studentRepository;

    @Autowired
    public CustomerManagerService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void saveCustomerToDB(Student student){
        studentRepository.save(student);
    }

    public Student getStudentById (Long id) {
        return studentRepository.getStudentsById(id);
    }
}
