/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOclasses;

import Classes.*;
import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucasfranco
 */
public class CaixaDiaDAO {
    private final Connection connection;
    
    public CaixaDiaDAO(){
            this.connection = new ConnectionFactory().getConnection(); 
    }
    
    public void adiciona(CaixaDia caixa) {  

        String sql = "insert into CaixaDia(saldoInicial, entradaBruto, entradaReal, saldoLiquido, saldoReal, saidaTotal, data) values(?,?,?,?,?,?,?)";
        
        try{
           PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setFloat(1, caixa.getSaldoInicial());
            stmt.setFloat(2, caixa.getEntradaBruto());
            stmt.setFloat(3, caixa.getEntradaReal());
            stmt.setFloat(4, caixa.getSaldoLiquido());
            stmt.setFloat(5, caixa.getSaldoReal());
            stmt.setFloat(6, caixa.getSaidaTotal());
            
            java.sql.Date dataSql = new java.sql.Date(caixa.getData().getTime());        
            stmt.setDate(7, dataSql);
 
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            caixa.setIdCaixa(rs.getInt(1)); 
            stmt.close();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        } 
        catch (Exception ex) {
            Logger.getLogger(CaixaDiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<CaixaDia> getCaixasDiarios() throws Exception{
        try {
            List<CaixaDia> caixas = new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from Caixa;");
            ResultSet rs = stmt.executeQuery();
 
            while (rs.next()) {
                // criando o objeto Caixa
                CaixaDia caixa = new CaixaDia();

                caixa.setIdCaixa(rs.getInt("idCaixa"));
                caixa.setSaldoInicial(rs.getFloat("saldoInicial"));
                caixa.setEntradaBruto(rs.getFloat("entradaBruto"));
                caixa.setEntradaReal(rs.getFloat("entradaReal"));
                caixa.setSaldoLiquido(rs.getFloat("saldoLiquido"));
                caixa.setSaldoReal(rs.getFloat("saldoReal"));
                caixa.setSaidaTotal(rs.getFloat("saidaTotal"));

                // adicionando o objeto à lista
                caixas.add(caixa);
            }
            rs.close();
            stmt.close();
            return caixas;
        }
        catch (SQLException e) {
             throw new RuntimeException(e);
        }
    }
    
    public CaixaDia buscaCaixa(Date data) throws Exception{
            
        PreparedStatement stmt = this.connection.prepareStatement("select * from Caixa where horario=?;");
        ResultSet rs = stmt.executeQuery();
        try{
            // criando o objeto Caixa
            CaixaDia caixa = new CaixaDia();
            
            stmt.setDate(1, data);
            stmt.executeUpdate();
            
            if(rs.next()){
                caixa.setIdCaixa(rs.getInt("idCaixa"));
                caixa.setSaldoInicial(rs.getFloat("saldoInicial"));
                caixa.setEntradaBruto(rs.getFloat("entradaBruto"));
                caixa.setEntradaReal(rs.getFloat("entradaReal"));
                caixa.setSaldoLiquido(rs.getFloat("saldoLiquido"));
                caixa.setSaldoReal(rs.getFloat("saldoReal"));
                caixa.setSaidaTotal(rs.getFloat("saidaTotal"));
            }
            
            rs.close();
            stmt.close();
            return caixa;
        }
        catch (SQLException e) {
             throw new RuntimeException(e);
        }    
    }
    
    public void remove(int id){    
        String sql = "delete from CaixaDia where CaixaDia.id = ?";
        
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
    
      public void altera(CaixaDia caixa) {
          String sql = "update CaixaDia set saldoInicial=?, entradaBruto=?," +
            "entradaReal=?, SaldoLiquido=?, SaldoReal=?, SaidaTotal=? where idCaixa=?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setFloat(1,caixa.getSaldoInicial());
            stmt.setFloat(2, caixa.getEntradaBruto());
            stmt.setFloat(3, caixa.getEntradaReal());
            stmt.setFloat(4, caixa.getSaldoLiquido());
            stmt.setFloat(5, caixa.getSaldoReal());
            stmt.setFloat(6, caixa.getSaidaTotal());
            stmt.setInt(7, caixa.getIdCaixa());          
            stmt.execute();
            stmt.close();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }        
    }
}
