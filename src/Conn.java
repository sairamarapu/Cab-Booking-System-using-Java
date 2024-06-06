package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        // Loading and registering Oracle database thin driver
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // Creating a connection between Java program and Oracle database.
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "manager");

        // Creating a Statement object to execute SQL statements
        Statement stmt = conn.createStatement();

        // Returning the Connection object (you may want to return both Connection and Statement if needed)
        return conn;
    }

    public static void closeConnection(Connection conn, Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
