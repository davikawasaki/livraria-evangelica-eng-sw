/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOclasses;

import Classes.Fornecedor;
import Classes.Pessoa;
import Classes.PessoaJuridica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucasfranco
 */
public class FornecedorDAO {
    private Connection connection;
    
    public FornecedorDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
        
    public void adiciona(Fornecedor fornecedor) {  
    
        PessoaJuridicaDAO pjdao = new PessoaJuridicaDAO();
        
        pjdao.adiciona(fornecedor.getPj());
        
        String sql = "insert into Fornecedor" + 
                "(nomeRepresentante, tipoServico, tipoFornecimento, PessoaJuridica_CNPJ)" + 
                "values(?,?,?,?)";
        
        try{
           PreparedStatement stmt = connection.prepareStatement(sql);

           stmt.setString(1, fornecedor.getNomeRepresentante());
           stmt.setString(2, fornecedor.getTipoServico());
           stmt.setString(3, fornecedor.getTipoFornecimento());
           stmt.setString(4, fornecedor.getPj().getCNPJ());
           
           stmt.execute();
           stmt.close();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public List<Fornecedor> getLista(){
        try {
            List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
            PreparedStatement stmt = this.connection.
            prepareStatement("select * from Pessoa P join PessoaJuridica PJ on P.idPessoa = PJ.Pessoa_IdPessoa join Fornecedor F on PJ.CNPJ = F.PessoaJuridica_CNPJ where idPessoa = 46;");
            ResultSet rs = stmt.executeQuery();
 
        while (rs.next()) {
            // criando o objeto Fornecedor
            Fornecedor fornecedor = new Fornecedor();
            PessoaJuridica pj = new PessoaJuridica();
            fornecedor.setPj(pj);
            Pessoa pessoa = new Pessoa();
            fornecedor.getPj().setPessoa(pessoa);

            fornecedor.setNomeRepresentante(rs.getString("nomeRepresentante"));
            fornecedor.setTipoServico(rs.getString("tipoServico"));
            fornecedor.setTipoFornecimento(rs.getString("tipoFornecimento"));
            fornecedor.getPj().setCNPJ(rs.getString("CNPJ"));
            fornecedor.getPj().setNomeFantasia(rs.getString("nomeFantasia"));
            fornecedor.getPj().getPessoa().setTelefone(rs.getString("telefone"));
            fornecedor.getPj().getPessoa().setEmail(rs.getString("email"));
            fornecedor.getPj().getPessoa().setLogradouro(rs.getString("logradouro"));
            fornecedor.getPj().getPessoa().setNumero(rs.getInt("numero"));
            fornecedor.getPj().getPessoa().setComplemento(rs.getString("complemento"));
            fornecedor.getPj().getPessoa().setBairro(rs.getString("bairro"));
            fornecedor.getPj().getPessoa().setCEP(rs.getString("CEP"));
            fornecedor.getPj().getPessoa().setCidade(rs.getString("cidade"));
            fornecedor.getPj().getPessoa().setEstado(rs.getString("estado"));
            fornecedor.getPj().getPessoa().setPais(rs.getString("pais"));

            // adicionando o objeto à lista
            fornecedores.add(fornecedor);
        }
        rs.close();
        stmt.close();
        return fornecedores;
        }
        catch (SQLException e) {
             throw new RuntimeException(e);
        }
    }
    
    public void altera(Fornecedor fornecedor) {
            
        PessoaJuridicaDAO pjdao = new PessoaJuridicaDAO();
        
        PessoaJuridica pj = new PessoaJuridica();
        fornecedor.setPj(pj);
       
        pjdao.altera(fornecedor.getPj());
        String sql = "update Fornecedor set nome=?, email=?," +
             "endereco=?, dataNascimento=? where id=?";
        
         
        try{
           PreparedStatement stmt = connection.prepareStatement(sql);

           stmt.setString(1, fornecedor.getNomeRepresentante());
           stmt.setString(2, fornecedor.getTipoServico());
           stmt.setString(3, fornecedor.getTipoFornecimento());
           stmt.setString(4, fornecedor.getPj().getCNPJ());
           
           stmt.execute();
           stmt.close();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }        
    }    
}