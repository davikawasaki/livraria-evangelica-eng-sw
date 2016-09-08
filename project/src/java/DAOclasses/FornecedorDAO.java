/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOclasses;

import Classes.Fornecedor;
import Classes.Pessoa;
import Classes.PessoaJuridica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author lucasfranco
 */
public class FornecedorDAO {
    private Connection connection;
    
    public FornecedorDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    //PessoaJuridicaDAO pjdao;
        
    public void adiciona(Fornecedor fornecedor) {  
             
        String sql = "insert into Fornecedor" + 
                "(nomeRepresentante, tipoServico, tipoFornecimento)" + 
                "values(?,?,?)";
        
        //pjdao.adiciona(fornecedor);
        
        try{
           PreparedStatement stmt = connection.prepareStatement(sql);

           stmt.setString(1, fornecedor.getNomeRepresentante());
           stmt.setString(2, fornecedor.getTipoServico());
           stmt.setString(3, fornecedor.getTipoFornecimento());
           
           stmt.execute();
           stmt.close();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}