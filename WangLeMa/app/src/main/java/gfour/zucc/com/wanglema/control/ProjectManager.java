package gfour.zucc.com.wanglema.control;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import gfour.zucc.com.wanglema.Util.MyOpenHelper;
import gfour.zucc.com.wanglema.model.BeanProject;

/**
 * Created by Administrator on 2017/5/28.
 */

public class ProjectManager {

    SQLiteDatabase sqLiteDatabase;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    /**
     *
     * 新增项目
     *
     * @author 陈幼安
     * @param context
     * @param beanProject
     * @return
     */
    public boolean add(Context context, BeanProject beanProject) {

        sqLiteDatabase = new MyOpenHelper(context).getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("projectname",beanProject.getProjectName());
        values.put("projectcontext",beanProject.getProjectContext());

        long result = sqLiteDatabase.insert("project", null, values);

        sqLiteDatabase.close();

        if (result > 0){
            return true;
        }else {
            return false;
        }

    }

    public List<BeanProject> loadAll(Context context){

        List<BeanProject> projectList = new ArrayList<BeanProject>();
        sqLiteDatabase = new MyOpenHelper(context).getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query("project", new String[]{"projectid", "projectname"}, null, null, null, null, null);

        while(cursor.moveToNext()){
            BeanProject beanProject = new BeanProject();
            beanProject.setProjectId(cursor.getInt(0));
            beanProject.setProjectName(cursor.getString(1));
            projectList.add(beanProject);
        }
        sqLiteDatabase.close();

        return projectList;
    }

    public boolean delete(Context context , String projectName){
        return true;
    }

    public int getMaxProjectId(Context context){
        sqLiteDatabase = new MyOpenHelper(context).getReadableDatabase();
        int result = -1;

        Cursor cursor = sqLiteDatabase.rawQuery("select max(projectid) from project", null);

        if (cursor.moveToNext()) {
            System.out.println("cursor:" + cursor.getInt(0));
            result = cursor.getInt(0);
        }

        sqLiteDatabase.close();

        return result;
    }
}
