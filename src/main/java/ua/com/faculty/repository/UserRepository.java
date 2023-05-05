package ua.com.faculty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.faculty.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
