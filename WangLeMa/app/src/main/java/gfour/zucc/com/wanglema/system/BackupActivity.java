package gfour.zucc.com.wanglema.system;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import gfour.zucc.com.wanglema.R;
import gfour.zucc.com.wanglema.Util.SysApplication;

/**
 * Created by Administrator on 2017/5/26.
 */

public class BackupActivity extends Activity implements View.OnClickListener {

    private ImageView backup_back;
    private ImageView backup_backup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backup);
        SysApplication.getInstance().addActivity(this);

        backup_back = (ImageView) findViewById(R.id.backup_back);
        backup_backup = (ImageView) findViewById(R.id.backup_backup);

        backup_backup.setOnClickListener(this);
        backup_back.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.backup_back){
            finish();
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        }else if (v.getId() == R.id.backup_backup){
            //TODO 调用备份操作

            if (true){
                Toast.makeText(getApplicationContext(),"备份成功！",Toast.LENGTH_LONG).show();
            }

        }
    }
}
