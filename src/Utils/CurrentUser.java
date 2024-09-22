package Utils;

public class CurrentUser {
    static String username;
    static int userid;

    public static void setUserId(int userId){
        userid = userId;
    }

    public static int getUserId(){
        return userid;
    }

    public static void setUserName(String name){
        username = name;
    }

    public static String getUserName(){
        return username;
    }
}