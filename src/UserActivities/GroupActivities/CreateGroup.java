package UserActivities.GroupActivities;

import java.sql.Connection;

import UserActivities.UserOptions;
import Utils.Connect;
import Utils.CurrentUser;
import Utils.InputScan;

public class CreateGroup {
    static Connect connect = new Connect();
    static Connection connection = connect.getConnection();

    public static void createGroup() {
        if (InputScan.sc.hasNextLine()) {
            InputScan.sc.nextLine();
        }
        System.out.println("Enter name of Group");
        String groupname = InputScan.sc.nextLine();
        
        if (connection != null) {
            try {
                String currentUser = CurrentUser.getUserName();
                AddRemoveUser.addUser(groupname, currentUser);

                UserOptions.selectOption();
            } catch (Exception e) {
                System.out.println("An error occurred in createGroup function");
                e.printStackTrace();
            } finally {
                connect.closeConnection();
            }
        }
    }
}