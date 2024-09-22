package UserActivities.GroupActivities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Utils.Connect;
import Utils.InputScan;

public class ShowExpenses {

    public static Connect connect = new Connect();
    public static Connection connection = connect.getConnection();

    public static void showExpenses(String grpName) {
        try {
            Statement statement = connection.createStatement();
            Statement statement1 = connection.createStatement();
            if (InputScan.sc.hasNextLine()) {
                InputScan.sc.nextLine();
            }

            String searchUser = "SELECT expense_name,expense_amount FROM user_expense_details WHERE group_name='" + grpName
                    + "'";

            ResultSet resultSet = statement.executeQuery(searchUser);

            String searchCount ="SELECT user_count FROM group_user_count WHERE group_name ='" + grpName
                    + "'";
            ResultSet resultSet2 = statement1.executeQuery(searchCount);
            int count = 1;
            if(resultSet2.next()){
                count = resultSet2.getInt("user_count");
            }

            boolean hasGroups = false;

            while (resultSet.next()) {
                hasGroups = true;
                System.out.println("Expense name: " + resultSet.getString("expense_name"));
                System.out.println("Expenses amount: " + resultSet.getInt("expense_amount")/count);
            }

            if (!hasGroups) {
                System.out.println("No expenses found for this group.");
            }
            EditGroup.addUsr(grpName);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error in Show Expenses");
        }
    }
}