package ua.com.faculty.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ua.com.bus_cash.entity.Category;
import ua.com.bus_cash.entity.Routes;
import ua.com.bus_cash.repository.RoutesRepository;
import ua.com.faculty.entity.Faculty;
import ua.com.faculty.repository.FacultyRepository;

import java.util.List;

@Service
public class RoutestService {
    private final FacultyRepository facultyRepository;

    @Autowired
    public RoutestService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }


    @Cacheable(cacheNames = "routes", key = "#category.getId()")
    public List<Faculty> getFacultyByCategory(Faculty category){
        return facultyRepository.findAllByCategories(category);
    }
}
