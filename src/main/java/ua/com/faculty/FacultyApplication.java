package ua.com.faculty;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.com.faculty.entity.Roles;
import ua.com.faculty.repository.RolesRepository;

@SpringBootApplication
public class FacultyApplication {

    public static void main(String[] args) {
        SpringApplication.run(FacultyApplication.class, args);
    }

    @Bean
    CommandLineRunner run(RolesRepository roleRepository) {
        return args -> {
            if (roleRepository.findAll().isEmpty()) {
                roleRepository.save(new Roles(1L, "ROLE_User"));
                roleRepository.save(new Roles(2L, "ROLE_Manager"));
                roleRepository.save(new Roles(3L, "ROLE_Admin"));
            }
        };
    }

}
