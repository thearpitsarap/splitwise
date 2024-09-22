package UserActivities.GroupActivities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import UserActivities.UserOptions;
import Utils.Connect;
import Utils.CurrentUser;
import Utils.InputScan;

public class ShowGroups {
    public static Connect connect = new Connect();
    static Connection connection = connect.getConnection();

    public static void selectOpt() {
        System.out.println("Select an Option");
        System.out.println("1 - Show Profile");
        System.out.println("2 - Edit Group");

        int opt = InputScan.sc.nextInt();

        switch (opt) {
            case 1:
                UserOptions.selectOption();
                break;
            case 2:
                System.out.println("Enter Group name to Edit");
                if (InputScan.sc.hasNextLine()) {
                    InputScan.sc.nextLine();
                }
                String grpName = InputScan.sc.nextLine();
                EditGroup.addUsr(grpName);
                break;
            default:
                break;
        }
    }

    public static void showGroups() {
        try {
            if (connection != null) {
                Statement statement = connection.createStatement();

                String user = CurrentUser.getUserName();

                String selectSQL = "SELECT group_name FROM group_details WHERE user_name='" + user
                        + "'";

                ResultSet resultSet = statement.executeQuery(selectSQL);

                boolean hasGroups = false;

                while (resultSet.next()) {
                    hasGroups = true;
                    System.out.println("Group: " + resultSet.getString("group_name"));
                }

                if (!hasGroups) {
                    System.out.println("No groups found for this user.");
                }

                resultSet.close();
                statement.close();
                selectOpt();
            }
        } catch (Exception e) {
            System.out.println("Error while fetching Groups");
        }
    }
}