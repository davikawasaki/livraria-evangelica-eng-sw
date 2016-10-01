/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes_Main;

import Classes.Cliente;
import Classes.Fornecedor;
import DAOclasses.ClienteDAO;
import DAOclasses.FornecedorDAO;
import java.util.List;

/**
 *
 * @author lucasfranco
 */
public class Teste_Lista {
    public static void main(String[] args) {
        FornecedorDAO dao = new FornecedorDAO();
        
        
        List<Fornecedor> fornecedores = dao.getLista(); //Captura todos os fornecedores cadastrados
       
        for (Fornecedor fornecedor : fornecedores) {     //Lista todos os fornecedores cadastrados 
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
        }

        //Lista um cliente especifico, passado pelo id
        ClienteDAO cdao = new ClienteDAO();
        
        Cliente cliente = cdao.busca(1);
        //Exibe o cliente retornado
            System.out.println("\n\n");
            System.out.println("Id Cliente: " + cliente.getIdCliente());
            System.out.println("Fidelidade: " + cliente.isFidelidade());
            System.out.println("CodFidelidade: " + cliente.getCodFidelidade());
            System.out.println("CPF: " + cliente.getPf().getCPF());
            System.out.println("Nome: " + cliente.getPf().getNome());
            System.out.println("Sobrenome: " + cliente.getPf().getSobrenome());
            System.out.println("RG: " + cliente.getPf().getRG());
            System.out.println("Sexo: " + cliente.getPf().getSexo());
            System.out.println("Data Nascimento: " + cliente.getPf().getDataNascimento());
            System.out.println("Telefone: " + cliente.getPf().getPessoa().getTelefone());
            System.out.println("Email: " + cliente.getPf().getPessoa().getEmail());
            System.out.println("Logradouro: " + cliente.getPf().getPessoa().getLogradouro());
            System.out.println("Numero: " + cliente.getPf().getPessoa().getNumero());
            System.out.println("Complemento: " + cliente.getPf().getPessoa().getComplemento());
            System.out.println("Bairro: " + cliente.getPf().getPessoa().getBairro());
            System.out.println("CEP: " + cliente.getPf().getPessoa().getCEP());
            System.out.println("Cidade: " + cliente.getPf().getPessoa().getCidade());
            System.out.println("Estado: " + cliente.getPf().getPessoa().getEstado());
            System.out.println("Pais: " + cliente.getPf().getPessoa().getPais());
              
    }
}
