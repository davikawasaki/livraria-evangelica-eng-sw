-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema livraria
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema livraria
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `livraria` DEFAULT CHARACTER SET utf8 ;
USE `livraria` ;

-- -----------------------------------------------------
-- Table `livraria`.`Cidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livraria`.`Cidade` (
  `idCidade` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCidade`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `livraria`.`Estado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livraria`.`Estado` (
  `idEstado` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEstado`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `livraria`.`Pais`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livraria`.`Pais` (
  `idPais` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPais`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `livraria`.`Pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livraria`.`Pessoa` (
  `idPessoa` INT NOT NULL,
  `telefone` INT NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `CEP` VARCHAR(45) NOT NULL,
  `logradouro` VARCHAR(45) NOT NULL,
  `complemento` VARCHAR(45) NULL,
  `numero` INT NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `idCidade` VARCHAR(45) NOT NULL,
  `idEstado` VARCHAR(45) NOT NULL,
  `idPais` VARCHAR(45) NOT NULL,
  `Cidade_idCidade` INT NULL,
  `Estado_idEstado` INT NULL,
  `Pais_idPais` INT NULL,
  `senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPessoa`),
  INDEX `fk_Pessoa_Cidade_idx` (`Cidade_idCidade` ASC),
  INDEX `fk_Pessoa_Estado1_idx` (`Estado_idEstado` ASC),
  INDEX `fk_Pessoa_Pais1_idx` (`Pais_idPais` ASC),
  CONSTRAINT `fk_Pessoa_Cidade`
    FOREIGN KEY (`Cidade_idCidade`)
    REFERENCES `livraria`.`Cidade` (`idCidade`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Pessoa_Estado1`
    FOREIGN KEY (`Estado_idEstado`)
    REFERENCES `livraria`.`Estado` (`idEstado`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Pessoa_Pais1`
    FOREIGN KEY (`Pais_idPais`)
    REFERENCES `livraria`.`Pais` (`idPais`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `livraria`.`PessoaFisica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livraria`.`PessoaFisica` (
  `CPF` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `sobrenome` VARCHAR(45) NOT NULL,
  `RG` VARCHAR(45) NOT NULL,
  `sexo` VARCHAR(20) NOT NULL,
  `dataNascimento` DATE NOT NULL,
  `Pessoa_idPessoa` INT NOT NULL,
  `loginFisico` VARCHAR(45) NOT NULL,
  UNIQUE INDEX `RG_UNIQUE` (`RG` ASC),
  PRIMARY KEY (`CPF`),
  UNIQUE INDEX `CPF_UNIQUE` (`CPF` ASC),
  INDEX `fk_PessoaFisica_Pessoa1_idx` (`Pessoa_idPessoa` ASC),
  UNIQUE INDEX `loginFisico_UNIQUE` (`loginFisico` ASC),
  CONSTRAINT `fk_PessoaFisica_Pessoa1`
    FOREIGN KEY (`Pessoa_idPessoa`)
    REFERENCES `livraria`.`Pessoa` (`idPessoa`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `livraria`.`PessoaJuridica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livraria`.`PessoaJuridica` (
  `CNPJ` INT NOT NULL,
  `loginJuridico` VARCHAR(45) NOT NULL,
  `nomeFantasia` VARCHAR(45) NOT NULL,
  `Pessoa_idPessoa` INT NOT NULL,
  PRIMARY KEY (`CNPJ`),
  UNIQUE INDEX `CNPJ_UNIQUE` (`CNPJ` ASC),
  INDEX `fk_PessoaJuridica_Pessoa1_idx` (`Pessoa_idPessoa` ASC),
  UNIQUE INDEX `loginJuridico_UNIQUE` (`loginJuridico` ASC),
  CONSTRAINT `fk_PessoaJuridica_Pessoa1`
    FOREIGN KEY (`Pessoa_idPessoa`)
    REFERENCES `livraria`.`Pessoa` (`idPessoa`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `livraria`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livraria`.`Cliente` (
  `PessoaFisica_CPF` INT NOT NULL,
  `fidelidade` TINYINT(1) NOT NULL,
  `codFidelidade` INT NULL,
  PRIMARY KEY (`PessoaFisica_CPF`),
  UNIQUE INDEX `codFidelidade_UNIQUE` (`codFidelidade` ASC),
  INDEX `fk_Cliente_PessoaFisica1_idx` (`PessoaFisica_CPF` ASC),
  UNIQUE INDEX `PessoaFisica_CPF_UNIQUE` (`PessoaFisica_CPF` ASC),
  CONSTRAINT `fk_Cliente_PessoaFisica1`
    FOREIGN KEY (`PessoaFisica_CPF`)
    REFERENCES `livraria`.`PessoaFisica` (`CPF`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `livraria`.`Fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livraria`.`Fornecedor` (
  `PessoaJuridica_CNPJ` INT NOT NULL,
  `nomeRepresentante` VARCHAR(45) NOT NULL,
  `tipoServico` VARCHAR(45) NOT NULL,
  `tipoFornecimento` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`PessoaJuridica_CNPJ`),
  INDEX `fk_Fornecedor_PessoaJuridica1_idx` (`PessoaJuridica_CNPJ` ASC),
  UNIQUE INDEX `PessoaJuridica_CNPJ_UNIQUE` (`PessoaJuridica_CNPJ` ASC),
  CONSTRAINT `fk_Fornecedor_PessoaJuridica1`
    FOREIGN KEY (`PessoaJuridica_CNPJ`)
    REFERENCES `livraria`.`PessoaJuridica` (`CNPJ`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `livraria`.`Atendente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livraria`.`Atendente` (
  `PessoaFisica_CPF` INT NOT NULL,
  `comecoExpediente` DATETIME NOT NULL,
  `fimExpediente` DATETIME NOT NULL,
  PRIMARY KEY (`PessoaFisica_CPF`),
  INDEX `fk_Atendente_PessoaFisica1_idx` (`PessoaFisica_CPF` ASC),
  UNIQUE INDEX `PessoaFisica_CPF_UNIQUE` (`PessoaFisica_CPF` ASC),
  CONSTRAINT `fk_Atendente_PessoaFisica1`
    FOREIGN KEY (`PessoaFisica_CPF`)
    REFERENCES `livraria`.`PessoaFisica` (`CPF`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
