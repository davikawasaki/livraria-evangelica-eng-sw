/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Classes.Livro;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nicholas
 */
public class LivroTest {

    //Testes Editora
    @Test
    public void testEditoraInvalida(){
        Livro v = new Livro();
        try{
      //      v.setEditora(1);
            String valorRecebido = v.getAutor();
        }
        catch(Exception ce){
            assertEquals(ce.getMessage(), "Editora invalida");
        }
    }
    
    @Test
    public void testEditoraValida(){
        Livro v = new Livro();
        v.setEditora("Som livre");
        String valorRecebido = v.getEditora();
        assertEquals(valorRecebido, "Som livre");
    }
    
    //Testes Autor
    
    @Test
    public void testAutorValido(){
        Livro v = new Livro();
        v.setAutor("Dan Pica Brown");
        String valorRecebido = v.getAutor();
        assertEquals(valorRecebido, "Dan Pica Brown");
    }
}