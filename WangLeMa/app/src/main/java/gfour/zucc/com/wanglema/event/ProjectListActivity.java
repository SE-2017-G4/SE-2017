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
 * Created by Administrator on 2017/5/26.
 */

public class ProjectListActivity extends Activity implements View.OnClickListener {

    private int pageView =1;
    private static String returnView;

    private ImageView itemlist_back;
    private ImageView itemlist_add;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projectlist);
        SysApplication.getInstance().addActivity(this);

        Intent recever = getIntent();
        if (pageView == 1) {
            returnView = recever.getStringExtra("return");
        }else {
            pageView = 1;
        }


        itemlist_back = (ImageView) findViewById(R.id.itemlist_back);
        itemlist_add = (ImageView) findViewById(R.id.itemlist_add);

        itemlist_back.setOnClickListener(this);
        itemlist_add.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.itemlist_back){
            finish();
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        }else if (v.getId() == R.id.itemlist_add){
            Intent intent = new Intent();
            intent.setClassName("gfour.zucc.com.wanglema", "gfour.zucc.com.wanglema.event.ProjectCreationActivity");
            startActivity(intent);
        }
    }
}
