package com.epam.brest.course.dao;

import com.epam.brest.course.model.DTO.DepartmentDTO;
import com.epam.brest.course.model.DTO.ShortDepartmentDTO;
import com.epam.brest.course.model.Department;

import java.util.Collection;

/**
 * Department DAO Interface.
 */
public interface DepartmentDao {

    /**
     * Get collection of departments.
     *
     * @return Collection of objects Department.
     */
    Collection<Department> getDepartments();

    /**
     * Get collection of departments.
     *
     * @return Short collection of objects Department.
     */
    Collection<ShortDepartmentDTO> getShortDepartmentsDTO();

    /**
     * Get collection of departments.
     *
     * @return Collection of objects Department.
     */
    Collection<DepartmentDTO> getDepartmentsDTO();

    /**
     * Get department.
     *
     * @param departmentId department number.
     * @return Department.
     */
    Department getDepartmentById(Integer departmentId);

    /**
     * Add new department.
     *
     * @param department new department.
     * @return Department.
     */
    Department addDepartment(Department department);

    /**
     * Update department.
     *
     * @param department new version of old department.
     */
    void updateDepartment(Department department);

    /**
     * Delete department.
     *
     * @param id what department to remove.
     */
    void deleteDepartmentById(Integer id);

}
