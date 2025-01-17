package com.employee2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee2.Entity.EmployeeEntity;
import com.employee2.model.EmployeeModel;
import com.employee2.service.EmployeeService;


@Controller
public class EmployeeController {

    @Autowired
     EmployeeService employeeService;

    @GetMapping("/homepage")
    public String home() {
        return "home";
    }

    @GetMapping("/aboutus")
    public String about() {
        return "about";
    }

    @GetMapping("/contactus")
    public String contact() {
        return "contact";
    }

    @GetMapping("/addemployee")
    public String add() {
        return "addemployee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(EmployeeModel employeeModel) {
        employeeService.saveEmployeeDetails(employeeModel); // Assuming this method exists and works
        return "success";  // You can redirect to a success page or an employee list view
    }


    @GetMapping("/getallemployee")
    public String getAllEmployees(Model model) {
        List<EmployeeEntity> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employee-list";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/getallemployee";
    }

    @GetMapping("/searchId")
    public String searchByIdForm() {
        return "search";
    }

    @PostMapping("/searchbyid")
    public String searchByIdGet(@RequestParam Long id, Model model) {
        Optional<EmployeeEntity> employee = employeeService.searchById(id);
        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());
        } else {
            model.addAttribute("employee", null);
        }
        return "search";
    }
}
