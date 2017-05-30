package gfour.zucc.com.wanglema.system;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import gfour.zucc.com.wanglema.R;
import gfour.zucc.com.wanglema.Util.SysApplication;

/**
 * Created by Administrator on 2017/5/26.
 */

public class RegistActivity extends Activity implements View.OnClickListener {

    private ImageView regist_back;
    private TextView regist_username;
    private TextView regist_password;
    private TextView regist_repassword;
    private ImageView regist_regist;
    private TextView regist_return;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        SysApplication.getInstance().addActivity(this);

        regist_back = (ImageView) findViewById(R.id.regist_back);
        regist_username = (TextView) findViewById(R.id.regist_username);
        regist_password = (TextView) findViewById(R.id.regist_password);
        regist_repassword = (TextView) findViewById(R.id.regist_repassword);
        regist_regist = (ImageView) findViewById(R.id.regist_regist);
        regist_return = (TextView) findViewById(R.id.regist_return);

        regist_back.setOnClickListener(this);
        regist_regist.setOnClickListener(this);
        regist_return.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.regist_back){
            finish();
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        }else if (v.getId() == R.id.regist_regist){
            //TODO 此处添加注册操作

            finish();
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        }else if (v.getId() == R.id.regist_return){
            finish();
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        }

    }
}
