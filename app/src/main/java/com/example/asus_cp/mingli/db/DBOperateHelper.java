package com.example.asus_cp.mingli.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.example.asus_cp.mingli.model.DiTianShui;
import com.example.asus_cp.mingli.model.QiongTong;
import com.example.asus_cp.mingli.model.SanMing;

/**
 * Created by asus-cp on 2016-04-29.
 */
public class DBOperateHelper {
    private DBCreateHelper helper;
    public DBOperateHelper(DBCreateHelper helper){
        this.helper=helper;
    }

    /**
     * 向数据库插入三命通会数据的方法
     */
    public void insertSanMing(SanMing sanMing){
        SQLiteDatabase db=null;
        try{
            db=helper.getWritableDatabase();
            ContentValues contentValues=new ContentValues();
            contentValues.put(DBConstant.SanMing.RI_GAN,sanMing.getRiGanZhi());
            contentValues.put(DBConstant.SanMing.SHI_CHEN,sanMing.getShiChen());
            contentValues.put(DBConstant.SanMing.DUAN_YU,sanMing.getDuanYu());
            db.insert(DBConstant.SanMing.TABLE_NAME,null,contentValues);
        }catch (SQLiteException e){
            e.printStackTrace();
        }finally {
            if(db!=null){
//                db.close();
            }
        }
    }

    /**
     * 向数据库插入穷通宝鉴的方法
     */
    public void insertQiongTong(QiongTong qiongTong ){
        SQLiteDatabase db=null;
        try{
            db=helper.getWritableDatabase();
            ContentValues contentValues=new ContentValues();
            contentValues.put(DBConstant.QiongTong.RI_GAN,qiongTong.getRiGan());
            contentValues.put(DBConstant.QiongTong.YUE_FEN,qiongTong.getYueFen());
            contentValues.put(DBConstant.QiongTong.DUAN_YU,qiongTong.getDuanYu());
            db.insert(DBConstant.QiongTong.TABLE_NAME,null,contentValues);
        }catch (SQLiteException e){
            e.printStackTrace();
        }finally {
            if(db!=null){
//                db.close();
            }
        }
    }

    /**
     * 向数据库中插入滴天髓的方法
     */
    public void insertDiTianShui(DiTianShui diTianShui){
        SQLiteDatabase db=null;
        try{
            db=helper.getWritableDatabase();
            ContentValues contentValues=new ContentValues();
            contentValues.put(DBConstant.DiTianShui.RI_GAN,diTianShui.getRiGan());
            contentValues.put(DBConstant.DiTianShui.DUAN_YU,diTianShui.getDuanYu());
            db.insert(DBConstant.DiTianShui.TABLE_NAME,null,contentValues);
        }catch (SQLiteException e){
            e.printStackTrace();
        }finally {
            if(db!=null){
//                db.close();
            }
        }
    }

    /**
     * 向数据库查询数据的通用方法
     */
    public Object query(String sql,String[] args,MyCursorHandler handler){
        SQLiteDatabase db=null;
        Cursor cursor=null;
        Object obj=null;
        try{
            db=helper.getReadableDatabase();
            cursor=db.rawQuery(sql, args);
            obj=handler.handleCursor(cursor);
        }catch (SQLiteException e){
            e.printStackTrace();
        }finally {
            if(cursor!=null){
                cursor.close();
            }
            if(db!=null){
//                db.close();
            }
        }
        return obj;
    }

    /**
     * 查询三命通会断语的方法
     */
    public String querySanMingDuanYu(String sql,String[] args){
        String duanYu= (String) query(sql, args, new MyCursorHandler() {
            @Override
            public Object handleCursor(Cursor cursor) {
                String duanYu1=null;
                if(cursor.moveToNext()){
                    duanYu1=cursor.getString(cursor.getColumnIndex(DBConstant.SanMing.DUAN_YU));
                }
                return duanYu1;
            }
        });
        return duanYu;
    }

    /**
     * 查询穷通宝鉴断语的方法
     */
    public String queryQiongTongDuanYu(String sql,String[] args){
        String duanYu= (String) query(sql, args, new MyCursorHandler() {
            @Override
            public Object handleCursor(Cursor cursor) {
                String duanYu1=null;
                if(cursor.moveToNext()){
                    duanYu1=cursor.getString(cursor.getColumnIndex(DBConstant.QiongTong.DUAN_YU));
                }
                return duanYu1;
            }
        });
        return duanYu;
    }

    /**
     * 查询滴天髓断语的方法
     */
    public String queryDiTianShui(String sql,String[] args){
        String duanYu= (String) query(sql, args, new MyCursorHandler() {
            @Override
            public Object handleCursor(Cursor cursor) {
                String duanYu1=null;
                if(cursor.moveToNext()){
                    duanYu1=cursor.getString(cursor.getColumnIndex(DBConstant.DiTianShui.DUAN_YU));
                }
                return duanYu1;
            }
        });
        return duanYu;
    }

    /**
     * 关闭数据库的方法
     */
    public void closeDB(){
        SQLiteDatabase db=null;
        try{
            db=helper.getWritableDatabase();
        }catch (SQLiteException e){
            e.printStackTrace();
        }finally {
            if(db!=null){
                db.close();
            }
        }

    }
}
