/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOclasses;

import Classes.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author lucasfranco
 */
public class PessoaDAO {    
    private Connection connection;
    
    public PessoaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Pessoa pessoa) {
        String sql = "insert into Pessoa" + 
                "(id, telefone, email, CEP, logradouro, complemento, numero, bairro, cidade, estado, pais, senha)" + 
                "values(?,?,?,?,?,?,?,?,?,?,?,?)";
    
        try{
           PreparedStatement stmt = connection.prepareStatement(sql);

           stmt.setInt(1,pessoa.getId());
           stmt.setInt(2,pessoa.getTelefone());
           stmt.setString(3, pessoa.getEmail());
           stmt.setString(4, pessoa.getCEP());
           stmt.setString(5, pessoa.getLogradouro());
           stmt.setString(6, pessoa.getComplemento());
           stmt.setInt(7, pessoa.getNumero());
           stmt.setString(8, pessoa.getBairro());
           stmt.setString(9, pessoa.getCidade());
           stmt.setString(10, pessoa.getEstado());
           stmt.setString(11, pessoa.getPais());
           stmt.setString(12, pessoa.getSenha());

           stmt.execute();
           stmt.close();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
