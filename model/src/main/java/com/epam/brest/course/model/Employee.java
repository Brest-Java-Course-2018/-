package com.epam.brest.course.model;

/**
 * POJO Employee for model.
 */
public class Employee {

    /**
     * Property Id.
     */
    private Integer employeeId;

    /**
     * Property Name.
     */
    private String employeeName;


    /**
     * Property Salary.
     */
    private Integer salary;

    /**
     * Property Id of department.
     */
    private Integer departmentId;

    /**
     * Get employee Id.
     *
     * @return employeeId.
     */
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     * Set employee Id.
     *
     * @param employeeId new Id.
     */
    public void setEmployeeId(final Integer employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Get employee Name.
     *
     * @return employeeName.
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * Set employee Name.
     *
     * @param employeeName new Name.
     */
    public void setEmployeeName(final String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * Get employee Salary.
     *
     * @return salary.
     */
    public Integer getSalary() {
        return salary;
    }

    /**
     * Set employee Salary.
     *
     * @param salary new Salary.
     */
    public void setSalary(final Integer salary) {
        this.salary = salary;
    }

    /**
     * Get employee departmentId.
     *
     * @return id of department.
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * Set employee departmentId.
     *
     * @param departmentId new id of department.
     */
    public void setDepartmentId(final Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Employee{"
                + "employeeId=" + employeeId
                + ", employeeName='" + employeeName
                + '\'' + ", salary=" + salary
                + ", departmentId=" + departmentId
                + '}';
    }
}
