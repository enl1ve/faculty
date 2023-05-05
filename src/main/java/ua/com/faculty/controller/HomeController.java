package ua.com.faculty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/")
    public String getHomePage() {
        return "home";
    }

    @GetMapping("/categories")
    public String getCategoryAdmin(){
        return "categoryAdminPage";
    }
}
