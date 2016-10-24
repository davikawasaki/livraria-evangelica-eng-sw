/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOclasses;

import Classes.Cartao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucasfranco
 */
public class CartaoDAO {
    private final Connection connection;
    
    public CartaoDAO() throws Exception{
            this.connection = new ConnectionFactory().getConnection("root","danilo"); 
    }
    
    public void adiciona(Cartao cartao) {  

        String sql = "insert into Cartao (Pagamento_idPagamento, tipo, numeroParcelas) values(?,?,?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, cartao.getIdPagamento());
            stmt.setString(2, cartao.getTipo());
            stmt.setInt(3, cartao.getNumeroParcelas());
            stmt.execute();
            stmt.close();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
        
    public List<Cartao> getCartoes(){
        try {
            List<Cartao> cartoes = new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from Cartao;");
            ResultSet rs = stmt.executeQuery();
 
            while (rs.next()) {
                // criando o objeto Cartao
                Cartao cartao = new Cartao();

                cartao.setIdPagamento(rs.getInt("Pagamento_idPagamento"));
                cartao.setTipo(rs.getString("tipo"));
                cartao.setNumeroParcelas(rs.getInt("numeroParcelas"));
    
                // adicionando o objeto à lista
                cartoes.add(cartao);
            }
            rs.close();
            stmt.close();
            return cartoes;
        }
        catch (Exception e) {
             throw new RuntimeException(e);
        }
    }
    
    public void remove(int idPagamento){    
        String sql = "delete from Cartao where Cartao.Pagamento_idPagamento = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idPagamento);
            stmt.execute();
            stmt.close();      
        }
        catch (SQLException e){         
            throw new RuntimeException(e);
        }
    }
    
      public void altera(Cartao cartao) {
          String sql = "update Cartao set tipo=?, numeroParcelas=? where Pagamento_idPagamento=?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1,cartao.getTipo());
            stmt.setInt(2, cartao.getNumeroParcelas());
            stmt.setInt(3, cartao.getIdPagamento());
           
            stmt.execute();
            stmt.close();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }        
    }
}
