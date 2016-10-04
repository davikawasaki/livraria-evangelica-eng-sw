/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author davikawasaki
 */
public class PessoaFisicaTest {
    // Testes de caixa preta
    @Test
    public void testeNomePessoaFisicaValido() throws Exception {
        PessoaFisica pf = new PessoaFisica();
        pf.setNome("Joao");
        String valorRecebido = pf.getNome();
        assertEquals(valorRecebido, "Joao");
    }
    // Nome inválido estourando o limite de caracteres
    @Test
    public void testeNomePessoaFisicaInvalido1() throws Exception {
        PessoaFisica pf = new PessoaFisica();
        String expResult = "Nome maior que 45 caracteres";
        try {
            pf.setNome("Marcos Lopes Joaquim Deodoro da Fonseca Filho Júnior");
            String valorRecebido = pf.getNome();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    // Nome inválido vazio
    @Test
    public void testeNomePessoaFisicaInvalido2() throws Exception {
        PessoaFisica pf = new PessoaFisica();
        String expResult = "Nome Invalido";
        try {
            pf.setNome("");
            String valorRecebido = pf.getNome();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    @Test
    public void testeSobrenomePessoaFisicaValido() throws Exception {
        PessoaFisica pf = new PessoaFisica();
        pf.setSobrenome("Silva");
        String valorRecebido = pf.getSobrenome();
        assertEquals(valorRecebido, "Silva");
    }
    // Sobrenome inválido estourando o limite de caracteres
    @Test
    public void testeSobrenomePessoaFisicaInvalido1() throws Exception {
        PessoaFisica pf = new PessoaFisica();
        String expResult = "Sobrenome maior que 45 caracteres";
        try {
            pf.setSobrenome("Suzuki Silva Brasil Silveira Cardoso Busquim Roder");
            String valorRecebido = pf.getSobrenome();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    // Sobrenome inválido vazio
    @Test
    public void testeSobrenomePessoaFisicaInvalido2() throws Exception {
        PessoaFisica pf = new PessoaFisica();
        String expResult = "Sobrenome Invalido";
        try {
            pf.setSobrenome("");
            String valorRecebido = pf.getSobrenome();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    @Test
    public void testeCPFPessoaFisicaValido() throws Exception {
        PessoaFisica pf = new PessoaFisica();
        pf.setCPF("720.834.973-84");
        String valorRecebido = pf.getCPF();
        assertEquals(valorRecebido, "72083497384");
    }
    // CPF inválido menor que 11 dígitos
    @Test
    public void testeCPFPessoaFisicaInvalido1() throws Exception {
        PessoaFisica pf = new PessoaFisica();
        String expResult = "CPF Invalido";
        try {
            pf.setCPF("720.834.973-8");
            String valorRecebido = pf.getCPF();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    // CPF inválido menor que 12 dígitos
    @Test
    public void testeCPFPessoaFisicaInvalido2() throws Exception {
        PessoaFisica pf = new PessoaFisica();
        String expResult = "CPF Invalido";
        try {
            pf.setCPF("720.834.973-844");
            String valorRecebido = pf.getCPF();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    // CPF inválido vazio
    @Test
    public void testeCPFPessoaFisicaInvalido3() throws Exception {
        PessoaFisica pf = new PessoaFisica();
        String expResult = "CPF Invalido";
        try {
            pf.setCPF("");
            String valorRecebido = pf.getCPF();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    @Test
    public void testeRGPessoaFisicaValido() throws Exception {
        PessoaFisica pf = new PessoaFisica();
        pf.setRG("3.805.396-03");
        String valorRecebido = pf.getRG();
        assertEquals(valorRecebido, "380539603");
    }
    // RG inválido menor que 9 dígitos
    @Test
    public void testeRGPessoaFisicaInvalido1() throws Exception {
        PessoaFisica pf = new PessoaFisica();
        String expResult = "RG Invalido";
        try {
            pf.setRG("3.805.396-0");
            String valorRecebido = pf.getRG();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    // RG inválido maior que 12 dígitos
    @Test
    public void testeRGPessoaFisicaInvalido2() throws Exception {
        PessoaFisica pf = new PessoaFisica();
        String expResult = "RG Invalido";
        try {
            pf.setRG("322.805.396-0232");
            String valorRecebido = pf.getRG();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    // RG inválido vazio
    @Test
    public void testeRGPessoaFisicaInvalido3() throws Exception {
        PessoaFisica pf = new PessoaFisica();
        String expResult = "RG Invalido";
        try {
            pf.setRG("");
            String valorRecebido = pf.getRG();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    @Test
    public void testeSexoPessoaFisicaValido() throws Exception {
        PessoaFisica pf = new PessoaFisica();
        pf.setSexo("m");
        String valorRecebido = pf.getSexo();
        assertEquals(valorRecebido, "M");
    }
    // Sexo inválido diferente de M ou F
    @Test
    public void testeSexoPessoaFisicaInvalido1() throws Exception {
        PessoaFisica pf = new PessoaFisica();
        String expResult = "Sexo Invalido";
        try {
            pf.setSexo("c");
            String valorRecebido = pf.getSexo();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    // Sexo inválido vazio
    @Test
    public void testeSexoPessoaFisicaInvalido2() throws Exception {
        PessoaFisica pf = new PessoaFisica();
        String expResult = "Sexo Invalido";
        try {
            pf.setSexo("");
            String valorRecebido = pf.getSexo();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    @Test
    public void testeDataNascimentoPessoaFisicaValido() throws Exception {
        PessoaFisica pf = new PessoaFisica();
        Calendar cal = new GregorianCalendar();
        // Reduz um mês na data atual instanciada
        cal.add(Calendar.DAY_OF_MONTH, -1);
        Date data = cal.getTime();
        pf.setDataNascimento(data);
        Date results = pf.getDataNascimento();
        assertEquals(data, results);        
    }
    // Data inválida um mês seguinte ao mês atual
    @Test
    public void testeDataNascimentoPessoaFisicaInvalido1() throws Exception {
        PessoaFisica pf = new PessoaFisica();
        Calendar cal = new GregorianCalendar();
        // Adiciona um mês na data atual instanciada
        cal.add(Calendar.DAY_OF_MONTH, 1);
        String expResult = "Data Invalida";
        try {
            Date data = cal.getTime();
            pf.setDataNascimento(data);
            Date results = pf.getDataNascimento();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    @Test
    public void ContatoInserePessoa(){
        PessoaFisica pf = new PessoaFisica();
        Pessoa pessoa = new Pessoa();
        
        pf.setPessoa(pessoa);
        Pessoa result = pf.getPessoa();
        assertEquals(pessoa, result);
    }
}
