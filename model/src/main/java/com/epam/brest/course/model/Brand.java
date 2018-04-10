package com.epam.brest.course.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

/**
 * Brand class.
 */
public class Brand {

    /**
     * Constant variable for length of fields parameters.
     */
    private static final int MAX_LENGTH_OF_STRING = 255;

    /**
     * Property Id.
     */
    private Integer brandId;

    /**
     * Property Name.
     */
    @NotEmpty
    @Size(min = 2, max = MAX_LENGTH_OF_STRING)
    private String brandName;

    /**
     * Property Sold cars.
     */
    @PositiveOrZero
    private Integer brandSold;

    /**
     * Property Description.
     */
    @Size(max = MAX_LENGTH_OF_STRING)
    private String brandDescription;

    /**
     * Constructor without parameters for Brand.
     */
    public Brand() {
    }

    /**
     * Constructor with parameters for Brand.
     *
     * @param brandName name of Brand.
     * @param brandDescription description od Brand.
     */
    public Brand(final String brandName, final String brandDescription) {
        this.brandName = brandName;
        this.brandDescription = brandDescription;
    }

    /**
     * Get brand id.
     *
     * @return BrandId.
     */
    public Integer getBrandId() {
        return brandId;
    }

    /**
     * Set brand id.
     *
     * @param brandId BrandId.
     */
    public void setBrandId(final Integer brandId) {
        this.brandId = brandId;
    }

    /**
     * Get brand name.
     *
     * @return BrandName.
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * Set brand name.
     *
     * @param brandName BrandName.
     */
    public void setBrandName(final String brandName) {
        this.brandName = brandName;
    }

    /**
     * Get brand number of sold cars.
     *
     * @return BrandSold.
     */
    public Integer getBrandSold() {
        return brandSold;
    }

    /**
     * Set brand number of sold cars.
     *
     * @param brandSold BrandSold.
     */
    public void setBrandSold(final Integer brandSold) {
        this.brandSold = brandSold;
    }

    /**
     * Get brand description.
     *
     * @return BrandDescription
     */
    public String getBrandDescription() {
        return brandDescription;
    }

    /**
     *
     * Set brand description.
     *
     * @param brandDescription BrandDescription.
     */
    public void setBrandDescription(final String brandDescription) {
        this.brandDescription = brandDescription;
    }

    @Override
    public String toString() {
        return "Brand{"
                + "brandId=" + brandId
                + ", brandName='" + brandName + '\''
                + ", brandSold=" + brandSold
                + ", brandDescription='" + brandDescription + '\''
                + '}';
    }
}
