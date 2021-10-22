package com.tienda.mattelsa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tienda.mattelsa.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding registerBinding;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerBinding = ActivityRegisterBinding.inflate(getLayoutInflater());
        View view = registerBinding.getRoot();
        setContentView(view);
        dbHelper = new DbHelper(this);
    }

    public void registerUser(View view){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues userData = new ContentValues();
        String name = registerBinding.etnameuser.getText().toString();
        String email = registerBinding.etEmail.getText().toString();
        String city = registerBinding.etCity.getText().toString();
        String document = registerBinding.etidentification.getText().toString();
        String password = registerBinding.etpassword.getText().toString();
        userData.put("name",name);
        userData.put("email",email);
        userData.put("city",city);
        userData.put("document",document);
        userData.put("password",password);
        long newUser = db.insert("users", null, userData);
        Toast.makeText(this, "" + newUser, Toast.LENGTH_SHORT).show();

    }
}