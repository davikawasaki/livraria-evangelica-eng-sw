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
import java.sql.Date;
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
           stmt.setBoolean(2, cliente.isFidelidade());
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
            cliente.setFidelidade(rs.getBoolean("Fidelidade"));
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
            cliente.getPf().getPessoa().setId(rs.getInt("idPessoa"));

            // adicionando o objeto à lista
            clientes.add(cliente);
        }
        rs.close();
        stmt.close();
        return clientes;
    }
    
    public Cliente getCliente(String id) throws Exception{
        Cliente cliente = new Cliente();
        String sql = "select * from Pessoa P join PessoaFisica PF on P.idPessoa = PF.Pessoa_IdPessoa join Cliente C on PF.CPF = C.PessoaFisica_CPF WHERE C.idCliente = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, id);
        ResultSet rs = stmt.executeQuery();
        try {
           while (rs.next()) {
                PessoaFisica pf = new PessoaFisica();
                cliente.setPf(pf);
                Pessoa pessoa = new Pessoa();
                cliente.setIdCliente(Integer.parseInt(id));
                cliente.setCodFidelidade(rs.getString("codFidelidade"));
                cliente.setFidelidade(rs.getBoolean("fidelidade"));
                cliente.getPf().setPessoa(pessoa);
                cliente.getPf().setNome(rs.getString("nome"));
                cliente.getPf().setSobrenome(rs.getString("sobrenome"));
                cliente.getPf().setCPF(rs.getString("CPF"));
                cliente.getPf().setRG(rs.getString("RG"));
                cliente.getPf().setDataNascimento(rs.getDate("dataNascimento"));
                cliente.getPf().setSexo(rs.getString("sexo"));
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
                cliente.getPf().getPessoa().setId(rs.getInt("idPessoa"));
           }
           stmt.execute();
           stmt.close();
           return cliente;
        }
        catch (Exception e){
            throw new Exception("Erro ao requisitar o cliente do banco");
        }
    }
    
    public boolean altera(Cliente cliente) throws Exception{ 
        if(cliente.getPf().getCPF() == null)
            throw new Exception("Campo nulo, erro ao enviar o cliente para o banco");
        
        PessoaFisicaDAO pfdao = new PessoaFisicaDAO();
        
        pfdao.altera(cliente.getPf());
        String sql = "update Cliente C inner join PessoaFisica PF on C.PessoaFisica_CPF = PF.CPF inner join Pessoa P on PF.Pessoa_idPessoa = P.idPessoa set idCliente=?, fidelidade=?, codFidelidade=?, nome=?, sobrenome=?, CPF=?, RG=?, dataNascimento=?, sexo=?, telefone=?, email=?, logradouro=?, numero=?, complemento=?, bairro=?, CEP=?, cidade=?, estado=?, pais=? where PF.CPF=?";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, cliente.getIdCliente());
            stmt.setBoolean(2, cliente.isFidelidade());
            stmt.setString(3, cliente.getCodFidelidade());
            stmt.setString(4, cliente.getPf().getNome());
            stmt.setString(5, cliente.getPf().getSobrenome());
            stmt.setString(6, cliente.getPf().getCPF());
            stmt.setString(7, cliente.getPf().getRG());
            stmt.setDate(8, new java.sql.Date(cliente.getPf().getDataNascimento().getTime()));
            stmt.setString(9, cliente.getPf().getSexo());
            stmt.setString(10, cliente.getPf().getPessoa().getTelefone());
            stmt.setString(11, cliente.getPf().getPessoa().getEmail());
            stmt.setString(12, cliente.getPf().getPessoa().getLogradouro());
            stmt.setInt(13, cliente.getPf().getPessoa().getNumero());
            stmt.setString(14, cliente.getPf().getPessoa().getComplemento());
            stmt.setString(15, cliente.getPf().getPessoa().getBairro());
            stmt.setString(16, cliente.getPf().getPessoa().getCEP());
            stmt.setString(17, cliente.getPf().getPessoa().getCidade());
            stmt.setString(18, cliente.getPf().getPessoa().getEstado());
            stmt.setString(19, cliente.getPf().getPessoa().getPais());
            stmt.setString(20, cliente.getPf().getCPF());
            stmt.execute();
            stmt.close();
            return true;
            
        } catch (Exception e){
            throw new Exception("Erro ao alterar o cliente");
        }
    }
    
    public Cliente getCliente(String CPF) throws Exception{

        Cliente cliente = new Cliente();
        PreparedStatement stmt = this.connection.
        prepareStatement("select * from Pessoa P join PessoaFisica PF on P.idPessoa = PF.Pessoa_IdPessoa join Cliente C on PF.CPF = C.PessoaFisica_CPF where CPF=?;");
        stmt.setString(1, CPF);
        ResultSet rs = stmt.executeQuery();
 
        while (rs.next()){
            // criando o objeto Cliente
            PessoaFisica pj = new PessoaFisica();
            cliente.setPf(pj);
            Pessoa pessoa = new Pessoa();
            cliente.getPf().setPessoa(pessoa);

            cliente.setIdCliente(rs.getInt("idCliente"));
            cliente.setCodFidelidade(rs.getString("codFidelidade"));
            cliente.setFidelidade(rs.getBoolean("Fidelidade"));
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
            cliente.getPf().getPessoa().setId(rs.getInt("idPessoa"));
        }
        rs.close();
        stmt.close();
        return cliente;
    }
    
}
