package com.tienda.mattelsa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION=2;
    public static final String DATABASE_NAME= "userchekin";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "name VARCHAR(100), email VARCHAR(50),"+
                "city VARCHAR(25),document VARCHAR(20),password VARCHAR(20),"+
                "rol VARCHAR(20),sede VARCHAR(50))");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
        onCreate(sqLiteDatabase);
    }
}
