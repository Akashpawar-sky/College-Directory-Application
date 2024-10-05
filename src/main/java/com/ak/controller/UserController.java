package com.ak.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/login")
    public String login() {
        return "login"; // Return the login view
    }

    // Additional mappings for handling other user actions
}

