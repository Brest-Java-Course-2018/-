package com.epam.brest.course.service;

import com.epam.brest.course.model.Department;

/**
 * Departmen Service Interface.
 */
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

}
