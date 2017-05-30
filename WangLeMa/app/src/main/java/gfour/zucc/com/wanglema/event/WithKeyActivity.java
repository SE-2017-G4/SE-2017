package gfour.zucc.com.wanglema.event;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import gfour.zucc.com.wanglema.R;
import gfour.zucc.com.wanglema.Util.SysApplication;

/**
 * Created by Administrator on 2017/5/25.
 */

public class WithKeyActivity extends Activity implements View.OnClickListener{

    private ImageView withkey_back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withkey);
        SysApplication.getInstance().addActivity(this);

        withkey_back = (ImageView) findViewById(R.id.withkey_back);

        withkey_back.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.withkey_back){
            finish();
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        }
    }
}
