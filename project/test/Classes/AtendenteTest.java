/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucasfranco
 */
public class AtendenteTest {
    // Testes de caixa preta
    @Test
    public void testeComecoExpedienteAtendenteValido() throws Exception {
        Atendente atendente = new Atendente();
        Calendar cal = new GregorianCalendar();
        // Acrescenta uma hora na data atual instanciada
        cal.add(Calendar.HOUR_OF_DAY, 1);
        Date data = cal.getTime();
        atendente.setComecoExpediente(data);
        Date results = atendente.getComecoExpediente();
        assertEquals(data, results);
    }
    // Comeco expediente invalido anterior a data atual
    @Test
    public void testeComecoExpedienteAtendenteInvalido1() throws Exception {
        Atendente atendente = new Atendente();
        Calendar cal = new GregorianCalendar();
        String expResult = "Horario Invalido";
        try {
            // Decrementa uma hora na data atual instanciada
            cal.add(Calendar.HOUR_OF_DAY, -1);
            Date data = cal.getTime();
            atendente.setComecoExpediente(data);
            Date results = atendente.getComecoExpediente();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    @Test
    public void testeFimExpedienteAtendenteValido() throws Exception {
        Atendente atendente = new Atendente();
        Calendar cal = new GregorianCalendar();
        // Decrementa uma hora na data atual instanciada
        cal.add(Calendar.HOUR_OF_DAY, -1);
        Date data = cal.getTime();
        atendente.setFimExpediente(data);
        Date results = atendente.getFimExpediente();
        assertEquals(data, results);
    }
    // Fim expediente invalido anterior a data atual
    @Test
    public void testeFimExpedienteAtendenteInvalido1() throws Exception {
        Atendente atendente = new Atendente();
        Calendar cal = new GregorianCalendar();
        String expResult = "Horario Invalido";
        try {
            // Incrementa uma hora na data atual instanciada
            cal.add(Calendar.HOUR_OF_DAY, 1);
            Date data = cal.getTime();
            atendente.setFimExpediente(data);
            Date results = atendente.getFimExpediente();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    @Test
    public void testeSenhaAtendenteValido() throws Exception {
        Atendente atendente = new Atendente();
        atendente.setSenha("senha@123");
        String valorRecebido = atendente.getSenha();
        assertEquals(valorRecebido, "senha@123");
    }
    // Senha inválida com menos de 6 dígitos
    @Test
    public void testeSenhaAtendenteInvalido1() throws Exception {
        Atendente atendente = new Atendente();
        String expResult = "Senha Invalida";
        try{
            atendente.setSenha("senh4");
            String valorRecebido = atendente.getSenha();
            fail("Deveria ter lançado uma exceção!");
        }
        catch(Exception e){
            assertEquals(expResult, e.getMessage());
        }
    }
    // Senha inválida com mais de 16 dígitos
    @Test
    public void testeSenhaAtendenteInvalido2() {
        Atendente atendente = new Atendente();
        String expResult = "Senha Invalida";
        try{
            atendente.setSenha("senhamuit0grande");
            String valorRecebido = atendente.getSenha();
            fail("Deveria ter lançado uma exceção!");
        }
        catch(Exception e){
            assertEquals(expResult, e.getMessage());
        }
    }
    // Senha inválida com somente letras
    @Test
    public void testeSenhaAtendenteInvalido3() {
        Atendente atendente = new Atendente();
        String expResult = "Senha Invalida";
        try{
            atendente.setSenha("sohletras");
            String valorRecebido = atendente.getSenha();
            fail("Deveria ter lançado uma exceção!");
        }
        catch(Exception e){
            assertEquals(expResult, e.getMessage());
        }
    }
    // Senha inválida com somente numeros
    @Test
    public void testeSenhaAtendenteInvalido4() {
        Atendente atendente = new Atendente();
        String expResult = "Senha Invalida";
        try{
            atendente.setSenha("7654321");
            String valorRecebido = atendente.getSenha();
            fail("Deveria ter lançado uma exceção!");
        }
        catch(Exception e){
            assertEquals(expResult, e.getMessage());
        }
    }
    @Test
    public void testeLoginAtendenteValido() throws Exception {
        Atendente atendente = new Atendente();
        atendente.setLogin("senha@123");
        String valorRecebido = atendente.getLogin();
        assertEquals(valorRecebido, "senha@123");
    }
    // Login inválido menor que 5 caracteres
    @Test
    public void testeLoginAtendenteInvalido1() throws Exception {
        Atendente atendente = new Atendente();
        String expResult = "Login menor que 5 caracteres";
        try {
            atendente.setLogin("senh");
            String valorRecebido = atendente.getLogin();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    // Login inválido estourando o limite de caracteres
    @Test
    public void testeLoginAtendenteInvalido2() throws Exception {
        Atendente atendente = new Atendente();
        String expResult = "Login maior que 45 caracteres";
        try {
            atendente.setLogin("A1312515131NFJ34JH1IJEI2JO1JDFOIJFO1IJ23O1J2OJ1I231FJ1I");
            String valorRecebido = atendente.getLogin();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    // Login inválido vazio
    @Test
    public void testeLoginAtendenteInvalido3() throws Exception {
        Atendente atendente = new Atendente();
        String expResult = "Login Invalido";
        try {
            atendente.setLogin("");
            String valorRecebido = atendente.getLogin();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    @Test
    public void ContatoInserePessoaFisica() {
        Atendente atendente = new Atendente();
        PessoaFisica pf = new PessoaFisica();
        atendente.setPf(pf);
        PessoaFisica result = atendente.getPf();
        assertEquals(pf, result);
    }
}
