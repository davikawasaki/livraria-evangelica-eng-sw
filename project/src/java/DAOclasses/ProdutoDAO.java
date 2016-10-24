/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOclasses;

import Classes.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danilo
 */
public class ProdutoDAO {
    private Connection connection;
    
    public ProdutoDAO() throws Exception{
        this.connection = new ConnectionFactory().getConnection("root","danilo");
    }
    
    public void adiciona(Produto produto) throws Exception{
        String sql = "insert into Produto"
                + "(titulo, tipo, preco, idioma, anoLancamento, quantidade)"
                + "values(?,?,?,?,?,?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, produto.getTitulo());
            stmt.setInt(2, produto.getTipo());
            stmt.setFloat(3,produto.getPreco());
            stmt.setString(4, produto.getIdioma());
            stmt.setInt(5, produto.getAnoLancamento());
            stmt.setInt(6, produto.getQuantidade());
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            produto.setIdProduto(rs.getInt(1));
            
            stmt.close();
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public List<Produto> getLista() throws Exception{
        try{
            List<Produto> produtos = new ArrayList<Produto>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from Produto");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Produto produto = new Produto();
                
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setTitulo(rs.getString("titulo"));
                produto.setTipo(rs.getInt("tipo"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setIdioma(rs.getString("idioma"));
                produto.setAnoLancamento(rs.getInt("anoLancamento"));
                produto.setQuantidade(rs.getInt("quantidade"));
                
                produtos.add(produto);
            }
            rs.close();
            stmt.close();
            return produtos;
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void remove(Produto produto){
        String sql = "delete from Produto where Produto.idProduto = ?";
        
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            
            stmt.setInt(1, produto.getIdProduto());
            stmt.execute();
            stmt.close();
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void altera(Produto produto){
        String sql = "update Produto set titulo=?, tipo=?, preco=?,"
                + "idioma=?, anoLancamento=?, quantidade=? where idProduto =?";
            
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            
            stmt.setString(1, produto.getTitulo());
            stmt.setInt(2, produto.getTipo());
            stmt.setFloat(3, produto.getPreco());
            stmt.setString(4, produto.getIdioma());
            stmt.setInt(5, produto.getAnoLancamento());
            stmt.setInt(6, produto.getQuantidade());
            stmt.setInt(7, produto.getIdProduto());
            
            stmt.execute();
            stmt.close();
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
