DROP TABLE IF EXISTS brand;
CREATE TABLE brand (
    brand_id          INT          NOT NULL AUTO_INCREMENT
  , brand_name        VARCHAR(255) NOT NULL
  , brand_description VARCHAR(255) NULL
  , PRIMARY KEY (brand_id)
);

DROP TABLE IF EXISTS car;
CREATE TABLE car (
    car_id           INT          NOT NULL AUTO_INCREMENT
  , car_name         VARCHAR(255) NOT NULL
  , car_date_of_sale DATE         NOT NULL
  , car_description  VARCHAR(255) NULL
  , br_id            INT          NOT NULL
  , PRIMARY KEY (car_id)
  , CONSTRAINT car_to_brand_fk
    FOREIGN KEY (br_id)
    REFERENCES brand (brand_id)
);