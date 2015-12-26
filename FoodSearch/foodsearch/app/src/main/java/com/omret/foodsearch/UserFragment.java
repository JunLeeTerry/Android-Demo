package com.omret.foodsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by terry on 12/15/15.
 */
public class UserFragment extends Fragment {
    private ImageView userswitch;
    private static Boolean swithstatus = true;
    private FrameLayout messageLayout;
    private TextView signinTextView;
    private static boolean signStatus = false;

    private FrameLayout allorders;
    private FrameLayout starshops;

    private TextView signoutTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View contentView = inflater.inflate(R.layout.fragment_user, null);
        userswitch = (ImageView) contentView.findViewById(R.id.receivemsgswitch);
        messageLayout = (FrameLayout) contentView.findViewById(R.id.receivemsg);
        messageLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) userswitch.getLayoutParams();
                if (swithstatus) {
                    userswitch.setImageResource(R.drawable.switch_off);
                    userswitch.setLayoutParams(params);
                    swithstatus = false;

                } else {
                    userswitch.setImageResource(R.drawable.switch_on);
                    swithstatus = true;

                }
            }
        });

        signinTextView = (TextView) contentView.findViewById(R.id.signintextview);
        if (signStatus) {
            signinTextView.setVisibility(View.INVISIBLE);
        } else {
            signinTextView.setVisibility(View.VISIBLE);
        }
        signinTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SigninActivity.class);
                getActivity().startActivity(intent);
            }
        });

        allorders = (FrameLayout) contentView.findViewById(R.id.allorders);
        starshops = (FrameLayout) contentView.findViewById(R.id.starshop);

        allorders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (signStatus){
                    Intent intent = new Intent(getActivity(),AllOrderActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getActivity(),"尚未登录，请先登录！",Toast.LENGTH_LONG).show();
                }
            }
        });

        starshops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (signStatus){
                    Intent intent = new Intent(getActivity(),UserStarShopActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getActivity(),"尚未登录，请先登录！",Toast.LENGTH_LONG).show();
                }
            }
        });

        signoutTextView = (TextView)contentView.findViewById(R.id.signouttext);
        signoutTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signStatus = false;
                Toast.makeText(getActivity(),"已登出！",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(), SigninActivity.class);
                getActivity().startActivity(intent);
            }
        });

        return contentView;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (signStatus) {
            signinTextView.setVisibility(View.INVISIBLE);
        } else {
            signinTextView.setVisibility(View.VISIBLE);
        }
    }

    public static void setSignStatus(boolean status) {
        signStatus = status;
    }
}
