/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author eryc
 */
public class pedidoTest {
    
//    @Test
//    public void testEstadoLetra() throws Exception{
//        Reserva = reserva new Reserva();
//        String expResult = "Os dias devem ser maiores do que zero.";
//        try{
//            reserva.setTempoDias(-10);
//            fail("Deveria ter lançado uma exceção!");
//        }catch(Exception e){
//             assertEquals(expResult, e.getMessage());
//        }
//    }

    @Test
    public void testEstadoNumeroMaiorUm() throws Exception{
        Pedido pedido = new Pedido();
        String expResult = "Estado invalido";
        try{
            pedido.setEstado(10);
            fail("Deveria ter lançado uma exceção!");
        }catch(Exception e){
             assertEquals(expResult, e.getMessage());
        }
    }
    
    @Test
    public void testEstadoNumeroNegativo() throws Exception{
        Pedido pedido = new Pedido();
        String expResult = "Estado invalido";
        try{
            pedido.setEstado(-10);
            fail("Deveria ter lançado uma exceção!");
        }catch(Exception e){
             assertEquals(expResult, e.getMessage());
        }
    }
    
    @Test
    public void testEstadoNumeroVazio() throws Exception{
        Pedido  pedido = new Pedido();
        String expResult = "Estado invalido";
        try{
            pedido.setEstado(null);
            fail("Deveria ter lançado uma exceção!");
        }catch(Exception e){
             assertEquals(expResult, e.getMessage());
        }
    }
    
    @Test
    public void testEstadoValido() throws Exception{
        Pedido  pedido = new Pedido();
        int value = 10;
        pedido.setEstado(value);
        assertEquals(pedido.getEstado, value);
    }
    
    @Test
        public void testQuantidadeMenorZero() throws Exception{
            Pedido pedido = new Pedido();
            String expResult = "Quantidade deve ser maior que zero";
            try{
                pedido.setQuantidade(-10);
                fail("Deveria ter lançado uma exceção!");
            }catch(Exception e){
                 assertEquals(expResult, e.getMessage());
            }
        } 
        
    @Test
        public void testQuantidadeMaior() throws Exception{
            Pedido pedido = new Pedido();
            String expResult = "Quantidade deve ser menor que 2000";
            try{
                pedido.setQuantidade(2000);
                fail("Deveria ter lançado uma exceção!");
            }catch(Exception e){
                 assertEquals(expResult, e.getMessage());
            }
        } 
    
    @Test
        public void testQuantidadeVazia() throws Exception{
            Pedido pedido = new Pedido();
            String expResult = "Quantidade invalida";
            try{
                pedido.setQuantidade(null);
                fail("Deveria ter lançado uma exceção!");
            }catch(Exception e){
                 assertEquals(expResult, e.getMessage());
            }
        } 
    
    @Test
    public void testQuantidadeValida() throws Exception{
        Pedido  pedido = new Pedido();
        int value = 10;
        pedido.setQuantidade(value);
        assertEquals(pedido.getQuantidade(), value);
    }
        
        
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
