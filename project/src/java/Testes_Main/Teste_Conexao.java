/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes_Main;

import DAOclasses.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author lucasfranco
 */
public class Teste_Conexao {
    
    public static void main(String[] args) throws SQLException, Exception {
        Connection connection = new ConnectionFactory().getConnection("root","root");
        System.out.println("Conexão Aberta!!!");
        connection.close();
    }
}
