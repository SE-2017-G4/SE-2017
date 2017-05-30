package gfour.zucc.com.wanglema.control;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;

import gfour.zucc.com.wanglema.Util.MyOpenHelper;
import gfour.zucc.com.wanglema.model.BeanTime;

/**
 * Created by Administrator on 2017/5/28.
 */

public class TimeManager {

    SQLiteDatabase sqLiteDatabase;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    /**
     * @authr 陈幼安
     * @version V1.0
     * @param context
     * @param beanTime
     * @return
     */
    public boolean add(Context context , BeanTime beanTime){

        //打开数据库
        sqLiteDatabase = new MyOpenHelper(context).getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("eventid",beanTime.getEventId());
        values.put("warn",format.format(beanTime.getWarn().getTime()));
        System.out.println("闹钟时间"+values.get("warn"));

        long result = sqLiteDatabase.insert("time", null, values);

        sqLiteDatabase.close();

        if (result > 0){
            return true;
        }else {
            return false;
        }

    }

}
