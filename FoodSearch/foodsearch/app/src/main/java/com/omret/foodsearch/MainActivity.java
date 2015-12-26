package com.omret.foodsearch;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;


public class MainActivity extends FragmentActivity {
    private final static String LOG = "main activity";
    private RelativeLayout homeLayout;
    private RelativeLayout locationLayout;
    private RelativeLayout userLayout;
    private FragmentManager fragmentManager;

    private HomeFragment homeFragment;
    private LocationFragment locationFragment;
    private UserFragment userFragment;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        homeLayout = (RelativeLayout) findViewById(R.id.home_layout);
        locationLayout = (RelativeLayout) findViewById(R.id.location_layout);
        userLayout = (RelativeLayout) findViewById(R.id.user_layout);

        fragmentTransaction = fragmentManager.beginTransaction();
        clearFragments(fragmentTransaction);

        homeFragment = new HomeFragment();
        fragmentTransaction.replace(R.id.fragmentContent, homeFragment).commit();

        homeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = fragmentManager.beginTransaction();
                clearFragments(fragmentTransaction);
                Log.e(LOG, "click home layout");

                homeFragment = new HomeFragment();
                fragmentTransaction.replace(R.id.fragmentContent, homeFragment).commit();

            }
        });

        locationLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                fragmentTransaction = fragmentManager.beginTransaction();
                clearFragments(fragmentTransaction);

                locationFragment = new LocationFragment();
                fragmentTransaction.replace(R.id.fragmentContent, locationFragment).commit();

            }
        });

        userLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = fragmentManager.beginTransaction();
                clearFragments(fragmentTransaction);

                userFragment = new UserFragment();
                fragmentTransaction.replace(R.id.fragmentContent, userFragment).commit();

            }
        });
    }

    private void clearFragments(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
            //transaction.remove(homeFragment);
        } else if (locationFragment != null) {
            transaction.hide(locationFragment);
            //transaction.remove(locationFragment);
        } else if (userFragment != null) {
            transaction.hide(userFragment);
            //transaction.remove(userFragment);
        }
    }
}
