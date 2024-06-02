package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDatabase {

    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn != null) {
            return conn;
        }

        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection("jdbc:odbc:Asian_Paints", "", "");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}
