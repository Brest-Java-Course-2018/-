package com.epam.brest.course.service;

import com.epam.brest.course.model.Department;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Departmen Service Interface.
 */
@Service
public interface DepartmentService {

    /**
     * Get department.
     *
     * @param departmentId department number.
     * @return Department.
     */
    Department getDepartmentById(Integer departmentId);

    /**
     * Update department.
     *
     * @param departmentId new version of old department.
     * @param description new description.
     */
    void updateDepartmentDescription(Integer departmentId, String description);

    /**
     * Get list of departments.
     *
     * @return Collection of objects Department.
     */
    Collection<Department> getDepartments();

}
