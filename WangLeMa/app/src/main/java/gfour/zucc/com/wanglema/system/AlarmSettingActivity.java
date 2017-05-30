package gfour.zucc.com.wanglema.system;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import gfour.zucc.com.wanglema.R;
import gfour.zucc.com.wanglema.Util.SysApplication;

/**
 * Created by Administrator on 2017/5/26.
 */

public class AlarmSettingActivity extends Activity implements View.OnClickListener {

    private ImageView alarmsetting_back;
    private CheckBox alarmsetting_vibrate;
    private CheckBox alarmsetting_ring;
    private TextView alarmsetting_ringname;
    private Button alarmsetting_choose;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarmsetting);
        SysApplication.getInstance().addActivity(this);


        alarmsetting_back = (ImageView) findViewById(R.id.alarmsetting_back);
        alarmsetting_vibrate = (CheckBox) findViewById(R.id.alarmsetting_vibrate);
        alarmsetting_ring = (CheckBox) findViewById(R.id.alarmsetting_ring);
        alarmsetting_ringname = (TextView) findViewById(R.id.alarmsetting_ringname);
        alarmsetting_choose = (Button) findViewById(R.id.alarmsetting_choose);

        alarmsetting_back.setOnClickListener(this);
        alarmsetting_choose.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.alarmsetting_back){
            finish();
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        }else if (v.getId() == R.id.alarmsetting_choose){
            //TODO 此处弹出选择框
        }
    }
}
