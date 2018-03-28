package com.epam.brest.course.web_app.controllers;

import com.epam.brest.course.model.DTO.ShortDepartmentDTO;
import com.epam.brest.course.model.Employee;
import com.epam.brest.course.service.DepartmentService;
import com.epam.brest.course.service.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Collection;

/**
 * Employee controller.
 */
@Controller
public class EmployeeController {

    private static final Logger LOGGER = LogManager.getLogger();

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
    public final String employees(Model model) {
        LOGGER.debug("getEmployees({})", model);
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
    public final String gotoAddEmployeePage(Model model) {
        LOGGER.debug("addEmployee({})", model);
        Employee employee = new Employee();
        Collection<ShortDepartmentDTO> shortDepartmentDTOS =
                departmentService.getShortDepartmentsDTO();
        model.addAttribute("type", "add");
        model.addAttribute("employee", employee);
        model.addAttribute("departments", shortDepartmentDTOS);
        return "employee";
    }


    /**
     * Persist new employee into persistence storage.
     *
     * @param employee new employee with filled data.
     * @param result   data binding result.
     * @return view name.
     */
    @PostMapping(value = "/employee")
    public final String addEmployee(@Valid Employee employee,
                                    BindingResult result, final Model model) {
        LOGGER.debug("addEmployee({}, {})", employee, result);
        if (result.hasErrors()) {
            Collection<ShortDepartmentDTO> shortDepartmentDTOS =
                    departmentService.getShortDepartmentsDTO();
            model.addAttribute("type", "add");
            model.addAttribute("employee", employee);
            model.addAttribute("departments", shortDepartmentDTOS);
            return "employee";
        } else {
            this.employeeService.addEmployee(employee);
            return "redirect:/employees";
        }
    }

    /**
     * Goto employee page.
     *
     * @param id employee id.
     * @param model model.
     * @return view name.
     */
    @GetMapping(value = "/employee/{id}")
    public final String employee(final @PathVariable Integer id, Model model) {
        LOGGER.debug("gotoEditEmployeePage({}, {})", id, model);
        Employee employee = employeeService.getEmployeeById(id);
        Collection<ShortDepartmentDTO> shortDepartmentDTOS =
                departmentService.getShortDepartmentsDTO();
        model.addAttribute("type", "change");
        model.addAttribute("employee", employee);
        model.addAttribute("departments", shortDepartmentDTOS);
        return "employee";
    }

    /**
     * Update department into persistence storage.
     *
     * @param employee employee.
     * @param result   result.
     * @return view name.
     */
    @PostMapping(value = "/employee/{id}")
    public String updateDepartment(@Valid Employee employee,
                                   BindingResult result, final Model model) {
        LOGGER.debug("updateDepartment({}, {})", employee, result);
        if (result.hasErrors()) {
            Collection<ShortDepartmentDTO> shortDepartmentDTOS =
                    departmentService.getShortDepartmentsDTO();
            model.addAttribute("type", "change");
            model.addAttribute("employee", employee);
            model.addAttribute("departments", shortDepartmentDTOS);
            return "employee";
        } else {
            employeeService.updateEmployee(employee);
            return "redirect:/employees";
        }
    }

    @GetMapping(value = "/employee/{id}/delete")
    public final String deleteEmployeeById(@PathVariable Integer id,
                                           Model model) {
        LOGGER.debug("deleteEmployeeById({},{})", id, model);
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees";
    }
}
