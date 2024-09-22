package UserActivities.GroupActivities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Utils.Connect;

public class AddRemoveUser {
    static Connect connect = new Connect();
    static Connection connection = connect.getConnection();

    public static boolean validateUser(String name) {
        try {
            Statement statement = connection.createStatement();
            String searchUser = "SELECT username FROM users WHERE username='" + name + "'";
            ResultSet resultSet = statement.executeQuery(searchUser);

            if (resultSet.next()) {
                System.out.println("User Exists!");
                return true;
            } else {
                System.out.println("Invalid username or User does not exist");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void removeUser(String grpName, String username) {
        try {
            if (connection != null) {
                Statement statement = connection.createStatement();
                String searchUser = "DELETE FROM group_details WHERE user_name='" + username + "' AND group_name = '"
                        + grpName + "'";
                int rowsAffected = statement.executeUpdate(searchUser);

                if (rowsAffected > 0) {
                    System.out.println("User deleted successfully.");
                } else {
                    System.out.println("User not found.");
                }

                statement.close();
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while executing the SQL query");
            e.printStackTrace();
        } finally {
            connect.closeConnection();
        }
    }

    public static void addUser(String grpName, String username) {
        try {
            boolean user = validateUser(username);
            if (connection != null && user == true) {
                Statement statement = connection.createStatement();

                String insertSQL = "INSERT INTO group_details (group_name,user_name) VALUES ('"
                        + grpName + "', '" + username + "')";

                int resultSet = statement.executeUpdate(insertSQL);

                if (resultSet > 0) {
                    System.out.println("User Added successfully!");
                } else {
                    System.out.println("Invalid username");
                }
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while executing the SQL query");
            e.printStackTrace();
        }
    }
}