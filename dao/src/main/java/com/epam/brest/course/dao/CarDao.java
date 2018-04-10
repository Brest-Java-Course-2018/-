package com.epam.brest.course.dao;

import com.epam.brest.course.model.Car;
import com.epam.brest.course.model.DTO.CarDTO;

import java.util.Collection;

/**
 * Car class.
 */
public interface CarDao {

    /**
     * Get list of cars.
     *
     * @return List of objects CarDTO.
     */
    Collection<CarDTO> getCars();

    /**
     * Get car.
     *
     * @param carId car number.
     * @return Car.
     */
    Car getCarById(Integer carId);

    /**
     * Add new car.
     *
     * @param car new car.
     * @return Car.
     */
    Car addCar(Car car);

    /**
     * Update car.
     *
     * @param car new version of old car.
     */
    void updateCar(Car car);

    /**
     * Delete car.
     *
     * @param id what car to remove.
     */
    void deleteCarById(Integer id);
}
