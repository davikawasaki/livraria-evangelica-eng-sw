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
public class Cliente extends PessoaFisica{
    private int idCliente;
    private boolean fidelidade;
    private int codFidelidade;

    public int getIdCliente() {
        return idCliente;
    }

    public boolean isFidelidade() {
        return fidelidade;
    }

    public int getCodFidelidade() {
        return codFidelidade;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setFidelidade(boolean fidelidade) {
        this.fidelidade = fidelidade;
    }

    public void setCodFidelidade(int codFidelidade) {
        this.codFidelidade = codFidelidade;
    }
}
