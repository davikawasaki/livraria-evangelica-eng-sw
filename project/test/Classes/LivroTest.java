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
public class LivroTest {

    //Testes Editora

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
        v.setAutor("Dan Brown");
        String valorRecebido = v.getAutor();
        assertEquals(valorRecebido, "Dan Brown");
    }
}