package br.com.exemplo.servlet.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by davikawasaki on 18/08/16.
 */
public class ConnectionFactory {
    public Connection getConnection() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/livrariaengsw", "root", "root"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
