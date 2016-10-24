/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes_Main;

import Classes.Pessoa;
import DAOclasses.PessoaDAO;

/**
 *
 * @author lucasfranco
 */
public class Testa_Insere {
    public static void main(String[] args) throws Exception {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1);
        pessoa.setTelefone("123456789");
        pessoa.setEmail("pessoa@caelum.com.br");
        pessoa.setCEP("1190000");
        pessoa.setLogradouro("R. Vergueiro 3185 cj57");
        pessoa.setComplemento("");
        pessoa.setNumero(75);
        pessoa.setBairro("Vila Nova");
        pessoa.setCidade("Registro");
        pessoa.setEstado("Acre");
        pessoa.setPais("Brasil");
        
        PessoaDAO dao = new PessoaDAO();
        
        dao.adiciona(pessoa);

        System.out.println("Gravado!");
    }
}
