package com.epam.brest.course.web_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeesController {

    @GetMapping(value = "/employees")
    public String employees() {
        return "employees";
    }
}
