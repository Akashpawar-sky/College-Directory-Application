package com.ak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/admin/dashboard")
    public String adminDashboard(Model model) {
        // Add necessary attributes to the model if needed
        // model.addAttribute("admin", new Admin("Admin Name", "admin@example.com"));
        return "admin_dashboard"; // Return the view name corresponding to admin_dashboard.html
    }

    @GetMapping("/faculty/dashboard")
    public String facultyDashboard(Model model) {
        // Add necessary attributes to the model if needed
        return "faculty_dashboard"; // Return the view name corresponding to faculty_dashboard.html
    }

    @GetMapping("/student/dashboard")
    public String studentDashboard(Model model) {
        // Add necessary attributes to the model if needed
        return "student_dashboard"; // Return the view name corresponding to student_dashboard.html
    }
}
