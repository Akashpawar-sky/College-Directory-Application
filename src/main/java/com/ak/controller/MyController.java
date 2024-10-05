package com.ak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
    @GetMapping("/home")
    public String home() {
        return "home"; // Refers to home.html in the /templates/ directory
    }
}
