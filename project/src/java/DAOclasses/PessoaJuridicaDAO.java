/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOclasses;

import Classes.PessoaJuridica;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author lucasfranco
 */
public class PessoaJuridicaDAO {
    private Connection connection;
    
    public PessoaJuridicaDAO() throws Exception {
        this.connection = new ConnectionFactory().getConnection("root","danilo");
    }
    
    // Método do DAO para conexão manual com o banco
    public void setaConexaoPessoaJuridicaDAO(String user, String password) throws Exception {
        try {
            this.connection = new ConnectionFactory().getConnection(user, password);
        } catch(Exception e) {
            throw new Exception("Erro ao conectar com o banco");
        }
    }
    
    public boolean adiciona(PessoaJuridica pj) throws Exception {
        if((pj.getCNPJ()== null)||(pj.getNomeFantasia()== null))
            throw new Exception("Campo nulo, erro ao enviar a pessoa juridica para o banco");
        PessoaDAO pdao = new PessoaDAO();
        pdao.adiciona(pj.getPessoa());

        String sql = "insert into PessoaJuridica" + 
                "(CNPJ, nomeFantasia, Pessoa_idPessoa)" + "values(?,?,?)";
      
        try{
           PreparedStatement stmt = connection.prepareStatement(sql);

           stmt.setString(1, pj.getCNPJ());
           stmt.setString(2, pj.getNomeFantasia());
           stmt.setInt(3, pj.getPessoa().getId());
          
           stmt.execute();
           stmt.close();
           return true;
        }
        catch (Exception e){
            throw new Exception("Erro ao enviar a pessoa juridica para o banco");
        }
    }
    
    public boolean altera(PessoaJuridica pj) throws Exception {
        if((pj.getCNPJ()== null)||(pj.getNomeFantasia()== null))
            throw new Exception("Campo nulo, erro ao enviar a pessoa juridica para o banco");
        String sql = "update PessoaJuridica PJ inner join Pessoa P on PJ.Pessoa_idPessoa = P.idPessoa set CNPJ=?, NomeFantasia=? where P.idPessoa = ?";
        
        try{
           PreparedStatement stmt = connection.prepareStatement(sql);
           stmt.setString(1, pj.getCNPJ());
           stmt.setString(2, pj.getNomeFantasia());
           stmt.setInt(3, pj.getPessoa().getId());
           stmt.execute();
           stmt.close();
           return true;
        }
        catch (Exception e){
            throw new Exception("Erro ao alterar a pessoa juridica");
        }        
    }  
}
