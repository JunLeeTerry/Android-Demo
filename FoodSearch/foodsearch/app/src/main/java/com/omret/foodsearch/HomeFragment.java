package com.omret.foodsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by terry on 12/15/15.
 */
public class HomeFragment extends Fragment{
    private static final String LOG = "homefragment";
    private ListView shopList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_home,null);

        shopList = (ListView) contentView.findViewById(R.id.shopList);
        ShopAdapter shopAdapter = new ShopAdapter(getActivity(),DataUtil.getInstance().getShopData(),false);
        shopList.setAdapter(shopAdapter);

        shopList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),ShopDetailActivity.class);
                intent.putExtra("index",position);
                startActivity(intent);
            }
        });

        Log.e(LOG, "on create view ");
        return contentView;
    }
}
