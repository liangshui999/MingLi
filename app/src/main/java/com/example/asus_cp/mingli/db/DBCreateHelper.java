package com.example.asus_cp.mingli.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.asus_cp.mingli.util.MyApplication;

/**
 * Created by asus-cp on 2016-04-29.
 */
public class DBCreateHelper extends SQLiteOpenHelper {
    //这里使用了单例设计模式
    private static DBCreateHelper createHelper=new DBCreateHelper(MyApplication.getContext(),DBConstant.DB_NAME,
            null,DBConstant.DB_VERSION);
    private DBCreateHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static DBCreateHelper getDBCreateHelper(){
        return createHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBConstant.SanMing.CREATE_TABLE);
        db.execSQL(DBConstant.QiongTong.CREATE_TABLE);
        db.execSQL(DBConstant.DiTianShui.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
