package pl.bikes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.bikes.dao.CategoryDao;
import pl.bikes.repository.CategoryRepositpry;

@Controller
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryDao dao;
    private final CategoryRepositpry repositpry;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("categories", repositpry.findAll());
        return "/categories/categories-list";
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String categoryDetails(@PathVariable Long id, Model model) {
        model.addAttribute("categoriy", dao.findById(id));
        return "/categories/categories-details";
    }


}
