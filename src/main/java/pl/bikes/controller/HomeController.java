package pl.bikes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.bikes.repository.BikeRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final BikeRepository repository;

//    @RequestMapping(value = "/",method = RequestMethod.GET)
//    public String index(HttpServletRequest request){
//            HttpSession session = request.getSession();
//        Enumeration<String> enumeration = session.getAttributeNames();
//        while(enumeration.hasMoreElements()){
//            String key = enumeration.nextElement();
//            Object value = session.getAttribute(key);
//            System.out.println("key: " + key + " value: " + value);
//        }
//        return "home";
//    }
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("lastAddedBike", repository.findLast());
        return "home";
    }

    @GetMapping("/przykladowaStrona")
    @ResponseBody
    public String about() { return "Here you can find some details for logged users"; }
}