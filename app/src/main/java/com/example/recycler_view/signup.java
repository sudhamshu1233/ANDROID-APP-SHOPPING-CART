package com.example.recycler_view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {


    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

    }


    public void signup_page(View v)
    {
        EditText ed1 = findViewById(R.id.user1);
        EditText ed2 = findViewById(R.id.pass1);
        EditText ed3 = findViewById(R.id.email);
        EditText ed4 = findViewById(R.id.contact);
        db = openOrCreateDatabase("db1" , Context.MODE_PRIVATE , null);
        db.execSQL("CREATE TABLE IF NOT EXISTS signup_table(uname VARCHAR , pwd VARCHAR,email VARCHAR , contact VARCHAR);");
        Cursor c1 = db.rawQuery("SELECT * FROM signup_table WHERE uname='"+ed1.getText()+"'", null);
        if(c1.getCount() !=0)
        {
            String err = "Username " +ed1.getText()+" already exists!!";
            Toast.makeText(getApplicationContext(), err, Toast.LENGTH_SHORT).show();
        }
        else {

            if(ed1.getText().toString().equals(""))
                Toast.makeText(getApplicationContext(), "Username can not be empty", Toast.LENGTH_SHORT).show();

            else if(ed2.getText().toString().equals(""))
                Toast.makeText(getApplicationContext(), "Password can not be empty", Toast.LENGTH_SHORT).show();

            else {
                db.execSQL("INSERT INTO signup_table VALUES('" + ed1.getText() + "','" + ed2.getText() + "','" + ed3.getText() + "','" + ed4.getText() +
                        "');");
                Toast.makeText(getApplicationContext(), "You have Signed Up !!", Toast.LENGTH_SHORT).show();
                db.close();
                Intent obj = new Intent(signup.this, signin.class);
                startActivity(obj);
            }
             /*Cursor c = db.rawQuery("SELECT * FROM signup_table", null);
            String res;
            c.moveToFirst();
            while (c.moveToNext()) {
                String un = c.getString(0);
                String pw = c.getString(1);
                res = un + pw;
                Toast.makeText(getApplicationContext(), res, Toast.LENGTH_LONG).show();
            } */
        }

    }
}
