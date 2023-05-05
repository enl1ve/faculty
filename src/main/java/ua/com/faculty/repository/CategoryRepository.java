package ua.com.faculty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.faculty.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
