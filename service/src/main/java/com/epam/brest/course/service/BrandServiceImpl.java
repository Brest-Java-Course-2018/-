package com.epam.brest.course.service;

import com.epam.brest.course.dao.BrandDao;
import com.epam.brest.course.model.Brand;
import com.epam.brest.course.model.DTO.BrandDTO;
import com.epam.brest.course.model.DTO.BrandShortDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;

/**
 * Brand service.
 */
public class BrandServiceImpl implements BrandService{

    /**
     * Constant variable for logs.
     */
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * BrandDao.
     */
    private BrandDao brandDao;

    public BrandServiceImpl(final BrandDao brandDao) {
        this.brandDao = brandDao;
    }

    @Override
    public Collection<BrandShortDTO> getBrandShortDTO() {
        return null;
    }

    @Override
    public Collection<BrandDTO> getBrandDTOs() {
        return null;
    }

    @Override
    public Brand getBrandById(final Integer brandId) {
        return null;
    }

    @Override
    public Brand addBrand(final Brand brand)
            throws IllegalArgumentException {
        return null;
    }

    @Override
    public void updateBrand(final Brand brand) {
    }

    @Override
    public void deleteBrand(final Integer brandId) {
    }
}
