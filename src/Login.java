package src;

import javax.swing.*;
import java.sql.*;

public class Login {
    static boolean loggedIn=false;
    public static boolean re(){
        boolean log=loggedIn;
        return log;
    } 
    public static boolean performAction(String selectedOption) {
        switch (selectedOption) {
            case "Login":
                loggedIn=loginUser(loggedIn);
                break;
            case "Sign Up":
                registerUser();
                break;
            case "Logout":
                Logout();
                break;
            default:
                break;
        
        }
        return loggedIn;
    }

    private static boolean loginUser(boolean loggedIn) {
        if(loggedIn==false){
        String username = JOptionPane.showInputDialog("Enter your username:");
        String password = JOptionPane.showInputDialog("Enter your password:");
        String query = "SELECT * FROM signup WHERE username = '" + username + "' AND password = '" + password + "'";
        try {
            // Loading and registering Oracle database thin driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Creating a connection between the Java program and Oracle database.
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "manager");
            // Creating a Statement object to execute SQL statements
            Statement stmt = con.createStatement();

            // Execute the SELECT query
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                // User found in the database
                JOptionPane.showMessageDialog(null, "Login Successful with username: " + username);
                loggedIn=true;
            } else {
                // User not found in the database
                JOptionPane.showMessageDialog(null, "Invalid Username or Password");
            }

            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error during login: " + e.getMessage());
        }
    }

        // Clear the password field for security


        // Add your logic for user login here
         
        
        return loggedIn;
    }

    private static void registerUser() {
        if(loggedIn==false){ 
        String username = JOptionPane.showInputDialog("Enter your desired username:");
        String mobileNumber = JOptionPane.showInputDialog("Enter your mobile number:");
        String emailAddress = JOptionPane.showInputDialog("Enter your email address");
        String password = JOptionPane.showInputDialog("Enter your password:");
        String confirmPassword = JOptionPane.showInputDialog("Confirm your password");
    
        // Add your logic for user registration here
        if (password.equals(confirmPassword)) {
            try {
                Conn conn = new Conn();
                Statement stmt = conn.getConnection().createStatement();
    
                // Check if the table already exists
                DatabaseMetaData meta = conn.getConnection().getMetaData();
                ResultSet tables = meta.getTables(null, null, "SIGNUP", null);
                if (!tables.next()) {
                    // Create the table if it doesn't exist
                    stmt.executeUpdate("CREATE TABLE signup(Username VARCHAR(20), Password VARCHAR(20), MobileNumber varchar(12), EmailAddress VARCHAR(20))");
                }
    
                // Insert user data into the table
                String insertQuery = String.format("INSERT INTO signup VALUES('%s', '%s', '%s', '%s')", username, password, mobileNumber, emailAddress);
                stmt.executeUpdate(insertQuery);
    
                // Close the statement and connection
                conn.closeConnection(conn.getConnection(), stmt);
    
                JOptionPane.showMessageDialog(null, "User registered successfully with username: " + username);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Password confirmation failed. Please try again.");
        }
    }
    }
    

    private static void Logout() {
        loggedIn=false;
    }

    private static boolean isAdminValid(String adminUsername, String adminPassword) {
        // Add your logic to validate admin credentials
        // For example, you might check against a predefined admin username and password
        return adminUsername.equals("admin") && adminPassword.equals("admin123");
    }
}
