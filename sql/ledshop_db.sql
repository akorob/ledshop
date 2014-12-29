-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema ledshop
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ledshop
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ledshop` DEFAULT CHARACTER SET utf8 ;
USE `ledshop` ;

-- -----------------------------------------------------
-- Table `ledshop`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ledshop`.`category` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `url` VARCHAR(400) NULL,
  `active` BIT NULL,
  `position` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ledshop`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ledshop`.`product` (
  `id` INT NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `sku` VARCHAR(45) NULL,
  `position` INT NULL,
  `shot_descr` VARCHAR(255) NULL,
  `long_descr` TEXT NULL,
  `date` DATETIME NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_product_category_idx` (`category_id` ASC),
  CONSTRAINT `fk_product_category`
    FOREIGN KEY (`category_id`)
    REFERENCES `ledshop`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ledshop`.`media`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ledshop`.`media` (
  `id` INT NOT NULL,
  `size` BIGINT NULL,
  `name` VARCHAR(255) NULL,
  `date` DATETIME NULL,
  `product_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_media_product1_idx` (`product_id` ASC),
  CONSTRAINT `fk_media_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `ledshop`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ledshop`.`photo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ledshop`.`photo` (
  `id` INT NOT NULL,
  `size` BIGINT NULL,
  `name` VARCHAR(255) NULL,
  `date` DATETIME NULL,
  `product_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_photo_product1_idx` (`product_id` ASC),
  CONSTRAINT `fk_photo_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `ledshop`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ledshop`.`prices`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ledshop`.`prices` (
  `id` INT NOT NULL,
  `price` DECIMAL(18,2) NULL,
  `product_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_prices_product1_idx` (`product_id` ASC),
  CONSTRAINT `fk_prices_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `ledshop`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
