package com.controller;


import com.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Value("${countries}")
    private List<String> countries;

    @Value("${favoriteLanguage}")
    private List<String> favoriteLanguage;

    @GetMapping("/showStudentForm")
    public String showForm(Model model) {
        Student temp=new Student();

        model.addAttribute("countries", countries);

        model.addAttribute("student", temp);

        model.addAttribute("favoriteLanguage", favoriteLanguage);

        return "student-form";
    }


    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student theStudent) {
        System.out.println("The information of student: " + theStudent.getLastName() +" "+ theStudent.getFirstName());
        return "student-confirmation";
    }
}
