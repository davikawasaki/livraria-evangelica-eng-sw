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

    public void setNomeRepresentante(String nomeRepresentante) {
        this.nomeRepresentante = nomeRepresentante;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String getTipoFornecimento() {
        return tipoFornecimento;
    }

    public void setTipoFornecimento(String tipoFornecimento) {
        this.tipoFornecimento = tipoFornecimento;
    }

    public PessoaJuridica getPj() {
        return pj;
    }

    public void setPj(PessoaJuridica pj) {
        this.pj = pj;
    }
    
}
