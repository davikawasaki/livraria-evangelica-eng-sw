/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOclasses;

import Classes.Atendente;
import Classes.Pessoa;
import Classes.PessoaFisica;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucasfranco
 */
public class AtendenteDAOTest {

    @Test
    public void testeConexaoAtendenteDAOConnectionFactoryInvalido() throws Exception {
        String expResult = "Erro ao conectar com o banco";
        try {
            AtendenteDAO adao = new AtendenteDAO();
            adao.setaConexaoAtendenteDAO("root", "root123");
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
//    Verifica possível retorno de exceção da inserção vazia do atendente
    @Test
    public void testeAdicionaAtendenteDAOInvalido() throws Exception {
        String expResult = "Campo nulo, erro ao enviar o cliente para o banco";
        Atendente a = new Atendente();
        AtendenteDAO adao = new AtendenteDAO();
        try {
            adao.adiciona(a);
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    
    //    Verifica se o atendente foi adicionado com sucesso
    @Test
    public void testeAdicionaAtendenteDAOValido() throws Exception {
        Atendente a = new Atendente();
        PessoaFisica pf = new PessoaFisica();
        Pessoa pessoa = new Pessoa();
        AtendenteDAO adao = new AtendenteDAO();
        
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

        pf.setCPF("45884718823");

        String data = "21/02/2010";
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        pf.setDataNascimento(new Date(format.parse(data).getTime()));
        pf.setNome("Nome");
        pf.setRG("465765751");
        pf.setSexo("M");
        pf.setSobrenome("Sobrenome");
        pf.setPessoa(pessoa);
        
        a.setLogin("abcdefg");
        String expedienteInicio = "30/09/2016";
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        a.setComecoExpediente(new Date(format.parse(expedienteInicio).getTime()));
        String expedienteFim = "01/10/2016";
        SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
        a.setFimExpediente(new Date(format.parse(expedienteFim).getTime()));
        a.setSenha("123@abc");
        a.setPf(pf);
        boolean resultAdiciona = adao.adiciona(a);
        assertTrue(resultAdiciona);       
    }
    //    Verifica se o retorno foi realizado com sucesso (a implementar)
//    @Ignore
//    @Test
//    public void testeListaAtendenteDAOValido() throws Exception {
//        AtendenteDAO adao = new AtendenteDAO();
//        List lista = adao.getLista();
//        assertTrue(lista instanceof java.util.List);
//    }
    //    Verifica possível retorno de exceção da update vazio do fornecedor (a implementar)
//    @Ignore
//    @Test
//    public void testeAlteraAtendenteDAOInvalido() throws Exception {
//        String expResult = "Campo nulo, erro ao enviar o atendente para o banco";
//        Atendente a = new Atendente();
//        AtendenteDAO adao = new AtendenteDAO();
//        try {
//            adao.altera(a);
//            fail("Deveria ter lançado uma exceção!");
//        } catch(Exception e) {
//            assertEquals(expResult, e.getMessage());
//        }
//    }
    //    Verifica se o atendente foi alterado com sucesso (a implementar)
//    @Ignore
//    @Test
//    public void testeAlteraAtendenteDAOValido() throws Exception {
//        Atendente a = new Atendente();
//        PessoaFisica pf = new PessoaFisica();
//        Pessoa pessoa = new Pessoa();
//        AtendenteDAO adao = new AtendenteDAO();
//        
//        pessoa.setId(48);
//        pessoa.setEmail("abc@abc.com");
//        pessoa.setSenha("123@abc");
//        pessoa.setTelefone("(43)99999-9999");
//        pessoa.setCEP("99999-999");
//        pessoa.setLogradouro("Rua Abc");
//        pessoa.setNumero(10);
//        pessoa.setComplemento("Sala 2");
//        pessoa.setBairro("Centro");
//        pessoa.setCidade("Abc");
//        pessoa.setEstado("Abc");
//        pessoa.setPais("Abc");
//
//        String data = "21/02/2010";
//        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//        pf.setDataNascimento(new Date(format.parse(data).getTime()));
//        pf.setNome("Nomedo jura");
//        pf.setRG("465765751");
//        pf.setSexo("M");
//        pf.setCPF("45884718823");
//        pf.setSobrenome("Sobrenome");
//        pf.setPessoa(pessoa);
//        
//        a.setLogin("abcdefg");
//        String expedienteInicio = "30/09/2016";
//        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
//        a.setComecoExpediente(new Date(format.parse(expedienteInicio).getTime()));
//        String expedienteFim = "01/10/2016";
//        SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
//        a.setFimExpediente(new Date(format.parse(expedienteFim).getTime()));
//        a.setSenha("123@abc");
//        a.setPf(pf);
//
//        boolean resultAltera = adao.altera(a);
//        assertTrue(resultAltera);        
//    }
    
}
