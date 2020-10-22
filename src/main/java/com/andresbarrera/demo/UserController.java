package com.andresbarrera.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal){
        if(principal.getAttribute("name")!="" || principal.getAttribute("name") != null &&
                principal.getAttribute("email")!="" || principal.getAttribute("email") != null ){
            User newUser = new User();
            if(!(userRepository.existsByEmail(principal.getAttribute("email")))){
                newUser.setName(principal.getAttribute("name"));
                newUser.setEmail(principal.getAttribute("email"));
                userRepository.save(newUser);
            }
        }
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }

}
