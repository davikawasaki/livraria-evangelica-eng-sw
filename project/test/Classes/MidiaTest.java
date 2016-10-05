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
    
    //Testes Produto
    @Test
    public void testProdutoValido() throws Exception{
        Produto p = new Produto();
        Midia m = new Midia();
        
        p.setTitulo("CD ao vivo");
        m.setPdt(p);
        
        assertEquals(m.getPdt().getTitulo(), "CD ao vivo");
    }
    
    @Test
    public void testProdutoInvalido() throws Exception{
        Produto p = new Produto();
        Midia m = null;
        try{
            m.setPdt(p);
            fail("Era para ser disparada uma exceção");
        }catch(Exception e){
            assertEquals(e.getMessage(), null);
        }
    }
    
    //Testes Artista
    
    @Test
    public void testArtistaValido() throws Exception{
        Midia m = new Midia();
        m.setArtista("João Brasil");
        String valorRecebido = m.getArtista();
        assertEquals(valorRecebido, "João Brasil");
    }
    
    @Test
    public void testArtistaInvalido1() throws Exception{
        Midia m = new Midia();
        
        try{
            m.setArtista("");
            fail("Deveria ter lançado uma exceção!");
        }catch(Exception e){
            assertEquals(e.getMessage(), "Artista invalido");
        }
    }
    
    @Test
     public void testArtistaInvalido2() throws Exception{
        Midia m = new Midia();
        
        try{
            m.setArtista("Marcos Lopes Joaquim Deodoro da Fonseca Filho Júnior");
            fail("Deveria ter lançado uma exceção!");
        }catch(Exception e){
            assertEquals(e.getMessage(), "Artista invalido");
        }
    }
    
    //Teste tipoMidia
    
    @Test
    public void testTipoMidiaValida() throws Exception{
        Midia m = new Midia();
        m.setTipoMidia("CD");
        String valorRecebido = m.getTipoMidia();
        assertEquals(valorRecebido, "CD");
    }
    
    @Test
    public void testMidiaInvalida1() throws Exception{
        Midia m = new Midia();
        
        try{
            m.setTipoMidia("Marcos Lopes Joaquim Deodoro da Fonseca Filho Júnior");
            fail("Deveria ter lançado uma exceção!");
        }catch(Exception e){
            assertEquals(e.getMessage(), "Midia invalida");
        }
    }
    
    @Test
     public void testMidiaInvalida2() throws Exception{
        Midia m = new Midia();
        
        try{
            m.setTipoMidia("");
            fail("Deveria ter lançado uma exceção!");
        }catch(Exception e){
            assertEquals(e.getMessage(), "Midia invalida");
        }
    }
     
     
     
}