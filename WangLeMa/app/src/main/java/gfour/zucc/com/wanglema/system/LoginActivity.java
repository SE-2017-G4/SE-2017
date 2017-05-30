package gfour.zucc.com.wanglema.system;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import gfour.zucc.com.wanglema.R;
import gfour.zucc.com.wanglema.Util.SysApplication;

/**
 * Created by Administrator on 2017/5/26.
 */

public class LoginActivity extends Activity implements View.OnClickListener {

    private ImageView login_back;
    private EditText login_username;
    private EditText login_password;
    private ImageView login;
    private TextView login_regist;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SysApplication.getInstance().addActivity(this);

        login_back = (ImageView) findViewById(R.id.login_back);
        login_username = (EditText) findViewById(R.id.login_username);
        login_password = (EditText) findViewById(R.id.login_password);
        login = (ImageView) findViewById(R.id.login_login);
        login_regist = (TextView) findViewById(R.id.login_regist);

        login_back.setOnClickListener(this);
        login.setOnClickListener(this);
        login_regist.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.login_back) {
            finish();
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        } else if (v.getId() == R.id.login_login) {

            //TODO 判断用户名密码是否正确
            //

            if (true) {
                Intent intent = new Intent();
                intent.setClassName("gfour.zucc.com.wanglema", "gfour.zucc.com.wanglema.system.BackupActivity");
                startActivity(intent);
            } else {
                //TODO 根据返回信息给用户友好的提示
                Toast.makeText(this, "用户名或者密码错误！", Toast.LENGTH_LONG).show();
            }

        } else if (v.getId() == R.id.login_regist) {
            Intent intent = new Intent();
            intent.setClassName("gfour.zucc.com.wanglema", "gfour.zucc.com.wanglema.system.RegistActivity");
            startActivity(intent);
        }
    }
}
