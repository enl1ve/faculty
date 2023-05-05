package ua.com.faculty.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.faculty.bl.Cart;
import ua.com.faculty.bl.ItemCart;
import ua.com.faculty.entity.Rate;
import ua.com.faculty.entity.RateHasFaculty;
import ua.com.faculty.entity.Student;
import ua.com.faculty.entity.User;
import ua.com.faculty.repository.RateHasFacultyRepository;
import ua.com.faculty.repository.RateRepository;
import ua.com.faculty.repository.StudentRepository;
import ua.com.faculty.repository.UserRepository;
import ua.com.faculty.service.StudentService;
import ua.com.faculty.service.UsersService;

import java.util.Date;

@Controller
public class UserController {
    private final UserRepository usersRepository;
    private final UsersService usersService;
    private final StudentService studentService;
    private final StudentRepository studentRepository;
    private final RateRepository rateRepository;
    private final RateHasFacultyRepository rateHasFacultyRepository;

    @Autowired
    public UserController(UserRepository usersRepository, UsersService usersService, StudentService studentService, StudentRepository studentRepository, RateRepository rateRepository, RateHasFacultyRepository rateHasFacultyRepository) {
        this.usersRepository = usersRepository;
        this.usersService = usersService;
        this.studentService = studentService;
        this.studentRepository = studentRepository;
        this.rateRepository = rateRepository;
        this.rateHasFacultyRepository = rateHasFacultyRepository;
    }


    @PostMapping("/login")
    public String getPageOrder(@RequestParam(name = "username") String users,
                               @RequestParam(name = "password") String password,
                               HttpServletRequest request){

        if(usersService.getLogicByUsernameAndPassword(users, password)){

            User users1 = usersService.getUserByUsernameAndPassword(users, password);
            HttpSession session = request.getSession();

            session.setAttribute("user", users1);

            return "redirect:/order";
        } else {
            return "redirect:/registration";
        }

    }


    @GetMapping("/registration")
    public String getPageRegistration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String saveNewUser(@RequestParam(name = "name") String name,
                              @RequestParam(name = "surname") String surname,
                              @RequestParam(name = "phone") String phone,
                              @RequestParam(name = "email") String email,
                              @RequestParam(name = "username") String username,
                              @RequestParam(name = "password") String password,
                              HttpServletRequest request) {

        HttpSession session = request.getSession();

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        usersRepository.save(user);

        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setPhone(phone);
        student.setEmail(email);
        student.setUser(user);

        studentRepository.save(student);

        return "login";
    }

    @GetMapping("/order")
    public String getPageOrder(HttpServletRequest request, Model model){


        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");

        if(user == null) {
            return "redirect:/";
        }

        if (cart==null) return "redirect:/";

        model.addAttribute("itemCart", cart.getCart());


        Student student = studentService.getStudentByUser(user);

        model.addAttribute("student", student);

        return "order";
    }

    @PostMapping("/order")
    public String saveOrderToDB(HttpServletRequest request ){

        HttpSession session = request.getSession();

        Cart cart  = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");

        Student student = studentService.getStudentByUser(user);


        Rate rate = new Rate();
        rate.setGrate(0);
        rate.setStudent(student);

        Rate rate1 = rateRepository.save(rate);

        for (ItemCart el : cart.getCart()) {
            rateHasFacultyRepository.save(new RateHasFaculty(el.getFaculty(), rate1));
        }

        return "thank";
    }

    @GetMapping("/thank")
    public String getPageThank() {
        return "thank";
    }


}
