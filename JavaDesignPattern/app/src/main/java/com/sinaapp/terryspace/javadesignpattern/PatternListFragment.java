package com.sinaapp.terryspace.javadesignpattern;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by terry on 6/27/15.
 */
public class PatternListFragment extends Fragment {
    public static final String PATTERN_ID =
            "com.sinaapp.terryspace.javadesignpattern.PatternListFragment.pattern_id";
    //this is the title of patternlist activity.The title is received from type fragment
    private TextView patternListTitle;
    private ListView designPatternListView;
    private ImageView returnbackButton;

    private String type;
    private ArrayList<DesignPattern> designpatterns;
    private ArrayAdapter adapter;

    private DesignPattern clickedDesignPattern;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String typeName = getActivity().getIntent().getStringExtra(TypeFragment.PATTERN_TYPE);
        designpatterns = DesignPatternLab.getInstance().getDesignPatternList(typeName);
        //new an adapter to show list in the listview
        adapter = new ArrayAdapter(getActivity(), R.layout.item_pattern_list,designpatterns);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_patternlist,null);

        //set the title by string in the activity intent
        patternListTitle = (TextView)view.findViewById(R.id.pattern_list_title);
        //get the name of pattern type from type fragment
        type = getActivity().getIntent().getStringExtra(TypeFragment.PATTERN_TYPE);
        patternListTitle.setText(showTitle(type));
        //set the title in the center of the textview
        patternListTitle.setGravity(Gravity.CENTER);

        //show the list with design pattern name
        designPatternListView = (ListView)view.findViewById(R.id.design_pattern_list);
        designPatternListView.setAdapter(adapter);
        designPatternListView.setDivider(null);
        designPatternListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //get the design pattern whick you click on it
                clickedDesignPattern = (DesignPattern) adapter.getItem(position);
                Intent intent = new Intent(getActivity(), PatternContentActivity.class);
                intent.putExtra(PATTERN_ID, clickedDesignPattern.getID());
                startActivity(intent);
            }
        });

        returnbackButton = (ImageView) view.findViewById(R.id.list_returnback);
        returnbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        return view;
    }

    //switch the type ,and return the title of the specific type
    private String showTitle(String type){
        String titleName = "";
        switch (type){
            case TypeFragment.CREATION_PATTERN:
                titleName = "Creational Patterns";
                break;
            case TypeFragment.STRUCTURAL_PATTERN:
                titleName = "Structural Patterns";
                break;
            case TypeFragment.BEHAVIORAL_PATTERN:
                titleName = "Behavioral Patterns";
                break;
            case TypeFragment.J2EE_PATTERN:
                titleName = "J2EE Patterns";
                break;
            default:
                break;
        }
        return  titleName;
    }


}
