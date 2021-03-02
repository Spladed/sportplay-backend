package com.splade.sportplay.controller;

import com.splade.sportplay.bean.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping("/login")
    public String login(@RequestBody User user){
        System.out.println(user);
        return "ok";
    }

}
