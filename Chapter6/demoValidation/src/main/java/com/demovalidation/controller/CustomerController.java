package com.demovalidation.controller;

import com.demovalidation.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


    @GetMapping("/")
    public String showForm(Model model) {

        model.addAttribute("customer", new Customer());

        return "customer-form";
    }


    @PostMapping("/processCustomerForm")
    public String processCustomerForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult) {
        System.out.println("Error: " + theBindingResult.toString());

        System.out.println("\n\n\n\n");

//        typeMismatch.customer.feeGas
        if(theBindingResult.hasErrors()) {
            return "customer-form";
        } else {
            return "customer-confirmation";
        }
    }
}
