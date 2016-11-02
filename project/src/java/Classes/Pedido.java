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
public class Pedido {
    private int idPedido;
    private int quantidade;
    private boolean estado;

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) throws Exception {
        if(idPedido < 0)
            throw new Exception("Id invalido");
        this.idPedido = idPedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) throws Exception {
        if(quantidade < 0)
            throw new Exception("Quantidade deve ser maior que zero");
        else if(quantidade > 2000)
            throw new Exception("Quantidade deve ser menor que 2000");
        this.quantidade = quantidade;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado){
        this.estado = estado;
    }
    
}
