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
    public void testeIdPessoaValido() throws Exception {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(0);
        int valorRecebido = pessoa.getId();
        assertEquals(valorRecebido, 0);
    }
    @Test
    public void testeIdPessoaInvalido() throws Exception {
        Pessoa pessoa = new Pessoa();
        String expResult = "ID Invalido";
        try {
            pessoa.setId(-1);
            int valorRecebido = pessoa.getId();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }      
    @Test
    public void testeTelefonePessoaValido() throws Exception {
        Pessoa pessoa = new Pessoa();
        String telefone = "(19)99999-9999";
        pessoa.setTelefone(telefone);
        String valorRecebido = pessoa.getTelefone();
        assertEquals(valorRecebido, "19999999999");
    }
    // Telefone inválido para menos que 10 dígitos
    @Test
    public void testeTelefonePessoaInvalido1() throws Exception {
        Pessoa pessoa = new Pessoa();
        String expResult = "Telefone Invalido";
        try {
            String telefone = "(19)99999-99";
            pessoa.setTelefone(telefone);
            String valorRecebido = pessoa.getTelefone();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    // Telefone inválido para maior que 11 dígitos
    @Test
    public void testeTelefonePessoaInvalido2() throws Exception {
        Pessoa pessoa = new Pessoa();
        String expResult = "Telefone Invalido";
        try {
            String telefone = "(19)99999-99999";
            pessoa.setTelefone(telefone);
            String valorRecebido = pessoa.getTelefone();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    @Test
    public void testeEmailPessoaValido() throws Exception {
        Pessoa pessoa = new Pessoa();
        pessoa.setEmail("contato@livraria.com.br");
        String valorRecebido = pessoa.getEmail();
        assertEquals(valorRecebido, "contato@livraria.com.br");
    }
    // E-mail inválido sem nome
    @Test
    public void testeEmailPessoaInvalido1() throws Exception {
        Pessoa pessoa = new Pessoa();
        String expResult = "E-mail Invalido";
        try {
            pessoa.setEmail("@livraria.com.br");
            String valorRecebido = pessoa.getEmail();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    // E-mail inválido sem domínio
    @Test
    public void testeEmailPessoaInvalido2() throws Exception {
        Pessoa pessoa = new Pessoa();
        String expResult = "E-mail Invalido";
        try {
            pessoa.setEmail("contato@.com.br");
            String valorRecebido = pessoa.getEmail();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    // E-mail inválido sem subdomínio
    @Test
    public void testeEmailPessoaInvalido3() throws Exception {
        Pessoa pessoa = new Pessoa();
        String expResult = "E-mail Invalido";
        try {
            pessoa.setEmail("contato@livraria.");
            String valorRecebido = pessoa.getEmail();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    // E-mail inválido com subdomínio de apenas 1 caractere
    @Test
    public void testeEmailPessoaInvalido4() throws Exception {
        Pessoa pessoa = new Pessoa();
        String expResult = "E-mail Invalido";
        try {
            pessoa.setEmail("a@a.a");
            String valorRecebido = pessoa.getEmail();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    // E-mail vazio
    @Test
    public void testeEmailPessoaInvalido5() throws Exception {
        Pessoa pessoa = new Pessoa();
        String expResult = "E-mail Invalido";
        try {
            pessoa.setEmail("@.");
            String valorRecebido = pessoa.getEmail();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    @Test
    public void testeCEPPessoaValido() throws Exception {
        Pessoa pessoa = new Pessoa();
        pessoa.setCEP("86300000");
        String valorRecebido = pessoa.getCEP();
        assertEquals(valorRecebido, "86300000");
    }
    // CEP Inválido com menos de 8 dígitos
    @Test
    public void testeCEPPessoaInvalido1() throws Exception {
        Pessoa pessoa = new Pessoa();
        String expResult = "CEP Invalido";
        try {
            pessoa.setCEP("86300");
            String valorRecebido = pessoa.getCEP();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    // CEP Inválido com mais de 8 dígitos
    @Test
    public void testeCEPPessoaInvalido2() throws Exception {
        Pessoa pessoa = new Pessoa();
        String expResult = "CEP Invalido";
        try {
            pessoa.setCEP("863000000");
            String valorRecebido = pessoa.getCEP();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    @Test
    public void testeLogradouroPessoaValido() throws Exception {
        Pessoa pessoa = new Pessoa();
        pessoa.setLogradouro("Rua do Escambau");
        String valorRecebido = pessoa.getLogradouro();
        assertEquals(valorRecebido, "Rua do Escambau");
    }
    // Logradouro inválido estourando o limite de caracteres
    @Test
    public void testeLogradouroPessoaInvalido1() throws Exception {
        Pessoa pessoa = new Pessoa();
        String expResult = "Logradouro maior que 45 caracteres";
        try {
            pessoa.setLogradouro("Rua Marcos Lopes Joaquim Deodoro Ultimo Filho Júnior");
            String valorRecebido = pessoa.getLogradouro();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    // Logradouro inválido vazio
    @Test
    public void testeLogradouroPessoaInvalido2() throws Exception {
        Pessoa pessoa = new Pessoa();
        String expResult = "Logradouro Invalido";
        try {
            pessoa.setLogradouro("");
            String valorRecebido = pessoa.getLogradouro();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    @Test
    public void testeComplementoPessoaValido() throws Exception {
        Pessoa pessoa = new Pessoa();
        pessoa.setComplemento("Sala 02");
        String valorRecebido = pessoa.getComplemento();
        assertEquals(valorRecebido, "Sala 02");
    }
    // Complemento inválido estourando o limite de caracteres
    @Test
    public void testeComplementoPessoaInvalido1() throws Exception {
        Pessoa pessoa = new Pessoa();
        String expResult = "Complemento maior que 45 caracteres";
        try {
            pessoa.setComplemento("Sala Comercial Empresarial Rocha 123151251251251");
            String valorRecebido = pessoa.getComplemento();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    // Complemento inválido vazio
    @Test
    public void testeComplementoPessoaInvalido2() throws Exception {
        Pessoa pessoa = new Pessoa();
        String expResult = "Complemento Invalido";
        try {
            pessoa.setComplemento("");
            String valorRecebido = pessoa.getComplemento();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    @Test
    public void testeNumeroPessoaValido() throws Exception {
        Pessoa pessoa = new Pessoa();
        pessoa.setNumero(10);
        int valorRecebido = pessoa.getNumero();
        assertEquals(valorRecebido, 10);
    }
    @Test
    public void testeNumeroPessoaInvalido() throws Exception {
        Pessoa pessoa = new Pessoa();
        String expResult = "Numero Invalido";
        try {
            pessoa.setNumero(0);
            int valorRecebido = pessoa.getNumero();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    @Test
    public void testeBairroPessoaValido() throws Exception {
        Pessoa pessoa = new Pessoa();
        pessoa.setBairro("Centro");
        String valorRecebido = pessoa.getBairro();
        assertEquals(valorRecebido, "Centro");
    }
    // Bairro inválido estourando o limite de caracteres
    @Test
    public void testeBairroPessoaInvalido1() throws Exception {
        Pessoa pessoa = new Pessoa();
        String expResult = "Bairro maior que 45 caracteres";
        try {
            pessoa.setBairro("Zona centralizada do Parque Joaquim Moreira Silva");
            String valorRecebido = pessoa.getBairro();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    // Bairro inválido vazio
    @Test
    public void testeBairroPessoaInvalido2() throws Exception {
        Pessoa pessoa = new Pessoa();
        String expResult = "Bairro Invalido";
        try {
            pessoa.setBairro("");
            String valorRecebido = pessoa.getBairro();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    @Test
    public void testeCidadePessoaValido() throws Exception {
        Pessoa pessoa = new Pessoa();
        pessoa.setCidade("Londrina");
        String valorRecebido = pessoa.getCidade();
        assertEquals(valorRecebido, "Londrina");
    }
    // Cidade inválida estourando o limite de caracteres
    @Test
    public void testeCidadePessoaInvalido1() throws Exception {
        Pessoa pessoa = new Pessoa();
        String expResult = "Cidade maior que 45 caracteres";
        try {
            pessoa.setCidade("Santo Antônio da Platina do Sudoeste Paranaense");
            String valorRecebido = pessoa.getCidade();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    // Cidade inválida vazia
    @Test
    public void testeCidadePessoaInvalido2() throws Exception {
        Pessoa pessoa = new Pessoa();
        String expResult = "Cidade Invalida";
        try {
            pessoa.setCidade("");
            String valorRecebido = pessoa.getCidade();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    @Test
    public void testeEstadoPessoaValido() throws Exception {
        Pessoa pessoa = new Pessoa();
        pessoa.setEstado("Parana");
        String valorRecebido = pessoa.getEstado();
        assertEquals(valorRecebido, "Parana");
    }
    // Estado inválido estourando o limite de caracteres
    @Test
    public void testeEstadoPessoaInvalido1() throws Exception {
        Pessoa pessoa = new Pessoa();
        String expResult = "Estado maior que 45 caracteres";
        try {
            pessoa.setEstado("Maranhão Justino Cortieri do Nordeste Praineiro");
            String valorRecebido = pessoa.getEstado();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    // Estado inválido vazio
    @Test
    public void testeEstadoPessoaInvalido2() throws Exception {
        Pessoa pessoa = new Pessoa();
        String expResult = "Estado Invalido";
        try {
            pessoa.setEstado("");
            String valorRecebido = pessoa.getEstado();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    @Test
    public void testePaisPessoaValido() throws Exception {
        Pessoa pessoa = new Pessoa();
        pessoa.setPais("Brasil");
        String valorRecebido = pessoa.getPais();
        assertEquals(valorRecebido, "Brasil");
    }
    // País inválido estourando o limite de caracteres
    @Test
    public void testePaisPessoaInvalido1() throws Exception {
        Pessoa pessoa = new Pessoa();
        String expResult = "País maior que 45 caracteres";
        try {
            pessoa.setPais("Estados Concisos Caribenhos da América do Norte");
            String valorRecebido = pessoa.getPais();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    // País inválido vazio
    @Test
    public void testePaisPessoaInvalido2() throws Exception {
        Pessoa pessoa = new Pessoa();
        String expResult = "País Invalido";
        try {
            pessoa.setPais("");
            String valorRecebido = pessoa.getPais();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
}