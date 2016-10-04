package DAOclasses;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    public Connection getConnection(String user, String password) throws Exception {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost/livrariaengsw", user, password
            );
        } catch (Exception e) {
            throw new Exception("Erro de conexão com banco");
        }
    }
}
