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
-- Table `livrariaengsw`.`Pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livrariaengsw`.`Pessoa` (
  `idPessoa` INT NOT NULL AUTO_INCREMENT,
  `telefone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `CEP` VARCHAR(45) NOT NULL,
  `logradouro` VARCHAR(45) NOT NULL,
  `complemento` VARCHAR(45) NULL,
  `numero` INT NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `pais` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPessoa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `livrariaengsw`.`PessoaFisica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livrariaengsw`.`PessoaFisica` (
  `CPF` VARCHAR(45) NOT NULL,
  `Pessoa_idPessoa` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `sobrenome` VARCHAR(45) NOT NULL,
  `RG` VARCHAR(45) NOT NULL,
  `sexo` VARCHAR(45) NOT NULL,
  `dataNascimento` DATE NOT NULL,
  PRIMARY KEY (`CPF`),
  INDEX `fk_PessoaFisica_Pessoa_idx` (`Pessoa_idPessoa` ASC),
  CONSTRAINT `fk_PessoaFisica_Pessoa`
    FOREIGN KEY (`Pessoa_idPessoa`)
    REFERENCES `livrariaengsw`.`Pessoa` (`idPessoa`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `livrariaengsw`.`PessoaJuridica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livrariaengsw`.`PessoaJuridica` (
  `CNPJ` VARCHAR(45) NOT NULL,
  `nomeFantasia` VARCHAR(45) NOT NULL,
  `Pessoa_idPessoa` INT NOT NULL,
  INDEX `fk_PessoaJuridica_Pessoa1_idx` (`Pessoa_idPessoa` ASC),
  PRIMARY KEY (`CNPJ`),
  CONSTRAINT `fk_PessoaJuridica_Pessoa1`
    FOREIGN KEY (`Pessoa_idPessoa`)
    REFERENCES `livrariaengsw`.`Pessoa` (`idPessoa`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `livrariaengsw`.`Fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livrariaengsw`.`Fornecedor` (
  `nomeRepresentante` VARCHAR(45) NOT NULL,
  `tipoServico` VARCHAR(45) NOT NULL,
  `tipoFornecimento` VARCHAR(45) NOT NULL,
  `PessoaJuridica_CNPJ` VARCHAR(45) NOT NULL,
  INDEX `fk_Fornecedor_PessoaJuridica1_idx` (`PessoaJuridica_CNPJ` ASC),
  PRIMARY KEY (`PessoaJuridica_CNPJ`),
  CONSTRAINT `fk_Fornecedor_PessoaJuridica1`
    FOREIGN KEY (`PessoaJuridica_CNPJ`)
    REFERENCES `livrariaengsw`.`PessoaJuridica` (`CNPJ`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `livrariaengsw`.`Atendente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livrariaengsw`.`Atendente` (
  `login` VARCHAR(45) NOT NULL,
  `comecoExpediente` DATETIME NOT NULL,
  `fimExpediente` DATETIME NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `PessoaFisica_CPF` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`login`),
  INDEX `fk_Atendente_PessoaFisica1_idx` (`PessoaFisica_CPF` ASC),
  CONSTRAINT `fk_Atendente_PessoaFisica1`
    FOREIGN KEY (`PessoaFisica_CPF`)
    REFERENCES `livrariaengsw`.`PessoaFisica` (`CPF`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `livrariaengsw`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livrariaengsw`.`Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `fidelidade` TINYINT(1) NOT NULL,
  `codFidelidade` VARCHAR(45) NULL,
  `PessoaFisica_CPF` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCliente`),
  INDEX `fk_Cliente_PessoaFisica1_idx` (`PessoaFisica_CPF` ASC),
  UNIQUE INDEX `PessoaFisica_CPF_UNIQUE` (`PessoaFisica_CPF` ASC),
  CONSTRAINT `fk_Cliente_PessoaFisica1`
    FOREIGN KEY (`PessoaFisica_CPF`)
    REFERENCES `livrariaengsw`.`PessoaFisica` (`CPF`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
