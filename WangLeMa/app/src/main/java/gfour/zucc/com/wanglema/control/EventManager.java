package gfour.zucc.com.wanglema.control;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gfour.zucc.com.wanglema.Util.MyOpenHelper;
import gfour.zucc.com.wanglema.model.BeanEvent;

/**
 * Created by Administrator on 2017/5/28.
 */

public class EventManager {

    SQLiteDatabase sqLiteDatabase;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");


    /**
     * 添加事件
     *
     * @param context
     * @param beanEvent
     * @return
     * @author 陈幼安
     * @version V1.0
     */
    public boolean add(Context context, BeanEvent beanEvent) {

        //打开数据库
        sqLiteDatabase = new MyOpenHelper(context).getWritableDatabase();


        //封装进ContentValues
        ContentValues values = new ContentValues();
        values.put("projectid", beanEvent.getProjectId());
        values.put("eventcontext", beanEvent.getEventContext());
        values.put("eventbegin", format.format(beanEvent.getEventBegin().getTime()));
        values.put("eventend", format.format(beanEvent.getEventEnd().getTime()));
        values.put("eventlevel", beanEvent.getEventLevel());
        values.put("eventissuccess", beanEvent.getEventIsSuccess());
        //插入的时候不要eventdeletedate这一项
        if (beanEvent.getEventVoiceSrc() != null) {
            values.put("eventvoicesrc", beanEvent.getEventVoiceSrc());
        }
        if (beanEvent.getEventImgSrc() != null) {
            values.put("eventimgsrc", beanEvent.getEventImgSrc());
        }
        if (beanEvent.getEventPwd() != null) {
            values.put("eventpwd", beanEvent.getEventPwd());
        }

        long event = sqLiteDatabase.insert("event", null, values);

        sqLiteDatabase.close();

        if (event > 0) {
            return true;
        } else {
            return false;
        }

    }


    /**
     * 获取最新添加的事件ID
     *
     * @param context
     * @return
     * @author 陈幼安
     * @version V1.0
     */
    public int getMaxEventId(Context context) {
        sqLiteDatabase = new MyOpenHelper(context).getReadableDatabase();
        int result = -1;

        Cursor cursor = sqLiteDatabase.rawQuery("select max(eventid) from event", null);

        if (cursor.moveToNext()) {
            System.out.println("cursor:" + cursor.getInt(0));
            result = cursor.getInt(0);
        }

        sqLiteDatabase.close();

        return result;
    }

    /**
     * 删除事件
     *
     * @param context
     * @param eventId
     * @return
     * @author 陈幼安
     * @version V1.0
     */
    public boolean delete(Context context, int eventId) {

        sqLiteDatabase = new MyOpenHelper(context).getWritableDatabase();
        int result = sqLiteDatabase.delete("event", "eventid=?", new String[]{String.valueOf(eventId)});
        sqLiteDatabase.close();

        if (result >= 0) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * @param context
     * @param beanEvent
     * @return
     * @author 陈幼安
     * @version V1.0
     */
    public boolean update(Context context, BeanEvent beanEvent) {

        sqLiteDatabase = new MyOpenHelper(context).getWritableDatabase();

        //封装进ContentValues
        ContentValues values = new ContentValues();
        values.put("projectid", beanEvent.getProjectId());
        values.put("eventcontext", beanEvent.getEventContext());
        values.put("eventbegin", format.format(beanEvent.getEventBegin().getTime()));
        values.put("eventend", format.format(beanEvent.getEventEnd().getTime()));
        values.put("eventlevel", beanEvent.getEventLevel());
        values.put("eventissuccess", beanEvent.getEventIsSuccess());
        //插入的时候不要eventdeletedate这一项
        if (beanEvent.getEventVoiceSrc() != null) {
            values.put("eventvoicesrc", beanEvent.getEventVoiceSrc());
        }
        if (beanEvent.getEventImgSrc() != null) {
            values.put("eventimgsrc", beanEvent.getEventImgSrc());
        }
        if (beanEvent.getEventPwd() != null) {
            values.put("eventpwd", beanEvent.getEventPwd());
        }

        int result = sqLiteDatabase.update("event", values, "eventid=?", new String[]{String.valueOf(beanEvent.getEventId())});

        sqLiteDatabase.close();

        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据事件名称模糊查找没有被删除的事件信息
     *
     * @param context
     * @param key
     * @return
     * @author 陈幼安
     */
    public List<BeanEvent> searchByName(Context context, String key) {

        List<BeanEvent> list = new ArrayList<BeanEvent>();
        sqLiteDatabase = new MyOpenHelper(context).getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query("event", new String[]{"eventid",
                "projectid",
                "eventcontext",
                "eventbegin",
                "eventend",
                "eventdeletedate",
                "eventvoicesrc",
                "eventlevel",
                "eventimgsrc",
                "eventpwd",
                "eventissuccess"}, "eventcontext like ? and eventdeletedate = null", new String[]{key}, null, null, null);

        while (cursor.moveToNext()) {
            BeanEvent beanEvent = new BeanEvent();
        }

        return null;
    }

    public boolean deleteToRecycle(Context context, BeanEvent beanEvent) {

        sqLiteDatabase = new MyOpenHelper(context).getWritableDatabase();

//        ContentValues values = new ContentValues();
//        values.put("projectid", beanEvent.getProjectId());
//        values.put("eventcontext", beanEvent.getEventContext());
//        values.put("eventbegin", format.format(beanEvent.getEventBegin().getTime()));
//        values.put("eventend", format.format(beanEvent.getEventEnd().getTime()));
//        values.put("eventlevel", beanEvent.getEventLevel());
//        values.put("eventissuccess", beanEvent.getEventIsSuccess());
//        //插入的时候不要eventdeletedate这一项
//        values.put("eventdeletedate",format.format(new Date(System.currentTimeMillis())));
//        if (beanEvent.getEventVoiceSrc() != null) {
//            values.put("eventvoicesrc", beanEvent.getEventVoiceSrc());
//        }
//        if (beanEvent.getEventImgSrc() != null) {
//            values.put("eventimgsrc", beanEvent.getEventImgSrc());
//        }
//        if (beanEvent.getEventPwd() != null) {
//            values.put("eventpwd", beanEvent.getEventPwd());

        ContentValues values = new ContentValues();
        values.put("eventdeletedate", format.format(new Date(System.currentTimeMillis())));

        int result = sqLiteDatabase.update("event", values, "eventid=?", new String[]{String.valueOf(beanEvent.getEventId())});

        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

}
