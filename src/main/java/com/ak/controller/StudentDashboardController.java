package com.ak.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ak.entity.Advisor;
import com.ak.entity.Student;

@Controller
public class StudentDashboardController {

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        // Simulating a student object (you would typically fetch this from a database)
        Student student = new Student("John Doe", "johndoe@example.com", "/images/profile.jpg", "Computer Science", "A", "95%");

        // Simulating faculty advisors and search results
        List<Advisor> advisors = List.of(new Advisor("Prof. Jane Smith", "jane.smith@example.com", "+1234567890"));
        List<Student> searchResults = new ArrayList<>(); // Empty initially or populate it

        model.addAttribute("student", student);
        model.addAttribute("advisors", advisors);
        model.addAttribute("searchResults", searchResults); // Initially empty

        return "student_dashboard"; // this refers to your HTML template
    }
}

