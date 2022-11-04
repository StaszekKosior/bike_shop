package pl.bikes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.bikes.repository.CategoryRepository;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/categories")
public class CategoryController {


    private final CategoryRepository repository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("categories", repository.findAll());
        return "/categories/categories-list";
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String categoryDetails(@PathVariable Long id, Model model) {
        model.addAttribute("categoriy", repository.findById(id));
        return "/categories/categories-details";
    }


}
