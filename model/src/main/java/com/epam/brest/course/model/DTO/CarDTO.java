package com.epam.brest.course.model.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Date;

/**
 * CarDTO class.
 */
public class CarDTO {

    /**
     * Constant variable for length of fields parameters.
     */
    private static final int MAX_LENGTH_OF_STRING = 255;

    /**
     * Property Id.
     */
    private Integer carId;

    /**
     * Property Name.
     */
    @NotEmpty
    @Size(min = 2, max = MAX_LENGTH_OF_STRING)
    private String carName;

    /**
     * Property Date of sale.
     */

    private Date carDateOfSale;

    /**
     * Constructor without parameters for CarDTO.
     */
    public CarDTO() {
    }

    /**
     * Constructor with parameters for CarDTO.
     *
     * @param carName name of Car.
     * @param carDateOfSale date of sale Car.
     */
    public CarDTO(final String carName, final Date carDateOfSale) {
        this.carName = carName;
        this.carDateOfSale = carDateOfSale;
    }

    /**
     * Get car Id.
     *
     * @return CarId.
     */
    public Integer getCarId() {
        return carId;
    }

    /**
     * Set car Id.
     *
     * @param carId CarId.
     */
    public void setCarId(final Integer carId) {
        this.carId = carId;
    }

    /**
     * Get car Name.
     *
     * @return CarName.
     */
    public String getCarName() {
        return carName;
    }

    /**
     * Set car Name.
     *
     * @param carName CarName.
     */
    public void setCarName(final String carName) {
        this.carName = carName;
    }

    /**
     * Get car Date of sale.
     *
     * @return CarDateOfSale.
     */
    public Date getCarDateOfSale() {
        return carDateOfSale;
    }

    /**
     * Set car Date of sale.
     *
     * @param carDateOfSale CarDateOfSale.
     */
    public void setCarDateOfSale(final Date carDateOfSale) {
        this.carDateOfSale = carDateOfSale;
    }

    @Override
    public String toString() {
        return "CarDTO{"
                + "carId=" + carId
                + ", carName='" + carName + '\''
                + ", carDateOfSale=" + carDateOfSale
                + '}';
    }
}
