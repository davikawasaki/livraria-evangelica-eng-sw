/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Objects;

/**
 *
 * @author Nicholas
 */
public class Cliente{
    private PessoaFisica pf;
    private int idCliente;
    private boolean fidelidade;
    private String codFidelidade;

    public int getIdCliente() {
        return idCliente;
    }

    public boolean isFidelidade() {
        return fidelidade;
    }

    public String getCodFidelidade() {
        return codFidelidade;
    }

    public void setIdCliente(int idCliente) throws Exception {
        if(idCliente >= 0)
            this.idCliente = idCliente;
        else
            throw new Exception("ID Invalido");
    }

    public void setFidelidade(boolean fidelidade) {
        this.fidelidade = fidelidade;
    }

    public void setCodFidelidade(String codFidelidade) throws Exception {
        if((codFidelidade.isEmpty()) || ((codFidelidade.length() >= 3) && (codFidelidade.length() < 45)))
            this.codFidelidade = codFidelidade;
        else if(codFidelidade.length() < 3)
            throw new Exception("Codigo de Fidelidade menor que 3 caracteres");
        else
            throw new Exception("Codigo de Fidelidade maior que 45 caracteres");
    }

    public PessoaFisica getPf() {
        return pf;
    }

    public void setPf(PessoaFisica pf) {
        this.pf = Objects.requireNonNull(pf);
    }
    
}
