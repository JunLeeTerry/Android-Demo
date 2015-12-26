package com.omret.foodsearch;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by terry on 12/19/15.
 */
class ShopAdapter extends BaseAdapter {
    private ArrayList<Shop> shops;
    private Context context;
    private boolean showButton;

    private ImageView shopimage;
    private TextView shopname;
    private TextView shopdescription;
    private TextView commitButton;

    public ShopAdapter(Context context,ArrayList<Shop> shops,boolean showButton){
        this.shops = shops;
        this.context = context;
        this.showButton = showButton;
    }

    @Override
    public int getCount() {
        return shops.size();
    }

    @Override
    public Object getItem(int position) {
        return shops.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.shopitem,null);
        final int temposition = position;
        final Shop shop = shops.get(position);
        shopimage = (ImageView) convertView.findViewById(R.id.shopimage);
        shopname = (TextView) convertView.findViewById(R.id.shopname);
        shopdescription = (TextView) convertView.findViewById(R.id.shopdescription);

        shopimage.setImageResource(shop.getImagePath());
        shopname.setText(shop.getName());
        shopdescription.setText(shop.getDescription());

        commitButton = (TextView) convertView.findViewById(R.id.commitbutton);
        if(showButton){
            commitButton.setVisibility(View.VISIBLE);
        }
        else{
            commitButton.setVisibility(View.INVISIBLE);
        }
        commitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,CommitActivity.class);
                intent.putExtra("index",temposition);
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
