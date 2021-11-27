package com.tienda.mattelsa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tienda.mattelsa.databinding.ActivityProfilesBinding;
import com.tienda.mattelsa.entities.UserEntity;

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
        UserEntity userData = (UserEntity) getIntent().getSerializableExtra("userData");
        getUser(userData);
    }

    public void getUser(UserEntity user){
            idUser = user.getId();
            profilesBinding.etname.setText(user.getName());
            profilesBinding.etemail.setText(user.getEmail());
            profilesBinding.etdocument.setText(user.getDocument());
            profilesBinding.etcity.setText(user.getCity());
    }


    public void updateUser(View view) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String name = profilesBinding.etname.getText().toString();
        String email = profilesBinding.etemail.getText().toString();
        String city = profilesBinding.etcity.getText().toString();
        String sql = String.format("UPDATE users set name='%s', email='%s', city='%s' WHERE id=%s", name,email,city, idUser);
        db.execSQL(sql);

        Intent intent = new Intent(this,ListUserActivity.class);
        startActivity(intent);
    }

}