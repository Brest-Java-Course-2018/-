package com.epam.brest.course.dao;

import com.epam.brest.course.model.Brand;
import com.epam.brest.course.model.DTO.BrandDTO;
import com.epam.brest.course.model.DTO.BrandShortDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.util.Collection;

/**
 * CRUD for Brand.
 */
public class BrandDaoImpl implements BrandDao {

    /**
     * Constant variable for logs.
     */
    private static final Logger LOGGER = LogManager.getLogger();
    /**
     * Constant variable.
     */
    private static final String BRAND_ID = "brand_id";
    /**
     * Constant variable.
     */
    private static final String BRAND_NAME = "brand_name";
    /**
     * Constant variable.
     */
    private static final String BRAND_DESCRIPTION = "brand_description";

    /**
     * Query for selectShortDTO.
     */
    @Value("${brand.selectShortDTO}")
    private String selectShortDTO;
    /**
     * Query for selectDTO.
     */
    @Value("${brand.selectDTO}")
    private String selectDTO;
    /**
     * Query for select by id.
     */
    @Value("${brand.selectById}")
    private String selectById;
    /**
     * Query for count of number.
     */
    @Value("${brand.checkBrand}")
    private String checkBrand;
    /**
     * Query for inserting.
     */
    @Value("${brand.insert}")
    private String insert;
    /**
     * Query for updating.
     */
    @Value("${brand.update}")
    private String update;
    /**
     * Query for deleting.
     */
    @Value("${brand.delete}")
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
    public BrandDaoImpl(
            final NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        LOGGER.debug("constructor BrandDaoImpl({})",
                namedParameterJdbcTemplate);
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Collection<BrandShortDTO> getBrandShortDTO() {
        LOGGER.debug("getBrandShortDTO()");
        Collection<BrandShortDTO> brandShortDTOS =
                namedParameterJdbcTemplate.getJdbcOperations().query(
                        selectShortDTO,
                        BeanPropertyRowMapper.newInstance(
                                BrandShortDTO.class));
        LOGGER.debug("getBrandShortDTO({})", brandShortDTOS);
        return brandShortDTOS;
    }

    @Override
    public Collection<BrandDTO> getBrandDTOs() {
        LOGGER.debug("getBrandDTOs()");
        Collection<BrandDTO> brandDTOS =
                namedParameterJdbcTemplate.getJdbcOperations().query(
                        selectDTO,
                        BeanPropertyRowMapper.newInstance(BrandDTO.class));
        LOGGER.debug("getBrandDTOs({})", brandDTOS);
        return brandDTOS;
    }

    @Override
    public Brand getBrandById(final Integer brandId) {
        LOGGER.debug("getBrandById({})", brandId);
        SqlParameterSource namedParametrs =
                new MapSqlParameterSource(BRAND_ID, brandId);
        Brand brand = namedParameterJdbcTemplate.queryForObject(
                selectById, namedParametrs,
                BeanPropertyRowMapper.newInstance(Brand.class));
        LOGGER.debug("getBrandById({})", brand);
        return brand;
    }

    @Override
    public Brand addBrand(final Brand brand)
        throws IllegalArgumentException {
        LOGGER.debug("addBrand({})", brand);
        MapSqlParameterSource namedParameters = new MapSqlParameterSource(
                BRAND_NAME, brand.getBrandName());

        Integer result = namedParameterJdbcTemplate.queryForObject(
                checkBrand, namedParameters, Integer.class);

        if (result == 0) {
            namedParameters = new MapSqlParameterSource();
            namedParameters.addValue(BRAND_NAME, brand.getBrandName());
            namedParameters.addValue(
                    BRAND_DESCRIPTION, brand.getBrandDescription());

            KeyHolder generatedKeyHolder = new GeneratedKeyHolder();

            namedParameterJdbcTemplate.update(
                    insert, namedParameters, generatedKeyHolder);
            brand.setBrandId(generatedKeyHolder.getKey().intValue());
        } else {
            throw new IllegalArgumentException(
                    "Brand with the same name already exists");
        }
        LOGGER.debug("addBrand({})", brand);
        return brand;
    }

    @Override
    public void updateBrand(final Brand brand) {
        LOGGER.debug("updateBrand({})", brand);
        MapSqlParameterSource namedParameter = new MapSqlParameterSource(
                BRAND_ID, brand.getBrandId());
        namedParameter.addValue(BRAND_NAME, brand.getBrandName());
        namedParameter.addValue(
                BRAND_DESCRIPTION, brand.getBrandDescription());
        namedParameterJdbcTemplate.update(update, namedParameter);
    }

    @Override
    public void deleteBrand(final Integer brandId)
        throws EmptyResultDataAccessException,
               DataIntegrityViolationException {
        LOGGER.debug("deleteBrand({})", brandId);
        Brand brand = getBrandById(brandId);
        LOGGER.debug("{}", brand);
        namedParameterJdbcTemplate.getJdbcOperations()
                .update(delete, brandId);
    }
}
