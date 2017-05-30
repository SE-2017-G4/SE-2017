package gfour.zucc.com.wanglema.note;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import gfour.zucc.com.wanglema.R;
import gfour.zucc.com.wanglema.Util.SysApplication;

/**
 * Created by Administrator on 2017/5/21.
 */

public class NoteEditActivity extends Activity implements View.OnClickListener {

    private ImageView noteedit_back;
    private Button noteedit_cancel;
    private Button noteedit_ensure;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noteedit);
        SysApplication.getInstance().addActivity(this);

        noteedit_back = (ImageView) findViewById(R.id.noteedit_back);
        noteedit_cancel = (Button) findViewById(R.id.noteedit_cancel);
        noteedit_ensure = (Button) findViewById(R.id.noteedit_ensure);

        noteedit_back.setOnClickListener(this);
        noteedit_cancel.setOnClickListener(this);
        noteedit_ensure.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.noteedit_back) {

            //TODO 这里有一步保存

            //
            // System.out.println("保存便签");

            finish();
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        } else if (v.getId() == R.id.noteedit_cancel) {
            finish();
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        } else if (v.getId() == R.id.noteedit_ensure) {
            //TODO 这里有一步保存

            finish();
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        }
    }
}
