package gfour.zucc.com.wanglema.event;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import gfour.zucc.com.wanglema.MainActivity;
import gfour.zucc.com.wanglema.R;
import gfour.zucc.com.wanglema.Util.SysApplication;

/**
 * Created by Administrator on 2017/5/26.
 */

public class EventListActivity extends Activity implements View.OnClickListener {

    private ImageView eventlist_back;
    private TextView eventlist_tocalendar;
    private TextView eventlist_week;
    private ListView eventlist_lv;
    private ImageView eventlist_add;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventlist);
        SysApplication.getInstance().addActivity(this);

        eventlist_back = (ImageView) findViewById(R.id.eventlist_back);
        eventlist_tocalendar = (TextView) findViewById(R.id.eventlist_tocalendar);
        eventlist_week = (TextView) findViewById(R.id.eventlist_week);
        eventlist_lv = (ListView) findViewById(R.id.eventlist_lv);
        eventlist_add = (ImageView) findViewById(R.id.eventlist_add);


        eventlist_back.setOnClickListener(this);
        eventlist_tocalendar.setOnClickListener(this);
        eventlist_add.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.eventlist_back) {
            finish();
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        } else if (v.getId() == R.id.eventlist_tocalendar) {
            Intent intent = new Intent();
            intent.setClassName("gfour.zucc.com.wanglema", "gfour.zucc.com.wanglema.event.EventCalendarActivity");
            startActivity(intent);
        } else if (v.getId() == R.id.eventlist_add) {
            Intent intent = new Intent();
            intent.setClassName("gfour.zucc.com.wanglema", "gfour.zucc.com.wanglema.event.EventAdditionActivity");
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
}
