/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author eryc
 */
public class vendaTest {
    

    @Test
    public void testDataVendaFormato() throws Exception{
        Venda venda = new Venda();
        Calendar cal = new GregorianCalendar();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        String expResult = "Data Invalida";
        try {
            Date data = cal.getTime();
            venda.setDataVenda(data);
            Date results = venda.getDataVenda();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    
    @Test
    public void testDataVendaVazia() throws Exception{
        Venda venda = new Venda();
        String expResult = "Data invalida";
        try{
            venda.setDataVenda(null);
            fail("Deveria ter lançado uma exceção!");
        }catch(Exception e){
             assertEquals(expResult, e.getMessage());
        }
    }
    
    @Test
    public void testDataVendaValida() throws Exception{
        Venda venda = new Venda();
        Calendar cal = new GregorianCalendar();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        String expResult = "Data invalida";
        Date data = cal.getTime();
        venda.setDataVenda(data);
        Date results = venda.getDataVenda();
        assertEquals(data, results);  
    }
    
    
    @Test
    public void testValorTotalNegativo() throws Exception{
        Venda venda = new Venda();
        String expResult = "Apenas valores maiores que zero";
        try{
            venda.setValorTotal(-10);
            fail("Deveria ter lançado uma exceção!");
        }catch(Exception e){
             assertEquals(expResult, e.getMessage());
        }
    }
    
    @Test
    public void testValorTotalMaior() throws Exception{
        Venda venda = new Venda();
        String expResult = "Apenas valores até 5000";
        try{
            venda.setValorTotal(5001);
            fail("Deveria ter lançado uma exceção!");
        }catch(Exception e){
             assertEquals(expResult, e.getMessage());
        }
    }
    
    @Test
    public void testValorTotalVazio() throws Exception{
        Venda venda = new Venda();
        String expResult = "Valor invalido";
        try{
            venda.setValorTotal(null);
            fail("Deveria ter lançado uma exceção!");
        }catch(Exception e){
             assertEquals(expResult, e.getMessage());
        }
    }
    
    @Test
    public void testValorTotalValido() throws Exception{
        Venda venda = new Venda();
        int value = 100;
        venda.setValorTotal(null);
         assertEquals(venda.getValorTotal(), value);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
