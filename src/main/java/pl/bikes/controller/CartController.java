package pl.bikes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pl.bikes.model.Bike;
import pl.bikes.model.Product;
import pl.bikes.repository.ProductRepository;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final ProductRepository repository;
    private final HttpSession session;

    @RequestMapping("")
    public String cart(Model model) {
        if (session.getAttribute("cartContents") == null) {

        } else {
            model.addAttribute("cartValue", cartValue())
                    .addAttribute("numberOfProducts", numberOfProducts());
        }
        return "cart/cart";
    }

    @RequestMapping(value = "/addToCart/{id}/{quantity}", method = RequestMethod.GET)
    public String add(@PathVariable Long id, @PathVariable Integer quantity) {
        Product productToAdd = repository.findFirstById(id);
        Map<Product, Integer> cart = new HashMap<>();
        if (session.getAttribute("cartContents") == null) {
            session.setAttribute("cartContents", cart);
        } else {
            cart = (Map<Product, Integer>) session.getAttribute("cartContents");
        }
        addToCart(productToAdd, quantity, cart);
        return "redirect:/products";
    }

    @RequestMapping(value = "/removeFromCart/{key}", method = RequestMethod.GET)
    public String removeFromCart(@PathVariable Long key) {
        Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cartContents");
        cart.remove(repository.findFirstById(key));
        return "redirect:/cart";
    }


    @RequestMapping(value = "/cartChange", method = RequestMethod.POST)
    public String cartChange(@RequestParam Long id, @RequestParam Integer value) {
        Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cartContents");
        if (value <= 0) {
            value = 1;
        } else if (value > repository.findFirstById(id).getQuantity()) {
            value = repository.findFirstById(id).getQuantity();
        }
        cart.put(repository.findFirstById(id), value);
        return "redirect:/cart";
    }


    private void addToCart(Product productToAdd, Integer quantity, Map<Product, Integer> map) {

        Map<Product, Integer> mapTemp = (Map<Product, Integer>) session.getAttribute("cartContents");
        if (mapTemp.containsKey(productToAdd)) {
            mapTemp.put(productToAdd, (mapTemp.get(productToAdd)) + quantity);
        } else {
            mapTemp.put(productToAdd, quantity);
        }
    }

    private Integer numberOfProducts() {
        Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cartContents");
        Integer numberOfProducts = 0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            Integer value = entry.getValue();
            session.setAttribute("numberOfProducts", numberOfProducts);
            numberOfProducts += value;
        }
        return numberOfProducts;
    }

    private Double cartValue() {
        Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cartContents");
        Double cartValue = 0.0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            Product key = entry.getKey();
            Integer value = entry.getValue();
            cartValue += key.getPrice() * value;
        }
        session.setAttribute("cartValue", cartValue);
        return cartValue;
    }

}