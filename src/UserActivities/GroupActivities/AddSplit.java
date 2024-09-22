package UserActivities.GroupActivities;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Utils.Connect;
import Utils.InputScan;

public class AddSplit {
    static Connect connect = new Connect();
    static Connection connection = connect.getConnection();

    public static void addExpense(String grpName){
        if (InputScan.sc.hasNextLine()) {
            InputScan.sc.nextLine();
        }
        System.out.println("Enter expense name");
        String name = InputScan.sc.nextLine();
        System.out.println("Enter expense amount");
        int amt = InputScan.sc.nextInt();

        Connect connect = new Connect();
        Connection connection = connect.getConnection();
        
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();

                String insertSQL = "INSERT INTO user_expense_details(group_name, expense_name, expense_amount) VALUES ('" 
                                   + grpName + "', '" + name + "' , '"+ amt +"')";

                statement.executeUpdate(insertSQL);
                System.out.println("Expense added successfully!");
                ShowGroups.selectOpt();
                statement.close();
            } catch (SQLException e) {
                System.out.println("An error occurred while executing the SQL query in addExpense");
                e.printStackTrace();
            } finally {
                connect.closeConnection();
            }
        }
    }
}