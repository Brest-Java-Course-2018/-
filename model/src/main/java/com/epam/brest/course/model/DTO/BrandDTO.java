package com.epam.brest.course.model.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

/**
 * BrandDTO class.
 */
public class BrandDTO {

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
     * Constructor without parameters for BrandDTO.
     */
    public BrandDTO() {
    }

    /**
     * Constructor with parameters for BrandDTO.
     *
     * @param brandName name of BrandDTO.
     * @param brandSold number of sold cars of this BrandDTO.
     */
    public BrandDTO(final String brandName, final Integer brandSold) {
        this.brandName = brandName;
        this.brandSold = brandSold;
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

    @Override
    public String toString() {
        return "BrandDTO{"
                + "brandId=" + brandId
                + ", brandName='" + brandName + '\''
                + ", brandSold=" + brandSold
                + '}';
    }
}
