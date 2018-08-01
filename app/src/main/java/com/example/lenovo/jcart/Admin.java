package com.example.lenovo.jcart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }

    public void add(View view) {
        Intent intent=new Intent(getApplicationContext(),AddProduct.class);
        startActivity(intent);
    }

    public void Viewp(View view) {
        Intent intent=new Intent(getApplicationContext(),ViewProduct.class);
        startActivity(intent);
    }

    public void usrdetail(View view) {
        Intent intent=new Intent(getApplicationContext(),User.class);
        startActivity(intent);

    }

    public void odrdetail(View view) {
        Intent intent=new Intent(getApplicationContext(),Hot_Deals.class);
        startActivity(intent);

    }

    public void hdeal(View view) {
        Intent intent=new Intent(getApplicationContext(),Hot_Deals.class);
        startActivity(intent);

    }

    public void soffr(View view) {
        Intent intent=new Intent(getApplicationContext(),Special_offers.class);
        startActivity(intent);

    }
}
