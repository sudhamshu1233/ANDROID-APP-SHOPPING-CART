package com.example.recycler_view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class profile extends AppCompatActivity {

    SharedPreferences pref;
    SQLiteDatabase db;
    EditText ed1,ed2,ed3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void update_details(View v)
    {
        pref = getSharedPreferences("myfile",MODE_PRIVATE);
        String my_uname = pref.getString("username",null);
        ed1 = (EditText)findViewById(R.id.email4);
        ed2 = (EditText)findViewById(R.id.contact4);
        ed3 = (EditText)findViewById(R.id.pass4);

        String ema = ed1.getText().toString();
        String con = ed2.getText().toString();
        String passw = ed3.getText().toString();

        db = openOrCreateDatabase("db1" , Context.MODE_PRIVATE , null);
        db.execSQL("UPDATE signup_table  SET pwd ='"+ passw+"', email='"+ ema+"',contact='"+con+"' WHERE uname ='"+my_uname+"'");

        Toast.makeText(getApplicationContext() , "User details updated!!",Toast.LENGTH_SHORT).show();
        Intent obj = new Intent(profile.this , nav_bar.class);
        startActivity(obj);
    }

}
