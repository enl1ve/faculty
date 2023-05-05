package ua.com.faculty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.faculty.service.RateManagerService;

@Controller
public class RateManagerController {
    private final RateManagerService rateManagerService;

    @Autowired
    public RateManagerController(RateManagerService rateManagerService) {
        this.rateManagerService = rateManagerService;
    }

    @GetMapping("/ordermanager")
    public String getAllOrderPage(Model model){
        model.addAttribute("order1", rateManagerService.findListOrderByStatus(0));
        model.addAttribute("order2", rateManagerService.findListOrderByStatus(0));
        return "orderAdmin";
    }
}
