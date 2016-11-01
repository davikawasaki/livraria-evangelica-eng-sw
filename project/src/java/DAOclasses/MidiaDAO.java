/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOclasses;

import Classes.Midia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author danilo
 */
public class MidiaDAO {
    private Connection connection;
    
    public MidiaDAO() throws Exception{
        this.connection = new ConnectionFactory().getConnection("root","root");
    }
    
    public void adiciona(Midia midia) throws Exception{
        ProdutoDAO pdtdao = new ProdutoDAO();
        pdtdao.adiciona(midia.getPdt());
        
        String sql = "insert into Midia"
                + "(Produto_idProduto, artista, tipoMIdia)"
                + "values(?,?,?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, midia.getPdt().getIdProduto());
            stmt.setString(2, midia.getArtista());
            stmt.setString(3, midia.getTipoMidia());
            
            stmt.execute();
            stmt.close();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void altera(Midia midia) throws Exception{
        ProdutoDAO pdtdao = new ProdutoDAO();
        pdtdao.altera(midia.getPdt());
        
        String sql = "update Midia M join Produto P set artista=?,"
                + "tipoMidia=? where P.idProduto=?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, midia.getArtista());
            stmt.setString(2, midia.getTipoMidia());
            stmt.setInt(3, midia.getPdt().getIdProduto());
            
            stmt.execute();
            stmt.close();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
