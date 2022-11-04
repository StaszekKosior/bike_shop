package pl.bikes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.bikes.model.Bike;
import pl.bikes.model.Category;
import pl.bikes.model.Product;
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


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String form(Model model) {
        model.addAttribute("bike", new Bike());
        return "/products/add-product";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String submit(@ModelAttribute Bike bike) {
        bike.setCategory(categoryRepository.findFirstById(1L));
        productRepository.save(bike);
        return "redirect:/";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam("id") Long id, Model model) {
        model.addAttribute("bike", bikeRepository.findById(id));
        return "/products/add-product";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editSubmit(@ModelAttribute Product product) {

        return "redirect:/products";
    }

    @RequestMapping(value = "/deleteConfirm", method = RequestMethod.GET)
    public String deleteConfirm(@RequestParam Long id, Model model) {
        model.addAttribute("bike", bikeRepository.findById(id));
        return "/products/delete-confirm";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id) {


        return "redirect:/products";
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryRepository.findAll();
    }

}
