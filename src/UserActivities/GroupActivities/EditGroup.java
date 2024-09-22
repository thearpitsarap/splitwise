package UserActivities.GroupActivities;

import Utils.InputScan;

public class EditGroup {
    public static void addUsr(String grp) {
        System.out.println("Select option");
        System.out.println("1 - Add User");
        System.out.println("2 - Remove User");
        System.out.println("3 - Show Expenses");
        System.out.println("4 - Add Split");
        System.out.println("5 - Go Back");

        int opt = InputScan.sc.nextInt();
        System.out.println(opt);
        switch (opt) {
            case 1:
                System.out.println("Enter Username to add user");
                if (InputScan.sc.hasNextLine()) {
                    InputScan.sc.nextLine();
                }
                String name = InputScan.sc.nextLine();
                AddRemoveUser.addUser(grp, name);
                addUsr(grp);
                break;

            case 2:
                System.out.println("Enter user to remove user");
                if (InputScan.sc.hasNextLine()) {
                    InputScan.sc.nextLine();
                }
                String usrname = InputScan.sc.nextLine();
                AddRemoveUser.removeUser(grp, usrname);
                addUsr(grp);
                break;

            case 3:
                ShowExpenses.showExpenses(grp);
                break;

            case 4:
                AddSplit.addExpense(grp);
                break;

            case 5:
                ShowGroups.selectOpt();
                break;

            default:
                break;
        }
    }
}