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
     * Property email.
     */
    private String mail;

    /**
     * Property Id of department.
     */
    private Integer deptId;

    /**
     * Constructor without parameters for Employee.
     */
    public Employee() {
    }

    /**
     * Constructor with parameters for Employee.
     *
     * @param employeeName name of Employee.
     * @param salary salary for Employee.
     * @param mail email for Employee.
     * @param deptId index of department.
     */
    public Employee(final String employeeName,
                    final Integer salary,
                    final String mail,
                    final Integer deptId) {
        this.employeeName = employeeName;
        this.salary = salary;
        this.mail = mail;
        this.deptId = deptId;
    }

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
     * Get employee Email.
     *
     * @return email.
     */
    public String getMail() {
        return mail;
    }

    /**
     * Set employee Email.
     *
     * @param mail new Email.
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * Get employee deptId.
     *
     * @return id of department.
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * Set employee deptId.
     *
     * @param deptId new id of department.
     */
    public void setDeptId(final Integer deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Employee{"
                + "employeeId=" + employeeId
                + ", employeeName='" + employeeName
                + '\'' + ", salary=" + salary
                + ", mail='" + mail
                + '\'' + ", deptId=" + deptId + '}';
    }
}
