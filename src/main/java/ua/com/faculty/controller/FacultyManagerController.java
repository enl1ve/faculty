package ua.com.faculty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.faculty.entity.Category;
import ua.com.faculty.entity.Faculty;
import ua.com.faculty.service.CategoryManagerService;
import ua.com.faculty.service.FacultyManagerService;

@Controller
public class FacultyManagerController {
    private final FacultyManagerService facultyManagerService;

    private final CategoryManagerService categoryManagerService;

    @Autowired
    public FacultyManagerController(FacultyManagerService facultyManagerService, CategoryManagerService categoryManagerService) {
        this.facultyManagerService = facultyManagerService;
        this.categoryManagerService = categoryManagerService;
    }

    @GetMapping("/productmanager")
    public String getAllProduct(Model model) {
        model.addAttribute("allProduct", facultyManagerService.findAllProduct());
        model.addAttribute("allCategory", categoryManagerService.getCategoryList());
        return "routesAdminPage";
    }


    @PostMapping("/saveNewProduct")
    public String saveNewProductToDB(@RequestParam(value = "name") String name,
                                     @RequestParam(value = "description") String description,
                                     @RequestParam(value = "image") String image,
                                     @RequestParam(value = "teacher") String teacher,
                                     @RequestParam(value = "categoryId") Category category
    ) {

        facultyManagerService.saveNewProductToDB(name, description, teacher, image, category);

        return "redirect:/productmanager";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(
            @RequestParam(value = "id") Long id,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "description") String description,
            @RequestParam(value = "image") String image,
            @RequestParam(value = "teacher") String teacher,
            @RequestParam(value = "categoryId") Category category
    ) {

        facultyManagerService.updateProduct(id, name, description, teacher, image, category);

        return "redirect:/productmanager";
    }


    @PostMapping("/deleteProduct")
    public String deleteProduct(@RequestParam(value = "id") Long id){

        facultyManagerService.deleteProductById(id);

        return "redirect:/productmanager";
    }


    @PostMapping("/deleteAllProduct")
    public String deleteAllProduct(){

        facultyManagerService.deleteAllProduct();

        return "redirect:/productmanager";
    }

    @GetMapping("/productmanager/{id}")
    public String getCategoryPageById(@PathVariable("id") Long id,
                                      Model model){

        Faculty product = facultyManagerService.findProductById(id);
        model.addAttribute("product", product);

        return "productDet";
    }
}
