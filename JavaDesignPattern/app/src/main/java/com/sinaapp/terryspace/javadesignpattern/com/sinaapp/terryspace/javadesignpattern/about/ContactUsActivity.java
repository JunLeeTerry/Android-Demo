package com.sinaapp.terryspace.javadesignpattern.com.sinaapp.terryspace.javadesignpattern.about;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.sinaapp.terryspace.javadesignpattern.R;

/**
 * Created by terry on 7/9/15.
 */
public class ContactUsActivity extends Activity {
    private ImageView returnbackButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);

        returnbackButton = (ImageView)findViewById(R.id.contactus_returnback);
        returnbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
