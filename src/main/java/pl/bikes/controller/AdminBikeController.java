package pl.bikes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.bikes.dao.BikeDao;
import pl.bikes.model.Bike;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/bikes")
public class AdminBikeController {

    private final BikeDao dao;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String form(Model model) {
        model.addAttribute("bike", new Bike());
        return "/bikes/add-bike";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String submit(@ModelAttribute Bike bike) {
        dao.save(bike);
        return "redirect:/bikes";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam("id") Long id, Model model){
        model.addAttribute("bike", dao.findById(id));
        return "/bikes/add-bike";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editSubmit(@ModelAttribute Bike bike){
        dao.update(bike);
        return "redirect:/bikes";
    }

    @RequestMapping(value = "/deleteConfirm", method = RequestMethod.GET)
    public String deleteConfirm (@RequestParam Long id, Model model){
        model.addAttribute("bike", dao.findById(id));
        return "/bikes/delete-confirm";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete (@PathVariable Long id){
        dao.delete(dao.findById(id));
        return "redirect:/bikes";
    }






}
