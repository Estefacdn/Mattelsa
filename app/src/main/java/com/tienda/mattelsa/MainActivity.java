package com.tienda.mattelsa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.tienda.mattelsa.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);

        mainBinding.btnsignin.setOnClickListener(this);
        mainBinding.btnlogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnsignin:
                Intent intent= new Intent(this,RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.btnlogin:
                Intent intent2= new Intent(this,SessionActivity.class);
                startActivity(intent2);
                break;
        }

    }
}