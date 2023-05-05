package ua.com.faculty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.faculty.entity.Faculty;
import ua.com.faculty.entity.Rate;

import java.util.List;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {
}
