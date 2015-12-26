package com.omret.foodsearch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by terry on 12/17/15.
 */
public class SigninActivity extends Activity {
    private ImageView signinBack;
    private Button logupButton;
    private Button signupButton;
    private EditText signinusername;
    private EditText signinpasswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        signinusername = (EditText) findViewById(R.id.signinusername);
        signinpasswd = (EditText) findViewById(R.id.signinuserpasswd);

        signinBack = (ImageView) findViewById(R.id.signinback);
        signinBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        signupButton = (Button) findViewById(R.id.signinbutton);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = signinusername.getText().toString();
                String userpasswd = signinpasswd.getText().toString();

                if(UserUtil.getInstance().signinSuccessfully(username,userpasswd)){
                    Toast.makeText(SigninActivity.this,"登录成功",Toast.LENGTH_LONG).show();
                    UserFragment.setSignStatus(true);
                    finish();
                }
                else {
                    Toast.makeText(SigninActivity.this,"用户名或密码不正确！",Toast.LENGTH_LONG).show();
                    return ;
                }


            }
        });

        logupButton = (Button) findViewById(R.id.logupbutton);
        logupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SigninActivity.this,LogupActivity.class);
                startActivity(intent);

            }
        });
    }
}
