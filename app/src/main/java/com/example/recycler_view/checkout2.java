package com.example.recycler_view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class checkout2 extends AppCompatActivity {
    Button b;
    SQLiteDatabase db;
    SharedPreferences p;
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout2);
        b=findViewById(R.id.button7);
         p= getSharedPreferences("file.txt",Context.MODE_PRIVATE);
        if(p.contains("total1")){
            SharedPreferences.Editor editor = p.edit();
            int q=0;

            editor.putInt("total1",q);
            //Toast.makeText(getApplicationContext(),String.valueOf(Price),Toast.LENGTH_SHORT).show();
            editor.commit();




        }
        db = openOrCreateDatabase("datab" , Context.MODE_PRIVATE , null);
        db.execSQL("DELETE FROM cart_table ");


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent q=new Intent(checkout2.this,nav_bar.class);
                startActivity(q);

            }
        });
    }
}
