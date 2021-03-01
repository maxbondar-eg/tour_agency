-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema tour_agency_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tour_agency_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tour_agency_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `tour_agency_db` ;

-- -----------------------------------------------------
-- Table `tour_agency_db`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tour_agency_db`.`account` (
  `id` INT NOT NULL,
  `active` BIT(1) NOT NULL,
  `first_name` VARCHAR(2048) NULL DEFAULT NULL,
  `last_name` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `username` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UKgex1lmaqpg0ir5g1f5eftyaa1` (`username` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tour_agency_db`.`hibernate_sequence`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tour_agency_db`.`hibernate_sequence` (
  `next_val` BIGINT NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tour_agency_db`.`tour`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tour_agency_db`.`tour` (
  `id` INT NOT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `img` VARCHAR(255) NULL DEFAULT NULL,
  `is_hot` BIT(1) NOT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `people_amount` INT NOT NULL,
  `price` INT NOT NULL,
  `stars` INT NOT NULL,
  `tour_type` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tour_agency_db`.`tour_order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tour_agency_db`.`tour_order` (
  `id` INT NOT NULL,
  `status` INT NULL DEFAULT NULL,
  `tickets_quantity` INT NULL DEFAULT NULL,
  `user_id` INT NULL DEFAULT NULL,
  `tour_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK31np5r7cqxmaodl8tx09x244p` (`user_id` ASC) VISIBLE,
  INDEX `FK3kgc5yg2gcv2r4xxftprjk0q8` (`tour_id` ASC) VISIBLE,
  CONSTRAINT `FK31np5r7cqxmaodl8tx09x244p`
    FOREIGN KEY (`user_id`)
    REFERENCES `tour_agency_db`.`account` (`id`),
  CONSTRAINT `FK3kgc5yg2gcv2r4xxftprjk0q8`
    FOREIGN KEY (`tour_id`)
    REFERENCES `tour_agency_db`.`tour` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tour_agency_db`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tour_agency_db`.`user_role` (
  `user_id` INT NOT NULL,
  `roles` VARCHAR(255) NULL DEFAULT NULL,
  INDEX `FKlkhooy5w45r7bji6wv27a0wuq` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FKlkhooy5w45r7bji6wv27a0wuq`
    FOREIGN KEY (`user_id`)
    REFERENCES `tour_agency_db`.`account` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
