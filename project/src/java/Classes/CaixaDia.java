/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;

/**
 *
 * @author lucasfranco
 */
public class CaixaDia {
    private int idCaixa;
    private float saldoInicial;
    private float entradaBruto;
    private float entradaReal;
    private float saldoLiquido;
    private float saldoReal;
    private float saidaTotal;
    private Date data;

    public float getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(float saldoInicial) throws Exception {
        if(saldoInicial < 0)
            throw new Exception("Saldo Inicial invalido");

        this.saldoInicial = saldoInicial;
    }
    
    public float getEntradaBruto() {
        return entradaBruto;
    }

    public void setEntradaBruto(float entradaBruto) throws Exception {
        if(entradaBruto < 0)
            throw new Exception("Entrada invalida");
        
        this.entradaBruto = entradaBruto;
    }

    public float getEntradaReal() {
        return entradaReal;
    }

    public void setEntradaReal(float entradaReal) throws Exception {
        if(entradaReal < 0)
            throw new Exception("Entrada invalido");
        
        this.entradaReal = entradaReal;
    }

    public float getSaldoLiquido() {
        return saldoLiquido;
    }

    public void setSaldoLiquido(float saldoLiquido){
        this.saldoLiquido = saldoLiquido;
    }

    public float getSaldoReal() {
        return saldoReal;
    }

    public void setSaldoReal(float saldoReal) {      
        this.saldoReal = saldoReal;
    }

    public float getSaidaTotal() {
        return saidaTotal;
    }

    public void setSaidaTotal(float saidaTotal) throws Exception {  
        if(saidaTotal < 0)
            throw new Exception("Saida invalida");
       
        this.saidaTotal = saidaTotal;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) throws Exception {
        Date dt = new Date();
        
        if(data.after(dt))
            throw new Exception("Data invalida");
          
        this.data = data;
    }
            
    public int getIdCaixa() {
        return idCaixa;
    }

    public void setIdCaixa(int idCaixa) throws Exception {
        if(idCaixa < 0)
           throw new Exception("Id invalido");
        this.idCaixa = idCaixa;
    }
    
}
