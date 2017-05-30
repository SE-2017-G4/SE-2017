package gfour.zucc.com.wanglema.event;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import gfour.zucc.com.wanglema.MainActivity;
import gfour.zucc.com.wanglema.R;
import gfour.zucc.com.wanglema.Util.SysApplication;

import static android.R.transition.fade;

/**
 * Created by Administrator on 2017/5/25.
 */

public class EventCalendarActivity extends Activity implements View.OnClickListener {

    private ImageView eventcalendar_back;
    private ImageView eventcalendar_seeotherday;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventcalendar);
        SysApplication.getInstance().addActivity(this);

        eventcalendar_back = (ImageView) findViewById(R.id.eventcalendar_back);
        eventcalendar_seeotherday = (ImageView) findViewById(R.id.eventcalendar_seeotherday);

        eventcalendar_back.setOnClickListener(this);
        eventcalendar_seeotherday.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.eventcalendar_back) {
            finish();
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        } else if (v.getId() == R.id.eventcalendar_seeotherday) {
            Intent intent = new Intent();
            intent.setClassName("gfour.zucc.com.wanglema", "gfour.zucc.com.wanglema.event.SeeOtherDayActicity");
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
