/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes_Main;

import java.util.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author lucasfranco
 */
public class Teste_dates {

    public static void main(String[] args){
    
    //Teste conversão de string para data
    /*
        DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        
        String data = "26/09/2016";
        Date date;
        try{
            date = new Date(formatoData.parse(data).getTime());
            System.out.println("DATA: "+date);
        }
        catch(ParseException pe){
            System.out.println("ErroData: "+pe);
        }
    */
    
    //Teste conversão de string para hora
    /*  DateFormat formato = new SimpleDateFormat("hh:mm:ss");
        
        String horario = "21:13:15";
        Date date;

        try{
            date = new Time(formato.parse(horario).getTime());
            System.out.println("HORA: "+date);
        }
        catch(ParseException pe){
            System.out.println("ErroHora: "+pe);
        }
    */    
    
    //Conversao util.Date para sql.Date
    
        java.util.Date dataUtil = new java.util.Date();
        java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
        System.out.println("DataUtil: "+dataUtil +"\nDataSql: "+dataSql);
    
    } 
}
