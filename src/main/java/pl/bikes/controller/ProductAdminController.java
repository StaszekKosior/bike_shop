package pl.bikes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.bikes.model.Accessory;
import pl.bikes.model.Bike;
import pl.bikes.model.Category;
import pl.bikes.model.Product;
import pl.bikes.repository.AccessoryRepository;
import pl.bikes.repository.BikeRepository;
import pl.bikes.repository.CategoryRepository;
import pl.bikes.repository.ProductRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/products")
public class ProductAdminController {

    private final CategoryRepository categoryRepository;
    private final BikeRepository bikeRepository;
    private final ProductRepository productRepository;
    private final AccessoryRepository accessoryRepository;


    @RequestMapping(value = "/add/bike", method = RequestMethod.GET)
    public String formBike(Model model) {
        model.addAttribute("bike", new Bike());
        return "/products/add-bike";
    }

    @RequestMapping(value = "/add/bike", method = RequestMethod.POST)
    public String submitBike(@Valid @ModelAttribute Bike bike, BindingResult result) {
        if (result.hasErrors()) {
            return "/products/add-bike";
        } else {
        bike.setCategory(categoryRepository.findFirstById(1L));
        productRepository.save(bike);
        }
        return "redirect:/";
    }
    @RequestMapping(value = "/add/accessory", method = RequestMethod.GET)
    public String formAccessory(Model model) {
        model.addAttribute("accessory", new Accessory());
        return "/products/add-accessory";
    }

    @RequestMapping(value = "/add/accessory", method = RequestMethod.POST)
    public String submitAccessory(@Valid @ModelAttribute Accessory accessory, BindingResult result) {
        if (result.hasErrors()) {
            return "/products/add-accessory";
        }
        productRepository.save(accessory);

        return "redirect:/";
    }

    @RequestMapping(value = "/edit/bike", method = RequestMethod.GET)
    public String editBike(@RequestParam("id") Long id, Model model) {
        model.addAttribute("bike", bikeRepository.findById(id));
        return "/products/add-bike";
    }

    @RequestMapping(value = "/edit/bike", method = RequestMethod.POST)
    public String editBikeSubmit(@Valid @ModelAttribute Bike bike, BindingResult result) {
        if (result.hasErrors()) {
            return "/products/add-bike";
        }
        bike.setCategory(categoryRepository.findFirstById(1L));
        bikeRepository.save(bike);
        return "redirect:/products/details/" + bike.getId();
    }
    @RequestMapping(value = "/edit/accessory", method = RequestMethod.GET)
    public String editAccessory(@RequestParam("id") Long id, Model model) {
        model.addAttribute("accessory", accessoryRepository.findById(id));
        return "/products/add-accessory";
    }

    @RequestMapping(value = "/edit/accessory", method = RequestMethod.POST)
    public String editAccessorySubmit(@Valid @ModelAttribute Accessory accessory, BindingResult result) {
        if (result.hasErrors()) {
            return "/products/add-accessory";
        }
        accessoryRepository.save(accessory);
        return "redirect:/products/details/" + accessory.getId();
    }

    @RequestMapping(value = "/deleteConfirm", method = RequestMethod.GET)
    public String deleteConfirm(@RequestParam Long id, Model model) {
        model.addAttribute("product", productRepository.findFirstById(id));
        return "/products/delete-confirm";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id) {
        productRepository.deleteById(id);
        return "redirect:/products";
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryRepository.findAll();
    }
    @ModelAttribute("bikes")
    public List<Bike> bikes() {
        return bikeRepository.findAll();
    }
}
