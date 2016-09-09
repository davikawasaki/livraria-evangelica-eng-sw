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
public class ClienteTest {
    @Test
    public void ContatoInsereIdCliente() {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(55555);
        int valorRecebido = cliente.getIdCliente();
        assertEquals(valorRecebido, 55555);
    }  
    @Test
    public void ContatoInsereFidelidade() {
        Cliente cliente = new Cliente();
        cliente.setFidelidade(true);
        boolean valorRecebido = cliente.isFidelidade();
        assertEquals(valorRecebido, true);
    }  
    @Test
    public void ContatoInsereCodFidelidade() {
        Cliente cliente = new Cliente();
        cliente.setCodFidelidade("A123");
        String valorRecebido = cliente.getCodFidelidade();
        assertEquals(valorRecebido, "A123");
    }  
    @Test
    public void ContatoInsereCliente() {
         // Verificar se classe foi instanciada
    }  
    @Test
    public void ContatoAlteraDadosCliente() {
        // Testa se os dados foram alterados com sucesso
    }
    @Test
    public void ContatoRemoveDadosCliente() {
        // Testa se os dados foram removidos com sucesso
    }
    @Test
    public void ContatoConsultaDadosCliente() {
        // Testa se os dados foram consultados com sucesso
    }
}
