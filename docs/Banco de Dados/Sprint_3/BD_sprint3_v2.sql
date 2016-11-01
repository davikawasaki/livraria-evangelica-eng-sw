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
-- Table `livrariaengsw`.`Pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livrariaengsw`.`Pedido` (
  `idPedido` INT NOT NULL AUTO_INCREMENT,
  `estado` TINYINT(1) NOT NULL,
  `quantidade` INT NOT NULL,
  `Produto_idProduto` INT NOT NULL,
  `Cliente_idCliente` INT NOT NULL,
  PRIMARY KEY (`idPedido`),
  INDEX `fk_Pedido_Produto1_idx` (`Produto_idProduto` ASC),
  INDEX `fk_Pedido_Cliente1_idx` (`Cliente_idCliente` ASC),
  CONSTRAINT `fk_Pedido_Produto1`
    FOREIGN KEY (`Produto_idProduto`)
    REFERENCES `livrariaengsw`.`Produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `livrariaengsw`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `livrariaengsw`.`Venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livrariaengsw`.`Venda` (
  `idVenda` INT NOT NULL AUTO_INCREMENT,
  `dataVenda` VARCHAR(45) NOT NULL,
  `valorTotal` FLOAT NOT NULL,
  `Pedido_idPedido` INT NOT NULL,
  PRIMARY KEY (`idVenda`, `Pedido_idPedido`),
  INDEX `fk_Venda_Pedido1_idx` (`Pedido_idPedido` ASC),
  CONSTRAINT `fk_Venda_Pedido1`
    FOREIGN KEY (`Pedido_idPedido`)
    REFERENCES `livrariaengsw`.`Pedido` (`idPedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `livrariaengsw`.`Pagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livrariaengsw`.`Pagamento` (
  `idPagamento` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NOT NULL,
  `valorTotal` FLOAT NOT NULL,
  `desconto` FLOAT NOT NULL,
  `horario` DATETIME NOT NULL,
  `Caixa_idCaixa` INT NOT NULL,
  `Venda_idVenda` INT NOT NULL,
  `Venda_Pedido_idPedido` INT NOT NULL,
  PRIMARY KEY (`idPagamento`, `Venda_idVenda`, `Venda_Pedido_idPedido`),
  INDEX `fk_Pagamento_Caixa1_idx` (`Caixa_idCaixa` ASC),
  INDEX `fk_Pagamento_Venda1_idx` (`Venda_idVenda` ASC, `Venda_Pedido_idPedido` ASC),
  CONSTRAINT `fk_Pagamento_Caixa1`
    FOREIGN KEY (`Caixa_idCaixa`)
    REFERENCES `livrariaengsw`.`CaixaDia` (`idCaixa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pagamento_Venda1`
    FOREIGN KEY (`Venda_idVenda` , `Venda_Pedido_idPedido`)
    REFERENCES `livrariaengsw`.`Venda` (`idVenda` , `Pedido_idPedido`)
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
  `idSaida` INT NOT NULL AUTO_INCREMENT,
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


-- -----------------------------------------------------
-- Table `livrariaengsw`.`Pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livrariaengsw`.`Pedido` (
  `idPedido` INT NOT NULL AUTO_INCREMENT,
  `estado` TINYINT(1) NOT NULL,
  `quantidade` INT NOT NULL,
  `Produto_idProduto` INT NOT NULL,
  `Cliente_idCliente` INT NOT NULL,
  PRIMARY KEY (`idPedido`),
  INDEX `fk_Pedido_Produto1_idx` (`Produto_idProduto` ASC),
  INDEX `fk_Pedido_Cliente1_idx` (`Cliente_idCliente` ASC),
  CONSTRAINT `fk_Pedido_Produto1`
    FOREIGN KEY (`Produto_idProduto`)
    REFERENCES `livrariaengsw`.`Produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `livrariaengsw`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `livrariaengsw`.`Reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livrariaengsw`.`Reserva` (
  `idReserva` INT NOT NULL AUTO_INCREMENT,
  `tempoDias` INT NOT NULL,
  `Pedido_idPedido` INT NOT NULL,
  PRIMARY KEY (`idReserva`),
  INDEX `fk_Reserva_Pedido1_idx` (`Pedido_idPedido` ASC),
  CONSTRAINT `fk_Reserva_Pedido1`
    FOREIGN KEY (`Pedido_idPedido`)
    REFERENCES `livrariaengsw`.`Pedido` (`idPedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;