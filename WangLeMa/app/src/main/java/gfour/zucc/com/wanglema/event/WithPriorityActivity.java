package gfour.zucc.com.wanglema.event;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import gfour.zucc.com.wanglema.R;
import gfour.zucc.com.wanglema.Util.SysApplication;

/**
 * Created by Administrator on 2017/5/22.
 */

public class WithPriorityActivity extends Activity implements View.OnClickListener{

    private ImageView withpriority_back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withpriority);
        SysApplication.getInstance().addActivity(this);

        withpriority_back = (ImageView) findViewById(R.id.withpriority_back);

        withpriority_back.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.withpriority_back){
            finish();
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        }
    }
}
