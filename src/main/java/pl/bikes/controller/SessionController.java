package pl.bikes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
public class SessionController {

    @GetMapping("/test")

    public String test(HttpSession session) {
        String loginStart = (String) session.getAttribute("loginStart");
        if (loginStart == null) {
            session.setAttribute(" loginStart", LocalDateTime.now().toString());
        } else {
            return loginStart;
        }
        return "";
    }
}
