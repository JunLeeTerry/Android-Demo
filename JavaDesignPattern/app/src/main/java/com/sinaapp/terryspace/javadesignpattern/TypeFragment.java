package com.sinaapp.terryspace.javadesignpattern;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * Created by terry on 6/26/15.
 */
public class TypeFragment extends Fragment {
    public static final String PATTERN_TYPE = "com.sinaapp.terryspace.TypeFragment.pattern_type";

    public static final String CREATION_PATTERN = "creational";
    public static final String STRUCTURAL_PATTERN = "structural";
    public static final String BEHAVIORAL_PATTERN = "behavioral";
    public static final String J2EE_PATTERN = "j2ee";

    private TextView creationalTextView;
    private TextView structuralTextView;
    private TextView behavioralTextView;
    private TextView j2eeTextView;

    private DBManager dbManager;

    private ImageView slidingView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dbManager = new DBManager(getActivity());
        dbManager.openDatabase();
        dbManager.closeDatabase();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_type,null);

        creationalTextView = (TextView)view.findViewById(R.id.creational_pattern_textview);
        structuralTextView = (TextView)view.findViewById(R.id.structural_pattern_textview);
        behavioralTextView = (TextView)view.findViewById(R.id.behavioral_pattern_textview);
        j2eeTextView = (TextView)view.findViewById(R.id.j2ee_pattern_textview);

        creationalTextView.getBackground().setAlpha(150);
        structuralTextView.getBackground().setAlpha(150);
        behavioralTextView.getBackground().setAlpha(150);
        j2eeTextView.getBackground().setAlpha(150);

        setClickListener(creationalTextView, CREATION_PATTERN);
        setClickListener(structuralTextView, STRUCTURAL_PATTERN);
        setClickListener(behavioralTextView, BEHAVIORAL_PATTERN);
        setClickListener(j2eeTextView, J2EE_PATTERN);

        slidingView = (ImageView)view.findViewById(R.id.image_sliding);
        slidingView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TypeActivity activity = (TypeActivity)getActivity();
                activity.getSlidingMenu().toggle();
            }
        });

        return view;
        // return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void setClickListener(TextView textView, final String name){
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(),"test click",Toast.LENGTH_SHORT);
                Intent intent = new Intent(getActivity(),PatternListActivity.class);
                //put the name of type to the pattern list fragment
                intent.putExtra(PATTERN_TYPE,name);
                startActivity(intent);
            }
        });
    }
}
