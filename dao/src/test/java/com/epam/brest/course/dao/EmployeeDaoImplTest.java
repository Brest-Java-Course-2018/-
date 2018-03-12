package com.epam.brest.course.dao;

import com.epam.brest.course.model.Employee;
import org.junit.Test;
import org.junit.Assert;
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
public class EmployeeDaoImplTest {

    public static final String IVAN_IVANOV = "Ivan Ivanov";
    public static final int SALARY_IVAN_IVANOV = 500;
    public static final String NICK = "Nick";
    public static final int SALARY_NICK = 1000;
    public static final String NICK_SMITH = "Nick Smith";
    public static final int SALARY_NICK_SMITH = 1100;
    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void getEmployees() {
        List<Employee> employees = employeeDao.getEmployees();
        Assert.assertFalse(employees.isEmpty());
    }

    @Test
    public void getEmployeeById() {
        Employee employee = employeeDao.getEmployeeById(1);
        Assert.assertNotNull(employee);
        Assert.assertTrue(employee.getEmployeeId().equals(1));
        Assert.assertTrue(employee.getEmployeeName().equals(IVAN_IVANOV));
        Assert.assertTrue(employee.getSalary().equals(SALARY_IVAN_IVANOV));
        Assert.assertTrue(employee.getDeptId().equals(1));
    }

    @Test
    public void getEmployeeByDepartmentId() {
        List<Employee> employees = employeeDao.getEmployeeByDepartmentId(1);
        Assert.assertNotNull(employees);
        Assert.assertTrue(employees.size() >= 1);
    }

    @Test
    public void addEmployee() {
        List<Employee> employees = employeeDao.getEmployees();
        int sizeBefore = employees.size();
        Employee employee = new Employee(NICK, SALARY_NICK, 1);
        Employee newEmployee = employeeDao.addEmployee(employee);

        Assert.assertNotNull(newEmployee);
        Assert.assertTrue(newEmployee.getEmployeeName().equals(
                employee.getEmployeeName()));
        Assert.assertTrue(newEmployee.getSalary().equals(
                employee.getSalary()));
        Assert.assertTrue(newEmployee.getDeptId().equals(
                employee.getDeptId()));
        Assert.assertTrue(sizeBefore + 1 == employeeDao.getEmployees().size());
    }

    @Test
    public void updateEmployee() {
        Employee employee = new Employee(NICK, SALARY_NICK, 1);
        Employee newEmployee = employeeDao.addEmployee(employee);
        newEmployee.setEmployeeName(NICK_SMITH);
        newEmployee.setSalary(SALARY_NICK_SMITH);
        employeeDao.updateEmployee(newEmployee);
        Employee updateDepartment = employeeDao.getEmployeeById(
                newEmployee.getEmployeeId());

        Assert.assertTrue(updateDepartment.getEmployeeId().equals(
                newEmployee.getEmployeeId()));
        Assert.assertTrue(updateDepartment.getEmployeeName().equals(
                newEmployee.getEmployeeName()));
        Assert.assertTrue(updateDepartment.getSalary().equals(
                newEmployee.getSalary()));
        Assert.assertTrue(updateDepartment.getDeptId().equals(
                newEmployee.getDeptId()));
    }

    @Test
    public void deleteEmployeeById() {
        Employee employee = new Employee(NICK, SALARY_NICK, 1);
        employee = employeeDao.addEmployee(employee);
        List<Employee> employees = employeeDao.getEmployees();
        int sizeBefore = employees.size();
        employeeDao.deleteEmployeeById(employee.getEmployeeId());

        Assert.assertTrue(sizeBefore - 1 == employeeDao.getEmployees().size());
    }
}