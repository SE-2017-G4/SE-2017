package gfour.zucc.com.wanglema.event;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import gfour.zucc.com.wanglema.R;
import gfour.zucc.com.wanglema.Util.SysApplication;
import gfour.zucc.com.wanglema.control.ProjectManager;
import gfour.zucc.com.wanglema.model.BeanProject;

import static gfour.zucc.com.wanglema.R.id.item_projectlist_word;

/**
 * Created by Administrator on 2017/5/26.
 */

public class ProjectSettingActivity extends Activity implements View.OnClickListener {

    public static final int PROJECTSETTING_RESULTCODE = 1110;
    public static final int PROJECTSETTING_REQUESTCODE = 1111;

    List<BeanProject> projectList = new ArrayList<BeanProject>();
    List colorList = new ArrayList();

    private int resultOfProjectId = -1;
    private RelativeLayout chooseRel = null;
    private int chooseProjectId = -1;
    private String chooseProjectName = null;

    private ImageView projectsetting_back;
    private LinearLayout projectsetting_additem;
    private LinearLayout projectsetting_noitem;
    private ListView projectsetting_lv;
    private Button projectsetting_ok;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projectsetting);
        SysApplication.getInstance().addActivity(this);


        projectsetting_back = (ImageView) findViewById(R.id.projectsetting_back);
        projectsetting_additem = (LinearLayout) findViewById(R.id.projectsetting_additem);
        projectsetting_noitem = (LinearLayout) findViewById(R.id.projectsetting_noitem);
        projectsetting_lv = (ListView) findViewById(R.id.projectsetting_lv);
        projectsetting_ok = (Button) findViewById(R.id.projectsetting_ok);

        projectsetting_back.setOnClickListener(this);
        projectsetting_additem.setOnClickListener(this);
        projectsetting_noitem.setOnClickListener(this);
        projectsetting_ok.setOnClickListener(this);

        projectsetting_additem.setFocusable(true);
        projectsetting_additem.setFocusableInTouchMode(true);
        projectsetting_additem.requestFocus();

        getProjectList();//获得项目列表
        projectsetting_lv.setAdapter(new myAdapter());
        projectsetting_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (chooseRel != null) {
                    chooseRel.setBackgroundResource(R.color.gray);
                }

                RelativeLayout item_additionalarm_relative = (RelativeLayout) view.findViewById(R.id.item_additionalarm_relative);
                item_additionalarm_relative.setBackgroundResource(R.color.choose);
                chooseRel = item_additionalarm_relative;
                chooseProjectId = projectList.get(position).getProjectId();
                System.out.println("getprojectid:"+chooseProjectId);
                chooseProjectName = projectList.get(position).getProjectName();

            }
        });


    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.projectsetting_back) {
            //返回 无结果
            setResult(PROJECTSETTING_RESULTCODE);
            finish();
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        } else if (v.getId() == R.id.projectsetting_additem) {

            Intent intent = new Intent();
            intent.setClassName("gfour.zucc.com.wanglema", "gfour.zucc.com.wanglema.event.ProjectCreationActivity");
            startActivityForResult(intent, PROJECTSETTING_REQUESTCODE);

        } else if (v.getId() == R.id.projectsetting_noitem) {
            //返回 无结果
            setResult(PROJECTSETTING_RESULTCODE);

            finish();
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        } else if (v.getId() == R.id.projectsetting_ok) {
            //返回值 并且finish

            Intent intent = new Intent();
            intent.putExtra("projectid", String.valueOf(chooseProjectId));
            intent.putExtra("projectname", chooseProjectName);

            setResult(PROJECTSETTING_RESULTCODE, intent);

            finish();
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == PROJECTSETTING_REQUESTCODE) {
            if (data != null) {
                //更新一下表
                getProjectList();
                //更新一下lv
                projectsetting_lv.setAdapter(new myAdapter());
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void getProjectList() {
        ProjectManager projectManager = new ProjectManager();
        projectList = projectManager.loadAll(getApplicationContext());

    }

    private class myAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return projectList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view;
            if (convertView == null) {
                view = View.inflate(getApplicationContext(), R.layout.item_projectlist, null);
            } else {
                view = convertView;
            }

            TextView item_projectlist_word = (TextView) view.findViewById(R.id.item_projectlist_word);
            item_projectlist_word.setText(projectList.get(position).getProjectName());

            return view;
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
