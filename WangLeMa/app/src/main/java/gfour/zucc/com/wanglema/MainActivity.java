package gfour.zucc.com.wanglema;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import gfour.zucc.com.wanglema.Util.MyOpenHelper;
import gfour.zucc.com.wanglema.Util.SysApplication;

import static android.R.id.list;
import static gfour.zucc.com.wanglema.R.id.main_torecycle;

public class MainActivity extends Activity implements View.OnClickListener {

    //退出时的时间
    private long mExitTime;
    private MyOpenHelper myOpenHelper ;
    //MAIN方法请求码
    public static final int MAIN_REQUESTCODE = 1;
    private Button main_tonote;
    private Button main_tocalendar;
    private ImageView main_showleftmenu;
    private SlidingMenu menu;
    private ImageView main_torecycle;
    private TextView leftmenu_eventcalendar;
    private TextView leftmenu_geteventlist;
    private TextView leftmenu_recycle;
    private TextView leftmenu_setting;
    private TextView leftmenu_backup;
    private Button main_toevent;
    private TextView leftmenu_itemlist;
    private SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        SysApplication.getInstance().addActivity(this);

        //设置左侧滑动菜单
        setLeftMenu();

        //初始化数据库
        myOpenHelper = new MyOpenHelper(getApplicationContext());
        sqLiteDatabase = myOpenHelper.getWritableDatabase();

        //拿到对象
        main_tonote = (Button) findViewById(R.id.main_tonote);
        main_tocalendar = (Button) findViewById(R.id.main_tocalendar);
        main_showleftmenu = (ImageView) findViewById(R.id.main_showleftmenu);
        main_torecycle = (ImageView) findViewById(R.id.main_torecycle);
        main_toevent = (Button) findViewById(R.id.main_toevent);
        leftmenu_eventcalendar = (TextView) menu.getMenu().findViewById(R.id.leftmenu_eventcalendar);
        leftmenu_geteventlist = (TextView) menu.getMenu().findViewById(R.id.leftmenu_geteventlist);
        leftmenu_recycle = (TextView) menu.getMenu().findViewById(R.id.leftmenu_recycle);
        leftmenu_setting = (TextView) menu.getMenu().findViewById(R.id.leftmenu_setting);
        leftmenu_backup = (TextView) menu.getMenu().findViewById(R.id.leftmenu_backup);
        leftmenu_itemlist = (TextView) menu.getMenu().findViewById(R.id.leftmenu_itemlist);


        //设置监听
        main_tonote.setOnClickListener(this);
        main_tocalendar.setOnClickListener(this);
        main_showleftmenu.setOnClickListener(this);
        main_torecycle.setOnClickListener(this);
        main_toevent.setOnClickListener(this);

        leftmenu_eventcalendar.setOnClickListener(this);
        leftmenu_geteventlist.setOnClickListener(this);
        leftmenu_recycle.setOnClickListener(this);
        leftmenu_setting.setOnClickListener(this);
        leftmenu_backup.setOnClickListener(this);
        leftmenu_itemlist.setOnClickListener(this);

    }


    //设置左侧滑动栏
    private void setLeftMenu() {
        //         configure the SlidingMenu
        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.drawable.shadow);

        // 设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        /**
         * SLIDING_WINDOW will include the Title/ActionBar in the content
         * section of the SlidingMenu, while SLIDING_CONTENT does not.
         */
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        //为侧滑菜单设置布局
        menu.setMenu(R.layout.leftmenu);
    }

    @Override
    public void onClick(View v) {

        //便签主页
        if (v.getId() == R.id.main_tonote) {
            Intent intent = new Intent();
            intent.setClassName("gfour.zucc.com.wanglema", "gfour.zucc.com.wanglema.note.NoteHomeActivity");
            startActivity(intent);
        }

        //事件表/日历
        else if (v.getId() == R.id.main_tocalendar) {
            Intent intent = new Intent();
            intent.setClassName("gfour.zucc.com.wanglema", "gfour.zucc.com.wanglema.event.EventCalendarActivity");
            intent.putExtra("return", "gfour.zucc.com.wanglema.MainActivity");
            startActivity(intent);
        }
        //按钮打开左侧菜单
        else if (v.getId() == R.id.main_showleftmenu) {
            menu.showMenu();
        }

        //按钮打开回收站
        else if (v.getId() == R.id.main_torecycle) {
            Intent intent = new Intent();
            intent.setClassName("gfour.zucc.com.wanglema", "gfour.zucc.com.wanglema.system.RecycleActivity");
            startActivity(intent);
        }

        //TODO
        //按钮打开事件表
        else if (v.getId() == R.id.main_toevent) {
            Intent intent = new Intent();
            intent.setClassName("gfour.zucc.com.wanglema", "gfour.zucc.com.wanglema.event.EventListActivity");
            startActivity(intent);
        }

        //左侧菜单打开事件表 / 日历
        else if (v.getId() == R.id.leftmenu_eventcalendar) {
            Intent intent = new Intent();
            intent.setClassName("gfour.zucc.com.wanglema", "gfour.zucc.com.wanglema.event.EventCalendarActivity");
            intent.putExtra("return", "gfour.zucc.com.wanglema.MainActivity");
            startActivity(intent);
        }

        //左侧菜单打开事件清单
        else if (v.getId() == R.id.leftmenu_geteventlist) {
            Intent intent = new Intent();
            intent.setClassName("gfour.zucc.com.wanglema", "gfour.zucc.com.wanglema.event.EventSearchListActivity");
            startActivity(intent);
        }

        //左侧菜单打开回收站
        else if (v.getId() == R.id.leftmenu_recycle) {
            Intent intent = new Intent();
            intent.setClassName("gfour.zucc.com.wanglema", "gfour.zucc.com.wanglema.system.RecycleActivity");
            startActivity(intent);
        }

        //左侧菜单打开设置
        else if (v.getId() == R.id.leftmenu_setting) {
            Intent intent = new Intent();
            intent.setClassName("gfour.zucc.com.wanglema", "gfour.zucc.com.wanglema.system.SettingActivity");
            startActivity(intent);
        }

        //左侧菜单打开备份
        else if (v.getId() == R.id.leftmenu_backup) {

            //TODO 此处是否做判断有没有登陆过


            Intent intent = new Intent();
            intent.setClassName("gfour.zucc.com.wanglema", "gfour.zucc.com.wanglema.system.LoginActivity");
            startActivity(intent);
        }

        //去项目列表
        else if (v.getId() == R.id.leftmenu_itemlist) {
            Intent intent = new Intent();
            intent.setClassName("gfour.zucc.com.wanglema", "gfour.zucc.com.wanglema.event.ProjectListActivity");
            intent.putExtra("return", "gfour.zucc.com.wanglema.MainActivity");
            startActivity(intent);
        }
    }

    //初始化数据库
    private void InitSQL(){
        myOpenHelper = new MyOpenHelper(getApplicationContext());
    }


    //对返回键进行监听
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {

            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void exit() {
        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            Toast.makeText(MainActivity.this, "再按一次退出忘了吗", Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        } else {
            //MyConfig.clearSharePre(this, "users");

            //TODO 调用保存操作
            //save
            SysApplication.getInstance().exit();
        }
    }

}
