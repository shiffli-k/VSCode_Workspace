package com.sprlearn.learningspring.learn.concepts.tryingout.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sprlearn.learningspring.learn.concepts.errorhandling.mvc.GenericMVCException;

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

    @GetMapping("/{pathparam}")
    public String baseEndpointWithParam(@PathVariable(required = true, value = "pathparam") String paramValue, Model mav) throws Exception {
        if ("error".equals(paramValue)) {
            // throw new Exception("The request parameter is incorrect. Please try again later");
            throw new GenericMVCException("The request parameter is incorrect. Please try again later");
        }
        mav.addAttribute("message", "The User has passed in -> " + paramValue);
        return "welcomepage";
    }
    

}
