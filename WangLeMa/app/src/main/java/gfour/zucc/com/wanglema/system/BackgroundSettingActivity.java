package gfour.zucc.com.wanglema.system;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import gfour.zucc.com.wanglema.R;
import gfour.zucc.com.wanglema.Util.SysApplication;

/**
 * Created by Administrator on 2017/5/26.
 */

public class BackgroundSettingActivity extends Activity implements View.OnClickListener {

    private ImageView backgroundsetting_back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backgroundsetting);
        SysApplication.getInstance().addActivity(this);

        backgroundsetting_back = (ImageView) findViewById(R.id.backgroundsetting_back);

        backgroundsetting_back.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.backgroundsetting_back){
            finish();
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        }
    }
}
