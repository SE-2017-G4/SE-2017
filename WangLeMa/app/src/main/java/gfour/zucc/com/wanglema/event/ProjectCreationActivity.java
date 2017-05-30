package gfour.zucc.com.wanglema.event;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import gfour.zucc.com.wanglema.R;
import gfour.zucc.com.wanglema.Util.SysApplication;
import gfour.zucc.com.wanglema.control.ProjectManager;
import gfour.zucc.com.wanglema.model.BeanProject;

/**
 * Created by Administrator on 2017/5/26.
 */

public class ProjectCreationActivity extends Activity implements View.OnClickListener {

    public static final int PROJECTCREATION_RESULTCODE = 11110;

    private ImageView itemcreation_back;
    private EditText itemcreation_projectname;
    private Button itemcreation_complete;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projectcreation);
        SysApplication.getInstance().addActivity(this);

        itemcreation_back = (ImageView) findViewById(R.id.itemcreation_back);
        itemcreation_projectname = (EditText) findViewById(R.id.itemcreation_projectname);
        itemcreation_complete = (Button) findViewById(R.id.itemcreation_complete);

        itemcreation_back.setOnClickListener(this);
        itemcreation_complete.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.itemcreation_back) {
            finish();
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        } else if (v.getId() == R.id.itemcreation_complete) {
            //TODO 保存数据 返回

            Intent intent = new Intent();

            ProjectManager projectManager = new ProjectManager();
            BeanProject beanProject = new BeanProject();
            beanProject.setProjectName(itemcreation_projectname.getText().toString());
            if (projectManager.add(getApplicationContext(),beanProject)){
                Toast.makeText(getApplicationContext(),"添加成功",Toast.LENGTH_LONG).show();
                intent.putExtra("projectid",projectManager.getMaxProjectId(getApplicationContext()));
                intent.putExtra("projectname",beanProject.getProjectName());
                setResult(PROJECTCREATION_RESULTCODE,intent);
            }else {
                Toast.makeText(getApplicationContext(),"添加失败，请重试",Toast.LENGTH_LONG).show();
                setResult(PROJECTCREATION_RESULTCODE);
            }

            finish();
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        }
    }
}
