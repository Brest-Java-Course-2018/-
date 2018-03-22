package com.epam.brest.course.service;

import com.epam.brest.course.dao.DepartmentDao;
import com.epam.brest.course.model.DTO.DepartmentDTO;
import com.epam.brest.course.model.DTO.ShortDepartmentDTO;
import com.epam.brest.course.model.Department;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;


/**
 * Departmen Service.
 */
public class DepartmentServiceImpl implements DepartmentService {

    /**
     * Constant variable for logs.
     */
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * DepartmentDao.
     */
    private DepartmentDao departmentDao;

    /**
     * Constructor.
     *
     * @param departmentDao new departmentDao.
     */
    public DepartmentServiceImpl(final DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public Collection<Department> getDepartments() {
        LOGGER.debug("getDepartments()");
        return departmentDao.getDepartments();
    }

    @Override
    public Department getDepartmentById(final Integer departmentId) {
        LOGGER.debug("getDepartmentById({})", departmentId);
        return departmentDao.getDepartmentById(departmentId);
    }

    @Override
    public Department addDepartment(Department department) {
        LOGGER.debug("addDepartment({})", department);
        return departmentDao.addDepartment(department);
    }

    @Override
    public void updateDepartment(Department department) {
        LOGGER.debug("updateDepartment({})", department);
        departmentDao.updateDepartment(department);
    }

    @Override
    public void updateDepartmentDescription(
            final Integer departmentId, final String description) {
        LOGGER.debug("updateDepartmentDescription({}, {})",
                departmentId, description);
        Department department = departmentDao.getDepartmentById(departmentId);
        department.setDescription(description);
        departmentDao.updateDepartment(department);
    }

    @Override
    public Collection<ShortDepartmentDTO> getShortDepartmentsDTO() {
        LOGGER.debug("getShortDepartmentsDTO()");
        return departmentDao.getShortDepartmentsDTO();
    }

    @Override
    public Collection<DepartmentDTO> getDepartmentsDTO() {
        LOGGER.debug("getDepartmentsDTO()");
        return departmentDao.getDepartmentsDTO();
    }

    @Override
    public void deleteDepartmentById(final Integer id) {
        LOGGER.debug("deleteDepartmentById({})", id);
        departmentDao.deleteDepartmentById(id);
    }
}
