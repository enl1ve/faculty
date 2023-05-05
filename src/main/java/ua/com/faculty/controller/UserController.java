package ua.com.faculty.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.bus_cash.bl.Cart;
import ua.com.bus_cash.bl.ItemCart;
import ua.com.bus_cash.entity.Client;
import ua.com.bus_cash.entity.Order;
import ua.com.bus_cash.entity.OrderHasRoutes;
import ua.com.bus_cash.entity.Users;
import ua.com.bus_cash.repository.ClientRepository;
import ua.com.bus_cash.repository.OrderHasRoutesRepository;
import ua.com.bus_cash.repository.OrderRepository;
import ua.com.bus_cash.repository.UsersRepository;
import ua.com.bus_cash.service.ClientService;
import ua.com.bus_cash.service.UsersService;

import java.util.Date;

@Controller
public class UserController {
    private final UsersRepository usersRepository;
    private final UsersService usersService;
    private final ClientService clientService;
    private final ClientRepository clientRepository;
    private final OrderRepository orderRepository;
    private final OrderHasRoutesRepository orderHasRoutesRepository;


    @Autowired
    public UserController(UsersRepository usersRepository, UsersService usersService, ClientService clientService, ClientRepository clientRepository, OrderRepository orderRepository, OrderHasRoutesRepository orderHasRoutesRepository) {
        this.usersRepository = usersRepository;
        this.usersService = usersService;
        this.clientService = clientService;
        this.clientRepository = clientRepository;
        this.orderRepository = orderRepository;
        this.orderHasRoutesRepository = orderHasRoutesRepository;
    }

    @PostMapping("/login")
    public String getPageOrder(@RequestParam(name = "username") String users,
                               @RequestParam(name = "password") String password,
                               HttpServletRequest request){

        if(usersService.getLogicByUsernameAndPassword(users, password)){

            Users users1 = usersService.getUserByUsernameAndPassword(users, password);
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

        Users user = new Users();
        user.setUsername(username);
        user.setPassword(password);

        usersRepository.save(user);

        Client client = new Client();
        client.setName(name);
        client.setSurname(surname);
        client.setPhone(phone);
        client.setEmail(email);
        client.setUser(user);

        clientRepository.save(client);

        return "login";
    }

    @GetMapping("/order")
    public String getPageOrder(HttpServletRequest request, Model model){


        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");
        Users user = (Users) session.getAttribute("user");

        if(user == null) {
            return "redirect:/";
        }

        if (cart==null) return "redirect:/";

        model.addAttribute("itemCart", cart.getCart());
        model.addAttribute("totalValue", cart.getTotalVal());


        Client client = clientService.getClientByUser(user);

        model.addAttribute("client", client);

        return "order";
    }

    @PostMapping("/order")
    public String saveOrderToDB(@RequestParam(name = "payment") String payment,
                                HttpServletRequest request ){

        HttpSession session = request.getSession();

        Cart cart  = (Cart) session.getAttribute("cart");
        Users user = (Users) session.getAttribute("user");

        Client client = clientService.getClientByUser(user);


        Order order = new Order();
        order.setData_create(new Date());
        order.setClient(client);
        order.setPayment(payment);
        order.setStatus(false);

        Order order1 = orderRepository.save(order);

        // save
        // Order + Id
        // Cart -> List<ItemCart>
        // foreach

        for (ItemCart el : cart.getCart()) {
            orderHasRoutesRepository.save(new OrderHasRoutes(el.getRoutes(), order1));
        }

        return "thank";
    }

    @GetMapping("/thank")
    public String getPageThank() {
        return "thank";
    }


}
