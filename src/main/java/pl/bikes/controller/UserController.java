package pl.bikes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.bikes.model.User;
import pl.bikes.repository.UserRepository;


import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserRepository repository;
    private final HttpSession session;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("users", repository.findAll());
        return "/users/users-list";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String form(Model model) {
        model.addAttribute("user", new User());
        return "/register/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String submit(@ModelAttribute User user) {

        repository.save(user);
        return "redirect:/users/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "/login/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginSubmit(@RequestParam("email") String email, @RequestParam("password") String password) {
        if (repository.findByEmail(email) != null && repository.findByEmail(email).getPassword().equals(password)) {
            session.setAttribute("loggedUser", repository.findByEmail(email));
            return "redirect:/";
        }
        return "/login/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        session.removeAttribute("loggedUser");
        return "redirect:/";
    }
}
