package com.tienda.mattelsa;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tienda.mattelsa.databinding.ActivityProfilesBinding;

public class ProfilesActivity extends AppCompatActivity {

    private ActivityProfilesBinding profilesBinding;
    private DbHelper dbHelper;
    private int idUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        profilesBinding = ActivityProfilesBinding.inflate(getLayoutInflater());
        View view = profilesBinding.getRoot();
        setContentView(view);
        dbHelper = new DbHelper(this);
        getUser();
    }

    public void getUser(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT * FROM users WHERE identification=123456",
                null);

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            idUser = Integer.parseInt(cursor.getString(0));
            int indexNameRow = cursor.getColumnIndex("name");
            int indexEmailRow = cursor.getColumnIndex("email");
            int indexDocumentRow = cursor.getColumnIndex("document");
            int indexCityRow = cursor.getColumnIndex("city");
            int indexPasswordRow = cursor.getColumnIndex("password");
            profilesBinding.etname.setText(cursor.getString(indexNameRow).toString());
            profilesBinding.etemail.setText(cursor.getString(indexEmailRow).toString());
            profilesBinding.etdocument.setText(cursor.getString(indexDocumentRow).toString());
            profilesBinding.etcity.setText(cursor.getString(indexCityRow).toString());
            profilesBinding.etPassword.setText(cursor.getString(indexPasswordRow).toString());

        }
        else{
            Toast.makeText(this,
                    "No hay registros",
                    Toast.LENGTH_SHORT).show();
        }

    }
    public void updateUser(View view) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String name = profilesBinding.etName.getText().toString();
        String sql = String.format("UPDATE users set name='%s' WHERE id=%s", name, idUser);
        db.execSQL(sql);
    }

}