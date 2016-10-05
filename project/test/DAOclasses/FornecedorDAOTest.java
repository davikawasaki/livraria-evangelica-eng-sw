/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOclasses;

import Classes.Fornecedor;
import Classes.Pessoa;
import Classes.PessoaJuridica;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author davikawasaki
 */
public class FornecedorDAOTest {
//    Testes de caixa branca
//    Verifica possível retorno de exceção do construtor
//    Conexão equivocada com usuário ou senha errada (mudar os valores de acesso ao JDBC)
    @Test
    public void testeConexaoFornecedorDAOConnectionFactoryInvalido() throws Exception {
        String expResult = "Erro ao conectar com o banco";
        try {
            FornecedorDAO fdao = new FornecedorDAO();
            fdao.setaConexaoFornecedorDAO("root", "root123");
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
//    Verifica possível retorno de exceção da inserção vazia do fornecedor
    @Test
    public void testeAdicionaFornecedorDAOInvalido1() throws Exception {
        String expResult = "Campo nulo, erro ao enviar o fornecedor para o banco";
        Fornecedor fornecedor = new Fornecedor();
        FornecedorDAO fdao = new FornecedorDAO();
        try {
            fdao.adiciona(fornecedor);
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
//    Verifica se o fornecedor foi adicionado com sucesso
    @Test
    public void testeAdicionaFornecedorDAOValido() throws Exception {
        Fornecedor fornecedor = new Fornecedor();
        PessoaJuridica pj = new PessoaJuridica();
        Pessoa pessoa = new Pessoa();
        FornecedorDAO fdao = new FornecedorDAO();
        pessoa.setId(2);
        pessoa.setEmail("abc@abc.com");
        pessoa.setSenha("123@abc");
        pessoa.setTelefone("(43)99999-9999");
        pessoa.setCEP("99999-999");
        pessoa.setLogradouro("Rua Abc");
        pessoa.setNumero(10);
        pessoa.setComplemento("Sala 2");
        pessoa.setBairro("Centro");
        pessoa.setCidade("Abc");
        pessoa.setEstado("Abc");
        pessoa.setPais("Abc");
        pj.setCNPJ("13.235.412/2122-33");
        pj.setNomeFantasia("Abc");
        pj.setPessoa(pessoa);

        fornecedor.setNomeRepresentante("Abc");
        fornecedor.setTipoFornecimento("Consignado");
        fornecedor.setTipoServico("Venda");
        fornecedor.setPj(pj);

        boolean resultAdiciona = fdao.adiciona(fornecedor);
        assertTrue(resultAdiciona);
    }
//    Verifica se o retorno foi realizado com sucesso
    @Test
    public void testeListaFornecedorDAOValido() throws Exception {
        FornecedorDAO fdao = new FornecedorDAO();
        List lista = fdao.getLista();
        assertTrue(lista instanceof java.util.List);
    }
//    Verifica possível retorno de exceção da update vazio do fornecedor
    @Test
    public void testeAlteraFornecedorDAOInvalido1() throws Exception {
        String expResult = "Campo nulo, erro ao enviar o fornecedor para o banco";
        Fornecedor fornecedor = new Fornecedor();
        FornecedorDAO fdao = new FornecedorDAO();
        try {
            fdao.altera(fornecedor);
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
//    Verifica se o fornecedor foi alterado com sucesso
    @Test
    public void testeAlteraFornecedorDAOValido() throws Exception {
        FornecedorDAO fdao = new FornecedorDAO();
        
        Pessoa pessoa = new Pessoa();
        pessoa.setEmail("abc@abc.com");
        pessoa.setSenha("123@abc");
        pessoa.setTelefone("(43)99999-9999");
        pessoa.setCEP("99999-999");
        pessoa.setLogradouro("Rua Abc");
        pessoa.setNumero(10);
        pessoa.setComplemento("Sala 2");
        pessoa.setBairro("Centro");
        pessoa.setCidade("Abc");
        pessoa.setEstado("Abc");
        pessoa.setPais("Abc");
        
        PessoaJuridica pj = new PessoaJuridica();
        pj.setCNPJ("11.111.111/1111-11");
        pj.setNomeFantasia("Abc");
        pj.setPessoa(pessoa);
        
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNomeRepresentante("Ronaldo");
        fornecedor.setTipoFornecimento("Consignado");
        fornecedor.setTipoServico("Venda");
        fornecedor.setPj(pj);
        
        boolean resultAltera = fdao.altera(fornecedor);
        assertTrue(resultAltera);        
    }
}
