package Classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Classes.Cartao;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nicholas
 */
public class CartaoTest {
    
    //Teste Tipo
    @Test
    public void testTipoValido() throws Exception{
        Cartao c = new Cartao();
        c.setTipo("Credito");
        String valorRecebido = c.getTipo();
        assertEquals(valorRecebido, "Credito");
    }
    
    @Test
    public void testTipoValido1() throws Exception{
        Cartao c = new Cartao();
        c.setTipo("Debito");
        String valorRecebido = c.getTipo();
        assertEquals(valorRecebido, "Debito");
    }

    @Test
    public void testTipoInvalido(){
        Cartao c = new Cartao();
        c.setTipo("ChewBacca");
        try{
            String valorRecebido = c.getTipo();
        }
        catch(Exception e){
            assertEquals(e.getMessage(), "Tipo invalido");
        }
    }
    
    @Test
    public void testTipoInvalido1(){
        Cartao c = new Cartao();
        c.setTipo("1");
        try{
            String valorRecebido = c.getTipo();
        }
        catch(Exception e){
            assertEquals(e.getMessage(), "Tipo invalido");
        }
    }
    
    //Teste NumeroParcelas
    @Test
    public void testNumeroParcelasValido() throws Exception{
        Cartao c = new Cartao();
        c.setNumeroParcelas(3);
        int valorRecebido = c.getNumeroParcelas();
        assertEquals(valorRecebido, 3);
    }
    
    @Test
    public void testNumeroParcelasValido1() throws Exception{
        Cartao c = new Cartao();
        c.setNumeroParcelas(0);
        int valorRecebido = c.getNumeroParcelas();
        assertEquals(valorRecebido, 0);
    }

    @Test
    public void testNumeroParcelasInvalido(){
        Cartao c = new Cartao();
        c.setNumeroParcelas(-1);
        try{
            int valorRecebido = c.getNumeroParcelas();
        }
        catch(Exception e){
            assertEquals(e.getMessage(), "Numero invalido");
        }
    }
    
    @Test
    public void testNumeroParcelasInvalido1(){
        Cartao c = new Cartao();
        c.setNumeroParcelas(4);
        try{
            int valorRecebido = c.getNumeroParcelas();
        }
        catch(Exception e){
            assertEquals(e.getMessage(), "Numero invalido");
        }
    }
    
}
