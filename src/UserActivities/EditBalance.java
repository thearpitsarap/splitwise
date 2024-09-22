package UserActivities;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Utils.Connect;
import Utils.CurrentUser;
import Utils.InputScan;

public class EditBalance {
    public static void editBalance(){

        System.out.println("Enter balance to edit");
        int bal = InputScan.sc.nextInt();

        int userId = CurrentUser.getUserId();

        Connect connect = new Connect();
        Connection connection = connect.getConnection();

        if (connection != null) {
            try {
                Statement statement = connection.createStatement();

                String SQLupdate = "UPDATE users SET balance = '"+bal+"' WHERE id = '" + userId + "';";

                int rowsAffected = statement.executeUpdate(SQLupdate);

                if (rowsAffected > 0) {
                    System.out.println("User balance updated successfully!");
                } else {
                    System.out.println("User not found.");
                }

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