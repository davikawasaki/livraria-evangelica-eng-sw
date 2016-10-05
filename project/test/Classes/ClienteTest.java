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
    public void testeIdClienteValido() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(55555);
        int valorRecebido = cliente.getIdCliente();
        assertEquals(valorRecebido, 55555);
    }
    // ID inválido para ID < 0
    @Test
    public void testeIdClienteInvalido() throws Exception {
        Cliente cliente = new Cliente();
        String expResult = "ID Invalido";
        try {
            cliente.setIdCliente(-1);
            int valorRecebido = cliente.getIdCliente();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    } 
    @Test
    public void testeFidelidadeClienteValido() {
        Cliente cliente = new Cliente();
        cliente.setFidelidade(1);
        int valorRecebido = cliente.isFidelidade();
        assertEquals(valorRecebido, true);
    }  
    @Test
    public void testeCodFidelidadeClienteValido() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setCodFidelidade("A123");
        String valorRecebido = cliente.getCodFidelidade();
        assertEquals(valorRecebido, "A123");
    }  
    // Codigo de Fidelidade inválido menor que 3 caracteres
    @Test
    public void testeCodFidelidadeClienteInvalido1() throws Exception {
        Cliente cliente = new Cliente();
        String expResult = "Codigo de Fidelidade menor que 3 caracteres";
        try {
            cliente.setCodFidelidade("A1");
            String valorRecebido = cliente.getCodFidelidade();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    // Codigo de Fidelidade inválido estourando o limite de caracteres
    @Test
    public void testeCodFidelidadeClienteInvalido2() throws Exception {
        Cliente cliente = new Cliente();
        String expResult = "Codigo de Fidelidade maior que 45 caracteres";
        try {
            cliente.setCodFidelidade("A1312515131NFJ34JH1IJEI2JO1JDFOIJFO1IJ23O1J2OJ1I231FJ1I");
            String valorRecebido = cliente.getCodFidelidade();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    // Codigo de Fidelidade inválido vazio
    @Test
    public void testeCodFidelidadeClienteInvalido3() throws Exception {
        Cliente cliente = new Cliente();
        String expResult = "Codigo de Fidelidade Invalido";
        try {
            cliente.setCodFidelidade("");
            String valorRecebido = cliente.getCodFidelidade();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    @Test
    public void testePessoaFisicaClienteValido() {
        Cliente cliente = new Cliente();
        PessoaFisica pf = new PessoaFisica();
        
        cliente.setPf(pf);
        PessoaFisica result = cliente.getPf();
        assertEquals(pf, result);
    }  
}
