package Entry;

import Auth.Login;
import Auth.Signup;

import Utils.InputScan;

public class App {

    public static void entryPoint(){
        System.out.println("Welcome to Splitwise");
        System.out.println("Select your choice");

        System.out.println("1 - Login");
        System.out.println("2 - Signup");

        int choice = InputScan.sc.nextInt();
        
        switch (choice) {
            case 1:
                Login.loginUser();
                break;

            case 2:
                Signup signup = new Signup();
                signup.createUser();
                break;

            default:
                break;
        }
    }

    public static void main(String[] args) {
        entryPoint();
    }
}