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
public class AllOrderActivity extends Activity {
    private ListView allorderList;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allorder);

        back = (ImageView) findViewById(R.id.allordlerback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        allorderList = (ListView)findViewById(R.id.allorderslist);

        ShopAdapter adapter = new ShopAdapter(this,DataUtil.getInstance().getBuyshop(),true);
        allorderList.setAdapter(adapter);

        allorderList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int index = DataUtil.getInstance().buyindex2index(position);
                Intent intent = new Intent(AllOrderActivity.this,ShopDetailActivity.class);
                intent.putExtra("index",index);
                startActivity(intent);
            }
        });
    }
}
