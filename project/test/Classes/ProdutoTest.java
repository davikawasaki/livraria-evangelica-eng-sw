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
public class ProdutoTest {

    //Testes idProduto
    @Test
    public void testIdProdutoInvalido() throws Exception {
        Produto p = new Produto();
        try{
            p.setIdProduto(-1);
        }
        catch(Exception e){
            assertEquals(e.getMessage(), "Id invalido");
        }
    }
    
    @Test
    public void testIdProdutoValido() throws Exception{
        Produto p = new Produto();
        p.setIdProduto(1);
        int valorRecebido = p.getIdProduto();
        assertEquals(valorRecebido, 1);
    }
    
    //Teste titulo
    
    @Test
    public void testTituloValido() throws Exception{
        Produto p = new Produto();
        p.setTitulo("Poesias de João Brasil");
        String valorRecebido = p.getTitulo();
        assertEquals(valorRecebido, "Poesias de João Brasil");
    }
    
    //Teste Tipo
    
    @Test
    public void testTipoValido() throws Exception{
        Produto p = new Produto();
        p.setTipo(3);
        int valorRecebido = p.getTipo();
        assertEquals(valorRecebido, 3);
    }
    
    @Test
    public void testTipoValido1() throws Exception{
        Produto p = new Produto();
        p.setTipo(0);
        int valorRecebido = p.getTipo();
        assertEquals(valorRecebido, 0);
    }

    @Test
    public void testTipoInvalido() throws Exception{
        Produto p = new Produto();
        try{
            p.setTipo(-1);
        }
        catch(Exception e){
            assertEquals(e.getMessage(), "Tipo invalido");
        }
    }
    
    @Test
    public void testTipoInvalido1() throws Exception{
        Produto p = new Produto();
        try{
            p.setTipo(4);
        }
        catch(Exception e){
            assertEquals(e.getMessage(), "Tipo invalido");
        }
    }    
    //Teste Preco
    
    @Test
    public void testPrecoInvalido() throws Exception{
        Produto p = new Produto();
        try{
            p.setPreco(-1);
        }
        catch(Exception e){
            assertEquals(e.getMessage(), "Preco invalido");
        }
    }
    
    @Test
    public void testPrecoValido() throws Exception{
        Produto p = new Produto();
        p.setPreco((float) 1.59);
        float valorRecebido = p.getPreco();
        assertEquals(valorRecebido, 1.59, 0.1);
    }
    
    //Teste Idioma
    @Test
    public void testIdiomaValido(){
        Produto p = new Produto();
        p.setIdioma("Português");
        String valorRecebido = p.getIdioma();
        assertEquals(valorRecebido, "Português");
    }
    
    //Teste anoLancamento
    
    @Test
    public void testAnoLancamentoInvalido() throws Exception{
        Produto p = new Produto();
        try{
            p.setAnoLancamento(-1);
        }
        catch(Exception e){
            assertEquals(e.getMessage(), "Ano invalido");
        }
    }
    
    @Test
    public void testAnoLancamentoValido() throws Exception{
        Produto p = new Produto();
        p.setAnoLancamento(1996);
        int valorRecebido = p.getAnoLancamento();
        assertEquals(valorRecebido, 1996);
    }
    
    //Teste quantidade
    
    @Test
    public void testQuantidadeInvalida() throws Exception{
        Produto p = new Produto();
        try{
            p.setQuantidade(-1);
        }
        catch(Exception e){
            assertEquals(e.getMessage(), "Quantidade invalida");
        }
    }
    
    @Test
    public void testQuantidadeValida() throws Exception{
        Produto p = new Produto();
        p.setQuantidade(5);
        int valorRecebido = p.getQuantidade();
        assertEquals(valorRecebido, 5);
    }
}
