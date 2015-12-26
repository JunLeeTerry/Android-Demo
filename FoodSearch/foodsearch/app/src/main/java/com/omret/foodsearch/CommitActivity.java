package com.omret.foodsearch;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by terry on 12/20/15.
 */
public class CommitActivity extends Activity {
    private ImageView back;
    private EditText commitedit;
    private TextView cancel;
    private TextView ensure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commit);

        final int index = getIntent().getIntExtra("index",0);

        back = (ImageView ) findViewById(R.id.commit_back);
        commitedit = (EditText) findViewById(R.id.commitedit);
        cancel = (TextView) findViewById(R.id.cancelButton);
        ensure  = (TextView) findViewById(R.id.ensureButton);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ensure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = commitedit.getText().toString();
                Commit commit = new Commit("",content);

                DataUtil.getInstance().getShopData().get(index).getCommits().add(commit);
                Toast.makeText(CommitActivity.this,"评论成功！",Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
