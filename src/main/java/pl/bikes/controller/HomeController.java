package pl.bikes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@Controller
public class HomeController {


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(HttpServletRequest request){
            HttpSession session = request.getSession();
        Enumeration<String> enumeration = session.getAttributeNames();
        while(enumeration.hasMoreElements()){
            String key = enumeration.nextElement();
            Object value = session.getAttribute(key);
            System.out.println("key: " + key + " value: " + value);
        }
        return "home";
    }
}