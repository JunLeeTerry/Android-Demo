package com.omret.foodsearch;

import java.util.ArrayList;

/**
 * Created by terry on 12/19/15.
 */
public class UserUtil {
    private ArrayList<User> users = new ArrayList<User>();
    private static UserUtil userUtil;
    private UserUtil (){}

    public static UserUtil getInstance(){
        if (userUtil == null) {
            userUtil = new UserUtil();
        }
        return userUtil;
    }

    public void addUser(User user){
       users.add(user);
    }

    public boolean isNameExist(String name){
        for(User user : users){
            if(user.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public boolean signinSuccessfully(String name,String passwd){
        for(User user:users){
            if (user.getName().equals(name)){
                if(user.getPasswd().equals(passwd)){
                    return true;
                }
            }
        }
        return false;
    }
}
