package Classes;
import org.junit.Test;
import static org.junit.Assert.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author eryc
 */
public class reservaTest {
    
    @Test
    public void testTempoDiasNegativoInvalido() throws Exception{
        Reserva reserva =new Reserva();
        String expResult = "Os dias devem ser maiores do que zero.";
        try{
            reserva.setTempoDias(-10);
            fail("Deveria ter lançado uma exceção!");
        }catch(Exception e){
             assertEquals(expResult, e.getMessage());
        }
    }

    @Test
    public void testTempoDiasZeroInvalido() throws Exception{
        Reserva reserva =new Reserva();
        String expResult = "Os dias devem ser maiores do que zero.";
        try{
            reserva.setTempoDias(0);
            fail("Deveria ter lançado uma exceção!");
        }catch(Exception e){
             assertEquals(expResult, e.getMessage());
        }
    }
    
    @Test
    public void testTempoDiasMaximoInvalido() throws Exception{
        Reserva reserva =new Reserva();
        String expResult = "Os dias devem ser menores do que 100.";
        try{
            reserva.setTempoDias(101);
            fail("Deveria ter lançado uma exceção!");
        }catch(Exception e){
             assertEquals(expResult, e.getMessage());
        }
    }
    
//    @Test
//    public void testTempoDiasLetras() throws Exception{
//        Reserva = reserva new Reserva();
//        String expResult = "Os dias devem ser maiores do que zero.";
//        try{
//            reserva.setTempoDias(0);
//            fail("Deveria ter lançado uma exceção!");
//        }catch(Exception e){
//             assertEquals(expResult, e.getMessage());
//        }
//    }

    @Test
    public void testTempoDiasVazioInvalido() throws Exception{
        Reserva reserva= new Reserva();
        String expResult = "Prazo da reserva obrigatório.";
        try{
            reserva.setTempoDias(null);
            fail("Deveria ter lançado uma exceção!");
        }catch(Exception e){
             assertEquals(expResult, e.getMessage());
        }
    }
    
    @Test
    public void testTempoDiasValido() throws Exception{
        Reserva reserva =new Reserva();
            int value = 10;
            reserva.setTempoDias(value);
            assertEquals(reserva.getTempoDias, value);
    }
    
    
    


    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
