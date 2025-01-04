package com.luv2code.springboot.cruddemo.controller;


import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService theEmployeeService;

    public EmployeeController(EmployeeService theemployeeService) {
        this.theEmployeeService=theemployeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        List<Employee> theEmployeesList=theEmployeeService.findAll();
        theModel.addAttribute("employees", theEmployeesList);
        return "list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Employee temp=new Employee();
        theModel.addAttribute("employee", temp);
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
        theEmployeeService.save(theEmployee);
        return "redirect:/employees/list";
    }

    @GetMapping("showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theInt, Model theModel) {
        Employee temp=theEmployeeService.findById(theInt);
        theModel.addAttribute("employee", temp);
        return "employees/employee-form";
    }

    @GetMapping("/showFormForDelete")
    public String showFormForDelete(@RequestParam("employeeId") int theId) {
        theEmployeeService.deleteById(theId);
        return "redirect:/employees/list";
    }
}
