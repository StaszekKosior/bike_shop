package pl.bikes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.bikes.dao.BikeDao;
import pl.bikes.repository.BikeRepositpry;

@Controller
@RequiredArgsConstructor
@RequestMapping("/bikes")
public class BikeController {

    private final BikeDao dao;
    private final BikeRepositpry repositpry;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("bikes", repositpry.findAll());
        return "/bikes/bikes-list";
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String bikeDetails(@PathVariable Long id, Model model) {
        model.addAttribute("bike", dao.findById(id));
        return "/bikes/bike-details";
    }


}
