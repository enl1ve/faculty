package ua.com.faculty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.faculty.entity.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
}
