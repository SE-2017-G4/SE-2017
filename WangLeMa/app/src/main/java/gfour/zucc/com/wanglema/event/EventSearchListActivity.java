package gfour.zucc.com.wanglema.event;

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
 * Created by Administrator on 2017/5/21.
 */

public class EventSearchListActivity extends Activity implements View.OnClickListener {

    private ImageView geteventlist_back;
    private TextView geteventlist_withitem;
    private TextView geteventlist_withkey;
    private TextView geteventlist_withpriority;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventsearchlist);
        SysApplication.getInstance().addActivity(this);

        geteventlist_back = (ImageView) findViewById(R.id.geteventlist_back);
        geteventlist_withitem = (TextView) findViewById(R.id.geteventlist_withitem);
        geteventlist_withkey = (TextView) findViewById(R.id.geteventlist_withkey);
        geteventlist_withpriority = (TextView) findViewById(R.id.geteventlist_withpriority);

        geteventlist_back.setOnClickListener(this);
        geteventlist_withitem.setOnClickListener(this);
        geteventlist_withkey.setOnClickListener(this);
        geteventlist_withpriority.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.geteventlist_back) {
            finish();
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        } else if (v.getId() == R.id.geteventlist_withitem){
            Intent intent = new Intent();
            intent.setClassName("gfour.zucc.com.wanglema", "gfour.zucc.com.wanglema.event.WithProjectActivity");
            startActivity(intent);
        }
        else if (v.getId() == R.id.geteventlist_withkey){
            Intent intent = new Intent();
            intent.setClassName("gfour.zucc.com.wanglema", "gfour.zucc.com.wanglema.event.WithKeyActivity");
            startActivity(intent);
        }
        else if (v.getId() == R.id.geteventlist_withpriority){
            Intent intent = new Intent();
            intent.setClassName("gfour.zucc.com.wanglema", "gfour.zucc.com.wanglema.event.WithPriorityActivity");
            startActivity(intent);
        }
    }
}
