package ua.com.faculty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.faculty.entity.RateHasFaculty;

@Repository
public interface RateHasFacultyRepository extends JpaRepository<RateHasFaculty, Long> {
}
