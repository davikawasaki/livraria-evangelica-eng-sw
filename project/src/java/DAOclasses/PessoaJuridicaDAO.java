/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOclasses;

import Classes.PessoaJuridica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author lucasfranco
 */
public class PessoaJuridicaDAO {
    private Connection connection;
    
    public PessoaJuridicaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    PessoaDAO pdao = new PessoaDAO();
    
    public void adiciona(PessoaJuridica pj) {
        String sql = "insert into PessoaJuridica" + 
                "(CNPJ, nomeFantasia, Pessoa_idPessoa)" + "values(?,?,?)";
    
        pdao.adiciona(pj);
        
        try{
           PreparedStatement stmt = connection.prepareStatement(sql);

           stmt.setString(1, pj.getCNPJ());
           stmt.setString(2, pj.getNomeFantasia());
           stmt.setInt(3, pj.getId());
          
           stmt.execute();
           stmt.close();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
