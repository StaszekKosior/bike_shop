package pl.bikes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.bikes.dao.BikeDao;
import pl.bikes.model.Bike;
import pl.bikes.model.Cart;
import pl.bikes.model.CartItem;

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


    @GetMapping("/addToCart/{id}/{quantity}")
    @ResponseBody
    public String add(@PathVariable Integer id, @PathVariable Integer quantity) {

        Bike productToAdd = bikeDao.findById(id);

        String cartContents = (String) session.getAttribute("cartContents");
        Map<Bike, Integer> cart = new HashMap<>();
        if (cartContents == null) {
            session.setAttribute("cartContents", cart);
        } else {
            cart = (Map<Bike, Integer>) session.getAttribute("cartContents");
        }
        addToCart(productToAdd, quantity, cart);



        return "addtocart";
    }

    @RequestMapping("")
    public String cart(Model model) {
        Map<Bike, Integer> cart = (Map<Bike, Integer>) session.getAttribute("cartContents");
        model.addAttribute("cartItems", cart);

        return "cart/cart";
    }

    private void addToCart(Bike productToAdd, Integer quantity, Map<Bike, Integer> map) {

        Map<Bike, Integer> mapTemp = (Map<Bike, Integer>) session.getAttribute("cartContents");
        if (mapTemp.containsKey(productToAdd)){
            mapTemp.put(productToAdd, (mapTemp.get(productToAdd)) + quantity);
        } else {
            mapTemp.put(productToAdd, quantity);
        }
    }
}