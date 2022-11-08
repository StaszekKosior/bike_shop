package pl.bikes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.bikes.model.Order;
import pl.bikes.model.Product;
import pl.bikes.model.User;
import pl.bikes.repository.OrderRepository;
import pl.bikes.repository.ProductRepository;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final HttpSession session;

    @RequestMapping("/summary")
    public String orderSummary() {

        return "";
    }

    @RequestMapping("/finalize")
    public String orderFinalize() {
        Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cartContents");
        User user = (User) session.getAttribute("loggedUser");
        Double value = (Double) session.getAttribute("cartValue");
        orderRepository.save(new Order(user, cart, value));
        productUpdate();

        session.removeAttribute("cartContents");
        return "redirect:/";
    }

    private void productUpdate() {
        Map<Product, Integer> map = (Map<Product, Integer>) session.getAttribute("cartContents");
        for (Map.Entry<Product, Integer> entry : map.entrySet()) {
            Product product = entry.getKey();
            Integer value = entry.getValue();
            product.setQuantity(product.getQuantity() - value);
            productRepository.save(product);
        }
    }

}
