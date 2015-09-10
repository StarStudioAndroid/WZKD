package com.exe.feife.wzkd2.wzkd.dbhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by feifei on 15-8-30.
 */
public class DataBaseHelper extends SQLiteOpenHelper {
    private final static String DB_NAME="didian.db";

    //写建表语句
    private final static String CREATE_DIDIAN="create table didian (did int primary key autoincrement,dname text not null,djieshao text not null);";
    private final static String CREATE_DIDIANTUPIAN="create table didiantupian (did int primary key autoincrement,pname text not null);";
    private final static String CREATE_DIDIANZHINAN="create table didianjieshao (did int primary key autoincrement,jieshao text not null,tname text not null)";

    //表的名字，列的名字等资源字符串
    private final static String NAME_DIDIAN="didian";
    private final static String NAME_DIDIANTUPIAN="didiantupian";
    private final static String NAME_DIDIANZHINAN="didianzhinan";

    private final static String DIDIAN_ID="did";
    private final static String DIDIAN_NAME="dname";
    private final static String DIDIANTUPIAN_NAME="pname";
    private final static String DIDIANZHINAN_ZHINAN="zhinan";
    private final static String DIDIANZHINAN_TUPAIN="tname";

    public DataBaseHelper(Context context)
    {
        super(context,DB_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DIDIAN);
        db.execSQL(CREATE_DIDIANTUPIAN);
        db.execSQL(CREATE_DIDIANZHINAN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
