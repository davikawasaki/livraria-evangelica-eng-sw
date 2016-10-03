-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema livrariaengsw
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema livrariaengsw
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `livrariaengsw` DEFAULT CHARACTER SET utf8 ;
USE `livrariaengsw` ;

-- -----------------------------------------------------
-- Table `livrariaengsw`.`Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livrariaengsw`.`Produto` (
  `idProduto` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NOT NULL,
  `tipo` INT NOT NULL,
  `preco` FLOAT NOT NULL,
  `idioma` VARCHAR(45) NULL,
  `anoLancamento` INT NULL,
  `quantidade` INT NOT NULL,
  PRIMARY KEY (`idProduto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `livrariaengsw`.`Midia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livrariaengsw`.`Midia` (
  `Produto_idProduto` INT NOT NULL,
  `artista` VARCHAR(45) NOT NULL,
  `tipoMidia` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Produto_idProduto`),
  INDEX `fk_Midia_Produto_idx` (`Produto_idProduto` ASC),
  CONSTRAINT `fk_Midia_Produto`
    FOREIGN KEY (`Produto_idProduto`)
    REFERENCES `livrariaengsw`.`Produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `livrariaengsw`.`Livro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livrariaengsw`.`Livro` (
  `Produto_idProduto` INT NOT NULL,
  `editora` VARCHAR(45) NOT NULL,
  `autor` VARCHAR(45) NOT NULL,
  INDEX `fk_Livro_Produto1_idx` (`Produto_idProduto` ASC),
  PRIMARY KEY (`Produto_idProduto`),
  CONSTRAINT `fk_Livro_Produto1`
    FOREIGN KEY (`Produto_idProduto`)
    REFERENCES `livrariaengsw`.`Produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `livrariaengsw`.`CaixaDia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livrariaengsw`.`CaixaDia` (
  `idCaixa` INT NOT NULL AUTO_INCREMENT,
  `saldoInicial` VARCHAR(45) NOT NULL,
  `entradaBruto` FLOAT NOT NULL,
  `entradaReal` FLOAT NOT NULL,
  `saldoLiquido` FLOAT NOT NULL,
  `saldoReal` FLOAT NOT NULL,
  `saidaTotal` FLOAT NOT NULL,
  `data` DATE NOT NULL,
  PRIMARY KEY (`idCaixa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `livrariaengsw`.`Pagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livrariaengsw`.`Pagamento` (
  `idPagamento` INT NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `valorTotal` FLOAT NOT NULL,
  `desconto` FLOAT NOT NULL,
  `horario` DATETIME NOT NULL,
  `Caixa_idCaixa` INT NOT NULL,
  PRIMARY KEY (`idPagamento`),
  INDEX `fk_Pagamento_Caixa1_idx` (`Caixa_idCaixa` ASC),
  CONSTRAINT `fk_Pagamento_Caixa1`
    FOREIGN KEY (`Caixa_idCaixa`)
    REFERENCES `livrariaengsw`.`CaixaDia` (`idCaixa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `livrariaengsw`.`Cartao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livrariaengsw`.`Cartao` (
  `Pagamento_idPagamento` INT NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `numeroParcelas` INT NOT NULL,
  PRIMARY KEY (`Pagamento_idPagamento`),
  CONSTRAINT `fk_Cartao_Pagamento1`
    FOREIGN KEY (`Pagamento_idPagamento`)
    REFERENCES `livrariaengsw`.`Pagamento` (`idPagamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `livrariaengsw`.`Saida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livrariaengsw`.`Saida` (
  `idSaida` INT NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `valor` FLOAT NOT NULL,
  `Caixa_idCaixa` INT NOT NULL,
  PRIMARY KEY (`idSaida`),
  INDEX `fk_Saida_Caixa1_idx` (`Caixa_idCaixa` ASC),
  CONSTRAINT `fk_Saida_Caixa1`
    FOREIGN KEY (`Caixa_idCaixa`)
    REFERENCES `livrariaengsw`.`CaixaDia` (`idCaixa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
