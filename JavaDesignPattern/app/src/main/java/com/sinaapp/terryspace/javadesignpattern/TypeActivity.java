package com.sinaapp.terryspace.javadesignpattern;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.sinaapp.terryspace.javadesignpattern.com.sinaapp.terryspace.javadesignpattern.about.SlidingMenuItem;
import com.sinaapp.terryspace.javadesignpattern.com.sinaapp.terryspace.javadesignpattern.about.SlidingMenuManager;
import com.sinaapp.terryspace.javadesignpattern.com.sinaapp.terryspace.javadesignpattern.about.VersionActivity;
import com.sinaapp.terryspace.javadesignpattern.com.sinaapp.terryspace.javadesignpattern.about.AboutUsActivity;
import com.sinaapp.terryspace.javadesignpattern.com.sinaapp.terryspace.javadesignpattern.about.ContactUsActivity;

import java.util.ArrayList;


public class TypeActivity extends FragmentActivity {

    private ListView slidingList;
    private SlidingMenu slidingMenu;

    private ArrayAdapter adapter;
    private SlidingMenuManager slidingMenuManager;
    private static final String email = "terry_love_c@sina.com";

    private class SlidingItemAdapter extends ArrayAdapter<SlidingMenuItem>{

        public SlidingItemAdapter(ArrayList<SlidingMenuItem> items){
            super(TypeActivity.this,0,items);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = TypeActivity.this.getLayoutInflater().inflate(R.layout.item_sliding_list,null);
            }
            SlidingMenuItem item = getItem(position);

            TextView textView = (TextView)convertView.findViewById(R.id.sliding_item_text);
            textView.setText(item.getName());

            ImageView imageView = (ImageView)convertView.findViewById(R.id.sliding_item_image);
            imageView.setImageResource(item.getImg());

            return convertView;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);

        //register the fragment in the activity
        if(fragment == null){
            fragment = new TypeFragment();
            fragmentTransaction.replace(R.id.fragmentContainer, fragment);
        }
        fragmentTransaction.commit();

        slidingMenu = new SlidingMenu(this);
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        //slidingMenu.setShadowWidthRes(R.dimen.shadow_width);
        //slidingMenu.setShadowDrawable(R.drawable.shadow);
        slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        slidingMenu.setFadeDegree(0.35f);
        slidingMenu.setMenu(R.layout.menu_slidingmenu);
        slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);

        slidingList = (ListView)findViewById(R.id.sliding_list);

        slidingMenuManager = SlidingMenuManager.getInstance(this);
        adapter = new SlidingItemAdapter(slidingMenuManager.getItems());
        slidingList.setAdapter(adapter);
        slidingList.setDividerHeight(1);


        slidingList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = adapter.getItem(position).toString();
                switch (item){
                    case "About Us":
                        Intent aboutusIntent = new Intent(TypeActivity.this,AboutUsActivity.class);
                        startActivity(aboutusIntent);
                        break;
                    case "Contact Us":
                        Intent contactusIntent = new Intent(TypeActivity.this,ContactUsActivity.class);
                        startActivity(contactusIntent);
                        break;
                    case "Proposal":
                        Intent proposalIntent = new Intent(Intent.ACTION_SEND);
                        proposalIntent.setData(Uri.parse(email));
                        proposalIntent.putExtra(Intent.EXTRA_SUBJECT, "Proposal from Java Design Patterns");
                        proposalIntent.putExtra(Intent.EXTRA_TEXT,"Advice:");
                        proposalIntent.setType("text/plain");
                        //startActivity(Intent.createChooser(proposalIntent,"Send E-mail..."));
                        startActivity(proposalIntent);
                        break;
                    case "Version":
                        Intent versionIntent = new Intent(TypeActivity.this,VersionActivity.class);
                        startActivity(versionIntent);
                        break;
                }
            }
        });
    }

   /* private ArrayList<String> getSlidingMenuItems(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("About Us");
        list.add("Proposal");
        list.add("Version");
        list.add("Contact Us");
        return list;
    }*/

    public SlidingMenu getSlidingMenu(){
        return this.slidingMenu;
    }
}
