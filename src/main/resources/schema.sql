DROP TABLE IF EXISTS countries;

CREATE TABLE countries (
  id NUMERIC AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  country_acronym VARCHAR(250) NOT NULL,
  population NUMERIC DEFAULT 0,
  UNIQUE(name)
);

DROP TABLE IF EXISTS mortalities;

CREATE TABLE mortalities (
  id NUMERIC AUTO_INCREMENT PRIMARY KEY,
  sex VARCHAR(250) NOT NULL,
  year NUMERIC DEFAULT 0,
  mortality NUMERIC DEFAULT 0,
  country_id NUMERIC DEFAULT null,
  FOREIGN KEY (country_id) REFERENCES countries
);