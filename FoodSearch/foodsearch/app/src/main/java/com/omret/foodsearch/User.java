package com.omret.foodsearch;

/**
 * Created by terry on 12/19/15.
 */
public class User  {
    private String name;
    private String passwd;
    private String type;

    public User(){}
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPasswd(){
        return this.passwd;
    }

    public void setPasswd(String passwd){
        this.passwd = passwd;
    }

    public String getType(){
        return this.type;
    }

    public void setType(String type){
        this.type = type;
    }
}
