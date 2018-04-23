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
public class BrandServiceImpl implements BrandService {

    /**
     * Constant variable for logs.
     */
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * BrandDao.
     */
    private BrandDao brandDao;

    /**
     * Constructor.
     *
     * @param brandDao new brandDao.
     */
    public BrandServiceImpl(final BrandDao brandDao) {
        this.brandDao = brandDao;
    }

    @Override
    public Collection<BrandShortDTO> getBrandShortDTO() {
        LOGGER.debug("getBrandShortDTO()");
        Collection<BrandShortDTO> brandShortDTOS = brandDao.getBrandShortDTO();
        LOGGER.debug("getBrandShortDTO({})", brandShortDTOS);
        return brandShortDTOS;
    }

    @Override
    public Collection<BrandDTO> getBrandDTOs() {
        LOGGER.debug("getBrandDTOs()");
        Collection<BrandDTO> brandDTOS = brandDao.getBrandDTOs();
        LOGGER.debug("getBrandDTOs({})", brandDTOS);
        return brandDTOS;
    }

    @Override
    public Brand getBrandById(final Integer brandId) {
        LOGGER.debug("getBrandById({})", brandId);
        Brand newBrand = brandDao.getBrandById(brandId);
        LOGGER.debug("getBrandById(new brand : {})", newBrand);
        return newBrand;
    }

    @Override
    public Brand addBrand(final Brand brand)
            throws IllegalArgumentException {
        LOGGER.debug("addBrand({})", brand);
        Brand newBrand = brandDao.addBrand(brand);
        LOGGER.debug("addBrand(new Brand: {})", newBrand);
        return newBrand;
    }

    @Override
    public void updateBrand(final Brand brand) {
        LOGGER.debug("updateBrand({})", brand);
        brandDao.updateBrand(brand);
    }

    @Override
    public void deleteBrand(final Integer brandId) {
        LOGGER.debug("deleteBrand({})", brandId);
        brandDao.deleteBrand(brandId);
    }
}
