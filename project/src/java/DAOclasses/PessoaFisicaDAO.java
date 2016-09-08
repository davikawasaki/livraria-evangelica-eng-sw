/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOclasses;

import java.sql.Connection;

/**
 * @author lucasfranco
 */

public class PessoaFisicaDAO {
    
    private Connection connection;
    
    public PessoaFisicaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
  /*  public void adiciona(PessoaFisica pessoafisica) {
        String sql = "insert into pessoafisica " + 
                "(CPF, nome, sobrenome, RG, sexo, dataNascimento, idPessoa, loginPF)" + 
                "values(?,?,?,?,?,?,?,?)";
    }
   */
}
