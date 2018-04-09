package com.epam.brest.course.model.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * BrandShortDTO class.
 */
public class BrandShortDTO {

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
     * Constructor without parameters for BrandShortDTO.
     */
    public BrandShortDTO() {
    }

    /**
     * Constructor with parameters for BrandShortDTO.
     *
     * @param brandName name of BrandShortDTO.
     */
    public BrandShortDTO(final String brandName) {
        this.brandName = brandName;
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

    @Override
    public String toString() {
        return "BrandShortDTO{"
                + "brandId=" + brandId
                + ", brandName='" + brandName + '\''
                + '}';
    }
}
