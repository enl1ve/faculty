package ua.com.faculty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.faculty.entity.Category;
import ua.com.faculty.entity.Faculty;
import ua.com.faculty.repository.FacultyRepository;

import java.util.List;

@Service
public class FacultyManagerService {
    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyManagerService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public void saveNewProductToDB(String name, String description, String image, String teacher, Category category){

        Faculty faculty = new Faculty();
        faculty.setName(name);
        faculty.setDescription(description);
        faculty.setImage(image);
        faculty.setTeacher(teacher);
        faculty.setCategories(category);

        facultyRepository.save(faculty);
    }

    public void updateProduct(Long id, String name, String description, String image, String teacher,Category category){
        Faculty faculty = new Faculty();
        faculty.setId(id);
        faculty.setName(name);
        faculty.setDescription(description);
        faculty.setImage(image);
        faculty.setTeacher(teacher);
        faculty.setCategories(category);

        facultyRepository.save(faculty);
    }


    public void deleteProductById(Long id){
        facultyRepository.deleteById(id);
    }

    public void deleteAllProduct(){
        facultyRepository.deleteAll();
    }

    public List<Faculty> findAllProduct(){
        return facultyRepository.findAll();
    }

    public Faculty findProductById(Long id){
        return facultyRepository.findById(id).get();
    }

    public Faculty findProductByName(String name){
        return facultyRepository.findByName(name);
    }

    public boolean sizeRoutesByCategory(Category category){
        List<Faculty> routes  = facultyRepository.findAllByCategories(category);
        if(routes.size()>0){
            return true;
        } else {
            return false;
        }
    }
}
