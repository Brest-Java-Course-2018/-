package com.epam.brest.course.dao;

import com.epam.brest.course.model.Department;

import java.util.List;

/**
 * Departmen DAO Interface.
 */
public interface DepartmentDao {

    List<Department> getAllDepartments();

    Department getDepartmentById(Integer departmentId);



}
