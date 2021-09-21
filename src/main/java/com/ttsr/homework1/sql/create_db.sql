CREATE SCHEMA `cinema_homework`;

CREATE TABLE `films` (
  `idfilms` INT NOT NULL AUTO_INCREMENT,
  `film_name` VARCHAR(245) NOT NULL,
  `film_duration` INT NOT NULL,
  PRIMARY KEY (`idfilms`),
  UNIQUE INDEX `idfilms_UNIQUE` (`idfilms` ASC) VISIBLE);

CREATE TABLE `sessions` (
  `idsessions` INT NOT NULL AUTO_INCREMENT,
  `film_id` INT NOT NULL,
  `start_time` DATETIME NOT NULL,
  `price` DECIMAL,
  PRIMARY KEY (`idsessions`),
  UNIQUE INDEX `idsessions_UNIQUE` (`idsessions` ASC) VISIBLE),
  FOREIGN KEY (`film_id`)
  REFERENCES `interview_homework`.`films` (`idfilms`);

CREATE TABLE `orders` (
  `idorders` INT NOT NULL AUTO_INCREMENT,
  `seat` INT NOT NULL,
  `session_id` INT NOT NULL,
  PRIMARY KEY (`idorders`),
  UNIQUE INDEX `idorders_UNIQUE` (`idorders` ASC) VISIBLE),
  FOREIGN KEY (`session_id`)
  REFERENCES `sessions` (`idsessions`);

insert into films (film_name,film_duration) values
('Silent Hill',120),
('Resident Evil',90),
('Flame Horizon',60),
('Earth is gone',120),
('The sparkle',120);
