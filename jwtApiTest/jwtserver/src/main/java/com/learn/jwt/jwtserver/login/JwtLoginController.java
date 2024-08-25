package com.learn.jwt.jwtserver.login;

import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Base64;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class JwtLoginController {

    
    @PostMapping("/login")
    public ResponseEntity<String> postMethodName(HttpServletRequest req) {
        
        if(validateHeader(req)){
            System.out.println("Authenticated!");
            return ResponseEntity.ok().body(new String(Base64.getDecoder().decode(req.getHeader("Authorization").split(" ")[1])));
        }
        
        return ResponseEntity.ok().body("Invalid Credentials");
    }

    private boolean validateHeader(HttpServletRequest req) {
        if("dXNOYW06UHdk".equals(req.getHeader("Authorization").split(" ")[1]))
            return true;
        else
            return false;
    }
    
}
