package ua.com.faculty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.faculty.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByUsernameAndPassword(String username, String password);

    User findByUsernameAndPassword(String username, String password);

    List<User> findAllByUsername(String name);

    User findByUsername(String name);

}
