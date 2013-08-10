SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `dbgames` ;
CREATE SCHEMA IF NOT EXISTS `dbgames` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `dbgames` ;

-- -----------------------------------------------------
-- Table `dbgames`.`genero`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dbgames`.`genero` ;

CREATE  TABLE IF NOT EXISTS `dbgames`.`genero` (
  `gen_id` INT NOT NULL AUTO_INCREMENT ,
  `gen_nome` VARCHAR(50) NOT NULL ,
  `gen_descricao` VARCHAR(100) NULL ,
  PRIMARY KEY (`gen_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbgames`.`plataforma`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dbgames`.`plataforma` ;

CREATE  TABLE IF NOT EXISTS `dbgames`.`plataforma` (
  `pla_id` INT NOT NULL AUTO_INCREMENT ,
  `pla_nome` VARCHAR(45) NOT NULL ,
  `pla_descricao` VARCHAR(100) NULL ,
  PRIMARY KEY (`pla_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbgames`.`midia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dbgames`.`midia` ;

CREATE  TABLE IF NOT EXISTS `dbgames`.`midia` (
  `mid_id` INT NOT NULL AUTO_INCREMENT ,
  `mid_nome` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`mid_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbgames`.`game`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dbgames`.`game` ;

CREATE  TABLE IF NOT EXISTS `dbgames`.`game` (
  `game_id` INT NOT NULL AUTO_INCREMENT ,
  `game_nome` VARCHAR(50) NOT NULL ,
  `game_data` DATETIME NOT NULL ,
  `game_descricao` VARCHAR(100) NULL ,
  `game_capa` LONGBLOB NULL ,
  `gen_id` INT NULL ,
  `pla_id` INT NULL ,
  `mid_id` INT NULL ,
  PRIMARY KEY (`game_id`) ,
  INDEX `fk_genero_idx` (`gen_id` ASC) ,
  INDEX `fk_midia_idx` (`mid_id` ASC) ,
  INDEX `fk_plataforma_idx` (`pla_id` ASC) ,
  CONSTRAINT `fk_genero`
    FOREIGN KEY (`gen_id` )
    REFERENCES `dbgames`.`genero` (`gen_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_midia`
    FOREIGN KEY (`mid_id` )
    REFERENCES `dbgames`.`midia` (`mid_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_plataforma`
    FOREIGN KEY (`pla_id` )
    REFERENCES `dbgames`.`plataforma` (`pla_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `dbgames` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
