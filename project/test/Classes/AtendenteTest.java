/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucasfranco
 */
public class AtendenteTest {
    
    /**
     * Test of getComecoExpediente method, of class Atendente.
     */
    @Test
    public void testGetComecoExpediente() throws ParseException {
        System.out.println("getComecoExpediente");
        Atendente instance = new Atendente();
        
    //Conversão string para sql.Time
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        long ms = sdf.parse("12:21:32").getTime();
        Time t = new Time(ms);

        instance.setComecoExpediente(t);
        Time result = instance.getComecoExpediente();
        assertEquals(t, result);
    }

    /**
     * Test of getFimExpediente method, of class Atendente.
     */
    @Test
    public void testGetFimExpediente() throws ParseException {
        System.out.println("getFimExpediente");
        Atendente instance = new Atendente();
    
    //Conversão string para sql.Time
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        long ms = sdf.parse("19:20:20").getTime();
        Time t = new Time(ms);

        instance.setFimExpediente(t);
        Time result = instance.getFimExpediente();
        assertEquals(t, result);
    }

    /**
     * Test of getSenha method, of class Atendente.
     */
    //Teste com Senha valida
    @Test
    public void testGetSenhaValida() throws Exception {
        System.out.println("getSenhaValida");
        Atendente instance = new Atendente();
        String expResult = "senha@123";        
        instance.setSenha(expResult);
        String result = instance.getSenha();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getSenha method, of class Atendente.
     */
    //Teste com Senha com numero menor de digitos (5)
    @Test
    public void testGetSenhaInvalida1() {
        System.out.println("getSenhaInvalida1");
        Atendente instance = new Atendente();
        String senha = "senh4";
        String expResult = "Senha Invalida";
        try{
            instance.setSenha(senha);
            String result = instance.getSenha();
            fail("Deveria ter lançado uma exceção!");
        }
        catch(Exception e){
            assertEquals(expResult, e.getMessage());
        }
    }

    /**
     * Test of getSenha method, of class Atendente.
     */
    //Teste com Senha com numero maior que de digitos (16)
    @Test
    public void testGetSenhaInvalida2() {
        System.out.println("getSenhaInvalida2");
        Atendente instance = new Atendente();
        String senha = "senhamuit0grande";
        String expResult = "Senha Invalida";
        try{
            instance.setSenha(senha);
            String result = instance.getSenha();
            fail("Deveria ter lançado uma exceção!");
        }
        catch(Exception e){
            assertEquals(expResult, e.getMessage());
        }
    }
   /**
     * Test of getSenha method, of class Atendente.
     */
    //Teste com Senha com somente letras
    @Test
    public void testGetSenhaInvalida3() {
        System.out.println("getSenhaInvalida3");
        Atendente instance = new Atendente();
        String senha = "sohletras";
        String expResult = "Senha Invalida";
        try{
            instance.setSenha(senha);
            String result = instance.getSenha();
            fail("Deveria ter lançado uma exceção!");
        }
        catch(Exception e){
            assertEquals(expResult, e.getMessage());
        }
    }
    
    /**
     * Test of getSenha method, of class Atendente.
     */
    //Teste com Senha com somente numeros
    @Test
    public void testGetSenhaInvalida4() {
        System.out.println("getSenhaInvalida4");
        Atendente instance = new Atendente();
        String senha = "7654321";
        String expResult = "Senha Invalida";
        try{
            instance.setSenha(senha);
            String result = instance.getSenha();
            fail("Deveria ter lançado uma exceção!");
        }
        catch(Exception e){
            assertEquals(expResult, e.getMessage());
        }
    }
    
    /**
     * Test of getLogin method, of class Atendente.
     */
    @Test
    public void testGetLogin() {
        System.out.println("getLogin");
        Atendente instance = new Atendente();
        String expResult = "login123";
        instance.setLogin(expResult);
        String result = instance.getLogin();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPf method, of class Atendente.
     */
    @Test
    public void testGetPf() {
        System.out.println("getPf");
        Atendente atendente = new Atendente();
        PessoaFisica pf = new PessoaFisica();
        atendente.setPf(pf);
        PessoaFisica result = atendente.getPf();
        
        assertEquals(pf, result);
    }
}
