package com.epam.brest.course.model.DTO;

/**
 * DTO Department for main page.
 */
public class DepartmentDTO {

    /**
     * Property Id.
     */
    private Integer departmentId;

    /**
     * Property Name.
     */
    private String departmentName;

    /**
     * Property avgSalary.
     */
    private String avgSalary;

    /**
     * Property Id.
     */
    private Integer employeeId;

    /**
     * Get department Id.
     *
     * @return DepartmentId.
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * Set department Id.
     *
     * @param departmentId new Id.
     */
    public void setDepartmentId(final Integer departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * Get department Name.
     *
     * @return DepartmentName.
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * Set department Name.
     *
     * @param departmentName new Name.
     */
    public void setDepartmentName(final String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * Get department avgSalary.
     *
     * @return avgSalary.
     */
    public String getAvgSalary() {
        return avgSalary;
    }

    /**
     * Set department avgSalary.
     *
     * @param avgSalary new Name.
     */
    public void setAvgSalary(final String avgSalary) {
        this.avgSalary = avgSalary;
    }

    /**
     * Get employee Id.
     *
     * @return EmployeeId.
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

    @Override
    public String toString() {
        return "DepartmentDTO{"
                + "departmentId=" + departmentId
                + ", departmentName='" + departmentName
                + '\'' + ", avgSalary='" + avgSalary
                + '\'' + ", employeeId=" + employeeId
                + '}';
    }
}
