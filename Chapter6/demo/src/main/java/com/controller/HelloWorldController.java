package com.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@RequestParam("studentName") String studentName, Model model) {
        // Thêm giá trị vào model để sử dụng trong view
        model.addAttribute("studentName", studentName);
        return "helloworld-result";
    }


    @PostMapping("/processFormVersionTwo")
    public String letShoutDude(HttpServletRequest request,  Model model) {
        String name=request.getParameter("studentName");

        String result="Yooooo! " + name.toUpperCase();

        model.addAttribute("message", result);

        return "helloworld-result";
    }
}
