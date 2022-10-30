package pl.bikes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.bikes.dao.AccessoriesDao;
import pl.bikes.dao.BikeDao;
import pl.bikes.repository.AccessorieRepositpry;
import pl.bikes.repository.BikeRepositpry;

@Controller
@RequiredArgsConstructor
@RequestMapping("/accessories")
public class AccessorieController {

    private final AccessoriesDao dao;
    private final AccessorieRepositpry repositpry;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("accessories", repositpry.findAll());
        return "/accessories/accessories-list";
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String bikeDetails(@PathVariable Long id, Model model) {
        model.addAttribute("accessorie", dao.findById(id));
        return "/accessories/accessorie-details";
    }


}
