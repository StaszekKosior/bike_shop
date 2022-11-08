package pl.bikes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.bikes.model.Accessory;
import pl.bikes.repository.AccessoryRepository;
import pl.bikes.repository.BikeRepository;
import pl.bikes.repository.ProductRepository;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final BikeRepository bikeRepository;
    private final AccessoryRepository accessoryRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String allProductsList(Model model) {
        model.addAttribute("bikes", bikeRepository.findAll());
        model.addAttribute("accessories", accessoryRepository.findAll());
        return "/products/products-list";
    }

    @RequestMapping(value = "/bikes", method = RequestMethod.GET)
    public String bikesList(Model model) {
        model.addAttribute("bikes", bikeRepository.findAll());
        return "/products/bikes-list";
    }

    @RequestMapping(value = "/accessories", method = RequestMethod.GET)
    public String accessoriesList(Model model) {
        model.addAttribute("accessories", accessoryRepository.findAll());
        return "/products/accessories-list";
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String bikeDetails(@PathVariable Long id, Model model) {
        model.addAttribute("product", productRepository.findFirstById(id));
        model.addAttribute("accessories", accessoryRepository.findAllByBikeIdEquals(id));
        return "/products/product-details";
    }

}
