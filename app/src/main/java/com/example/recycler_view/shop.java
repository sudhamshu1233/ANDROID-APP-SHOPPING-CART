package com.example.recycler_view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class shop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
    }

    public void foo1(View v)
    {
        Intent obj = new Intent(shop.this , clothes.class);
        startActivity(obj);
    }

    public void foo2(View v)
    {
       Intent obj = new Intent(shop.this , food.class);
      startActivity(obj);
    }

    public void foo3(View v)
    {
        Intent obj = new Intent(shop.this , books.class);
        startActivity(obj);
    }

    public void foo4(View v)
    {
       Intent obj = new Intent(shop.this , electronics.class);
        startActivity(obj);
    }
}
