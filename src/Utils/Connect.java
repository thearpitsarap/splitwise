package Utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    private Connection connection;

    public Connection getConnection() {
        if (connection == null) {
            try {
                // Load the MySQL JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Database URL, username, and password
                String url = "jdbc:mysql://localhost:3306/ss";
                String user = "root";
                String password = "";

                // Establish the connection
                connection = DriverManager.getConnection(url, user, password);

                if (connection != null) {
                    System.out.println("Connected to the database!");
                }
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println("An error occurred while connecting to the MySQL database");
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
