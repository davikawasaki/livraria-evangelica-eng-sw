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
    
    //Testes Produto
    @Test
    public void testProdutoValido() throws Exception{
        Produto p = new Produto();
        Livro l = new Livro();
        
        p.setTitulo("As cronicas de narnia");
        p.setAnoLancamento(1890);
        l.setPdt(p);
        
        assertEquals(l.getPdt().getTitulo(), "As cronicas de narnia");
    }
    
    @Test
    public void testProdutoInvalido(){
        Produto p = new Produto();
        Livro v = null;
        try{
            v.setPdt(p);
            fail("Era esperada uma Exceção");
        }catch(Exception e){
            assertEquals(e.getMessage(), null);
        }
    }
    //Testes Editora

    @Test
    public void testEditoraValida() throws Exception{
        Livro l = new Livro();
        l.setEditora("Som livre");
        String valorRecebido = l.getEditora();
        assertEquals(valorRecebido, "Som livre");
    }
    
    @Test
    public void testEditoraInvalida1() throws Exception{
        Livro l = new Livro();
        
        try{
            l.setEditora("");
            fail("Deveria ter lançado uma exceção!");
        }catch(Exception e){
            assertEquals(e.getMessage(), "Editora invalida");
        }
    }
    
    @Test
    public void testEditoraInvalida2(){
        Livro l = new Livro();
        
        try{
            l.setEditora("Marcos Lopes Joaquim Deodoro da Fonseca Filho Júnior");
            fail("Deveria ter lançado uma exceção!");
        }catch(Exception e){
            assertEquals(e.getMessage(), "Editora invalida");
        }
    }
    
    //Testes Autor
    
    @Test
    public void testAutorValido() throws Exception{
        Livro v = new Livro();
        v.setAutor("Dan Brown");
        String valorRecebido = v.getAutor();
        assertEquals(valorRecebido, "Dan Brown");
    }
    
    @Test
    public void testAutorInvalido1() throws Exception{
        Livro l = new Livro();
        
        try{
            l.setAutor("");
            fail("Deveria ter lançado uma exceção!");
        }catch(Exception e){
            assertEquals(e.getMessage(), "Autor invalido");
        }
    }
    
    @Test
    public void testAutorInvalido2() throws Exception{
        Livro l = new Livro();
        
        try{
            l.setAutor("Marcos Lopes Joaquim Deodoro da Fonseca Filho Júnior");
            fail("Deveria ter lançado uma exceção!");
        }catch(Exception e){
            assertEquals(e.getMessage(), "Autor invalido");
        }
    }
}