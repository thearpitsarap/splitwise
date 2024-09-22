package Auth;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import Entry.App;

import Utils.Connect;
import Utils.InputScan;

public class Signup {

    public void createUser() {

        System.out.println("Enter username");
        String username = InputScan.sc.nextLine();

        System.out.println("Enter password");
        String password = InputScan.sc.nextLine();

        Connect connect = new Connect();
        Connection connection = connect.getConnection();
        
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();

                String insertSQL = "INSERT INTO users (username, password) VALUES ('" 
                                   + username + "', '" + password + "')";

                statement.executeUpdate(insertSQL);
                System.out.println("User created successfully!");
                App.entryPoint();
                statement.close();
            } catch (SQLException e) {
                System.out.println("An error occurred while executing the SQL query");
                e.printStackTrace();
            } finally {
                connect.closeConnection();
            }
        }
    }
}