/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOclasses;

import Classes.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author danilo
 */
public class LivroDAO {
    private Connection connection;
    
    public LivroDAO() throws Exception{
        this.connection = new ConnectionFactory().getConnection("root","root");
    }
    
    public void adiciona(Livro livro) throws Exception{
        ProdutoDAO pdtdao = new ProdutoDAO();
        pdtdao.adiciona(livro.getPdt());
        
        String sql = "insert into Livro"
                + "(Produto_idProduto, editora, autor)"
                + "values(?,?,?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, livro.getPdt().getIdProduto());
            stmt.setString(2, livro.getEditora());
            stmt.setString(3, livro.getAutor());
            
            stmt.execute();
            stmt.close();
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void altera(Livro livro) throws Exception{
        ProdutoDAO pdtdao = new ProdutoDAO();
        pdtdao.adiciona(livro.getPdt());
        
        String sql = "update Livro L join Produto P set editora=?,"
                + "autor=? where P.idProduto=?";    
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, livro.getEditora());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getPdt().getIdProduto());
            
            stmt.execute();
            stmt.close();
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
}
