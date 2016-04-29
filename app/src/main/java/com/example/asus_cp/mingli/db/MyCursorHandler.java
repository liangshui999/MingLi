package com.example.asus_cp.mingli.db;

import android.database.Cursor;

/**
 * Created by asus-cp on 2016-04-29.
 * 处理cursor数据的接口
 */
public interface MyCursorHandler {
    public Object handleCursor(Cursor cursor);//用户自己实现这个接口来完成的cursor对象的处理
}
