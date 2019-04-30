package com.example.recycler_view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class electronics extends AppCompatActivity {

    ImageButton b1;
    ImageButton b2;
    ImageButton b3;
    ImageButton b4;
    ImageButton b5;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronics);
    }
    public void foo1(View v)
    {
        Intent obj = new Intent(this , refrigerators.class);
        startActivity(obj);
    }

    public void foo2(View v)
    {
        Intent obj = new Intent(this , elect.class);
        startActivity(obj);
    }

    public void foo3(View v)
    {
        Intent obj = new Intent(this , phones.class);
        startActivity(obj);
    }

    public void foo4(View v)
    {
        Intent obj = new Intent(this , television.class);
        startActivity(obj);
    }
    public void foo5(View v)
    {
        Intent obj = new Intent(this , kitchen.class);
        startActivity(obj);
    }
}

