/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOclasses;

import Classes.PessoaFisica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author lucasfranco
 */

public class PessoaFisicaDAO {
    
    private Connection connection;
    
    public PessoaFisicaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
     
    public void adiciona(PessoaFisica pf) {
        PessoaDAO pdao = new PessoaDAO();
        pdao.adiciona(pf.getPessoa());
        
        String sql = "insert into PessoaFisica" + 
                "(CPF, Pessoa_idPessoa, nome, sobrenome, RG, sexo, dataNascimento)" + 
                "values(?,?,?,?,?,?,?)";
      
        try{
           PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, pf.getCPF());
            stmt.setInt(2, pf.getPessoa().getId());
            stmt.setString(3, pf.getNome());
            stmt.setString(4, pf.getSobrenome());
            stmt.setString(5, pf.getRG());
            stmt.setString(6, pf.getSexo());
            stmt.setString(7, pf.getDataNascimento());
            
            stmt.execute();
            stmt.close();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
