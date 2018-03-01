package com.epam.brest.course.dao;

import com.epam.brest.course.model.Department;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-db-spring.xml",
        "classpath:test-dao.xml"})
public class DepartmentDaoImplTest {

    @Autowired
    DepartmentDao departmentDao;

    @Test
    public void getDepartments() {
        List<Department> departments = departmentDao.getDepartments();
        Assert.assertFalse(departments.isEmpty());
    }

    @Test
    public void getDepartmentById() {
        Department department = departmentDao.getDepartmentById(1);
        Assert.assertNotNull(department);
        Assert.assertTrue(department.getDepartmentId().equals(1));
        Assert.assertTrue(
                department.getDepartmentName().equals("Distribution"));
        Assert.assertTrue(
                department.getDescription().equals("Distribution Department"));
    }

    @Test
    public void addDepartment() {
        final String DEP_NAME = "Management";
        final String DEP_DESCR = "Management Department";

        Department dep = new Department();
        dep.setDepartmentName(DEP_NAME);
        dep.setDescription(DEP_DESCR);

        Department department = departmentDao.addDepartment(dep);

        Assert.assertNotNull(department);
        Assert.assertTrue(department.getDepartmentName().equals(DEP_NAME));
        Assert.assertTrue(department.getDescription().equals(DEP_DESCR));
    }

    @Test
    public void updateDepartment() {
        Department dep = new Department();
        dep.setDepartmentId(2);
        dep.setDepartmentName("Supp");
        dep.setDescription("Support Team");

        departmentDao.updateDepartment(dep);
        Department department = departmentDao.getDepartmentById(2);

        Assert.assertNotNull(department);
        Assert.assertEquals(dep, department);
    }


    @Test
    public void deleteDepartmentById() {
        departmentDao.deleteDepartmentById(3);
        Department department = departmentDao.getDepartmentById(3);
        Assert.assertTrue(department == null);
    }
}
