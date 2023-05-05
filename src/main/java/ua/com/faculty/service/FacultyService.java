package ua.com.faculty.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ua.com.faculty.entity.Category;
import ua.com.faculty.entity.Faculty;
import ua.com.faculty.repository.FacultyRepository;

import java.util.List;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }


    @Cacheable(cacheNames = "routes", key = "#category.getId()")
    public List<Faculty> getFacultyByCategory(Category category){
        return facultyRepository.findAllByCategories(category);
    }
}
