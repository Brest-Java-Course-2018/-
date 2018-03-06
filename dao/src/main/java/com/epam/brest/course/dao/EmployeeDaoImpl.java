package com.epam.brest.course.dao;

import com.epam.brest.course.model.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * CRUD for Employee.
 */
public class EmployeeDaoImpl implements EmployeeDao {

    /**
     * Constant variable.
     */
    public static final String EMPLOYEE_ID = "employeeId";
    /**
     * Constant variable.
     */
    public static final String EMPLOYEE_NAME = "employeeName";
    /**
     * Constant variable.
     */
    public static final String EMPLOYEE_SALARY = "salary";
    /**
     * Constant variable.
     */
    public static final String EMPLOYEE_DEPT_ID = "deptId";

    /**
     * Query for select.
     */
    @Value("${employee.select}")
    private String employeeSelect;
    /**
     * Query for select by id.
     */
    @Value("${employee.selectById}")
    private String employeeSelectById;
    /**
     * Query for inserting.
     */
    @Value("${employee.insert}")
    private String employeeInsert;
    /**
     * Query for updating.
     */
    @Value("${employee.update}")
    private String employeeUpdate;
    /**
     * Query for deleting.
     */
    @Value("${employee.delete}")
    private String employeeDelete;

    /**
     * Class NamedParameterJdbcTemplate from spring JDBC.
     */
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * Set namedParameterJdbcTemplate.
     *
     * @param namedParameterJdbcTemplate new namedParameterJdbcTemplate.
     */
    public void setNamedParameterJdbcTemplate(
            final NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = namedParameterJdbcTemplate.query(
                employeeSelect, new EmployeeRowMapper());
        return employees;
    }

    @Override
    public Employee getEmployeeById(final Integer employeeId) {
        SqlParameterSource namedParametrs =
                new MapSqlParameterSource(EMPLOYEE_ID, employeeId);
        Employee employee = namedParameterJdbcTemplate.queryForObject(
                employeeSelectById,
                namedParametrs,
                BeanPropertyRowMapper.newInstance(Employee.class));

        return  employee;
    }

    @Override
    public Employee addEmployee(final Employee employee) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue(EMPLOYEE_NAME, employee.getEmployeeName());
        namedParameters.addValue(EMPLOYEE_SALARY, employee.getSalary());
        namedParameters.addValue(EMPLOYEE_DEPT_ID, employee.getDeptId());

        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(
                employeeInsert, namedParameters, generatedKeyHolder);
        employee.setEmployeeId(generatedKeyHolder.getKey().intValue());

        return employee;
    }

    @Override
    public void updateEmployee(final Employee employee) {
        SqlParameterSource namedParameter =
                new BeanPropertySqlParameterSource(employee);
        namedParameterJdbcTemplate.update(employeeUpdate, namedParameter);
    }

    @Override
    public void deleteEmployeeById(final Integer employeeId) {
        namedParameterJdbcTemplate.getJdbcOperations().update(
                employeeDelete, employeeId);
    }

    /**
     * Class EmployeeRowMapper is implementation
     * of interface RowMapper<Department>.
     */
    private class EmployeeRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(final ResultSet resultSet, final int i)
                throws SQLException {
            Employee employee = new Employee();
            employee.setEmployeeId(resultSet.getInt(EMPLOYEE_ID));
            employee.setEmployeeName(resultSet.getString(EMPLOYEE_NAME));
            employee.setSalary(resultSet.getInt(EMPLOYEE_SALARY));
            employee.setDeptId(resultSet.getInt(EMPLOYEE_DEPT_ID));
            return employee;
        }
    }
}
