package com.epam.brest.course.dao;

import com.epam.brest.course.model.Car;
import com.epam.brest.course.model.DTO.CarDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.util.Collection;

/**
 * CRUD for Car.
 */
public class CarDaoImpl implements CarDao {

    /**
     * Constant variable for logs.
     */
    private static final Logger LOGGER = LogManager.getLogger();
    /**
     * Constant variable.
     */
    private static final String CAR_ID = "car_id";
    /**
     * Constant variable.
     */
    private static final String CAR_NAME = "car_name";
    /**
     * Constant variable.
     */
    private static final String CAR_DATE_OF_SALE = "car_date_of_sale";
    /**
     * Constant variable.
     */
    private static final String CAR_DESCRIPTION = "car_description";
    /**
     * Constant variable.
     */
    public static final String CAR_BRAND_ID = "br_id";

    /**
     * Query for select.
     */
    @Value("${car.select}")
    private String select;
    /**
     * Query for select by id.
     */
    @Value("${car.select_by_id}")
    private String selectById;
    /**
     * Query for inserting.
     */
    @Value("${car.insert}")
    private String insert;
    /**
     * Query for updating.
     */
    @Value("${car.update}")
    private String update;
    /**
     * Query for deleting.
     */
    @Value("${car.delete}")
    private String delete;

    /**
     * Class NamedParameterJdbcTemplate from spring JDBC.
     */
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * Constructor.
     *
     * @param namedParameterJdbcTemplate new namedParameterJdbcTemplate.
     */
    public CarDaoImpl(
            final NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }



    @Override
    public Collection<CarDTO> getCars() {
        LOGGER.debug("getCars()");
        Collection<CarDTO> carDTOS =
                namedParameterJdbcTemplate.getJdbcOperations().query(
                        select,
                        BeanPropertyRowMapper.newInstance(CarDTO.class));
        LOGGER.debug("getCars({})", carDTOS);
        return carDTOS;
    }

    @Override
    public Car getCarById(final Integer carId) {
        LOGGER.debug("getCarById({})", carId);
        SqlParameterSource namedParametrs =
                new MapSqlParameterSource(CAR_ID, carId);
        Car car = namedParameterJdbcTemplate.queryForObject(
                selectById, namedParametrs,
                BeanPropertyRowMapper.newInstance(Car.class));
        LOGGER.debug("getCarById({})", car);
        return car;
    }

    @Override
    public Car addCar(final Car car) {
        LOGGER.debug("addCar({})", car);
        MapSqlParameterSource namedParameters =
                new MapSqlParameterSource(CAR_NAME, car.getCarName());
        namedParameters.addValue(CAR_DATE_OF_SALE, car.getCarDateOfSale());
        namedParameters.addValue(CAR_DESCRIPTION, car.getCarDescription());
        namedParameters.addValue(CAR_BRAND_ID, car.getBrId());

        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(
                insert, namedParameters, generatedKeyHolder);
        car.setCarId(generatedKeyHolder.getKey().intValue());
        return car;
    }

    @Override
    public void updateCar(final Car car) {
        LOGGER.debug("updateCar({})", car);
        MapSqlParameterSource namedParameters =
                new MapSqlParameterSource(CAR_ID, car.getCarId());
        namedParameters.addValue(CAR_NAME, car.getCarName());
        namedParameters.addValue(CAR_DATE_OF_SALE, car.getCarDateOfSale());
        namedParameters.addValue(CAR_DESCRIPTION, car.getCarDescription());
        namedParameters.addValue(CAR_BRAND_ID, car.getBrId());
        namedParameterJdbcTemplate.update(update, namedParameters);
    }

    @Override
    public void deleteCarById(final Integer id) {
        LOGGER.debug("deleteCarById({})", id);
        namedParameterJdbcTemplate.getJdbcOperations().update(
                delete, id);
    }
}
