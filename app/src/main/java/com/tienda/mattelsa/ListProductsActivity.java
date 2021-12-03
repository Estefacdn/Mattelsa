package com.tienda.mattelsa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.tienda.mattelsa.databinding.ActivityListProductsBinding;

public class ListProductsActivity extends AppCompatActivity {

    private ActivityListProductsBinding listProductsBinding;
    private DbHelper dbHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listProductsBinding = ActivityListProductsBinding.inflate(getLayoutInflater());
        View v = listProductsBinding.getRoot();


        setContentView(R.layout.activity_list_products);
    }
}