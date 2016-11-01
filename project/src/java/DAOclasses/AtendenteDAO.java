/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOclasses;

import Classes.Atendente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

/**
 *
 * @author lucasfranco
 */
public class AtendenteDAO {
    private Connection connection;
    
    public AtendenteDAO() throws Exception {
        this.connection = new ConnectionFactory().getConnection("root","root");
    }
    
    // Método do DAO para conexão manual com o banco
    public void setaConexaoAtendenteDAO(String user, String password) throws Exception {
        try {
            this.connection = new ConnectionFactory().getConnection(user, password);
        } catch(Exception e) {
            throw new Exception("Erro ao conectar com o banco");
        }
    }
        
    public boolean adiciona(Atendente atendente) throws Exception {  
    
        PessoaFisicaDAO pfdao = new PessoaFisicaDAO();
        
        pfdao.adiciona(atendente.getPf());
        
        String sql = "insert into Atendente" + 
                "(login, comecoExpediente, fimExpediente, senha, PessoaFisica_CPF)" + 
                "values(?,?,?,?,?)";
        
        try{
           PreparedStatement stmt = connection.prepareStatement(sql);

           stmt.setString(1, atendente.getLogin());
           stmt.setTime(2, (Time) atendente.getComecoExpediente());
           stmt.setTime(3, (Time) atendente.getFimExpediente());
           stmt.setString(4, atendente.getSenha());
           stmt.setString(5, atendente.getPf().getCPF());
           
           stmt.execute();
           stmt.close();
           return true;
        }
        catch (Exception e){
            throw new Exception("Erro ao enviar o atendente para o banco");
        }
    }
}
