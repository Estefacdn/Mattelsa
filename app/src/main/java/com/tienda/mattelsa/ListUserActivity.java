package com.tienda.mattelsa;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.tienda.mattelsa.databinding.ActivityListUserBinding;

public class ListUserActivity extends AppCompatActivity  {

    private ActivityListUserBinding listUserBinding;
    private DbHelper dbHelper;
    private int idUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listUserBinding = ActivityListUserBinding.inflate(getLayoutInflater());
        View v = listUserBinding.getRoot();
        setContentView(v);
        dbHelper = new DbHelper(this);
    }

    public void listUser(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT * FROM users WHERE identification=123456",
                null);
        if(cursor.getCount() > 0){
            while (cursor.moveToNext()){
                idUser = Integer.parseInt(cursor.getString(0));
                int indexNameRow = cursor.getColumnIndex("name");
                int indexEmailRow = cursor.getColumnIndex("email");
                int indexDocumentRow = cursor.getColumnIndex("document");
                int indexCityRow = cursor.getColumnIndex("city");
                int indexPasswordRow = cursor.getColumnIndex("password");
                String name = cursor.getString(indexNameRow).toString();
                String email = cursor.getString(indexEmailRow).toString();
                String document = cursor.getString(indexDocumentRow).toString();
                String city = cursor.getString(indexCityRow).toString();
                String password = cursor.getString(indexPasswordRow).toString();
                Log.d( "Email",email);

            }

        }

    }


}