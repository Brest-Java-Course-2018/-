package com.epam.brest.course.dao;

import com.epam.brest.course.model.Department;
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
 * CRUD for Department.
 */
public class DepartmentDaoImpl implements DepartmentDao {

    /**
     * Constant variable.
     */
    public static final String DEPARTMENT_ID = "departmentId";
    /**
     * Constant variable.
     */
    public static final String DEPARTMENT_NAME = "departmentName";
    /**
     * Constant variable.
     */
    public static final String DESCRIPTION = "description";

    /**
     * Query for select.
     */
    @Value("${department.select}")
    private String departmentSelect;
    /**
     * Query for select by id.
     */
    @Value("${department.selectById}")
    private String departmentSelectByID;
    /**
     * Query for count of number.
     */
    @Value("${department.checkDepartment}")
    private String departmentCheckDepartment;
    /**
     * Query for inserting.
     */
    @Value("${department.insert}")
    private String departmentInsert;
    /**
     * Query for updating.
     */
    @Value("${department.update}")
    private String departmentUpdate;
    /**
     * Query for deleting.
     */
    @Value("${department.delete}")
    private String departmentDelete;

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
    public List<Department> getDepartments() {
        List<Department> departments =
                namedParameterJdbcTemplate.getJdbcOperations().query(
                        departmentSelect, new DepartmentRowMapper());
        return departments;

    }

    @Override
    public Department getDepartmentById(final Integer departmentId) {
        SqlParameterSource namedParametrs =
                new MapSqlParameterSource(DEPARTMENT_ID, departmentId);
        Department department = namedParameterJdbcTemplate.queryForObject(
                departmentSelectByID,
                namedParametrs,
                BeanPropertyRowMapper.newInstance(Department.class));

        return department;
    }

    @Override
    public Department addDepartment(final Department department) {
        MapSqlParameterSource namedParametrs = new MapSqlParameterSource(
                DEPARTMENT_NAME, department.getDepartmentName());

        Integer result = namedParameterJdbcTemplate.queryForObject(
                departmentCheckDepartment, namedParametrs, Integer.class);

        if (result == 0) {
            namedParametrs = new MapSqlParameterSource();
            namedParametrs.addValue(
                    DEPARTMENT_NAME, department.getDepartmentName());
            namedParametrs.addValue(DESCRIPTION, department.getDescription());

            KeyHolder generatedKeyHolder = new GeneratedKeyHolder();

            namedParameterJdbcTemplate.update(
                    departmentInsert, namedParametrs, generatedKeyHolder);
            department.setDepartmentId(generatedKeyHolder.getKey().intValue());
        } else {
            throw new IllegalArgumentException(
                    "Department with the same name already exists");
        }

        return department;
    }

    @Override
    public void updateDepartment(final Department department) {
        SqlParameterSource namedParameter =
                new BeanPropertySqlParameterSource(department);
        namedParameterJdbcTemplate.update(departmentUpdate, namedParameter);
    }

    @Override
    public void deleteDepartmentById(final Integer departmentId) {
        namedParameterJdbcTemplate.getJdbcOperations().update(
                departmentDelete, departmentId);
    }

    /**
     * Class DepartmentRowMapper is implementation
     * of interface RowMapper<Department>.
     */
    private static class DepartmentRowMapper implements RowMapper<Department> {

        @Override
        public Department mapRow(final ResultSet resultSet, final int i)
                throws SQLException {
            Department department = new Department();
            department.setDepartmentId(resultSet.getInt(DEPARTMENT_ID));
            department.setDepartmentName(resultSet.getString(DEPARTMENT_NAME));
            department.setDescription(resultSet.getString(DESCRIPTION));
            return department;
        }
    }
}
