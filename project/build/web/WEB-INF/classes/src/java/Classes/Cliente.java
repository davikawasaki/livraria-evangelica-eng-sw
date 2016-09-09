/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

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

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setFidelidade(boolean fidelidade) {
        this.fidelidade = fidelidade;
    }

    public void setCodFidelidade(String codFidelidade) {
        this.codFidelidade = codFidelidade;
    }

    public PessoaFisica getPf() {
        return pf;
    }

    public void setPf(PessoaFisica pf) {
        this.pf = pf;
    }
    
}
