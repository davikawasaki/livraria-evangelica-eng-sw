/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes_Main;

import Classes.CaixaDia;
import DAOclasses.CaixaDiaDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Testa_Calculos {
    
    public static void main(String[] args) throws ParseException, Exception {
        CaixaDiaDAO pdao = new CaixaDiaDAO();
        CaixaDia cd = new CaixaDia();
        
        String a = "04/10/2016";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        cd.setData(new Date(sdf.parse(a).getTime()));
        
        float saldo = pdao.calculaSaldoInicial();
        System.out.println("SALDO INICIAL: "+saldo);

        float entradaBruto = pdao.calculaEntradaBruto(cd);
        System.out.println("ENTRADA BRUTA: "+entradaBruto);  
     
        float entradaReal = pdao.calculaEntradaReal(cd);
        System.out.println("ENTRADA REAL: "+entradaReal);
        
        float saldoLiquido = pdao.calculaSaldoLiquido(cd);
        System.out.println("SALDO LIQUIDO: "+saldoLiquido);

        float saldoReal = pdao.calculaSaldoReal(cd);
        System.out.println("SALDO REAL: "+saldoReal);
        
        float saidaTotal = pdao.calculaSaidaTotal(cd);
        System.out.println("SAIDA TOTAL: "+saidaTotal);

    }
}
