package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private Connection connection;
    public ConnectionDB(){
        try {
            this.connection = DriverManager.getConnection(
                    Credentials.URL,
                    Credentials.USER,
                    Credentials.PASSWORD
            );
        }catch (SQLException e){
            e.printStackTrace();
        }
    };
    public Connection getConnection(){
        return this.connection;
    }
}
