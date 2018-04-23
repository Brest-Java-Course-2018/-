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
        return null;
    }

    @Override
    public Car getCarById(Integer carId) {
        return null;
    }

    @Override
    public Car addCar(Car car) throws NullPointerException {
        return null;
    }

    @Override
    public void updateCar(Car car) {

    }

    @Override
    public void deleteCarById(Integer carId) {

    }
}
