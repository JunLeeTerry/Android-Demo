package com.omret.foodsearch;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by terry on 12/20/15.
 */
public class ShopDetailActivity extends Activity {
    private ImageView back;
    private ImageView shopImage;
    private Button buyButton;
    private ListView commits;
    private ImageView shopcheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopdetail);
        final int index = getIntent().getIntExtra("index",0);
        final Shop shop = DataUtil.getInstance().getShopData().get(index);
        back = (ImageView) findViewById(R.id.shopdetailback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        shopImage = (ImageView) findViewById(R.id.detailimage);
        shopImage.setImageResource(shop.getShopImage());
        buyButton = (Button) findViewById(R.id.buybutton);
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataUtil.getInstance().addBuyShop(shop);
                Toast.makeText(ShopDetailActivity.this,"购买成功！",Toast.LENGTH_LONG).show();
            }
        });
        commits = (ListView) findViewById(R.id.commitlist);
        CommitAdapter adapter = new CommitAdapter(this,shop.getCommits());
        commits.setAdapter(adapter);

        shopcheck = (ImageView) findViewById(R.id.starcheck);
        shopcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(shop.isChecked()){
                    shopcheck.setImageResource(android.R.drawable.btn_star_big_off);
                    DataUtil.getInstance().removeStarShop(index);
                    Toast.makeText(ShopDetailActivity.this,"已取消收藏！",Toast.LENGTH_LONG).show();
                    shop.setChecked(false);
                }
                else{
                    shopcheck.setImageResource(android.R.drawable.btn_star_big_on);
                    DataUtil.getInstance().addStarShop(shop);
                    Toast.makeText(ShopDetailActivity.this,"收藏成功！",Toast.LENGTH_LONG).show();
                    shop.setChecked(true);
                }
            }
        });

    }
}
