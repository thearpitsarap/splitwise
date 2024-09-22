package Auth;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import UserActivities.UserOptions;
import Utils.Connect;
import Utils.CurrentUser;
import Utils.InputScan;

public class Login {
    public static void loginUser() {

        System.out.println("Login using username and password");
        System.out.println("");

        // Clear the buffer if needed
        if (InputScan.sc.hasNextLine()) {
            InputScan.sc.nextLine();
        }

        System.out.println("Enter username");
        String username = InputScan.sc.nextLine();

        int userId = -1;

        System.out.println("Enter password");
        String password = InputScan.sc.nextLine();

        Connect connect = new Connect();
        Connection connection = connect.getConnection();

        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                Statement statement1 = connection.createStatement();

                String selectSQL = "SELECT username, password FROM users WHERE username='" + username
                        + "' AND password='" + password + "'";

                ResultSet resultSet = statement.executeQuery(selectSQL);

                String selectId = "SELECT id FROM users WHERE username='" + username
                        + "' AND password='" + password + "'";

                ResultSet uId = statement1.executeQuery(selectId);

                if (uId.next()) {
                    userId = uId.getInt("id");
                    CurrentUser.setUserId(userId);
                }

                if (resultSet.next()) {
                    CurrentUser.setUserName(username);
                    System.out.println("User logged in successfully!");
                    UserOptions.selectOption();
                } else {
                    System.out.println("Invalid username or password.");
                }
                resultSet.close();
                uId.close();
                statement.close();
                statement1.close();
            } catch (SQLException e) {
                System.out.println("An error occurred while executing the SQL query");
                e.printStackTrace();
            } finally {
                connect.closeConnection();
            }
        }
    }
}
