package com.sprlearn.learningspring.learn.concepts;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/mvc")
public class TryingoutConceptsController {

    @GetMapping(path = "/static")
    public String testEndpoint() {
        return "forward:/index.html";
    }

    @GetMapping("/")
    public String baseEndpoint(Model mav) {
        mav.addAttribute("message", "This data on page is served via Spring Boot Thymeleaf! 🫨🤩");
        return "welcomepage";
    }

}
