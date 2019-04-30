package com.example.recycler_view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class start_activity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_activity);
    }

    public void in(View v)
    {
        Intent obj = new Intent(start_activity.this , signin.class);
        startActivity(obj);
    }

    public void up(View v)
    {
        Intent obj1 = new Intent(start_activity.this , signup.class);
        startActivity(obj1);
    }



}
