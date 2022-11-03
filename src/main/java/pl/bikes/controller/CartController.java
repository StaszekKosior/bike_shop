package pl.bikes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pl.bikes.dao.BikeDao;
import pl.bikes.model.Bike;
import pl.bikes.model.Cart;
import pl.bikes.model.CartItem;
import pl.bikes.model.Product;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final BikeDao bikeDao;
    private final HttpSession session;

    @RequestMapping("")
    public String cart(Model model) {
        if (session.getAttribute("cartContents") == null) {

        } else {
            Map<Bike, Integer> cart = (Map<Bike, Integer>) session.getAttribute("cartContents");
            model.addAttribute("cartItems", cart)
                    .addAttribute("cartValue", cartValue())
                    .addAttribute("numberOfProducts", numberOfProducts());
        }
        return "cart/cart";
    }

    @RequestMapping(value = "/addToCart/{id}/{quantity}", method = RequestMethod.GET)
    public String add(@PathVariable Integer id, @PathVariable Integer quantity) {
        Bike productToAdd = bikeDao.findById(id);
        Map<Bike, Integer> cart = new HashMap<>();
        if (session.getAttribute("cartContents") == null) {
            session.setAttribute("cartContents", cart);
        } else {
            cart = (Map<Bike, Integer>) session.getAttribute("cartContents");
        }
        addToCart(productToAdd, quantity, cart);
        return "redirect:/products";
    }

    @RequestMapping(value = "/removeFromCart/{key}", method = RequestMethod.GET)
    public String removeFromCart(@PathVariable Long key) {
        Map<Bike, Integer> cart = (Map<Bike, Integer>) session.getAttribute("cartContents");
        cart.remove(bikeDao.findById(key));
        return "redirect:/cart";
    }


    @RequestMapping(value = "/cartChange", method = RequestMethod.GET)
    public String cartChange(@RequestParam Long id, @RequestParam Integer value) {
        Map<Bike, Integer> cart = (Map<Bike, Integer>) session.getAttribute("cartContents");
        if (value <= 0) {
            value = 1;
        } else if (value > bikeDao.findById(id).getQuantity()){
            value = bikeDao.findById(id).getQuantity();
        }
        cart.put(bikeDao.findById(id), value);
        return "redirect:/cart";
    }


    private void addToCart(Bike productToAdd, Integer quantity, Map<Bike, Integer> map) {

        Map<Bike, Integer> mapTemp = (Map<Bike, Integer>) session.getAttribute("cartContents");
        if (mapTemp.containsKey(productToAdd)) {
            mapTemp.put(productToAdd, (mapTemp.get(productToAdd)) + quantity);
        } else {
            mapTemp.put(productToAdd, quantity);
        }
    }

    private Integer numberOfProducts() {
        Map<Bike, Integer> cart = (Map<Bike, Integer>) session.getAttribute("cartContents");
        Integer numberOfProducts = 0;
        for (Map.Entry<Bike, Integer> entry : cart.entrySet()) {
            Integer value = entry.getValue();
            numberOfProducts += value;
        }
        return numberOfProducts;
    }

    private Double cartValue() {
        Map<Bike, Integer> cart = (Map<Bike, Integer>) session.getAttribute("cartContents");
        Double cartValue = 0.0;
        for (Map.Entry<Bike, Integer> entry : cart.entrySet()) {
            Bike key = entry.getKey();
            Integer value = entry.getValue();
            cartValue += key.getPrice() * value;
        }
        return cartValue;
    }

}