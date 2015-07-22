package com.sinaapp.terryspace.javadesignpattern.com.sinaapp.terryspace.javadesignpattern.about;

/**
 * Created by terry on 7/10/15.
 */
public class SlidingMenuItem {
    private String name;
    private int img;
    public SlidingMenuItem(String name,int img){
        this.name = name;
        this.img = img;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getImg(){
        return this.img;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
