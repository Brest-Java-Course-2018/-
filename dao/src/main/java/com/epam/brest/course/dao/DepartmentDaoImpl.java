package com.epam.brest.course.dao;

import com.epam.brest.course.model.Department;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private String GET_DEPARTMENTS_SQL = "SELECT departmentId, departmentName, description " +
            "FROM department";

    private String GET_DEPARTMENTS_BY_ID_SQL = "SELECT departmentId, departmentName, description " +
            "FROM department WHERE departmentId = :departmentId";

    public DepartmentDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> departments = jdbcTemplate.query(GET_DEPARTMENTS_SQL, new DepartmentRowMapper());
        return departments;

    }

    @Override
    public Department getDepartmentById(Integer departmentId) {
        SqlParameterSource namedParametrs =
                new MapSqlParameterSource("departmentId", departmentId);
        Department department = namedParameterJdbcTemplate.queryForObject(
                GET_DEPARTMENTS_BY_ID_SQL, namedParametrs, new DepartmentRowMapper());
        return department;
    }

    private class DepartmentRowMapper implements RowMapper<Department> {

        @Override
        public Department mapRow(ResultSet resultSet, int i) throws SQLException {
            Department department = new Department();
            department.setDepartmentId(resultSet.getInt(1));
            department.setDepartmentName(resultSet.getString(2));
            department.setDescription(resultSet.getString(3));
            return department;
        }
    }

    @Override
    public Department addDepartment(Department department) {
        return null;
    }

    @Override
    public void updateDepartment(Department department) {

    }

    @Override
    public void deleteDepartmentById(Integer id) {

    }
}
