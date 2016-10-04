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
    
    public PessoaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Pessoa pessoa) {
                
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
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    
        public List<Pessoa> getLista(){
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
    
    public void remove(String CNPJ){
        String sql = "delete from Pessoa as P where P.idPessoa IN (select idPessoa from (select idPessoa from Pessoa as S, PessoaJuridica as PJ where S.idPessoa = PJ.Pessoa_idPessoa and PJ.CNPJ = ?))";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, CNPJ);
            stmt.execute();
            stmt.close();      
        }
        catch (SQLException e){         
            throw new RuntimeException(e);
            }
    }
    
      public void altera(Pessoa pessoa) {
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
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }        
    }  
   
}
