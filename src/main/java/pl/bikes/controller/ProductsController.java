package pl.bikes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.bikes.dao.AccessoryDao;
import pl.bikes.dao.BikeDao;
import pl.bikes.repository.AccessoryRepository;
import pl.bikes.repository.BikeRepository;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductsController {

    private final BikeDao bikeDao;
    private final BikeRepository repositpry;

    private final AccessoryDao accessoryDao;

    private final AccessoryRepository accessoryRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("bikes", repositpry.findAll());
        model.addAttribute("Accessories", accessoryRepository.findAll());
        return "/products/products-list";
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String bikeDetails(@PathVariable Long id, Model model) {
        model.addAttribute("bike", bikeDao.findById(id));
        return "/products/product-details";
    }
    @RequestMapping(value = "/details/accessory/{id}", method = RequestMethod.GET)
    public String accessoryDetails(@PathVariable Long id, Model model) {
        model.addAttribute("accessory", accessoryDao.findById(id));
        return "/products/product-details";
    }


}
