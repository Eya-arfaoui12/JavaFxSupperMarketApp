package Control;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {


    private static Connection conn = null ;
    private ConnectionDB(){

    }
    public static Connection openConnection() throws SQLException {

        if (conn == null)
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tunisiamarket", "root", "");
                return conn;

    }
}
