package com.epam.brest.course.service;

import com.epam.brest.course.model.Brand;
import com.epam.brest.course.model.DTO.BrandDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-db-spring.xml",
        "classpath:service-test.xml", "classpath:dao.xml"})
@Rollback
@Transactional
public class BrandServiceImplTest {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String BRAND_NAME_1 = "BMW";
    private static final String BRAND_DESCR_1 = "In English Bavarian Motor Works";
    private static final String NEW_BRAND_NAME = "Mercedes";
    private static final String NEW_BRAND_DESCR = "AMG C 63 models";

    @Autowired
    private BrandService brandService;

    @Test
    public void getBrandShortDTO() {
        LOGGER.debug("getBrandShortDTO()");
        brandService.addBrand(new Brand("qwerty", "uiop"));
        Assert.assertTrue(brandService.getBrandShortDTO().size() > 0);
    }

    @Test
    public void getBrandDTOs() {
        LOGGER.debug("getBrandDTOs()");
        brandService.addBrand(new Brand("qwerty", "uiop"));
        Assert.assertTrue(brandService.getBrandDTOs().size() > 0);
    }

    @Test
    public void getBrandById() {
        LOGGER.debug("getBrandById()");
        Brand brand = brandService.getBrandById(1);
        Assert.assertTrue(brand.getBrandName().equals(BRAND_NAME_1));
        Assert.assertTrue(brand.getBrandDescription().equals(BRAND_DESCR_1));
    }

    @Test
    public void addBrandTest1() {
        LOGGER.debug("addBrandTest1()");
        Collection<BrandDTO> brands = brandService.getBrandDTOs();
        int sizeBefore = brands.size();
        Brand brand = new Brand("Audi", "4 companies");
        Brand newBrand = brandService.addBrand(brand);

        Assert.assertNotNull(newBrand);
        Assert.assertTrue(newBrand.getBrandName().equals(
                brand.getBrandName()));
        Assert.assertTrue(newBrand.getBrandSold() == brand.getBrandSold());
        Assert.assertTrue(newBrand.getBrandDescription().equals(
                brand.getBrandDescription()));
        Assert.assertTrue(
                sizeBefore + 1 == brandService.getBrandDTOs().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addBrandTest2() {
        LOGGER.debug("addBrandTest2()");
        Brand brand = new Brand("Audi", "4 companies");
        brandService.addBrand(brand);
        brandService.addBrand(brand);
    }

    @Test
    public void updateBrand() {
        LOGGER.debug("updateBrand()");

        Brand brand = new Brand("Audi", "4 companies");
        Brand newBrand = brandService.addBrand(brand);
        newBrand.setBrandName(NEW_BRAND_NAME);
        newBrand.setBrandDescription(NEW_BRAND_DESCR);
        brandService.updateBrand(newBrand);
        Brand updateBrand = brandService.getBrandById(newBrand.getBrandId());

        Assert.assertTrue(newBrand.getBrandId() ==
                updateBrand.getBrandId());
        Assert.assertTrue(newBrand.getBrandName().equals(
                updateBrand.getBrandName()));
        Assert.assertTrue(newBrand.getBrandDescription().equals(
                updateBrand.getBrandDescription()));
    }

    @Test
    public void deleteBrandTest1() {
        LOGGER.debug("deleteBrandTest1()");
        Brand brand = new Brand("Audi", "4 companies");
        brand = brandService.addBrand(brand);
        Collection<BrandDTO> brandDTOS = brandService.getBrandDTOs();
        int sizeBefore = brandDTOS.size();
        brandService.deleteBrand(brand.getBrandId());

        Assert.assertTrue(sizeBefore - 1 == brandService.getBrandDTOs().size());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void deleteBrandTest2() {
        LOGGER.debug("deleteBrandTest2()");
        brandService.deleteBrand(1);
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void deleteBrandTest3() {
        LOGGER.debug("deleteBrandTest3()");
        Brand brand = new Brand("Audi", "4 companies");
        brandService.addBrand(brand);
        brandService.deleteBrand(brand.getBrandId());
        brandService.deleteBrand(brand.getBrandId());
    }
}