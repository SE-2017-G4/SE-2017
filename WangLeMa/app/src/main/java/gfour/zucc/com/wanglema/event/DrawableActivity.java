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
 * Created by Administrator on 2017/5/27.
 */

public class DrawableActivity extends Activity implements View.OnClickListener {

    private ImageView drawable_back;
    private ImageView drawable_add;
    private ImageView drawable_complete;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable);
        SysApplication.getInstance().addActivity(this);

        drawable_back = (ImageView) findViewById(R.id.drawable_back);
        drawable_add = (ImageView) findViewById(R.id.drawable_add);
        drawable_complete = (ImageView) findViewById(R.id.drawable_complete);

        drawable_back.setOnClickListener(this);
        drawable_add.setOnClickListener(this);
        drawable_complete.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.drawable_back){
            finish();
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        }else if (v.getId() == R.id.drawable_add){

        }else if (v.getId() == R.id.drawable_complete){
            //TODO 涂鸦的保存操作

            finish();
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        }
    }
}
