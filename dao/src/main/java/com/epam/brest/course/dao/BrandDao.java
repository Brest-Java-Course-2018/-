package com.epam.brest.course.dao;

import com.epam.brest.course.model.Brand;
import com.epam.brest.course.model.DTO.BrandDTO;
import com.epam.brest.course.model.DTO.BrandShortDTO;

import java.util.Collection;

/**
 * Brand DAO Interface.
 */
public interface BrandDao {

    /**
     * Get collection of Brands.
     *
     * @return Short collection of objects Brand.
     */
    Collection<BrandShortDTO> getBrandShortDTO();

    /**
     * Get collection of BrandDTOs.
     *
     * @return Collection of objects BrandDTO.
     */
    Collection<BrandDTO> getBrandDTOs();

    /**
     * Get Brand.
     *
     * @param brandId Brand number.
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
     * Update Brand.
     *
     * @param brand Brand with new fields.
     */
    void updateBrand(Brand brand);

    /**
     * Delete Brand.
     *
     * @param brandId Brand number.
     */
    void deleteBrand(Integer brandId);
}
