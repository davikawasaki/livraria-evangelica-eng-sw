/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucasfranco
 */
public class PessoaJuridicaTest {
    
    //Teste Pessoa
    @Test
    public void testPessoaValida() throws Exception{
        Pessoa p = new Pessoa();
        PessoaJuridica pj = new PessoaJuridica();
        
        p.setBairro("Jardim Ipiranga");
        pj.setPessoa(p);
        
        assertEquals(pj.getPessoa().getBairro(), "Jardim Ipiranga");
    }
    
    @Test
    public void testPessoaInvalida() throws Exception{
        Pessoa p = null;
        PessoaJuridica pj = new PessoaJuridica();
        try{
            pj.setPessoa(p);
            fail("Deveria ter lançado uma exceção!");
        }catch(Exception e){
            assertEquals(e.getMessage(), null);
        }
    }
    
    @Test
    public void testeCNPJPessoaJuridicaValido() throws Exception {
        PessoaJuridica pf = new PessoaJuridica();
        pf.setCNPJ("12.345.678/9012-34");
        String valorRecebido = pf.getCNPJ();
        assertEquals(valorRecebido, "12345678901234");
    }
    // CNPJ inválido menor que 14 dígitos
    @Test
    public void testeCNPJPessoaJuridicaInvalido1() throws Exception {
        PessoaJuridica pf = new PessoaJuridica();
        String expResult = "CNPJ Invalido";
        try {
            pf.setCNPJ("12.345.678/9012");
            String valorRecebido = pf.getCNPJ();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    // CNPJ inválido maior que 14 dígitos
    @Test
    public void testeCNPJPessoaJuridicaInvalido2() throws Exception {
        PessoaJuridica pf = new PessoaJuridica();
        String expResult = "CNPJ Invalido";
        try {
            pf.setCNPJ("12.345.678/9012-340");
            String valorRecebido = pf.getCNPJ();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    // CNPJ inválido vazio
    @Test
    public void testeCNPJPessoaJuridicaInvalido3() throws Exception {
        PessoaJuridica pf = new PessoaJuridica();
        String expResult = "CNPJ Invalido";
        try {
            pf.setCNPJ("");
            String valorRecebido = pf.getCNPJ();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    @Test
    public void testeNomeFantasiaJuridicaValido() throws Exception {
        PessoaJuridica pf = new PessoaJuridica();
        pf.setNomeFantasia("Livraria Cultura");
        String valorRecebido = pf.getNomeFantasia();
        assertEquals(valorRecebido, "Livraria Cultura");
    }
    // Nome Fantasia inválido estourando o limite de caracteres
    @Test
    public void testeNomeFantasiaPessoaJuridicaInvalido1() throws Exception {
        PessoaJuridica pf = new PessoaJuridica();
        String expResult = "Nome Fantasia maior que 45 caracteres";
        try {
            pf.setNomeFantasia("Livraria Abrindo as Portas da Imaginação Cultural e Literária LTDA/SA");
            String valorRecebido = pf.getNomeFantasia();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    // Nome Fantasia inválido vazio
    @Test
    public void testeNomeFantasiaPessoaJuridicaInvalido2() throws Exception {
        PessoaJuridica pf = new PessoaJuridica();
        String expResult = "Nome Fantasia Invalido";
        try {
            pf.setNomeFantasia("");
            String valorRecebido = pf.getNomeFantasia();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
}