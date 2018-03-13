package com.epam.brest.course.web_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DepartmentController {

    @GetMapping(value = "/department")
    public String department() {
        return "department";
    }
}
