package com.sinaapp.terryspace.javadesignpattern.com.sinaapp.terryspace.javadesignpattern.about;

import android.content.Context;

import com.sinaapp.terryspace.javadesignpattern.R;

import java.util.ArrayList;

/**
 * Created by terry on 7/10/15.
 */
public class SlidingMenuManager {
    private ArrayList<SlidingMenuItem> slidingMenuItems;
    private static SlidingMenuManager slidingMenuManager;
    private Context context;

    private SlidingMenuManager(Context context){
       this.context = context;
    }
    public static SlidingMenuManager getInstance(Context context){
        if(slidingMenuManager == null){
            slidingMenuManager = new SlidingMenuManager(context);
        }
        return slidingMenuManager;
    }

    public ArrayList<SlidingMenuItem> getItems(){
        slidingMenuItems = new ArrayList<>();
        slidingMenuItems.add(new SlidingMenuItem(context.getString(R.string.about_us),R.drawable.about_us));
        slidingMenuItems.add(new SlidingMenuItem(context.getString(R.string.proposal),R.drawable.proposal));
        slidingMenuItems.add(new SlidingMenuItem(context.getString(R.string.version),R.drawable.version));
        slidingMenuItems.add(new SlidingMenuItem(context.getString(R.string.contact_us), android.R.drawable.sym_action_email));
        return slidingMenuItems;
    }
}
