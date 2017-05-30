package gfour.zucc.com.wanglema.note;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import gfour.zucc.com.wanglema.R;
import gfour.zucc.com.wanglema.Util.SysApplication;

/**
 * Created by Administrator on 2017/5/21.
 */

public class NoteHomeActivity extends Activity implements View.OnClickListener {

    private ImageView notehome_back;
    private ImageView notehome_add;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //加载布局
        setContentView(R.layout.activity_nodehome);
        SysApplication.getInstance().addActivity(this);

        notehome_back = (ImageView) findViewById(R.id.notehome_back);
        notehome_add = (ImageView) findViewById(R.id.notehome_add);

        notehome_back.setOnClickListener(this);
        notehome_add.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.notehome_back) {
            finish();
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        } else if (v.getId() == R.id.notehome_add) {
            Intent intet = new Intent();
            intet.setClassName("gfour.zucc.com.wanglema", "gfour.zucc.com.wanglema.note.NoteEditActivity");
            startActivity(intet);
        }
    }
}
