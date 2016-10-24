/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOclasses;

import Classes.Saida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucasfranco
 */
public class SaidaDAO {
    private final Connection connection;
    
    public SaidaDAO() throws Exception{
            this.connection = new ConnectionFactory().getConnection("root","danilo"); 
    }
    
    public void adiciona(Saida saida) {  

        String sql = "insert into Saida (tipo, valor) values(?,?)";
        
        try{
           PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, saida.getTipo());
            stmt.setFloat(2, saida.getValor());
            stmt.executeUpdate();
           
           ResultSet rs = stmt.getGeneratedKeys();
           rs.next();
           saida.setIdSaida(rs.getInt(1)); 
           stmt.close();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
        
    public List<Saida> getSaidas(){
        try {
            List<Saida> saidas = new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from Saida;");
            ResultSet rs = stmt.executeQuery();
 
            while (rs.next()) {
                // criando o objeto Saida
                Saida saida = new Saida();

                saida.setIdSaida(rs.getInt("idSaida"));
                saida.setTipo(rs.getString("tipo"));
                saida.setValor(rs.getFloat("valor"));
    
                // adicionando o objeto à lista
                saidas.add(saida);
            }
            rs.close();
            stmt.close();
            return saidas;
        }
        catch (SQLException e) {
             throw new RuntimeException(e);
        }
    }
    
    public void remove(int id){    
        String sql = "delete from Saida where Saida.id = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();      
        }
        catch (SQLException e){         
            throw new RuntimeException(e);
        }
    }
    
      public void altera(Saida saida) {
          String sql = "update Saida set tipo=?, valor=? where idSaida=?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1,saida.getTipo());
            stmt.setFloat(2, saida.getValor());
            stmt.setInt(3, saida.getIdSaida());
           
            stmt.execute();
            stmt.close();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }        
    }
}
