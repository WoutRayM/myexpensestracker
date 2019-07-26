package be.giantoaf.myexpensestracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String homepageMapping() {
        return "home";
    }

}
