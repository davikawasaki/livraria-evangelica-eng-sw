package DAOclasses;

import Classes.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
        
           stmt.execute();
           stmt.close();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
