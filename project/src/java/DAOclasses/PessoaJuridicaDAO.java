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
    
    public PessoaJuridicaDAO() throws Exception {
        this.connection = new ConnectionFactory().getConnection("root","danilo");
    }
    
    public void adiciona(PessoaJuridica pj) throws Exception {    
        PessoaDAO pdao = new PessoaDAO();
        pdao.adiciona(pj.getPessoa());

        String sql = "insert into PessoaJuridica" + 
                "(CNPJ, nomeFantasia, Pessoa_idPessoa)" + "values(?,?,?)";
      
        try{
           PreparedStatement stmt = connection.prepareStatement(sql);

           stmt.setString(1, pj.getCNPJ());
           stmt.setString(2, pj.getNomeFantasia());
           stmt.setInt(3, pj.getPessoa().getId());
          
           stmt.execute();
           stmt.close();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void altera(PessoaJuridica pj) {
        String sql = "update PessoaJuridica PJ inner join Pessoa P on PJ.Pessoa_idPessoa = P.idPessoa set CNPJ=?, NomeFantasia=? where P.idPessoa = ?";
        
        try{
           PreparedStatement stmt = connection.prepareStatement(sql);
           stmt.setString(1, pj.getCNPJ());
           stmt.setString(2, pj.getNomeFantasia());
           stmt.setInt(3, pj.getPessoa().getId());
           stmt.execute();
           stmt.close();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }        
    }  
}
