/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author lucasfranco
 */
public class Fornecedor{
    private PessoaJuridica pj;
    private String nomeRepresentante;
    private String tipoServico;
    private String tipoFornecimento;

    public String getNomeRepresentante() {
        return nomeRepresentante;
    }

    public void setNomeRepresentante(String nomeRepresentante) throws Exception {
        if(nomeRepresentante.isEmpty())
            throw new Exception("Nome Representante Invalido");
        else if(nomeRepresentante.length() < 45)
            this.nomeRepresentante = nomeRepresentante;
        else
            throw new Exception("Nome Representante maior que 45 caracteres");  
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) throws Exception {
        if(tipoServico.isEmpty())
            throw new Exception("Tipo de Serviço Invalido");
        else if(tipoServico.length() < 45)
            this.tipoServico = tipoServico;
        else
            throw new Exception("Tipo de Serviço maior que 45 caracteres"); 
    }

    public String getTipoFornecimento() {
        return tipoFornecimento;
    }

    public void setTipoFornecimento(String tipoFornecimento) throws Exception {
        if(tipoFornecimento.isEmpty())
            throw new Exception("Tipo de Fornecimento Invalido");
        else if(tipoFornecimento.length() < 45)
            this.tipoFornecimento = tipoFornecimento;
        else
            throw new Exception("Tipo de Fornecimento maior que 45 caracteres"); 
    }

    public PessoaJuridica getPj() {
        return pj;
    }

    public void setPj(PessoaJuridica pj) {
        this.pj = pj;
    }
    
}
