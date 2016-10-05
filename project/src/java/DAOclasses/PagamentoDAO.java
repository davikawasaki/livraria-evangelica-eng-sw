/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOclasses;

import Classes.CaixaDia;
import Classes.Pagamento;
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
public class PagamentoDAO {
    private final Connection connection;
    
    public PagamentoDAO() throws Exception{
            this.connection = new ConnectionFactory().getConnection("root","root"); 
    }
    
    public void adiciona(Pagamento pagamento, CaixaDia caixa) throws Exception {  

        String sql = "insert into Pagamento(tipo, valorTotal, desconto, horario, Caixa_idCaixa) values(?,?,?,?,?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, pagamento.getTipo());
            stmt.setFloat(2, pagamento.getValorTotal());
            stmt.setFloat(3, pagamento.getDesconto());
            stmt.setTimestamp(4, pagamento.getHorario());
            stmt.setInt(5, caixa.getIdCaixa());
            stmt.execute();
        
             
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            pagamento.setIdPagamento(rs.getInt(1));
            
            CaixaDiaDAO cdao = new CaixaDiaDAO();
            cdao.calculaCaixa(caixa);
            stmt.close();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
        
    public List<Pagamento> getPagamentos(){
        try {
            List<Pagamento> pagamentos = new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from Pagamento;");
            ResultSet rs = stmt.executeQuery();
 
            while (rs.next()) {
                // criando o objeto Pagamento
                Pagamento pagamento = new Pagamento();

                pagamento.setIdPagamento(rs.getInt("idPagamento"));
                pagamento.setTipo(rs.getString("tipo"));
                pagamento.setValorTotal(rs.getFloat("valorTotal"));
                pagamento.setDesconto(rs.getFloat("desconto"));
                pagamento.setHorario(rs.getTimestamp("horario"));
             
                // adicionando o objeto à lista
                pagamentos.add(pagamento);
            }
            rs.close();
            stmt.close();
            return pagamentos;
        }
        catch (SQLException e) {
             throw new RuntimeException(e);
        }
    }
    
    public void remove(int id){    
        String sql = "delete from Pagamento where Pagamento.id = ?";
        
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
    
      public void altera(Pagamento pagamento) {
          String sql = "update Pagamento set tipo=?, valorTotal=?," +
            "desconto=?, Horario=? where idPagamento=?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1,pagamento.getTipo());
            stmt.setFloat(2, pagamento.getValorTotal());
            stmt.setFloat(3, pagamento.getDesconto());
            stmt.setTimestamp(4, pagamento.getHorario());
            stmt.setInt(5, pagamento.getIdPagamento());
           
            stmt.execute();
            stmt.close();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }        
    }
}
