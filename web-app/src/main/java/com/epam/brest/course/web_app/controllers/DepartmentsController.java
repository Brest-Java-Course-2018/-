package com.epam.brest.course.web_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DepartmentsController {

    @GetMapping(value = {"/", "/index", "/index.html"})
    public String defaultPageRedirect() {
        return "redirect:departments";
    }

    @GetMapping(value = "departments")
    public String departments() {
        return "departments";
    }
}
