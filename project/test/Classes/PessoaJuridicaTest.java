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
 * @author lucasfranco
 */
public class PessoaJuridicaTest {
    @Test
     public void ContatoInsereCNPJ() {
        PessoaJuridica pf = new PessoaJuridica();
        pf.setCNPJ("12.345.678/9012-34");
        String valorRecebido = pf.getCNPJ();
        assertEquals(valorRecebido, "12.345.678/9012-34");
    }  
    @Test
    public void ContatoInsereNomeFantasia() {
        PessoaJuridica pf = new PessoaJuridica();
        pf.setNomeFantasia("Livraria Cultura");
        String valorRecebido = pf.getNomeFantasia();
        assertEquals(valorRecebido, "Livraria Cultura");
    }  
    @Test
    public void ContatoInserePessoaJuridica() {
         // Verificar se classe foi instanciada
    }  
    @Test
    public void ContatoAlteraDadosPessoaJuridica() {
        // Testa se os dados foram alterados com sucesso
    }
    
    @Test
    public void ContatoRemoveDadosPessoaJuridica() {
        // Testa se os dados foram removidos com sucesso
    }
    
    @Test
    public void ContatoConsultaDadosPessoaJuridica() {
        // Testa se os dados foram consultados com sucesso
    }
}