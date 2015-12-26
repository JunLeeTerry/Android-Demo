package com.omret.foodsearch;

import java.util.ArrayList;

/**
 * Created by terry on 12/19/15.
 */
public class Shop {
    private int imagePath;
    private int shopImage;
    private String name;
    private String description;
    private ArrayList<Commit> commits = new ArrayList<>();
    private boolean isChecked = false;

    public Shop(){}

    public Shop(int imagePath,int shopImage,String name,String description){
        this.imagePath = imagePath;
        this.name = name;
        this.description = description;
        this.shopImage = shopImage;
    }

    public int getImagePath(){
        return this.imagePath;
    }

    public void setImagePath(int imagePath){
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getShopImage() {
        return shopImage;
    }

    public ArrayList<Commit> getCommits() {
        return commits;
    }

    public void setCommits(ArrayList<Commit> commits) {
        this.commits = commits;
    }

    public boolean isChecked(){
        return this.isChecked;
    }

    public void setChecked(boolean checkedStatus){
        this.isChecked = checkedStatus;
    }
}
