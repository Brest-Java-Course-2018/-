package com.epam.brest.course.dao;

import com.epam.brest.course.model.Department;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-db-spring.xml",
        "classpath:test-dao.xml", "classpath:dao.xml"})
@Rollback
@Transactional
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
        /*final String DEP_NAME = "Management";
        final String DEP_DESCR = "Management Department";

        Department dep = new Department();
        dep.setDepartmentName(DEP_NAME);
        dep.setDescription(DEP_DESCR);

        Department department = departmentDao.addDepartment(dep);

        Assert.assertNotNull(department);
        Assert.assertTrue(department.getDepartmentName().equals(DEP_NAME));
        Assert.assertTrue(department.getDescription().equals(DEP_DESCR));*/

        List<Department> departments = departmentDao.getDepartments();
        int sizeBefore = departments.size();
        Department department = new Department("Education and Training",
                "Department Education and Training");
        Department newDepartment = departmentDao.addDepartment(department);
        Assert.assertNotNull(newDepartment.getDepartmentId());
        Assert.assertTrue(newDepartment.getDepartmentName().equals(department.getDepartmentName()));
        Assert.assertTrue(newDepartment.getDescription().equals(department.getDescription()));
        Assert.assertTrue(sizeBefore + 1 == departmentDao.getDepartments().size());
        Assert.assertTrue(department.equals(newDepartment));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addSameDepartment() {
        Department department = new Department("Education and Training",
                "Department of Education and Training");
        departmentDao.addDepartment(department);
        departmentDao.addDepartment(department);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void addSameDepartmentWithRule() {
        Department department = new Department("Education and Training",
                "Department of Education and Training");
        departmentDao.addDepartment(department);

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Department with the same name already exists");
        departmentDao.addDepartment(department);
    }

    @Test
    public void updateDepartment() {
        /*Department dep = new Department();
        dep.setDepartmentId(2);
        dep.setDepartmentName("Supp");
        dep.setDescription("Support Team");

        departmentDao.updateDepartment(dep);
        Department department = departmentDao.getDepartmentById(2);

        Assert.assertNotNull(department);
        Assert.assertEquals(dep, department);*/

        Department department =
                new Department("Education", "Department of Education");
        Department newDepartment = departmentDao.addDepartment(department);
        newDepartment.setDepartmentName("NEW Education");
        newDepartment.setDescription("NEW Department of Education");

        departmentDao.updateDepartment(newDepartment);
        Department updateDepartment = departmentDao.getDepartmentById(newDepartment.getDepartmentId());
        Assert.assertTrue(newDepartment.getDepartmentId().equals(updateDepartment.getDepartmentId()));
        Assert.assertTrue(newDepartment.getDepartmentName().equals(updateDepartment.getDepartmentName()));
        Assert.assertTrue(newDepartment.getDescription().equals(updateDepartment.getDescription()));

    }


    @Test
    public void deleteDepartmentById() {
        /*departmentDao.deleteDepartmentById(3);
        Department department = departmentDao.getDepartmentById(3);
        Assert.assertTrue(department == null);*/

        Department department =
                new Department("Education", "Department of Education");
        department = departmentDao.addDepartment(department);
        List<Department> departments = departmentDao.getDepartments();
        int sizeBefore = departments.size();
        departmentDao.deleteDepartmentById(department.getDepartmentId());
        Assert.assertTrue(sizeBefore - 1 == departmentDao.getDepartments().size());
    }
}
