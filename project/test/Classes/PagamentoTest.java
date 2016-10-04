package Classes;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nicholas
 */
public class PagamentoTest {

    //Testes idPagamento
    @Test
    public void testIdPagamentoInvalido() {
        Pagamento p = new Pagamento();
        try{
            p.setIdPagamento(-1);
        }
        catch(Exception e){
            assertEquals(e.getMessage(), "Id invalido");
        }
    }
    
    @Test
    public void testIdPagamentoValido() throws Exception{
        Pagamento p = new Pagamento();
        p.setIdPagamento(1);
        int valorRecebido = p.getIdPagamento();
        assertEquals(valorRecebido, 1);
    }
    
    //Teste Tipo
    @Test
    public void testTipoValido() throws Exception{
        Pagamento p = new Pagamento();
        p.setTipo("Dinheiro");
        String valorRecebido = p.getTipo();
        assertEquals(valorRecebido, "Dinheiro");
    }
    
    @Test
    public void testTipoValido1() throws Exception{
        Pagamento p = new Pagamento();
        p.setTipo("Cartao");
        String valorRecebido = p.getTipo();
        assertEquals(valorRecebido, "Cartao");
    }

    @Test
    public void testTipoInvalido(){
        Pagamento p = new Pagamento();
        p.setTipo("Cheque");
        try{
            String valorRecebido = p.getTipo();
        }
        catch(Exception e){
            assertEquals(e.getMessage(), "Tipo invalido");
        }
    }
    
    @Test
    public void testTipoInvalido1(){
        Pagamento p = new Pagamento();
        p.setTipo("1");
        try{
            String valorRecebido = p.getTipo();
        }
        catch(Exception e){
            assertEquals(e.getMessage(), "Tipo invalido");
        }
    }
    
    //Teste ValorTotal
    @Test
    public void testValorTotalValido() throws Exception{
        Pagamento p = new Pagamento();
        p.setValorTotal(5);
        float valorRecebido = p.getValorTotal();
        assertEquals(valorRecebido, 5, 0);
    }
    
    @Test
    public void testValorTotalValido1() throws Exception{
        Pagamento p = new Pagamento();
        p.setValorTotal(0);
        float valorRecebido = p.getValorTotal();
        assertEquals(valorRecebido, 0, 0);
    }

    @Test
    public void testValorTotalInvalido(){
        Pagamento p = new Pagamento();
        try{
            p.setValorTotal(-1);
        }
        catch(Exception e){
            assertEquals(e.getMessage(), "Valor invalido");
        }
    }
    
    //Teste Desconto
    @Test
    public void testDescontoValido() throws Exception{
        Pagamento p = new Pagamento();
        p.setDesconto(5);
        float valorRecebido = p.getDesconto();
        assertEquals(valorRecebido, 5, 0);
    }
    
    @Test
    public void testDescontoValido1() throws Exception{
        Pagamento p = new Pagamento();
        p.setDesconto(0);
        float valorRecebido = p.getDesconto();
        assertEquals(valorRecebido, 0, 0);
    }

    @Test
    public void testDescontoInvalido(){
        Pagamento p = new Pagamento();
        p.setDesconto(-1);
        try{
            float valorRecebido = p.getDesconto();
        }
        catch(Exception e){
            assertEquals(e.getMessage(), "Desconto invalido");
        }
    }
    
    //Teste Horario    
    @Test
    public void testHorarioValido() throws Exception{
        Pagamento p = new Pagamento();
        
        Calendar cal = new GregorianCalendar();
        Timestamp data = (Timestamp) cal.getTime();
        
        p.setHorario(data);
        
        Timestamp results = p.getHorario();
        
        assertEquals(data, results);
    }
    
    @Test
    public void testHorarioValido1() throws Exception{
        Pagamento p = new Pagamento();
        
        Calendar cal = new GregorianCalendar();
        cal.add(Calendar.DAY_OF_MONTH, -1);
        Timestamp data = (Timestamp) cal.getTime();
        
        p.setHorario(data);
        
        Timestamp results = p.getHorario();
        
        assertEquals(data, results);
    }

    @Test
    public void testHorarioInvalido(){
        Pagamento p = new Pagamento();
        
        Calendar cal = new GregorianCalendar();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        Timestamp data = (Timestamp) cal.getTime();
        
        p.setHorario(data);
        try{
            Timestamp results = p.getHorario();
        }catch(Exception e){
            assertEquals(e.getMessage(), "Horario invalido");
        }
    }
}