/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Objects;

/**
 *
 * @author lucasfranco
 */
public class PessoaJuridica{
    private Pessoa pessoa;
    private String CNPJ;
    private String nomeFantasia;
    
    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) throws Exception {
        CNPJ = CNPJ.replaceAll("\\D+","");
        if(CNPJ.length() == 14)
            this.CNPJ = CNPJ;
        else
            throw new Exception("CNPJ Invalido");
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) throws Exception {
        if(nomeFantasia.isEmpty())
            throw new Exception("Nome Fantasia Invalido");
        else if(nomeFantasia.length() < 45)
            this.nomeFantasia = nomeFantasia;
        else
            throw new Exception("Nome Fantasia maior que 45 caracteres");     
    }    

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = Objects.requireNonNull(pessoa);
    }
}
