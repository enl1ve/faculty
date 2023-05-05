package ua.com.faculty.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.faculty.bl.Cart;
import ua.com.faculty.entity.Category;
import ua.com.faculty.entity.Faculty;
import ua.com.faculty.service.FacultyService;

import java.util.List;

@Controller
public class FacultyController {
    private final FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }


    @GetMapping("/category/{id}")
    public String getAllRoutesByCategory(@PathVariable(name = "id") Category category,
                                         Model model){

        List<Faculty> routes = facultyService.getFacultyByCategory(category);
        model.addAttribute("allRoutesByCategory", routes);

        return "routesByCategory";
    }



    @PostMapping("/cart")
    public String addNewItemToCart(@RequestParam(name = "id") Faculty faculty,
                                   HttpServletRequest request) {


        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        if(cart == null) {
            cart = new Cart();
        }

        cart.addNewItemToCart(faculty);

        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String getPageCart(HttpServletRequest request,
                              Model model) {
        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
        }

        model.addAttribute("itemCart", cart.getCart());

        return "cart";
    }

    @PostMapping("/deleteItem")
    public String deleteItemCart (@RequestParam(name="id") Faculty faculty,
                                  HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart==null) {
            cart = new Cart();
        }

        cart.deleteItem(faculty);


        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }

    @GetMapping("/login")
    public String getPageLogin() {
        return "login";
    }
}
