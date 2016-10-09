package Classes;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nicholas
 */
public class SaidaTest {

    //Testes idSaida
    @Test
    public void testIdSaidaInvalida() {
        Saida s = new Saida();
        s.setIdSaida(-1);
        try{
            int valorRecebido = s.getIdSaida();
        }
        catch(Exception e){
            assertEquals(e.getMessage(), "Id invalido");
        }
    }
    
    @Test
    public void testIdSaidaValida() throws Exception{
        Saida s = new Saida();
        s.setIdSaida(1);
        int valorRecebido = s.getIdSaida();
        assertEquals(valorRecebido, 1);
    }
    
    //Teste Valor
    @Test
    public void testValorValido() throws Exception{
        Saida s = new Saida();
        s.setValor(5);
        float valorRecebido = s.getValor();
        assertEquals(valorRecebido, 5, 0);
    }
    
    @Test
    public void testValorValido1() throws Exception{
        Saida s = new Saida();
        s.setValor(0);
        float valorRecebido = s.getValor();
        assertEquals(valorRecebido, 0, 0);
    }

    @Test
    public void testValorInvalido(){
        Saida s = new Saida();
        s.setValor(-1);
        try{
            float valorRecebido = s.getValor();
        }
        catch(Exception e){
            assertEquals(e.getMessage(), "Valor invalido");
        }
    }
    
    //Teste Tipo
    @Test
    public void testTipoValido1() throws Exception{
        Saida s = new Saida();
        s.setTipo("Contas");
        String valorRecebido = s.getTipo();
        assertEquals(valorRecebido, "Contas");
    }
}
