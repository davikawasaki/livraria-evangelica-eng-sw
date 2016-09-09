/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOclasses;

import Classes.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author lucasfranco
 */
public class ClienteDAO {
    private Connection connection;
    
    public ClienteDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
        
    public void adiciona(Cliente cliente) {  
    
        PessoaFisicaDAO pfdao = new PessoaFisicaDAO();
        
        pfdao.adiciona(cliente.getPf());
        
        String sql = "insert into Cliente" + 
                "(idCliente, fidelidade, codFidelidade, PessoaFisica_CPF)" + 
                "values(?,?,?,?)";
        
        try{
           PreparedStatement stmt = connection.prepareStatement(sql);

           stmt.setInt(1, cliente.getIdCliente());
           stmt.setBoolean(2, cliente.isFidelidade());
           stmt.setString(3, cliente.getCodFidelidade());
           stmt.setString(4, cliente.getPf().getCPF());
           
           stmt.execute();
           stmt.close();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
