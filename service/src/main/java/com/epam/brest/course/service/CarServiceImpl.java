package com.epam.brest.course.service;

import com.epam.brest.course.dao.CarDao;
import com.epam.brest.course.model.Car;
import com.epam.brest.course.model.DTO.CarDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;

/**
 * Car service.
 */
public class CarServiceImpl implements CarService {

    /**
     * Constant variable for logs.
     */
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * CarDao.
     */
    private CarDao carDao;


    public CarServiceImpl(final CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public Collection<CarDTO> getCars() {
        LOGGER.debug("getCars()");
        Collection<CarDTO> carDTOS = carDao.getCars();
        LOGGER.debug("getCars({})", carDTOS);
        return carDTOS;
    }

    @Override
    public Car getCarById(Integer carId) {
        LOGGER.debug("getCarById({})", carId);
        Car car = carDao.getCarById(carId);
        LOGGER.debug("getCarById({})", car);
        return car;
    }

    @Override
    public Car addCar(Car car) throws NullPointerException {
        LOGGER.debug("addCar({})", car);
        Car newCar = carDao.addCar(car);
        LOGGER.debug("addCar({})", newCar);
        return newCar;
    }

    @Override
    public void updateCar(Car car) {
        LOGGER.debug("updateCar({})", car);
        carDao.updateCar(car);
    }

    @Override
    public void deleteCarById(Integer carId) {
        LOGGER.debug("deleteCarById({})", carId);
        carDao.deleteCarById(carId);
    }
}
