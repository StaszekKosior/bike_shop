package pl.bikes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.bikes.dao.AddressDao;
import pl.bikes.dao.UserDao;
import pl.bikes.model.Address;
import pl.bikes.model.User;
import pl.bikes.repository.UserRepositpry;

import java.awt.print.Book;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserDao dao;
    private final AddressDao addressDao;

    private final UserRepositpry repositpry;



    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("users", repositpry.findAll());
        return "/users/users-list";
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String form(Model model) {
        model.addAttribute("user", new User());
        return "/register/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String submit(@ModelAttribute User user) {

        dao.save(user);
        return "redirect:/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "/login/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login2(@RequestParam("email") String email, @RequestParam("password") String password) {


        return "/login/login";
    }

    @ModelAttribute("authors")
    public List<Address> addresses() {
        return addressDao.findAll();
    }



}
