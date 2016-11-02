/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;

/**
 *
 * @author Nicholas
 */
public class Venda {
    private int idVenda;
    private Date dataVenda;
    private float valorTotal;

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) throws Exception {
        if(idVenda < 0)
            throw new Exception("Id invalido");
        this.idVenda = idVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) throws Exception {
        Date dt = new Date();
        
        if(dataVenda.after(dt) || dataVenda == null)
            throw new Exception("Data invalida");
        this.dataVenda = dataVenda;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) throws Exception {
        if(valorTotal < 0)
            throw new Exception("Apenas valores maiores que zero");
        else if(valorTotal > 5000)
            throw new Exception("Apenas valores até 5000");
        
        this.valorTotal = valorTotal;
    }
    
}
