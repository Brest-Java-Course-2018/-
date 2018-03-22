package com.epam.brest.course.service;

import com.epam.brest.course.model.DTO.DepartmentDTO;
import com.epam.brest.course.model.DTO.ShortDepartmentDTO;
import com.epam.brest.course.model.Department;

import java.util.Collection;

/**
 * Departmen Service Interface.
 */
public interface DepartmentService {

    /**
     * Get list department.
     *
     * @return Departments.
     */
    Collection<Department> getDepartments();

    /**
     * Get department.
     *
     * @param departmentId department number.
     * @return Department.
     */
    Department getDepartmentById(Integer departmentId);

    /**
     * Persist new department.
     *
     * @param department new department.
     * @return department department with id.
     */
    Department addDepartment(Department department);

    /**
     * Update department.
     *
     * @param department department
     */
    void updateDepartment(Department department);

    /**
     * Update department.
     *
     * @param departmentId new version of old department.
     * @param description new description.
     */
    void updateDepartmentDescription(Integer departmentId, String description);

    /**
     * Get list of ShortDepartmentDTO.
     *
     * @return Collection of objects ShortDepartmentDTO.
     */
    Collection<ShortDepartmentDTO> getShortDepartmentsDTO();

    /**
     * Get list of departmentsDTO.
     *
     * @return Collection of objects DepartmentDTO.
     */
    Collection<DepartmentDTO> getDepartmentsDTO();

    /**
     * Delete department.
     *
     * @param id what department to remove.
     */
    void deleteDepartmentById(Integer id);
}
