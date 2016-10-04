/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import DAOclasses.FornecedorDAO;
import DAOclasses.PessoaDAO;
import DAOclasses.PessoaJuridicaDAO;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Ignore;
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
//    Verifica possível retorno de exceção da inserção vazia de toda a stack tree do fornecedor    
    @Test
    public void testeAdicionaFornecedorDAOInvalido2() throws Exception {
        String expResult = "Campo nulo, erro ao enviar o fornecedor para o banco";
        Fornecedor fornecedor = new Fornecedor();
        FornecedorDAO fdao = new FornecedorDAO();
        PessoaJuridica pj = new PessoaJuridica();
        PessoaJuridicaDAO pjdao = new PessoaJuridicaDAO();
        Pessoa pessoa = new Pessoa();
        PessoaDAO pdao = new PessoaDAO();
        try {
            pdao.adiciona(pessoa);
            pjdao.adiciona(pj);
            fdao.adiciona(fornecedor);
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
//    Teste para caso de chave duplicada já inserida no banco (colocar valores de chaves duplicadas)
//    Teste para tabelas inexistentes (tabelas Pessoa, PessoaJuridica e Fornecedor)
//    Teste para query SQL erradas
    @Test
    public void testeAdicionaFornecedorDAOInvalido3() throws Exception {
        String expResult = "Erro ao enviar o fornecedor para o banco";
        Fornecedor fornecedor = new Fornecedor();
        PessoaJuridica pj = new PessoaJuridica();
        Pessoa pessoa = new Pessoa();
        FornecedorDAO fdao = new FornecedorDAO();
        
        try {
            pessoa.setId(1);
            pessoa.setEmail("abc@abc.com");
            pessoa.setSenha("123");
            pessoa.setTelefone("(43)99999-9999");
            pessoa.setCEP("99999-999");
            pessoa.setLogradouro("Rua Abc");
            pessoa.setNumero(10);
            pessoa.setComplemento("Sala 2");
            pessoa.setBairro("Centro");
            pessoa.setCidade("Abc");
            pessoa.setEstado("Abc");
            pessoa.setPais("Abc");

            pj.setCNPJ("18.345.611/9142-33");
            pj.setNomeFantasia("Abc");
            pj.setPessoa(pessoa);

            fornecedor.setNomeRepresentante("Abc");
            fornecedor.setTipoFornecimento("Consignado");
            fornecedor.setTipoServico("Venda");
            fornecedor.setPj(pj);
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
        try {
            pessoa.setId(2);
            pessoa.setEmail("abc@abc.com");
            pessoa.setSenha("123");
            pessoa.setTelefone("(43)99999-9999");
            pessoa.setCEP("99999-999");
            pessoa.setLogradouro("Rua Abc");
            pessoa.setNumero(10);
            pessoa.setComplemento("Sala 2");
            pessoa.setBairro("Centro");
            pessoa.setCidade("Abc");
            pessoa.setEstado("Abc");
            pessoa.setPais("Abc");

            pj.setCNPJ("13.035.541/9142-33");
            pj.setNomeFantasia("Abc");
            pj.setPessoa(pessoa);

            fornecedor.setNomeRepresentante("Abc");
            fornecedor.setTipoFornecimento("Consignado");
            fornecedor.setTipoServico("Venda");
            fornecedor.setPj(pj);

            boolean resultAdiciona = fdao.adiciona(fornecedor);
            assertTrue(resultAdiciona);
        } catch(Exception e) {
            throw new Exception("Erro ao enviar o fornecedor para o banco");
        }        
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
//    Verifica possível retorno de exceção da update vazio de toda a stack tree do fornecedor    
    @Test
    public void testeAlteraFornecedorDAOInvalido2() throws Exception {
        String expResult = "Campo nulo, erro ao enviar o fornecedor para o banco";
        Fornecedor fornecedor = new Fornecedor();
        FornecedorDAO fdao = new FornecedorDAO();
        PessoaJuridica pj = new PessoaJuridica();
        PessoaJuridicaDAO pjdao = new PessoaJuridicaDAO();
        Pessoa pessoa = new Pessoa();
        PessoaDAO pdao = new PessoaDAO();
        try {
            pdao.altera(pessoa);
            pjdao.altera(pj);
            fdao.altera(fornecedor);
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
//    Teste para caso de chave duplicada já inserida no banco (colocar valores de chaves duplicadas)
//    Teste para tabelas inexistentes (tabelas Pessoa, PessoaJuridica e Fornecedor)
//    Teste para query SQL erradas
    @Test
    public void testeAlteraFornecedorDAOInvalido3() throws Exception {
        String expResult = "Erro ao alterar o fornecedor";
        Fornecedor fornecedor = new Fornecedor();
        PessoaJuridica pj = new PessoaJuridica();
        Pessoa pessoa = new Pessoa();
        FornecedorDAO fdao = new FornecedorDAO();
        
        try {
            pessoa.setId(1);
            pessoa.setEmail("abc@abc.com");
            pessoa.setSenha("123");
            pessoa.setTelefone("(43)99999-9999");
            pessoa.setCEP("99999-999");
            pessoa.setLogradouro("Rua Abc");
            pessoa.setNumero(10);
            pessoa.setComplemento("Sala 2");
            pessoa.setBairro("Centro");
            pessoa.setCidade("Abc");
            pessoa.setEstado("Abc");
            pessoa.setPais("Abc");

            pj.setCNPJ("12.345.611/9142-33");
            pj.setNomeFantasia("Abc");
            pj.setPessoa(pessoa);

            fornecedor.setNomeRepresentante("Abc");
            fornecedor.setTipoFornecimento("Consignado");
            fornecedor.setTipoServico("Venda");
            fornecedor.setPj(pj);
            fdao.altera(fornecedor);
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
//    Verifica se o fornecedor foi alterado com sucesso
    @Test
    public void testeAlteraFornecedorDAOValido() throws Exception {
        Fornecedor fornecedor = new Fornecedor();
        PessoaJuridica pj = new PessoaJuridica();
        Pessoa pessoa = new Pessoa();
        FornecedorDAO fdao = new FornecedorDAO();
        try {
            pessoa.setId(2);
            pessoa.setEmail("abc@abc.com");
            pessoa.setSenha("123");
            pessoa.setTelefone("(43)99999-9999");
            pessoa.setCEP("99999-999");
            pessoa.setLogradouro("Rua Abc");
            pessoa.setNumero(10);
            pessoa.setComplemento("Sala 2");
            pessoa.setBairro("Centro");
            pessoa.setCidade("Abc");
            pessoa.setEstado("Abc");
            pessoa.setPais("Abc");

            pj.setCNPJ("13.035.611/2194-33");
            pj.setNomeFantasia("Abc");
            pj.setPessoa(pessoa);

            fornecedor.setNomeRepresentante("Abc");
            fornecedor.setTipoFornecimento("Consignado");
            fornecedor.setTipoServico("Venda");
            fornecedor.setPj(pj);

            boolean resultAltera = fdao.altera(fornecedor);
            assertTrue(resultAltera);
        } catch(Exception e) {
            throw new Exception("Erro ao enviar o fornecedor para o banco");
        }        
    }
}
