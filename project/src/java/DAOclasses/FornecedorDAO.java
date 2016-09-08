/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOclasses;

import Classes.Fornecedor;
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
        
    public void adiciona(Fornecedor fornecedor) {  
    
        PessoaJuridicaDAO pjdao = new PessoaJuridicaDAO();
        
        pjdao.adiciona(fornecedor.getPj());
        
        String sql = "insert into Fornecedor" + 
                "(nomeRepresentante, tipoServico, tipoFornecimento, PessoaJuridica_CNPJ)" + 
                "values(?,?,?,?)";
        
        try{
           PreparedStatement stmt = connection.prepareStatement(sql);

           stmt.setString(1, fornecedor.getNomeRepresentante());
           stmt.setString(2, fornecedor.getTipoServico());
           stmt.setString(3, fornecedor.getTipoFornecimento());
           stmt.setString(4, fornecedor.getPj().getCNPJ());
           
           stmt.execute();
           stmt.close();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}