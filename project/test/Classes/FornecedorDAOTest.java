/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import DAOclasses.FornecedorDAO;
import DAOclasses.PessoaDAO;
import DAOclasses.PessoaJuridicaDAO;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author davikawasaki
 */
public class FornecedorDAOTest {
//    Testes de caixa branca
//    Verifica possível retorno de exceção do construtor
//    Conexão equivocada com usuário ou senha errada (mudar os valores de acesso ao JDBC)    
    @Test(expected = RuntimeException.class)
    public void verificarExcecaoConexaoFornecedorDAOConnectionFactory() {
        FornecedorDAO fdao = new FornecedorDAO();
    }
//    Verifica possível retorno de exceção da inserção vazia do fornecedor
    @Test(expected = NullPointerException.class)
    public void fornecedorDAOadicionaExcecaoNullPointer() throws Exception {
        Fornecedor fornecedor = new Fornecedor();
        FornecedorDAO fdao = new FornecedorDAO();
        fdao.adiciona(fornecedor);
    }
//    Verificar possível retorno de exceção de inserção totalmente vazia da stack tree da herança de fornecedor
    @Test(expected = RuntimeException.class)
    public void fornecedorDAOadicionaStackTreeVazia() throws Exception {
        Fornecedor fornecedor = new Fornecedor();
        FornecedorDAO fdao = new FornecedorDAO();
        PessoaJuridica pj = new PessoaJuridica();
        PessoaJuridicaDAO pjdao = new PessoaJuridicaDAO();
        Pessoa pessoa = new Pessoa();
        PessoaDAO pdao = new PessoaDAO();
        pdao.adiciona(pessoa);
        pjdao.adiciona(pj);
        fdao.adiciona(fornecedor);
    }
//    Verifica se o fornecedor foi adicionado com sucesso
    @Test
    public void fornecedorDAOadicionaSucesso() throws Exception {
        Fornecedor fornecedor = new Fornecedor();
        PessoaJuridica pj = new PessoaJuridica();
        Pessoa pessoa = new Pessoa();
        FornecedorDAO fdao = new FornecedorDAO();
        
        pessoa.setId(2);
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
        
        pj.setCNPJ("654321");
        pj.setNomeFantasia("Abc");
        pj.setPessoa(pessoa);
        
        fornecedor.setNomeRepresentante("Abc");
        fornecedor.setTipoFornecimento("Consignado");
        fornecedor.setTipoServico("Venda");
        fornecedor.setPj(pj);

        fdao.adiciona(fornecedor);
        String valorCNPJ = fornecedor.getPj().getCNPJ();
        assertEquals(valorCNPJ, "654321");
    }
//    Teste para caso de chave duplicada já inserida no banco (colocar valores de chaves duplicadas)
//    Teste para tabelas inexistentes (tabelas Pessoa, PessoaJuridica e Fornecedor)
//    Teste para query SQL erradas
    @Test(expected = RuntimeException.class)
    public void fornecedorDAOadicionaErros() throws Exception {
        Fornecedor fornecedor = new Fornecedor();
        PessoaJuridica pj = new PessoaJuridica();
        Pessoa pessoa = new Pessoa();
        FornecedorDAO fdao = new FornecedorDAO();
        
        pessoa.setId(1);
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
        
        pj.setCNPJ("123456");
        pj.setNomeFantasia("Abc");
        pj.setPessoa(pessoa);
        
        fornecedor.setNomeRepresentante("Abc");
        fornecedor.setTipoFornecimento("Consignado");
        fornecedor.setTipoServico("Venda");
        fornecedor.setPj(pj);

        fdao.adiciona(fornecedor);
    }
//    Verifica se o retorno foi realizado com sucesso
    @Test
    public void fornecedorDAOlista() throws Exception {
        FornecedorDAO fdao = new FornecedorDAO();
        List lista = fdao.getLista();
        assertTrue(lista instanceof java.util.List);
    }
//    Teste para nenhum valor cadastrado    
//    Teste para tabelas inexistentes (tabelas Pessoa, PessoaJuridica e Fornecedor)
//    Teste para query SQL erradas    
    @Test(expected = RuntimeException.class)
    public void fornecedorDAOlistaErros() throws Exception {
        FornecedorDAO fdao = new FornecedorDAO();
        fdao.getLista();
    }
//    Verifica se o fornecedor foi alterado com sucesso
//    Ignorado, pois necessita implementar método de consulta específica
    @Ignore
    @Test
    public void fornecedorDAOalteraSucesso() {
        
    }
//    Teste para caso de chave não achada no banco
//    Teste para tabelas inexistentes (tabelas Pessoa, PessoaJuridica e Fornecedor)
//    Teste para query SQL erradas
//    Ignorado, pois necessita implementar método de consulta específica
    @Ignore    
    @Test(expected = RuntimeException.class)
    public void fornecedorDAOalteraErros() throws Exception {
        Fornecedor fornecedor = new Fornecedor();
        PessoaJuridica pj = new PessoaJuridica();
        Pessoa pessoa = new Pessoa();
        FornecedorDAO fdao = new FornecedorDAO();
        
        pessoa.setId(1);
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
        
        pj.setCNPJ("11111111111");
        pj.setNomeFantasia("Abc");
        pj.setPessoa(pessoa);
        
        fornecedor.setNomeRepresentante("Abc");
        fornecedor.setTipoFornecimento("Consignado");
        fornecedor.setTipoServico("Venda");
        fornecedor.setPj(pj);

        fdao.altera(fornecedor);
    }    
}
