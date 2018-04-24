package com.epam.brest.course.service;

import com.epam.brest.course.dao.BrandDao;
import com.epam.brest.course.model.Brand;
import org.easymock.Capture;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-db-spring.xml",
        "classpath:service-mock-test.xml"})
@Rollback
@Transactional
public class BrandServiceImplMockTest {

    private static final String BRAND_NAME_1 = "BMW";
    private static final String BRAND_DESCR_1 = "In English Bavarian Motor Works";
    private static final Brand BRAND_1 = new Brand(BRAND_NAME_1, BRAND_DESCR_1);

    @Autowired
    private BrandService brandService;

    @Autowired
    private BrandDao mockBrandDao;

    @Test
    public void updateBrand() {
        Capture<Brand> captureArgument = Capture.newInstance();
        mockBrandDao.updateBrand(EasyMock.capture(captureArgument));
        EasyMock.expectLastCall();
        EasyMock.replay(mockBrandDao);

        brandService.updateBrand(BRAND_1);

        Brand brand = captureArgument.getValue();
        Assert.assertEquals(BRAND_NAME_1, brand.getBrandName());
        Assert.assertEquals(BRAND_DESCR_1, brand.getBrandDescription());
    }

    @Test
    public void deleteBrand() {
        Capture<Integer> captureArgument = Capture.newInstance();
        mockBrandDao.deleteBrand(EasyMock.capture(captureArgument));
        EasyMock.expectLastCall();
        EasyMock.replay(mockBrandDao);

        brandService.deleteBrand(1);

        Integer brandId = captureArgument.getValue();
        Assert.assertTrue(brandId.equals(1));
    }
}
