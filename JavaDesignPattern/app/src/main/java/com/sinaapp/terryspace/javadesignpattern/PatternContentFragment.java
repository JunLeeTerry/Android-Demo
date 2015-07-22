package com.sinaapp.terryspace.javadesignpattern;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.UUID;

/**
 * Created by terry on 6/28/15.
 */
public class PatternContentFragment extends Fragment {
    private static final String TAG = "PatternContentFragment";

    private TextView patternContentTitle;
    private DesignPattern designPattern;
    private WebView designContentView;
    private ImageView returnbackButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //get the specific pattern
        UUID uuid = (UUID)getActivity().getIntent().getSerializableExtra(PatternListFragment.PATTERN_ID);
        designPattern = DesignPatternLab.getInstance().getDesignPattern(uuid);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_patterncontent, null);

        //this part is design pattern content view ,with web view
        designContentView = (WebView)view.findViewById(R.id.pattern_content_view);
        WebSettings webSettings = designContentView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //designContentView.loadData(designPattern.getContent(),"text/html", "UTF-8");

        designContentView.loadUrl(designPattern.getContent());
        patternContentTitle = (TextView)view.findViewById(R.id.pattern_content_title);
        //set the content title with the pattern name
        patternContentTitle.setText(designPattern.getName());

        returnbackButton = (ImageView)view.findViewById(R.id.content_returnback);
        returnbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        return view;
    }
}
