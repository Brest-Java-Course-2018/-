package com.epam.brest.course.service;

import com.epam.brest.course.model.Car;
import com.epam.brest.course.model.DTO.CarDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Collection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-db-spring.xml",
        "classpath:service-test.xml", "classpath:dao.xml"})
@Rollback
@Transactional
public class CarServiceImplTest {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String CAR_NAME = "330i Automatic";
    private static final String CAR_DATE_OF_SALE = "2018-03-26";
    private static final String CAR_DESCR = "Efficient and strong four-cylinder engine.";
    private static final String NEW_CAR_NAME = "VOLVO";
    private static final String NEW_CAR_DATE_OF_SALE = "2018-03-24";
    private static final String NEW_CAR_DESCR = "just volvo";

    @Autowired
    CarService carService;

    @Test
    public void getCars() {
        LOGGER.debug("getCars()");
        carService.addCar(new Car("qwerty",
                Date.valueOf("2018-04-16"), "uiopjkl", 1));
        Assert.assertFalse(carService.getCars().isEmpty());
    }

    @Test
    public void getCarById() {
        LOGGER.debug("getCarById()");
        Car car = carService.getCarById(1);
        Assert.assertNotNull(car);
        Assert.assertTrue(car.getCarId().equals(1));
        Assert.assertTrue(car.getCarName().equals(CAR_NAME));
        Assert.assertTrue(car.getCarDateOfSale().equals(
                Date.valueOf(CAR_DATE_OF_SALE)));
        Assert.assertTrue(car.getCarDescription().equals(CAR_DESCR));
        Assert.assertTrue(car.getBrId().equals(1));
    }

    @Test
    public void addCarTest1() {
        LOGGER.debug("addCarTest1()");
        Collection<CarDTO> cars = carService.getCars();
        int sizeBefore = cars.size();
        Car car = new Car(CAR_NAME,
                Date.valueOf(CAR_DATE_OF_SALE), CAR_DESCR, 1);
        Car newCar = carService.addCar(car);

        Assert.assertNotNull(newCar);
        Assert.assertTrue(newCar.getCarName().equals(car.getCarName()));
        Assert.assertTrue(newCar.getCarDateOfSale().equals(
                car.getCarDateOfSale()));
        Assert.assertTrue(newCar.getCarDescription().equals(
                car.getCarDescription()));
        Assert.assertTrue(newCar.getBrId().equals(
                car.getBrId()));
        Assert.assertTrue(sizeBefore + 1 == carService.getCars().size());
    }

    @Test
    public void addCarTest2() {
        LOGGER.debug("addCarTest2()");
        Car car = new Car(null,
                Date.valueOf(CAR_DATE_OF_SALE), CAR_DESCR, 1);
        carService.addCar(car);
    }

    @Test
    public void updateCar() {
        Car car = new Car(CAR_NAME,
                Date.valueOf(CAR_DATE_OF_SALE), CAR_DESCR, 1);
        Car newCar = carService.addCar(car);
        newCar.setCarName(NEW_CAR_NAME);
        newCar.setCarDateOfSale(Date.valueOf(NEW_CAR_DATE_OF_SALE));
        newCar.setCarDescription(NEW_CAR_DESCR);
        carService.updateCar(newCar);
        Car updateCar = carService.getCarById(
                newCar.getCarId());

        Assert.assertTrue(updateCar.getCarId().equals(
                newCar.getCarId()));
        Assert.assertTrue(updateCar.getCarName().equals(
                newCar.getCarName()));
        Assert.assertTrue(updateCar.getCarDateOfSale().equals(
                newCar.getCarDateOfSale()));
        Assert.assertTrue(updateCar.getCarDescription().equals(
                newCar.getCarDescription()));
        Assert.assertTrue(updateCar.getBrId().equals(
                newCar.getBrId()));
    }

    @Test
    public void deleteCarById() {
        Car car = new Car(CAR_NAME,
                Date.valueOf(CAR_DATE_OF_SALE), CAR_DESCR, 1);
        car = carService.addCar(car);
        Collection<CarDTO> cars = carService.getCars();
        int sizeBefore = cars.size();
        carService.deleteCarById(car.getCarId());

        Assert.assertTrue(sizeBefore - 1 == carService.getCars().size());
    }
}