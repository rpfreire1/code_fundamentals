package com.rpfreire.git.test.controller;

import com.rpfreire.git.test.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
    @GetMapping("/aaa")
    public String home() {
        System.out.println("home");
        return "home";
    }
    @GetMapping("/user")
    public User user()
    {
        User user = new User();
        user.setId(1L);
        user.setName("User");
        user.setEmailId("robertopatriciofreire@hotmail.com");
        return user;
    }
    @GetMapping("/{id}")
    public String pathVariable(@PathVariable String id){
        return  "path variable is "+id;

    }
    @GetMapping("/request")
    public String requestParm(
            @RequestParam String id,
            @RequestParam(name = "mes", required = false, defaultValue = "a") String message){
        return  "request param  is "+id+" message is "+message;

    }


}

