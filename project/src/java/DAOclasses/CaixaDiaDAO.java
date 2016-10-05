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
            PreparedStatement stmt = this.connection.prepareStatement("select * from CaixaDia;");
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
                caixa.setData(rs.getDate("data"));

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
            
        PreparedStatement stmt = this.connection.prepareStatement("select * from CaixaDia where data=?;");
        stmt.setDate(1, data);

        ResultSet rs = stmt.executeQuery();
        try{
            // criando o objeto Caixa
            CaixaDia caixa = null;
            if(rs.next()){
                caixa = new CaixaDia();

                caixa.setIdCaixa(rs.getInt("idCaixa"));
                caixa.setSaldoInicial(rs.getFloat("saldoInicial"));
                caixa.setEntradaBruto(rs.getFloat("entradaBruto"));
                caixa.setEntradaReal(rs.getFloat("entradaReal"));
                caixa.setSaldoLiquido(rs.getFloat("saldoLiquido"));
                caixa.setSaldoReal(rs.getFloat("saldoReal"));
                caixa.setSaidaTotal(rs.getFloat("saidaTotal"));
                caixa.setData(rs.getDate("data"));
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
          
    public float calculaSaldoInicial(){
        float saldoInicial = 0.0f;
        
        String sql = "Select saldoReal From CaixaDia Where data = SUBDATE(CURRENT_DATE(), INTERVAL 1 DAY);";
                
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()) {
                saldoInicial = rs.getFloat("saldoReal");
            }
            stmt.close();
                   
            return saldoInicial;
        }
        catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }
    public float calculaEntradaBruto(CaixaDia caixa){
        float entradaBruto = 0.0f;
        
        //String sql = "select sum(valorTotal) from Pagamento where horario = '2016-10-04'";
        String sql = "select sum(valorTotal) from Pagamento P join CaixaDia C on C.idCaixa=P.Caixa_idCaixa where C.data = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            java.sql.Date data = (java.sql.Date) caixa.getData();
            System.out.println("DATA: "+data);
            stmt.setDate(1,data);
            ResultSet rs = stmt.executeQuery();
            System.out.println("DATA2: ");

            if(rs.next())
                entradaBruto = rs.getFloat("sum(valorTotal)");
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        return entradaBruto;
    }
    
    //Calcula a soma dos pagamentos em dinheiros menos os pagamentos por cartão
    public float calculaEntradaReal(CaixaDia caixa){
        float entradaReal = 0.0f;
        
        //String sql = "select ((select sum(valorTotal) from Pagamento P where tipo=\"dinheiro\") - (select sum(valorTotal) from Pagamento where tipo=\"cartao\"));";
        String sql = "select sum(valorTotal) from Pagamento P join CaixaDia C on C.idCaixa = P.Caixa_idCaixa where C.data=? and (tipo='dinheiro' or tipo='cheque')";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDate(1,new Date(caixa.getData().getTime()));
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next())
                entradaReal = rs.getFloat("sum(valorTotal)");
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        
        return entradaReal;
    }
    
    public float calculaSaldoLiquido(CaixaDia caixa){
        float saldoLiquido = 0.0f;
        
        String sql = "select ((select sum(valorTotal) from Pagamento P join CaixaDia C on C.idCaixa=P.Caixa_idCaixa where C.data=? and (tipo=\"dinheiro\" or tipo=\"cheque\")) - (select sum(valor) from Saida S join CaixaDia C on C.idCaixa=S.Caixa_idCaixa where C.data=?)) as SaldoLiquido";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDate(1,new Date(caixa.getData().getTime()));
            stmt.setDate(2,new Date(caixa.getData().getTime()));
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next())
                saldoLiquido = rs.getFloat("SaldoLiquido");
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        
        return saldoLiquido;
    }
    
    public float calculaSaldoReal(CaixaDia caixa){
        float saldoReal = 0.0f;
        
        String sql = "select ((select sum(valorTotal) from Pagamento P join CaixaDia C on C.idCaixa=P.Caixa_idCaixa where C.data=? and (tipo=\"dinheiro\" or tipo=\"cheque\")) - (select sum(valor) from Saida S join CaixaDia C on C.idCaixa=S.Caixa_idCaixa where C.data=?)) as SaldoReal";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDate(1,new Date(caixa.getData().getTime()));
            stmt.setDate(2,new Date(caixa.getData().getTime()));
           
            ResultSet rs = stmt.executeQuery();
           
            if(rs.next())
                saldoReal = rs.getFloat("SaldoReal");
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        
        return saldoReal;
    }

    public float calculaSaidaTotal(CaixaDia caixa){
        float saidaTotal = 0.0f;
        
        String sql = "select sum(valor) as SaidaTotal from Saida S join CaixaDia C on C.idCaixa=S.Caixa_idCaixa where C.data=?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDate(1,new Date(caixa.getData().getTime()));    
           
            ResultSet rs = stmt.executeQuery();
           
            if(rs.next())
                saidaTotal = rs.getFloat("SaidaTotal");
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        
        return saidaTotal;
    }
    
    public void calculaCaixa(CaixaDia caixa) throws Exception{
    
        caixa.setIdCaixa(caixa.getIdCaixa());
        caixa.setSaldoInicial(calculaSaldoInicial());
        caixa.setEntradaBruto(calculaEntradaBruto(caixa));
        caixa.setEntradaReal(calculaEntradaReal(caixa));
        caixa.setSaldoLiquido(calculaSaldoLiquido(caixa));
        caixa.setSaldoReal(calculaSaldoReal(caixa));
        caixa.setSaidaTotal(calculaSaidaTotal(caixa));
        altera(caixa);       
    }
      
}
