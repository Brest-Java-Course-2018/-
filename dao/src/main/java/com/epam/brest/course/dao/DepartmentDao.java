package com.epam.brest.course.dao;

import com.epam.brest.course.model.Department;

import java.util.List;

/**
 * Departmen DAO Interface.
 */
public interface DepartmentDao {

    List<Department> getAllDepartments();

    Department getDepartmentById(Integer departmentId);

    Department addDepartment(Department department);

    void updateDepartment(Department department);

    void deleteDepartmentById(Integer id);

}
