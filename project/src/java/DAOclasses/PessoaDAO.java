package DAOclasses;

import Classes.Pessoa;
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
public class PessoaDAO {    
    private Connection connection;
    
    public PessoaDAO() throws Exception {
        this.connection = new ConnectionFactory().getConnection("root","root");
    }
    
    // Método do DAO para conexão manual com o banco
    public void setaConexaoPessoaDAO(String user, String password) throws Exception {
        try {
            this.connection = new ConnectionFactory().getConnection(user, password);
        } catch(Exception e) {
            throw new Exception("Erro ao conectar com o banco");
        }
    }
    
    public boolean adiciona(Pessoa pessoa) throws Exception {
                
        if((pessoa.getBairro()==null) || (pessoa.getCEP()==null) || (pessoa.getCidade()==null) || (pessoa.getEmail()==null) || (pessoa.getEstado()==null) || (pessoa.getLogradouro()==null) || (pessoa.getPais()==null) || (pessoa.getTelefone()==null))
                throw new Exception("Campo nulo, erro ao enviar a pessoa fisica para o banco");
        
        String sql = "insert into Pessoa" + 
                "(telefone, email, CEP, logradouro, complemento, numero, bairro, cidade, estado, pais)" + 
                "values(?,?,?,?,?,?,?,?,?,?)";
    
        try{
           PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

           stmt.setString(1, pessoa.getTelefone());
           stmt.setString(2, pessoa.getEmail());
           stmt.setString(3, pessoa.getCEP());
           stmt.setString(4, pessoa.getLogradouro());
           stmt.setString(5, pessoa.getComplemento());
           stmt.setInt(6, pessoa.getNumero());
           stmt.setString(7, pessoa.getBairro());
           stmt.setString(8, pessoa.getCidade());
           stmt.setString(9, pessoa.getEstado());
           stmt.setString(10, pessoa.getPais());       
           stmt.executeUpdate();
           
           ResultSet rs = stmt.getGeneratedKeys();
           rs.next();
           pessoa.setId(rs.getInt(1));
           
           stmt.close();
           return true;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public List<Pessoa> getLista() throws Exception{
        try {
            List<Pessoa> pessoas = new ArrayList<Pessoa>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from Pessoa;");
            ResultSet rs = stmt.executeQuery();
 
        while (rs.next()) {
            // criando o objeto Pessoa
            Pessoa pessoa = new Pessoa();
            
            pessoa.setId(rs.getInt("idPessoa"));
            pessoa.setTelefone(rs.getString("telefone"));
            pessoa.setEmail(rs.getString("email"));
            pessoa.setLogradouro(rs.getString("logradouro"));
            pessoa.setNumero(rs.getInt("numero"));
            pessoa.setComplemento(rs.getString("complemento"));
            pessoa.setBairro(rs.getString("bairro"));
            pessoa.setCEP(rs.getString("CEP"));
            pessoa.setCidade(rs.getString("cidade"));
            pessoa.setEstado(rs.getString("estado"));
            pessoa.setPais(rs.getString("pais"));

            // adicionando o objeto à lista
            pessoas.add(pessoa);
        }
        rs.close();
        stmt.close();
        return pessoas;
        }
        catch (SQLException e) {
             throw new RuntimeException(e);
        }
    }
    
    public boolean remove(int idPessoa){
        //String sql = "delete from Pessoa as P where P.idPessoa IN (select idPessoa from (select idPessoa from Pessoa as S, PessoaJuridica as PJ where S.idPessoa = PJ.Pessoa_idPessoa and PJ.CNPJ = ?))";
        String sql = "delete from Pessoa where id=?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idPessoa);
            stmt.execute();
            stmt.close();
            return true;
        }
        catch (SQLException e){         
            throw new RuntimeException(e);
        }
    }
    
      public boolean altera(Pessoa pessoa) throws Exception {
          if((pessoa.getBairro()==null) || (pessoa.getCEP()==null) || (pessoa.getCidade()==null) || (pessoa.getComplemento()==null) || (pessoa.getEmail()==null) || (pessoa.getEstado()==null) || (pessoa.getLogradouro()==null) || (pessoa.getPais()==null) || (pessoa.getSenha()==null) || (pessoa.getTelefone()==null))
                throw new Exception("Campo nulo, erro ao enviar a pessoa para o banco");
          
          String sql = "update Pessoa set telefone=?, email=?," +
            "CEP=?, Logradouro=?, Complemento=?, Numero=?, Bairro=?," +
            "Cidade=?, Estado=?, Pais=? where idPessoa=?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1,pessoa.getTelefone());
            stmt.setString(2, pessoa.getEmail());
            stmt.setString(3, pessoa.getCEP());
            stmt.setString(4, pessoa.getLogradouro());
            stmt.setString(5, pessoa.getComplemento());
            stmt.setInt(6, pessoa.getNumero());
            stmt.setString(7, pessoa.getBairro());
            stmt.setString(8, pessoa.getCidade());
            stmt.setString(9, pessoa.getEstado());
            stmt.setString(10, pessoa.getPais());
            stmt.setInt(11, pessoa.getId());
           
            stmt.execute();
            stmt.close();
            return true;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }        
    }  
   
}
