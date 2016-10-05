/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOclasses;

import Classes.Cliente;
import Classes.Pessoa;
import Classes.PessoaFisica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucasfranco
 */
public class ClienteDAO {
    private Connection connection;
    
    public ClienteDAO() throws Exception {
        this.connection = new ConnectionFactory().getConnection("root","root");
    }
    
    // Método do DAO para conexão manual com o banco
    public void setaConexaoClienteDAO(String user, String password) throws Exception {
        try {
            this.connection = new ConnectionFactory().getConnection(user, password);
        } catch(Exception e) {
            throw new Exception("Erro ao conectar com o banco");
        }
    }
        
    public boolean adiciona(Cliente cliente) throws Exception {  
        
        if((cliente.getCodFidelidade() == null)||(cliente.getPf().getCPF() == null))
            throw new Exception("Campo nulo, erro ao enviar o cliente para o banco");
       
        PessoaFisicaDAO pfdao = new PessoaFisicaDAO();
        pfdao.adiciona(cliente.getPf());
        
        String sql = "insert into Cliente" + 
                "(idCliente, fidelidade, codFidelidade, PessoaFisica_CPF)" + 
                "values(?,?,?,?)";
        
        
        try{
           PreparedStatement stmt = connection.prepareStatement(sql);

           stmt.setInt(1, cliente.getIdCliente());
           stmt.setInt(2, cliente.isFidelidade());
           stmt.setString(3, cliente.getCodFidelidade());
           stmt.setString(4, cliente.getPf().getCPF());
           
           stmt.execute();
           stmt.close();
           
           return true;
        }
        catch (Exception e){
            throw new Exception("Erro ao enviar o cliente para o banco");
        }
    }
    
    public List <Cliente> getLista() throws Exception{

        List <Cliente> clientes = new ArrayList<Cliente>();
        PreparedStatement stmt = this.connection.
        prepareStatement("select * from Pessoa P join PessoaFisica PF on P.idPessoa = PF.Pessoa_IdPessoa join Cliente C on PF.CPF = C.PessoaFisica_CPF;");
        ResultSet rs = stmt.executeQuery();
 
        while (rs.next()){
            // criando o objeto Cliente
            Cliente cliente = new Cliente();
            PessoaFisica pj = new PessoaFisica();
            cliente.setPf(pj);
            Pessoa pessoa = new Pessoa();
            cliente.getPf().setPessoa(pessoa);

            cliente.setIdCliente(rs.getInt("idCliente"));
            cliente.setCodFidelidade(rs.getString("codFidelidade"));
            cliente.setFidelidade(rs.getInt("Fidelidade"));
            cliente.getPf().setCPF(rs.getString("CPF"));
            cliente.getPf().setNome(rs.getString("nome"));
            cliente.getPf().setSobrenome(rs.getString("sobrenome"));
            cliente.getPf().setRG(rs.getString("RG"));
            cliente.getPf().setSexo(rs.getString("sexo"));
            cliente.getPf().setDataNascimento(rs.getDate("dataNascimento"));
            cliente.getPf().getPessoa().setTelefone(rs.getString("telefone"));
            cliente.getPf().getPessoa().setEmail(rs.getString("email"));
            cliente.getPf().getPessoa().setLogradouro(rs.getString("logradouro"));
            cliente.getPf().getPessoa().setNumero(rs.getInt("numero"));
            cliente.getPf().getPessoa().setComplemento(rs.getString("complemento"));
            cliente.getPf().getPessoa().setBairro(rs.getString("bairro"));
            cliente.getPf().getPessoa().setCEP(rs.getString("CEP"));
            cliente.getPf().getPessoa().setCidade(rs.getString("cidade"));
            cliente.getPf().getPessoa().setEstado(rs.getString("estado"));
            cliente.getPf().getPessoa().setPais(rs.getString("pais"));

            // adicionando o objeto à lista
            clientes.add(cliente);
        }
        rs.close();
        stmt.close();
        return clientes;
    }
    
    public boolean altera(Cliente cliente) throws Exception{ 
        if((cliente.getCodFidelidade() == null)||(cliente.getPf().getCPF() == null))
            throw new Exception("Campo nulo, erro ao enviar o cliente para o banco");
        
        PessoaFisicaDAO pfdao = new PessoaFisicaDAO();
        
        pfdao.altera(cliente.getPf());
        
        String sql = "update Cliente C join PessoaFisica P on C.PessoaFisica_CPF = P.CPF"
                + "set idCliente=?, fidelidade=?," +
                "codFidelidade=? where P.CPF=?";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, cliente.getIdCliente());
            stmt.setInt(2, cliente.isFidelidade());
            stmt.setString(3, cliente.getCodFidelidade());
            stmt.setString(4, cliente.getPf().getCPF());

            stmt.execute();
            stmt.close();
            return true;
            
        } catch (Exception e){
            throw new Exception("Erro ao alterar o cliente");
        }
    }
    
}
