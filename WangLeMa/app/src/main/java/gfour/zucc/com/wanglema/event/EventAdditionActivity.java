package gfour.zucc.com.wanglema.event;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.TimePickerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import gfour.zucc.com.wanglema.R;
import gfour.zucc.com.wanglema.Util.SysApplication;
import gfour.zucc.com.wanglema.control.EventManager;
import gfour.zucc.com.wanglema.control.TimeManager;
import gfour.zucc.com.wanglema.model.BeanEvent;
import gfour.zucc.com.wanglema.model.BeanTime;

import static android.R.attr.format;


/**
 * Created by Administrator on 2017/5/26.
 */

public class EventAdditionActivity extends Activity implements View.OnClickListener {

    private final int ALARMFLAG = 1;
    private final int VOICEFLAG = 2;
    private final int DRAWABLEFLAG = 3;
    public final int EVENTADDITIONRE_QUESTCODE = 110;
    private int eventFlag;

    private int level = 2;//重要级别
    private int startsyn = 0;
    private int endsyn = 0;
    private int alarmsyn = 0;

    private String passWord;
    private boolean ifpassWord = false;
    private int projectId = -1;
    private String projectName = null;

    Calendar startCalendar = Calendar.getInstance();
    Calendar endCalendar = Calendar.getInstance();
    Calendar rangCalendar = Calendar.getInstance();
    Calendar alarmCalendar = Calendar.getInstance();
    List<BeanTime> timeList = new ArrayList<BeanTime>();

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    private ImageView eventaddition_back;
    private ImageView eventaddition_voice;
    private EditText eventaddition_eventinfo;
    private Button eventaddition_darawable;
    private TextView eventaddition_setting;
    private TextView eventaddition_project;
    private RelativeLayout eventaddition_importent;
    private RelativeLayout eventaddition_common;
    private Button eventaddition_cancel;
    private Button eventaddition_complete;
    private RelativeLayout eventaddition_unimportent;
    private LinearLayout eventaddition_starttime;
    private LinearLayout eventaddition_endtime;
    private TextView eventaddition_tv_starttime;
    private TextView eventaddition_tv_endtime;
    private TextView eventaddition_remindinfo;
    private Button eventaddition_setpwd;
    private ListView eventaddition_lv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventaddition);
        SysApplication.getInstance().addActivity(this);


        eventaddition_back = (ImageView) findViewById(R.id.eventaddition_back);
        eventaddition_voice = (ImageView) findViewById(R.id.eventaddition_voice);
        eventaddition_eventinfo = (EditText) findViewById(R.id.eventaddition_eventinfo);
        eventaddition_darawable = (Button) findViewById(R.id.eventaddition_darawable);
        eventaddition_remindinfo = (TextView) findViewById(R.id.eventaddition_remindinfo);
        eventaddition_setting = (TextView) findViewById(R.id.eventaddition_setting);
        eventaddition_project = (TextView) findViewById(R.id.eventaddition_project);
        eventaddition_importent = (RelativeLayout) findViewById(R.id.eventaddition_importent);
        eventaddition_common = (RelativeLayout) findViewById(R.id.eventaddition_common);
        eventaddition_unimportent = (RelativeLayout) findViewById(R.id.eventaddition_unimportent);
        eventaddition_starttime = (LinearLayout) findViewById(R.id.eventaddition_starttime);
        eventaddition_tv_starttime = (TextView) findViewById(R.id.eventaddition_tv_starttime);
        //默认无
        eventaddition_tv_starttime.setText("");
        eventaddition_endtime = (LinearLayout) findViewById(R.id.eventaddition_endtime);
        eventaddition_tv_endtime = (TextView) findViewById(R.id.eventaddition_tv_endtime);
        //默认无
        eventaddition_tv_endtime.setText("");
        eventaddition_cancel = (Button) findViewById(R.id.eventaddition_cancel);
        eventaddition_complete = (Button) findViewById(R.id.eventaddition_complete);
        eventaddition_setpwd = (Button) findViewById(R.id.eventaddition_setpwd);
        eventaddition_lv = (ListView) findViewById(R.id.eventaddition_lv);


        eventaddition_back.setOnClickListener(this);
        eventaddition_voice.setOnClickListener(this);
        eventaddition_darawable.setOnClickListener(this);
        eventaddition_starttime.setOnClickListener(this);
        eventaddition_endtime.setOnClickListener(this);
        eventaddition_setting.setOnClickListener(this);
        eventaddition_project.setOnClickListener(this);
        eventaddition_importent.setOnClickListener(this);
        eventaddition_common.setOnClickListener(this);
        eventaddition_unimportent.setOnClickListener(this);
        eventaddition_cancel.setOnClickListener(this);
        eventaddition_complete.setOnClickListener(this);
        eventaddition_remindinfo.setOnClickListener(this);
        eventaddition_setpwd.setOnClickListener(this);
        eventaddition_setpwd.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (ifpassWord == true) {
                    new AlertDialog.Builder(EventAdditionActivity.this).setTitle("系统提示")//设置对话框标题
                            .setMessage("是否要删除密码")//设置显示的内容
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {//添加确定按钮
                                @Override
                                public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件
                                    ifpassWord = false;
                                    passWord = null;
                                    Log.i("alertdialog", " 删除密码");
                                }
                            }).setNegativeButton("取消", new DialogInterface.OnClickListener() {//添加返回按钮
                        @Override
                        public void onClick(DialogInterface dialog, int which) {//响应事件
                            Log.i("alertdialog", " 取消删除！");
                        }
                    }).show();//在按键响应事件中显示此对话框
                }
                return true;
            }
        });
        eventaddition_lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                new AlertDialog.Builder(EventAdditionActivity.this).setTitle("系统提示")//设置对话框标题
                        .setMessage("是否要删除该项")//设置显示的内容
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {//添加确定按钮
                            @Override
                            public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件
                                timeList.remove(position);
                                eventaddition_lv.setAdapter(new myAdapter());
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {//添加返回按钮
                    @Override
                    public void onClick(DialogInterface dialog, int which) {//响应事件
                        Log.i("alertdialog", " 取消删除");
                    }
                }).show();//在按键响应事件中显示此对话框

                return true;
            }
        });

    }

    @Override
    public void onClick(View v) {
        //返回上级菜单
        if (v.getId() == R.id.eventaddition_back) {
            finish();
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }

        //调用语音输入
        else if (v.getId() == R.id.eventaddition_voice) {
            //TODO 语音模块
        }

        //调用画板
        else if (v.getId() == R.id.eventaddition_darawable) {
            //TODO 画板模块
            Intent intent = new Intent();
            intent.setClassName("gfour.zucc.com.wanglema", "gfour.zucc.com.wanglema.event.DrawableActivity");
            startActivity(intent);
        }

        //获得事件开始时间
        else if (v.getId() == R.id.eventaddition_starttime) {
            //TODO 调用PickerView 年、月、日、时、分
            //时间选择器
            TimePickerView pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                @Override
                public void onTimeSelect(Date date, View v) {
                    //选中事件回调

                    startCalendar.setTime(date);
                    rangCalendar.setTime(date);
                    rangCalendar.add(Calendar.YEAR, 20);
                    System.out.println("startCalendar:" + startCalendar);
                    System.out.println("rangCalendar:" + rangCalendar);

                    startsyn = 1;

                    eventaddition_tv_starttime.setText(format.format(date));

                }
            })
                    .setOutSideCancelable(true)//点范围外取消显示
                    .setTitleText("设置事件开始时间")
                    .isCenterLabel(false)
                    .setType(new boolean[]{true, true, true, true, true, false})
                    .setLabel("年", "月", "日", "点", "分", "")
                    .setCancelText("取消")//取消按钮文字
                    .setSubmitText("确定")//确认按钮文字
                    .build();
            //注：根据需求来决定是否使用该方法（一般是精确到秒的情况），
            // 此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
            pvTime.setDate(Calendar.getInstance());
            pvTime.show();
        }

        //获得事件结束时间
        else if (v.getId() == R.id.eventaddition_endtime) {
            //TODO 调用PickerView 年、月、日、时、分
            //时间选择器
            TimePickerView pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                @Override
                public void onTimeSelect(Date date, View v) {
                    //选中事件回调
                    endCalendar.setTime(date);
                    if (endCalendar.before(startCalendar)) {
                        Toast.makeText(getApplicationContext(), "结束时间在开始时间之前！", Toast.LENGTH_LONG).show();
                        return;
                    }

                    endsyn = 1;

                    eventaddition_tv_endtime.setText(format.format(date));

                }
            })
                    .setOutSideCancelable(true)//点范围外取消显示
                    .setTitleText("设置事件结束时间")
                    .isCenterLabel(false)
                    .setRangDate(startCalendar, rangCalendar)
                    .setType(new boolean[]{true, true, true, true, true, false})
                    .setLabel("年", "月", "日", "点", "分", "")
                    .setCancelText("取消")//取消按钮文字
                    .setSubmitText("确定")//确认按钮文字
                    .build();
            //注：根据需求来决定是否使用该方法（一般是精确到秒的情况），
            // 此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
            pvTime.setDate(Calendar.getInstance());
            pvTime.show();
        }

        //TODO 设置密码
        else if (v.getId() == R.id.eventaddition_setpwd) {
            final EditText inputServer = new EditText(this);
            inputServer.setFocusable(true);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("设置密码").setView(inputServer).setNegativeButton(
                    "取消", null);
            builder.setPositiveButton("保存",
                    new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            ifpassWord = true;
                            passWord = inputServer.getText().toString();
                        }
                    });
            builder.show();
        }

        //调用提醒设置
        else if (v.getId() == R.id.eventaddition_setting) {
            //TODO
            if (startsyn == 1 && endsyn == 1) {
                //时间选择器
                TimePickerView pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        //选中事件回调

                        alarmCalendar.setTime(date);
                        if (alarmCalendar.after(endCalendar)) {
                            Toast.makeText(getApplicationContext(), "提醒时间在结束时间之后！", Toast.LENGTH_LONG).show();
                            return;
                        }
                        alarmsyn++;
                        eventFlag = ALARMFLAG;
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(date);
                        BeanTime beanTime = new BeanTime();
                        beanTime.setWarn(calendar);
                        timeList.add(beanTime);

                        //下方ListView要加一条
                        eventaddition_lv.setAdapter(new myAdapter());

                    }
                })
                        .setOutSideCancelable(true)//点范围外取消显示
                        .setTitleText("设置提醒时间")
                        .isCenterLabel(false)
                        .setRangDate(startCalendar, rangCalendar)
                        .setType(new boolean[]{true, true, true, true, true, false})
                        .setLabel("年", "月", "日", "点", "分", "")
                        .setCancelText("取消")//取消按钮文字
                        .setSubmitText("确定")//确认按钮文字
                        .build();
                //注：根据需求来决定是否使用该方法（一般是精确到秒的情况），
                // 此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
                pvTime.setDate(Calendar.getInstance());
                pvTime.show();
            } else {
                Toast.makeText(getApplicationContext(), "请先选择开始时间和结束时间", Toast.LENGTH_LONG).show();
            }
        }

        //跳转到项目选择界面
        else if (v.getId() == R.id.eventaddition_project) {
            Intent intent = new Intent();
            intent.setClassName("gfour.zucc.com.wanglema", "gfour.zucc.com.wanglema.event.ProjectSettingActivity");
            startActivityForResult(intent, EVENTADDITIONRE_QUESTCODE);
        }

        //选择以后设置优先级 ，并且更改背景变亮！
        else if (v.getId() == R.id.eventaddition_importent) {
            level = 3;
            eventaddition_importent.setBackgroundColor(Color.parseColor("#FFCC66"));
            eventaddition_common.setBackgroundColor(Color.parseColor("#FFFFFF"));
            eventaddition_unimportent.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }

        //选择以后设置优先级 ，并且更改背景变亮！
        else if (v.getId() == R.id.eventaddition_common) {
            level = 2;
            eventaddition_common.setBackgroundColor(Color.parseColor("#FFCC66"));
            eventaddition_importent.setBackgroundColor(Color.parseColor("#FFFFFF"));
            eventaddition_unimportent.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }

        //选择以后设置优先级 ，并且更改背景变亮！
        else if (v.getId() == R.id.eventaddition_unimportent) {
            level = 1;
            eventaddition_unimportent.setBackgroundColor(Color.parseColor("#FFCC66"));
            eventaddition_importent.setBackgroundColor(Color.parseColor("#FFFFFF"));
            eventaddition_common.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }

        //取消 返回 不保存
        else if (v.getId() == R.id.eventaddition_cancel) {
            finish();
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }

        //完成 返回 保存
        else if (v.getId() == R.id.eventaddition_complete) {
            //TODO 保存操作

            EventManager eventManager = new EventManager();
            TimeManager timeManager = new TimeManager();
            BeanTime beanTime = catchTimeInfo();
            if (eventManager.add(getApplicationContext(), catchEventInfo())) {
                Toast.makeText(getApplicationContext(), "添加成功", Toast.LENGTH_LONG).show();
                int eventId = eventManager.getMaxEventId(getApplicationContext());
                for (BeanTime addTime : timeList) {
                    addTime.setEventId(eventId);
                    timeManager.add(getApplicationContext(), addTime);
                }

            } else {
                Toast.makeText(getApplicationContext(), "添加失败", Toast.LENGTH_LONG).show();
            }

            finish();
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }

    }

    private BeanEvent catchEventInfo() {
        BeanEvent beanEvent = new BeanEvent();

        beanEvent.setEventContext(eventaddition_eventinfo.getText().toString());
        beanEvent.setEventBegin(startCalendar);
        beanEvent.setEventEnd(endCalendar);
        beanEvent.setEventLevel(level);
        beanEvent.setEventPwd(passWord);
        if (projectId != -1) {
            beanEvent.setProjectId(projectId);
        }
        beanEvent.setEventIsSuccess(false);

        return beanEvent;
    }

    private BeanTime catchTimeInfo() {
        BeanTime beanTime = new BeanTime();

        beanTime.setWarn(alarmCalendar);

        return beanTime;
    }

    private class myAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return timeList.size();
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
                view = View.inflate(getApplicationContext(), R.layout.item_additionalarm, null);
            } else {
                view = convertView;
            }
            if (eventFlag == ALARMFLAG) {
                TextView item_additionalarm_word = (TextView) view.findViewById(R.id.item_additionalarm_word);
                TextView item_additionalarm_time = (TextView) view.findViewById(R.id.item_additionalarm_time);
                item_additionalarm_time.setText(format.format(timeList.get(position).getWarn().getTime()));
            } else if (eventFlag == VOICEFLAG) {

            } else if (eventFlag == DRAWABLEFLAG) {

            }

            return view;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == EVENTADDITIONRE_QUESTCODE) {
            if (data != null) {
                if ((projectId = Integer.valueOf(data.getStringExtra("projectid"))) != -1) {
                    projectName = data.getStringExtra("projectname");
                    eventaddition_project.setText(projectName);
                }else {
                    eventaddition_project.setText("设置项目");
                }
            }else {
                projectId = -1;
                eventaddition_project.setText("设置项目");
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
