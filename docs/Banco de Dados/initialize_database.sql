drop table Midia; drop table Livro; drop table Cartao; drop table Pagamento; drop table Reserva; drop table Venda; drop table Saida; drop table CaixaDia; drop table Pedido; drop table Produto; drop table Cliente; drop table Fornecedor; drop table Atendente; drop table PessoaJuridica; drop table PessoaFisica; drop table Pessoa;

insert into Pessoa values(1, "1234-5678", "lucas@email.com", "123456", "Rua dois", "nao tem", 123, "Vila Nova", "Cidade Nova", "Estado Novo", "Pais Novo");
insert into PessoaFisica values("1234567899", 1, "Lucas", "Franco", "12345687654", "M", '2010-10-10');
insert into Cliente values(1, 1, "fid123", "1234567899");
insert into CaixaDia values(1, 200, 100, 80, 20, 20, 10, '2016-11-03');
insert into Produto values(1, "Core Java", 1, 80.99, "PT-BR", 1959, 12);
insert into Pedido values(1, 1, 10, 1, 1);
insert into Venda values(1, '2016-11-03 10:20:00', 100, 1);
