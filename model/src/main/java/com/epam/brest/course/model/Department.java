package com.epam.brest.course.model;

/**
 * POJO department.
 */
public class Department {

    /**
     * Property Id.
     */
    private Integer departmentId;

    /**
     * Property Name.
     */
    private String departmentName;

    /**
     * Property Description.
     */
    private String description;

    /**
     * Constructor without parameters for Department.
     */
    public Department() {
    }

    /**
     * Constructor with parameters for Department.
     *
     * @param departmentName name of Department.
     * @param description discription if Department.
     */
    public Department(final String departmentName, final String description) {
        this.departmentName = departmentName;
        this.description = description;
    }

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
     * Get department Description.
     *
     * @return Description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set department Description.
     *
     * @param description new Description.
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Department{"
                + "departmentId=" + departmentId
                + ", departmentName='" + departmentName
                + '\'' + ", description='" + description
                + '\'' + '}';
    }
}
