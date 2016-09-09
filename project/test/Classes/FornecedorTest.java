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
    public void ContatoInsereNomeRepresentante() {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNomeRepresentante("Daniel Souza");
        String valorRecebido = fornecedor.getNomeRepresentante();
        assertEquals(valorRecebido, "Daniel Souza");
    }  
    @Test
    public void ContatoInsereTipoServico() {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setTipoServico("Consignado");
        String valorRecebido = fornecedor.getTipoServico();
        assertEquals(valorRecebido, "Consignado");
    }  
    @Test
    public void ContatoInsereTipoFornecimento() {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setTipoFornecimento("Papelaria");
        String valorRecebido = fornecedor.getTipoFornecimento();
        assertEquals(valorRecebido, "Papelaria");
    }  
    @Test
    public void ContatoInsereFornecedor() {
         // Verificar se classe foi instanciada
    }  
    @Test
    public void ContatoAlteraDadosFornecedor() {
        // Testa se os dados foram alterados com sucesso
    }
    @Test
    public void ContatoRemoveDadosFornecedor() {
        // Testa se os dados foram removidos com sucesso
    }
    @Test
    public void ContatoConsultaDadosFornecedor() {
        // Testa se os dados foram consultados com sucesso
    }
}
