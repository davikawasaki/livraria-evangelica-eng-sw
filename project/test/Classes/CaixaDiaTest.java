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
 * @author Nicholas
 */
public class CaixaDiaTest {

    //Testes idCaixa
    @Test
    public void testIdCaixaInvalida() throws Exception {
        CaixaDia cd = new CaixaDia();
        try{
            cd.setIdCaixa(-1);
            int valorRecebido = cd.getIdCaixa();
        }
        catch(Exception ce){
            assertEquals(ce.getMessage(), "Id invalido");
        }
    }
    
    @Test
    public void testIdCaixaValida() throws Exception{
        CaixaDia cd = new CaixaDia();
        cd.setIdCaixa(1);
        int valorRecebido = cd.getIdCaixa();
        assertEquals(valorRecebido, 1);
    }
    
	//Teste saldoInicial
    @Test
    public void testSaldoInicialValido() throws Exception{
        CaixaDia cd = new CaixaDia();
        cd.setSaldoInicial(5);
        float valorRecebido = cd.getSaldoInicial();
        assertEquals(valorRecebido, 5, 0);
    }

    @Test
    public void testSaldoInicialValido1() throws Exception{
        CaixaDia cd = new CaixaDia();
        cd.setSaldoInicial(0);
        float valorRecebido = cd.getSaldoInicial();
        assertEquals(valorRecebido, 0, 0);
    }
    
    @Test
    public void testSaldoInicialInvalido() throws Exception{
        CaixaDia cd = new CaixaDia();
        try{
            cd.setSaldoInicial(-1);
            float valorRecebido = cd.getSaldoInicial();
        }
        catch(Exception ce){
            assertEquals(ce.getMessage(), "Saldo Inicial invalido");
        }
    }
    
    //Teste entradaBruto
    @Test
    public void testEntradaBrutoValida() throws Exception{
        CaixaDia cd = new CaixaDia();
        cd.setEntradaBruto(5);
        float valorRecebido = cd.getEntradaBruto();
        assertEquals(valorRecebido, 5, 0);
    }

    @Test
    public void testEntradaBrutoValida1() throws Exception{
        CaixaDia cd = new CaixaDia();
        cd.setEntradaBruto(0);
        float valorRecebido = cd.getEntradaBruto();
        assertEquals(valorRecebido, 0, 0);
    }
    
    @Test
    public void testEntradaBrutoInvalida() throws Exception{
        CaixaDia cd = new CaixaDia();
        try{
            cd.setEntradaBruto(-1);
            float valorRecebido = cd.getEntradaBruto();
        }
        catch(Exception ce){
            System.out.println(ce.getMessage());
            assertEquals(ce.getMessage(), "Entrada invalida");
        }
    }
    
    //Teste entradaReal
    @Test
    public void testEntradaRealValida() throws Exception{
        CaixaDia cd = new CaixaDia();
        cd.setEntradaReal(5);
        float valorRecebido = cd.getEntradaReal();
        assertEquals(valorRecebido, 5, 0);
    }
    
    @Test
    public void testEntradaRealValida1() throws Exception{
        CaixaDia cd = new CaixaDia();
        cd.setEntradaReal(0);
        float valorRecebido = cd.getEntradaReal();
        assertEquals(valorRecebido, 0, 0);
    }

    @Test
    public void testEntradaRealInvalida() throws Exception{
        CaixaDia cd = new CaixaDia();
        try{
            cd.setEntradaReal(-1);
            float valorRecebido = cd.getEntradaReal();
        }
        catch(Exception ce){
            assertEquals(ce.getMessage(), "Entrada invalida");
        }
    }
    
    //Teste saldoReal
    
    @Test
    public void testSaldoReal() throws Exception{
        CaixaDia cd = new CaixaDia();
        cd.setSaldoReal(5);
        float valorRecebido = cd.getSaldoReal();
        assertEquals(valorRecebido, 5, 0);
    }
    
    //Teste saldoLiquido
    
    @Test
    public void testSaldoLiquido() throws Exception{
        CaixaDia cd = new CaixaDia();
        cd.setSaldoLiquido(5);
        float valorRecebido = cd.getSaldoLiquido();
        assertEquals(valorRecebido, 5, 0);
    }
    
    //Teste saidaTotal
    
    @Test
    public void testSaidaTotalValida() throws Exception{
        CaixaDia cd = new CaixaDia();
        cd.setSaidaTotal(5);
        float valorRecebido = cd.getSaidaTotal();
        assertEquals(valorRecebido, 5, 0);
    }
    
    @Test
    public void testSaidaTotalValida1() throws Exception{
        CaixaDia cd = new CaixaDia();
        cd.setSaidaTotal(0);
        float valorRecebido = cd.getSaidaTotal();
        assertEquals(valorRecebido, 0, 0);
    }

    @Test
    public void testSaidaTotalInvalida() throws Exception{
        CaixaDia cd = new CaixaDia();
        try{
            cd.setSaidaTotal(-1);
            float valorRecebido = cd.getSaidaTotal();
        }
        catch(Exception ce){
            assertEquals(ce.getMessage(), "Saida invalida");
        }
    }

    //Teste data
    
    @Test
    public void testDataValida() throws Exception{
        CaixaDia cd = new CaixaDia();
        
        Date cal = new Date();
        cd.setData(cal);
        
        Date results = cd.getData();
        
        assertEquals(cal, results);
    }
    
    @Test
    public void testDataValida1() throws Exception{
        CaixaDia cd = new CaixaDia();
        
        Calendar cal = new GregorianCalendar();
        cal.add(Calendar.DAY_OF_MONTH, -1);
        Date data = cal.getTime();
        
        cd.setData(data);
        
        Date results = cd.getData();
        
        assertEquals(data, results);
    }

    @Test
    public void testDataInvalida() throws Exception{
        CaixaDia cd = new CaixaDia();
        
        Calendar cal = new GregorianCalendar();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        Date data = cal.getTime();
        
        try{
            cd.setData(data);
            Date results = cd.getData();
        }catch(Exception e){
            assertEquals(e.getMessage(), "Data invalida");
        }
    }
}

