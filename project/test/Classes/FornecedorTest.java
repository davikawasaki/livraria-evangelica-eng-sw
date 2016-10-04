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
public class FornecedorTest {
    @Test
    public void testeNomeRepresentanteFornecedorValido() throws Exception {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNomeRepresentante("Daniel Souza");
        String valorRecebido = fornecedor.getNomeRepresentante();
        assertEquals(valorRecebido, "Daniel Souza");
    }
    // Nome Representante inválido estourando o limite de caracteres
    @Test
    public void testeNomeRepresentanteFornecedorInvalido1() throws Exception {
        Fornecedor fornecedor = new Fornecedor();
        String expResult = "Nome Representante maior que 45 caracteres";
        try {
            fornecedor.setNomeRepresentante("Daniel Souza Mario Silvino Porchat Queiroz Moreira Kurt Júnior");
            String valorRecebido = fornecedor.getNomeRepresentante();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }  
    // Nome Representante inválido vazio
    @Test
    public void testeNomeRepresentanteFornecedorInvalido2() throws Exception {
        Fornecedor fornecedor = new Fornecedor();
        String expResult = "Nome Representante Invalido";
        try {
            fornecedor.setNomeRepresentante("");
            String valorRecebido = fornecedor.getNomeRepresentante();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    @Test
    public void testeTipoServicoFornecedorValido() throws Exception {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setTipoServico("Consignado");
        String valorRecebido = fornecedor.getTipoServico();
        assertEquals(valorRecebido, "Consignado");
    }  
    // Tipo Serviço inválido estourando o limite de caracteres
    @Test
    public void testeTipoServicoFornecedorInvalido1() throws Exception {
        Fornecedor fornecedor = new Fornecedor();
        String expResult = "Tipo de Serviço maior que 45 caracteres";
        try {
            fornecedor.setTipoServico("Consignado Parcelado Crediário Bolsa do Banco do Brasil creditada a long prazo");
            String valorRecebido = fornecedor.getTipoServico();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    // Tipo Serviço inválido vazio
    @Test
    public void testeTipoServicoFornecedorInvalido2() throws Exception {
        Fornecedor fornecedor = new Fornecedor();
        String expResult = "Tipo de Serviço Invalido";
        try {
            fornecedor.setTipoServico("");
            String valorRecebido = fornecedor.getTipoServico();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    @Test
    public void testeTipoFornecimentoFornecedorValido() throws Exception {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setTipoFornecimento("Papelaria");
        String valorRecebido = fornecedor.getTipoFornecimento();
        assertEquals(valorRecebido, "Papelaria");
    }
    // Tipo Fornecimento inválido estourando o limite de caracteres
    @Test
    public void testeTipoFornecimentoFornecedorInvalido1() throws Exception {
        Fornecedor fornecedor = new Fornecedor();
        String expResult = "Tipo de Fornecimento maior que 45 caracteres";
        try {
            fornecedor.setTipoFornecimento("Livraria de materiais primários de montagem e construção de materiais didáticos");
            String valorRecebido = fornecedor.getTipoFornecimento();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    // Tipo Fornecimento inválido vazio
    @Test
    public void testeTipoFornecimentoFornecedorInvalido2() throws Exception {
        Fornecedor fornecedor = new Fornecedor();
        String expResult = "Tipo de Fornecimento Invalido";
        try {
            fornecedor.setTipoFornecimento("");
            String valorRecebido = fornecedor.getTipoFornecimento();
            fail("Deveria ter lançado uma exceção!");
        } catch(Exception e) {
            assertEquals(expResult, e.getMessage());
        }
    }
    @Test
    public void testePessoaJuridicaFornecedorValido() {
        Fornecedor fornecedor = new Fornecedor();
        PessoaJuridica pj = new PessoaJuridica();
        
        fornecedor.setPj(pj);
        PessoaJuridica result = fornecedor.getPj();
        assertEquals(pj, result);
    }  

}
