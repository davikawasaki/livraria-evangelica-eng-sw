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
 * @author davikawasaki
 */
public class PessoaTest {
    // Testes de caixa preta
    @Test
    public void ContatoInsereId() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(0);
        int valorRecebido = pessoa.getId();
        assertEquals(valorRecebido, 0);
    }    
    @Test
    public void ContatoInsereTelefone() {
        Pessoa pessoa = new Pessoa();
        pessoa.setTelefone("19999999999");
        String valorRecebido = pessoa.getTelefone();
        assertEquals(valorRecebido, "19999999999");
    }
    @Test
    public void ContatoInsereEmail() {
        Pessoa pessoa = new Pessoa();
        pessoa.setEmail("contato@livraria.com.br");
        String valorRecebido = pessoa.getEmail();
        assertEquals(valorRecebido, "contato@livraria.com.br");
    }
    @Test
    public void ContatoInsereCEP() {
        Pessoa pessoa = new Pessoa();
        pessoa.setCEP("88888888");
        String valorRecebido = pessoa.getCEP();
        assertEquals(valorRecebido, "88888888");
    }
    @Test
    public void ContatoInsereLogradouro() {
        Pessoa pessoa = new Pessoa();
        pessoa.setLogradouro("Rua do Escambau");
        String valorRecebido = pessoa.getLogradouro();
        assertEquals(valorRecebido, "Rua do Escambau");
    }
    @Test
    public void ContatoInsereNumero() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNumero(10);
        int valorRecebido = pessoa.getNumero();
        assertEquals(valorRecebido, 10);
    }
    @Test
    public void ContatoInsereBairro() {
        Pessoa pessoa = new Pessoa();
        pessoa.setBairro("Centro");
        String valorRecebido = pessoa.getBairro();
        assertEquals(valorRecebido, "Centro");
    }
    @Test
    public void ContatoInsereCidade() {
        Pessoa pessoa = new Pessoa();
        pessoa.setCidade("Londrina");
        String valorRecebido = pessoa.getCidade();
        assertEquals(valorRecebido, "Londrina");
    }
    @Test
    public void ContatoInsereEstado() {
        Pessoa pessoa = new Pessoa();
        pessoa.setEstado("Parana");
        String valorRecebido = pessoa.getEstado();
        assertEquals(valorRecebido, "Parana");
    }
    @Test
    public void ContatoInserePais() {
        Pessoa pessoa = new Pessoa();
        pessoa.setPais("Vai Brazilian");
        String valorRecebido = pessoa.getPais();
        assertEquals(valorRecebido, "Vai Brazilian");
    }
}
