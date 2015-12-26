package com.omret.foodsearch;

import java.util.ArrayList;

/**
 * Created by terry on 12/20/15.
 */
public class DataUtil {
    private ArrayList<Shop> shops;
    private ArrayList<Shop> starshop = new ArrayList<>();
    private ArrayList<Shop> buyshop = new ArrayList<>();


    private static DataUtil dataUtil;
    private DataUtil(){}
    public static DataUtil getInstance(){
        if(dataUtil == null){
            dataUtil = new DataUtil();
        }
        return dataUtil;
    }
    public ArrayList<Shop> getShopData(){
        shops = new ArrayList<Shop>();
        shops.add(new Shop(R.drawable.kfc,R.drawable.pic1,"肯德基","汉堡 薯条 炸鸡"));
        shops.add(new Shop(R.drawable.hbw,R.drawable.pic2,"汉堡王","汉堡 薯条 炸鸡"));
        shops.add(new Shop(R.drawable.hls,R.drawable.pic3,"华莱士","汉堡 薯条 炸鸡"));
        shops.add(new Shop(R.drawable.mcd,R.drawable.pic4,"麦当劳","汉堡 薯条 炸鸡"));
        shops.add(new Shop(R.drawable.zgf,R.drawable.pic5,"真功夫","盖浇饭 汤饭 "));
        shops.add(new Shop(R.drawable.starbark,R.drawable.pic6,"星巴克","咖啡 饮料 面包"));
        return shops;
    }


    public void addStarShop(Shop shop){
        this.starshop.add(shop);
    }

    public void removeStarShop(int index){
        this.starshop.remove(index);
    }

    public ArrayList<Shop> getStarShops(){
        return starshop;
    }

    public int starindex2index(int starindex){
        for (int i = 0;i < shops.size();i++){
            if(shops.get(i).getName().equals(starshop.get(starindex).getName())){
                return i;
            }
        }
        return -1;
    }

    public void addBuyShop(Shop shop){
        this.buyshop.add(shop);
    }

    public ArrayList<Shop> getBuyshop(){
        return this.buyshop;
    }
    public int buyindex2index(int buyindex){
        for (int i = 0;i < shops.size();i++){
            if(shops.get(i).getName().equals(buyshop.get(buyindex).getName())){
                return i;
            }
        }
        return -1;
    }
}
