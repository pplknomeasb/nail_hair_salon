package org.perscholas.controllers;

import lombok.extern.java.Log;
import org.perscholas.models.Employee;
import org.perscholas.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("employee")
@Log
@SessionAttributes({"employee"})
public class EmployeeController {

    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {this.employeeService = employeeService;}

    @ModelAttribute("employee")
    public Employee initEmployee() { return new Employee(); }



    @GetMapping("/showemployees")
    public String showEmployees(@ModelAttribute("employee") @Valid Employee employee, BindingResult result, Model model){

        List<Employee> s = employeeService.getAllEmployees();
        model.addAttribute("employeeTemp", s);

        return "displayemployees";
    }
}
