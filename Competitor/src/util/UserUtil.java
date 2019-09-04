package util;

import beans.User;
import config.Initialization;

import java.util.Scanner;

public class UserUtil {

    public static User login(String username, String password){
        if("Aziz".equals(username) && "12345".equals(password))
            return new User(username, password);

        throw new IllegalArgumentException("Username or Password is incorrect!");
    }

    public static User requireInputsAndLogin(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please type your username:");
        String username = sc.nextLine();
        System.out.println("Please type your password:");
        String password = sc.nextLine();
        User user = UserUtil.login(username,password);
//        Initialization.config.setUser(user);
        return user;
    }

    public static User requireInputsAndLogin(int tryCount, boolean throwException){
        for (int i=0; i<tryCount; i++){
            try {
                User user = requireInputsAndLogin();
                return user;
            } catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
                System.out.println("Try again!");
            }
        }
        if(throwException)
            throw new IllegalArgumentException("You have banned!");
        else
            return null;
    }

}
