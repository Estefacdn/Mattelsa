package com.tienda.mattelsa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.tienda.mattelsa.adapters.UserAdapter;
import com.tienda.mattelsa.databinding.ActivityListUserBinding;
import com.tienda.mattelsa.entities.UserEntity;

import java.util.ArrayList;

public class ListUserActivity extends AppCompatActivity  {

    private ActivityListUserBinding listUserBinding;
    private DbHelper dbHelper;
    private int idUser;
    private ArrayList<UserEntity> userArrayList;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listUserBinding = ActivityListUserBinding.inflate(getLayoutInflater());
        View v = listUserBinding.getRoot();
        setContentView(v);
        userArrayList = new ArrayList<>();
        dbHelper = new DbHelper(this);
        userAdapter = new UserAdapter(this,userArrayList);
        listUserBinding.rvListUser.setHasFixedSize(true);
        listUserBinding.rvListUser.setLayoutManager(new LinearLayoutManager(this));
        listUserBinding.rvListUser.setAdapter(userAdapter);
        listUsers();
    }

    public void listUsers(){
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

                UserEntity userEntity = new UserEntity();
                userEntity.setId(idUser);
                userEntity.setName(name);
                userEntity.getPassword(password);
                userEntity.setEmail(email);
                userEntity.setCity(city);
                userEntity.setDocument(document);

                userArrayList.add(userEntity);

            }

            userAdapter.notifyDataSetChanged();

        }

    }


}