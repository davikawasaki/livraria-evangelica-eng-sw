package br.com.exemplo.servlet.jdbc;

import br.com.exemplo.servlet.jdbc.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by davikawasaki on 24/08/16.
 */
public class ContatoDao {
    // Variável de conexão com o banco de dados
    private Connection connection;
    public ContatoDao() {
        // Instância da factory de conexão, obtendo a conexão pelo método em questão
        this.connection = new ConnectionFactory().getConnection();
    }
    public void adiciona(Contato contato) {
        String sql = "insert into pessoa " +
                "(nome,email,endereco,dataNascimento)" +
                " values(?,?,?,?)";
        try {
            // Biblioteca Prepared statement atribuída para inserção SQL
            PreparedStatement stmt = connection.prepareStatement(sql);
            // Seta os valores
            stmt.setString(1,contato.getNome());
            stmt.setString(2,contato.getEmail());
            stmt.setString(3,contato.getEndereco());
            stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
            // Executa a query
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void altera(Contato contato) {
        String sql = "update pessoa set nome=?, email=?, endereco=?," +
                "dataNascimento=? where id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
            stmt.setLong(5, contato.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(Contato contato) {
        try {
            String sql = "delete from pessoa where id=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, contato.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Contato> getLista() {
        try {
            List<Contato> contatos = new ArrayList<Contato>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from pessoa");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                // Criando o objeto contato recebido na lista
                Contato contato = new Contato();
                contato.setId(rs.getLong("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));
                // Montando a data através da biblioteca Calendar
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("dataNascimento"));
                contato.setDataNascimento(data);
                // Adicionando o objeto à lista
                contatos.add(contato);
            }
            rs.close();
            stmt.close();
            return contatos;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
