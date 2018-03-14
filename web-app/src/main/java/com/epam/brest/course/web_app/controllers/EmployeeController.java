package com.epam.brest.course.web_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Employee controller.
 */
@Controller
public class EmployeeController {

    /**
     * Goto employees page.
     *
     * @return view name.
     */
    @GetMapping(value = "/employees")
    public String employees() {
        return "employees";
    }

    /**
     * Goto employee page.
     *
     * @return view name.
     */
    @GetMapping(value = "/employee")
    public String employee() {
        return "employee";
    }
}
