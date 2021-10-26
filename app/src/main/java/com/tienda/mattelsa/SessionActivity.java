package com.tienda.mattelsa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.tienda.mattelsa.databinding.ActivityRegisterBinding;
import com.tienda.mattelsa.databinding.ActivitySessionBinding;

public class SessionActivity<ActivitySessionBinding> extends AppCompatActivity implements View.OnClickListener {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);

    }

    @Override
    public void onClick(View view) {

    }
}