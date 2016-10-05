/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOclasses;

import Classes.Pessoa;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nicholaspicagrossa
 */
public class PessoaDAOTest {
    @Test
    public void testeConexaoPessoaDAOConnectionFactoryInvalido() throws Exception {
        String expResult = "Erro ao conectar com o banco";
        try {
            PessoaDAO pdao = new PessoaDAO();
            pdao.setaConexaoPessoaDAO("root", "root123");
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    
    //Verifica possível retorno de exceção da inserção vazia do pessoa
    @Test
    public void testeAdicionaPessoaDAOInvalido() throws Exception {
        String expResult = "Campo nulo, erro ao enviar a pessoa fisica para o banco";
        Pessoa p = new Pessoa();
        PessoaDAO pdao = new PessoaDAO();
        try {
            pdao.adiciona(p);
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    
//    Verifica se o fornecedor foi adicionado com sucesso
    @Test
    public void testeAdicionaPessoaDAOValido() throws Exception {
        
        Pessoa pessoa = new Pessoa();
        PessoaDAO pdao = new PessoaDAO();
        
        pessoa.setEmail("abc@abc.com");
        pessoa.setTelefone("(43)99999-9999");
        pessoa.setCEP("99999-999");
        pessoa.setLogradouro("Rua Abc");
        pessoa.setNumero(10);
        pessoa.setComplemento("Sala 2");
        pessoa.setBairro("Centro");
        pessoa.setCidade("Abc");
        pessoa.setEstado("Abc");
        pessoa.setPais("Abc");
        
        boolean resultAdiciona = pdao.adiciona(pessoa);
        
        assertTrue(resultAdiciona);       
    }

    //    Verifica possível retorno de exceção da update vazio do fornecedor
    @Test
    public void testeAlteraPessoaFisicaDAOInvalido() throws Exception {
        String expResult = "Campo nulo, erro ao enviar a pessoa para o banco";
        Pessoa p = new Pessoa();
        PessoaDAO pdao = new PessoaDAO();
        try {
            pdao.altera(p);
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    } 
    
    @Test
    public void testeAlteraPessoaDAOValida() throws Exception{
        PessoaDAO pdao = new PessoaDAO();
        
        Pessoa pessoa = new Pessoa();
        
        pessoa.setEmail("abc@abc.com");
        pessoa.setTelefone("(43)99999-9999");
        pessoa.setCEP("99999-999");
        pessoa.setLogradouro("Rua Abc");
        pessoa.setNumero(10);
        pessoa.setComplemento("Sala 2");
        pessoa.setBairro("Centro");
        pessoa.setCidade("Abc");
        pessoa.setEstado("Abc");
        pessoa.setPais("Abc");
        
        boolean resultAltera = pdao.altera(pessoa);
        assertTrue(resultAltera);
        
    }
    
}
