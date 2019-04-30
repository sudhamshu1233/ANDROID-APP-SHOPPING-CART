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

public class signin extends AppCompatActivity {
    SQLiteDatabase db;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        pref = getSharedPreferences("myfile" , MODE_PRIVATE);
        if(pref.contains("username"))
        {
            Intent obj = new Intent(signin.this , nav_bar.class);
            startActivity(obj);
        }
    }

    public void sign_in(View v)
    {
        db = openOrCreateDatabase("db1" , Context.MODE_PRIVATE , null);
        EditText et1 = (EditText)findViewById(R.id.u1);
        EditText et2 = (EditText)findViewById(R.id.p1);
        Cursor c1 = db.rawQuery("SELECT * FROM signup_table WHERE uname='"+et1.getText()+"'", null);
        c1.moveToFirst();
        if(c1.getCount() == 0)
        {
            String err = "Username does not exists!!";
            Toast.makeText(getApplicationContext(), err, Toast.LENGTH_SHORT).show();

        }
        else{
            String pass = c1.getString(1);
            if(et2.getText().toString().equals(pass))
            {
                SharedPreferences pref;
                pref = getSharedPreferences("myfile",MODE_PRIVATE);
                String my_un = et1.getText().toString();
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("username",my_un);
                editor.commit();
                String res = "Signing In!!";
                Toast.makeText(getApplicationContext(), res, Toast.LENGTH_SHORT).show();
                Intent obj = new Intent(signin.this,nav_bar.class);
                startActivity(obj);
            }
            else
            {
                String err1 = "Username  and passwords do not match!!";
                Toast.makeText(getApplicationContext(),err1,Toast.LENGTH_SHORT).show();
            }

        }
        db.close();
    }

}
