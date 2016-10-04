/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nicholas
 */
public class MidiaTest {

    //Testes Artista
    
    @Test
    public void testArtistaValido() throws Exception{
        Midia m = new Midia();
        m.setArtista("João Brasil");
        String valorRecebido = m.getArtista();
        assertEquals(valorRecebido, "João Brasil");
    }
    
    //Teste tipoMidia
    
    @Test
    public void testTipoMidiaValida() throws Exception{
        Midia m = new Midia();
        m.setTipoMidia("CD");
        String valorRecebido = m.getTipoMidia();
        assertEquals(valorRecebido, "CD");
    }
}