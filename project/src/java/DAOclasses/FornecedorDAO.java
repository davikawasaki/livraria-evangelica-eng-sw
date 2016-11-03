/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOclasses;

import Classes.Fornecedor;
import Classes.Pessoa;
import Classes.PessoaJuridica;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucasfranco
 */
public class FornecedorDAO {
    private Connection connection;

    // Construtor do DAO para conexão instantânea com o banco
    public FornecedorDAO() throws Exception {
        try {
            this.connection = new ConnectionFactory().getConnection("root", "root");
        } catch(Exception e) {
            throw new Exception("Erro ao conectar com o banco");
        }
    }

    // Método do DAO para conexão manual com o banco
    public void setaConexaoFornecedorDAO(String user, String password) throws Exception {
        try {
            this.connection = new ConnectionFactory().getConnection(user, password);
        } catch(Exception e) {
            throw new Exception("Erro ao conectar com o banco");
        }
    }

    public boolean adiciona(Fornecedor fornecedor) throws Exception {
        if((fornecedor.getNomeRepresentante() == null)||(fornecedor.getTipoServico() == null)||(fornecedor.getTipoFornecimento() == null)||(fornecedor.getPj().getCNPJ() == null))
            throw new Exception("Campo nulo, erro ao enviar o fornecedor para o banco");
        PessoaJuridicaDAO pjdao = new PessoaJuridicaDAO();
        pjdao.adiciona(fornecedor.getPj());
        String sql = "insert into Fornecedor" +
                "(nomeRepresentante, tipoServico, tipoFornecimento, PessoaJuridica_CNPJ)" +
                "values(?,?,?,?)";
        try {
           PreparedStatement stmt = connection.prepareStatement(sql);
           stmt.setString(1, fornecedor.getNomeRepresentante());
           stmt.setString(2, fornecedor.getTipoServico());
           stmt.setString(3, fornecedor.getTipoFornecimento());
           stmt.setString(4, fornecedor.getPj().getCNPJ());
           stmt.execute();
           stmt.close();
           return true;
        }
        catch (Exception e){
            throw new Exception("Erro ao enviar o fornecedor para o banco");
        }
    }

    public List<Fornecedor> getLista() throws Exception{
        List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
        PreparedStatement stmt = this.connection.
        prepareStatement("select * from Pessoa P join PessoaJuridica PJ on P.idPessoa = PJ.Pessoa_IdPessoa join Fornecedor F on PJ.CNPJ = F.PessoaJuridica_CNPJ;");
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
            fornecedor.getPj().getPessoa().setId(rs.getInt("idPessoa"));
            // adicionando o objeto à lista
            fornecedores.add(fornecedor);
        }
        rs.close();
        stmt.close();
        return fornecedores;
    }

    public Fornecedor getFornecedor(String CNPJ) throws Exception{
        Fornecedor fornecedor = new Fornecedor();
        String sql = "select * from Pessoa P join PessoaJuridica PJ on P.idPessoa = PJ.Pessoa_IdPessoa join Fornecedor F on PJ.CNPJ = F.PessoaJuridica_CNPJ WHERE F.PessoaJuridica_CNPJ = ?;";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, CNPJ);
        ResultSet rs = stmt.executeQuery();
        try {
           while (rs.next()) {
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
                fornecedor.getPj().getPessoa().setId(rs.getInt("idPessoa"));
           }
           stmt.execute();
           stmt.close();
           return fornecedor;
        }
        catch (Exception e){
            throw new Exception("Erro ao requisitar o fornecedor do banco");
        }
    }

    public boolean altera(Fornecedor fornecedor) throws Exception {
        if((fornecedor.getNomeRepresentante() == null)||(fornecedor.getTipoServico() == null)||(fornecedor.getTipoFornecimento() == null)||(fornecedor.getPj().getCNPJ() == null))
            throw new Exception("Campo nulo, erro ao enviar o fornecedor para o banco");
        PessoaJuridicaDAO pjdao = new PessoaJuridicaDAO();
        pjdao.altera(fornecedor.getPj());
        String sql = "update Pessoa P inner join PessoaJuridica PJ on P.idPessoa = PJ.Pessoa_IdPessoa inner join Fornecedor F on PJ.CNPJ = F.PessoaJuridica_CNPJ set PJ.CNPJ=?, F.nomeRepresentante=?, F.tipoServico=?, F.tipoFornecimento=?, P.telefone=?, P.email=?, P.logradouro=?, P.numero=?, P.complemento=?, P.bairro=?, P.CEP=?, P.cidade=?, P.estado=?, P.pais=? where PJ.CNPJ=?";
        try {
           PreparedStatement stmt = connection.prepareStatement(sql);
           stmt.setString(1, fornecedor.getPj().getCNPJ());
           stmt.setString(2, fornecedor.getNomeRepresentante());
           stmt.setString(3, fornecedor.getTipoServico());
           stmt.setString(4, fornecedor.getTipoFornecimento());
           stmt.setString(5, fornecedor.getPj().getPessoa().getTelefone());
           stmt.setString(6, fornecedor.getPj().getPessoa().getEmail());
           stmt.setString(7, fornecedor.getPj().getPessoa().getLogradouro());
           stmt.setInt(8, fornecedor.getPj().getPessoa().getNumero());
           stmt.setString(9, fornecedor.getPj().getPessoa().getComplemento());
           stmt.setString(10, fornecedor.getPj().getPessoa().getBairro());
           stmt.setString(11, fornecedor.getPj().getPessoa().getCEP());
           stmt.setString(12, fornecedor.getPj().getPessoa().getCidade());
           stmt.setString(13, fornecedor.getPj().getPessoa().getEstado());
           stmt.setString(14, fornecedor.getPj().getPessoa().getPais());
           stmt.setString(15, fornecedor.getPj().getCNPJ());
           stmt.execute();
           stmt.close();
           return true;
        }
        catch (Exception e){
            throw new Exception("Erro ao alterar o fornecedor");
        }
    }
}
