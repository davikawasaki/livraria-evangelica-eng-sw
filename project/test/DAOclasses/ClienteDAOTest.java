/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOclasses;

import Classes.Cliente;
import Classes.Pessoa;
import Classes.PessoaFisica;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author Nicholas
 */
public class ClienteDAOTest {
   
    @Test
    public void testeConexaoClienteDAOConnectionFactoryInvalido() throws Exception {
        String expResult = "Erro ao conectar com o banco";
        try {
            ClienteDAO cdao = new ClienteDAO();
            cdao.setaConexaoClienteDAO("root", "root123");
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
//    Verifica possível retorno de exceção da inserção vazia do cliente
    @Test
    public void testeAdicionaClienteDAOInvalido() throws Exception {
        String expResult = "Campo nulo, erro ao enviar o cliente para o banco";
        Cliente c = new Cliente();
        ClienteDAO cdao = new ClienteDAO();
        try {
            cdao.adiciona(c);
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    
    /*//    Verifica se o fornecedor foi adicionado com sucesso
    @Test
    public void testeAdicionaClienteDAOValido() throws Exception {
        Cliente cliente = new Cliente();
        PessoaFisica pf = new PessoaFisica();
        Pessoa pessoa = new Pessoa();
        ClienteDAO cdao = new ClienteDAO();
        
        pessoa.setEmail("abc@abc.com");
        pessoa.setSenha("123");
        pessoa.setTelefone("(43)99999-9999");
        pessoa.setCEP("99999-999");
        pessoa.setLogradouro("Rua Abc");
        pessoa.setNumero(10);
        pessoa.setComplemento("Sala 2");
        pessoa.setBairro("Centro");
        pessoa.setCidade("Abc");
        pessoa.setEstado("Abc");
        pessoa.setPais("Abc");

        pf.setCPF("45884718823");

        String data = "21/02/2010";
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        pf.setDataNascimento(new Date(format.parse(data).getTime()));
        pf.setNome("Nome");
        pf.setRG("465765751");
        pf.setSexo("M");
        pf.setSobrenome("Sobrenome");
        pf.setPessoa(pessoa);
        
        cliente.setFidelidade(true);
        cliente.setCodFidelidade("12312");
        cliente.setPf(pf);
        boolean resultAdiciona = cdao.adiciona(cliente);
        
        assertTrue(resultAdiciona);       
    }
*/
//    Verifica se o retorno foi realizado com sucesso
    @Test
    public void testeListaClienteDAOValido() throws Exception {
        ClienteDAO cdao = new ClienteDAO();
        List lista = cdao.getLista();
        assertTrue(lista instanceof java.util.List);
    }
    //    Verifica possível retorno de exceção da update vazio do fornecedor
    @Test
    public void testeAlteraClienteDAOInvalido() throws Exception {
        String expResult = "Campo nulo, erro ao enviar o cliente para o banco";
        Cliente cliente = new Cliente();
        ClienteDAO cdao = new ClienteDAO();
        try {
            cdao.altera(cliente);
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
 
    //    Verifica se o fornecedor foi alterado com sucesso
    @Test
    public void testeAlteraClienteDAOValido() throws Exception {
        Cliente cliente = new Cliente();
        PessoaFisica pf = new PessoaFisica();
        Pessoa pessoa = new Pessoa();
        ClienteDAO cdao = new ClienteDAO();
        
        pessoa.setId(48);
        pessoa.setEmail("abc@abc.com");
        pessoa.setTelefone("(43)99999-9999");
        pessoa.setCEP("99999-999");
        pessoa.setLogradouro("Rua Abc");
        pessoa.setNumero(10);
        pessoa.setComplemento("Sala 2");
        pessoa.setBairro("Centro");
        pessoa.setCidade("Abc");
        pessoa.setEstado("Abc");
        pessoa.setPais("Abc");

        String data = "21/02/2010";
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        pf.setDataNascimento(new Date(format.parse(data).getTime()));
        pf.setNome("Nomedo jura");
        pf.setRG("465765751");
        pf.setSexo("M");
        pf.setCPF("45884718823");
        pf.setSobrenome("Sobrenome");
        pf.setPessoa(pessoa);
        
        cliente.setIdCliente(9);
        cliente.setFidelidade(true);
        cliente.setCodFidelidade("11252");
        cliente.setPf(pf);

        boolean resultAltera = cdao.altera(cliente);
        assertTrue(resultAltera);        
    }
}
