package pl.bikes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.bikes.model.Order;
import pl.bikes.model.User;
import pl.bikes.repository.BikeRepository;
import pl.bikes.repository.OrderRepository;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final BikeRepository bikeRepository;
    private final OrderRepository orderRepository;
    private final HttpSession session;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("lastAddedBike", bikeRepository.findLast());
        if (session.getAttribute("loggedUser") != null) {
            User user = (User) session.getAttribute("loggedUser");
            Order order = orderRepository.findLast(user);
            if (order != null) {
                model.addAttribute("lastOrder", order);
            }
        }
        return "home";
    }

}