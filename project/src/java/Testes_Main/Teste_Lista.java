/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes_Main;

import Classes.Fornecedor;
import DAOclasses.FornecedorDAO;
import java.util.List;

/**
 *
 * @author lucasfranco
 */
public class Teste_Lista {
    public static void main(String[] args) throws Exception {
        FornecedorDAO dao = new FornecedorDAO();
        
        List<Fornecedor> fornecedores = dao.getLista();
        
        for (Fornecedor fornecedor : fornecedores) {
            System.out.println("NomeRepresenta: " + fornecedor.getNomeRepresentante());
            System.out.println("Servico: " + fornecedor.getTipoServico());
            System.out.println("Fornecimentoo: " + fornecedor.getTipoFornecimento());
            System.out.println("CNPJ: " + fornecedor.getPj().getCNPJ());
            System.out.println("NomeFantasia: " + fornecedor.getPj().getNomeFantasia());
            System.out.println("Telefone: " + fornecedor.getPj().getPessoa().getTelefone());
            System.out.println("Email: " + fornecedor.getPj().getPessoa().getEmail());
            System.out.println("LOGRADoURO: " + fornecedor.getPj().getPessoa().getLogradouro());
            System.out.println("NUMERO: " + fornecedor.getPj().getPessoa().getNumero());
            System.out.println("COMPPLEMENTO: " + fornecedor.getPj().getPessoa().getComplemento());
            System.out.println("BAIRRO: " + fornecedor.getPj().getPessoa().getBairro());
            System.out.println("CEP: " + fornecedor.getPj().getPessoa().getCEP());
            System.out.println("Cidade: " + fornecedor.getPj().getPessoa().getCidade());
            System.out.println("Estado: " + fornecedor.getPj().getPessoa().getEstado());
            System.out.println("Pais: " + fornecedor.getPj().getPessoa().getPais());
          
            System.out.println("AAAA");
        }        
    }
}
