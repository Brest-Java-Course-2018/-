package com.epam.brest.course.service;

import com.epam.brest.course.model.Brand;
import com.epam.brest.course.model.DTO.BrandDTO;
import com.epam.brest.course.model.DTO.BrandShortDTO;

import java.util.Collection;

/**
 * Brand Service Interface.
 */
public interface BrandService {

    /**
     * Get collection of shortBrandDTOs.
     *
     * @return collection of objects shortBrandDTO.
     */
    Collection<BrandShortDTO> getBrandShortDTO();

    /**
     * Get collection of BrandDTOs.
     *
     * @return collection of objects brandDTO.
     */
    Collection<BrandDTO> getBrandDTOs();

    /**
     * Get Brand by id.
     *
     * @param brandId brand number.
     * @return Brand.
     */
    Brand getBrandById(Integer brandId);

    /**
     * Add new Brand.
     *
     * @param brand new Brand.
     * @return Brand.
     */
    Brand addBrand(Brand brand);

    /**
     * Update brand.
     *
     * @param brand new version of brand.
     */
    void updateBrand(Brand brand);

    /**
     * Delete Brand.
     *
     * @param brandId id for deleting brand.
     */
    void deleteBrand(Integer brandId);
}
