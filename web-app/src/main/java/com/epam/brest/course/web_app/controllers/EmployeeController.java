package com.epam.brest.course.web_app.controllers;

import com.epam.brest.course.model.DTO.ShortDepartmentDTO;
import com.epam.brest.course.model.Employee;
import com.epam.brest.course.service.DepartmentService;
import com.epam.brest.course.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

/**
 * Employee controller.
 */
@Controller
public class EmployeeController {

    /**
     * EmployeeService.
     */
    @Autowired
    private EmployeeService employeeService;

    /**
     * DepartmentService.
     */
    @Autowired
    private DepartmentService departmentService;

    /**
     * Goto employees page.
     *
     * @param model model.
     * @return view name.
     */
    @GetMapping(value = "/employees")
    public String employees(Model model) {
        Collection<Employee> employees = employeeService.getEmployees();
        model.addAttribute("employees", employees);
        return "employees";
    }

    /**
     * Goto employee page.
     *
     * @param model model.
     * @return view name.
     */
    @GetMapping(value = "/employee")
    public String employee(Model model) {
        Collection<ShortDepartmentDTO> shortDepartmentDTOS =
                departmentService.getShortDepartmentsDTO();
        model.addAttribute("departments", shortDepartmentDTOS);
        model.addAttribute("type", "add");
        return "employee";
    }

    /**
     * Goto employee page.
     *
     * @param id employee id.
     * @param model model.
     * @return view name.
     */
    @GetMapping(value = "/employee/{id}")
    public String employee(final @PathVariable Integer id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        Collection<ShortDepartmentDTO> shortDepartmentDTOS =
                departmentService.getShortDepartmentsDTO();
        model.addAttribute("departments", shortDepartmentDTOS);
        model.addAttribute("employee", employee);
        model.addAttribute("type", "change");
        return "employee";
    }
}
