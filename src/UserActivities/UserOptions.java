package UserActivities;


import UserActivities.GroupActivities.CreateGroup;
import UserActivities.GroupActivities.ShowGroups;
import Utils.InputScan;

public class UserOptions {
    public static void selectOption() {
        System.out.println("Select option");
        System.out.println("1 - Edit Balance");
        System.out.println("2 - Show Groups");
        System.out.println("3 - Create Group");

        int option = InputScan.sc.nextInt();
        
        switch (option) {
            case 1:
                EditBalance.editBalance();
                break;
            case 2:
                ShowGroups.showGroups();
                break;
            case 3:
                CreateGroup.createGroup();
                break;

            default:
                break;
        }
    }
}