/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOclasses;

import Classes.Pessoa;
import Classes.PessoaJuridica;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author davikawasaki
 */
public class PessoaJuridicaDAOTest {
    @Test
    public void testeConexaoPessoaJuridicaDAOConnectionFactoryInvalido() throws Exception {
        String expResult = "Erro ao conectar com o banco";
        try {
            PessoaJuridicaDAO pjdao = new PessoaJuridicaDAO();
            pjdao.setaConexaoPessoaJuridicaDAO("root", "root123");
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    
    //Verifica possível retorno de exceção da inserção vazia do pessoa juridica
    @Test
    public void testeAdicionaPessoaJuridicaDAOInvalido() throws Exception {
        String expResult = "Campo nulo, erro ao enviar a pessoa juridica para o banco";
        PessoaJuridica pj = new PessoaJuridica();
        PessoaJuridicaDAO pjdao = new PessoaJuridicaDAO();
        try {
            pjdao.adiciona(pj);
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    
    //    Verifica se o pessoa juridica foi adicionado com sucesso
    @Test
    public void testeAdicionaPessoaJuridicaDAOValido() throws Exception {
        
        PessoaJuridica pj = new PessoaJuridica();
        Pessoa pessoa = new Pessoa();
        PessoaJuridicaDAO pjdao = new PessoaJuridicaDAO();
        
        pessoa.setId(2);
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
        pj.setCNPJ("13.235.412/2122-33");
        pj.setNomeFantasia("Abc");
        pj.setPessoa(pessoa);
        
        boolean resultAdiciona = pjdao.adiciona(pj);
        
        assertTrue(resultAdiciona);       
    }

    //    Verifica possível retorno de exceção da update vazio do pessoa juridica
    @Test
    public void testeAlteraPessoaJuridicaDAOInvalido() throws Exception {
        String expResult = "Campo nulo, erro ao enviar a pessoa juridica para o banco";
        PessoaJuridica pj = new PessoaJuridica();
        PessoaJuridicaDAO pjdao = new PessoaJuridicaDAO();
        try {
            pjdao.altera(pj);
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    } 
    
    @Test
    public void testeAlteraPessoaFisicaDAOValida() throws Exception{
        PessoaJuridicaDAO pjdao = new PessoaJuridicaDAO();
        
        PessoaJuridica pj = new PessoaJuridica();
        Pessoa pessoa = new Pessoa();
        pessoa.setId(2);
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
        pj.setCNPJ("13.235.412/2122-33");
        pj.setNomeFantasia("Abc");
        pj.setPessoa(pessoa);
        
        boolean resultAltera = pjdao.altera(pj);
        assertTrue(resultAltera);
        
    }    
}
