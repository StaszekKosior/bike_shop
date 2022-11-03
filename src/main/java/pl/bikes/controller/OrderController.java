package pl.bikes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.bikes.dao.OrderDao;
import pl.bikes.model.Bike;
import pl.bikes.model.Order;
import pl.bikes.model.User;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderDao dao;
    private final HttpSession session;

    @RequestMapping("/summary")
    public String orderSummary() {

        return"";
    }

    @RequestMapping("/finalize")
    public String orderFinalize() {
        Map<Bike, Integer> cart = (Map<Bike, Integer>) session.getAttribute("cartContents");
        User user = (User) session.getAttribute("loggedUser");
        dao.save(new Order(user, cart));
        session.removeAttribute("cartContents");
        return"redirect:/";
    }


}
