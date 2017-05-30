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

public class SettingActivity extends Activity implements View.OnClickListener {

    private ImageView setting_back;
    private TextView setting_alarm;
    private TextView setting_background;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        SysApplication.getInstance().addActivity(this);

        setting_back = (ImageView) findViewById(R.id.setting_back);
        setting_alarm = (TextView) findViewById(R.id.setting_alarm);
        setting_background = (TextView) findViewById(R.id.setting_background);

        setting_back.setOnClickListener(this);
        setting_alarm.setOnClickListener(this);
        setting_background.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.setting_back){
            finish();
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        }else if (v.getId() == R.id.setting_alarm){
            Intent intent = new Intent();
            intent.setClassName("gfour.zucc.com.wanglema", "gfour.zucc.com.wanglema.system.AlarmSettingActivity");
            startActivity(intent);
        }else if (v.getId() == R.id.setting_background){
            Intent intent = new Intent();
            intent.setClassName("gfour.zucc.com.wanglema", "gfour.zucc.com.wanglema.system.BackgroundSettingActivity");
            startActivity(intent);
        }

    }
}
