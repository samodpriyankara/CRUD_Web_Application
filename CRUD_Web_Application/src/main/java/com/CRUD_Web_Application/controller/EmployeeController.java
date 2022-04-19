package com.CRUD_Web_Application.controller;

import com.CRUD_Web_Application.model.Employee;
import com.CRUD_Web_Application.service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
@GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listEmployees",employeeService.getAllEmployee());
        return "index";
    }
    @GetMapping("/showEmployeeForm")
    public String showEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
    //save employee to database
    employeeService.saveEmployee(employee);
    return "redirect:/";
    }
@GetMapping("showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") long id,Model model){
    //get employee from the service
        Employee employee = employeeService.getEmployeeById(id);

        //set employee as a model attribute to pr-populate the form
        model.addAttribute("employee",employee);
        return "update_employee";
    }
@GetMapping("deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") long id){
this.employeeService.deleteEmployee(id);
return "redirect:/";
    }



}
