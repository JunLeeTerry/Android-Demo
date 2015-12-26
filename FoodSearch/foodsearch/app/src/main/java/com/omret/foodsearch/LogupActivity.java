package com.omret.foodsearch;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by terry on 12/18/15.
 */
public class LogupActivity extends Activity {
    private ImageView logupback;
    private EditText logupname;
    private EditText loguppasswd;
    private EditText loguppasswdcertify;
    private RadioGroup group;
    private Button logupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logup);

        final User user = new User();

        logupname = (EditText) findViewById(R.id.logupusername);
        loguppasswd = (EditText) findViewById(R.id.logupuserpasswd);
        loguppasswdcertify = (EditText) findViewById(R.id.logupuserpasswdcertify);
        group = (RadioGroup) findViewById(R.id.logupradiogroup);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radio1) {
                    user.setType("buyer");
                } else if (checkedId == R.id.radio2) {
                    user.setType("seller");
                }
            }
        });

        logupback = (ImageView) findViewById(R.id.logupback);
        logupback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        logupButton = (Button) findViewById(R.id.loguplogupbutton);
        logupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = logupname.getText().toString();

                if (!loguppasswd.getText().toString().equals(loguppasswdcertify.getText().toString())) {
                    Toast.makeText(LogupActivity.this, "两次密码不一致", Toast.LENGTH_LONG).show();
                    return;
                }

                if (UserUtil.getInstance().isNameExist(name)) {
                    Toast.makeText(LogupActivity.this, "用户名已存在，请重新输入", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    user.setName(name);
                }

                String passwd = loguppasswd.getText().toString();
                user.setPasswd(passwd);
                UserUtil.getInstance().addUser(user);
                Toast.makeText(LogupActivity.this,"注册成功！",Toast.LENGTH_LONG).show();
            }
        });
    }
}
