package com.omret.foodsearch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by terry on 12/20/15.
 */
public class UserStarShopActivity extends Activity {
    private ImageView back;
    private ListView starshop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userstarshop);
        back = (ImageView) findViewById(R.id.userstarback);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        starshop = (ListView) findViewById(R.id.userstarshopList);
        ShopAdapter adapter = new ShopAdapter(this,DataUtil.getInstance().getStarShops(),false);
        starshop.setAdapter(adapter);

        starshop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(UserStarShopActivity.this,ShopDetailActivity.class);
                int index = DataUtil.getInstance().starindex2index(position);
                if(index < 0){
                    return;
                }
                intent.putExtra("index",index);
                startActivity(intent);
            }
        });

    }
}
