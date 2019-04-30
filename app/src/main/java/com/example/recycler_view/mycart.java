package com.example.recycler_view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class mycart extends AppCompatActivity
{
    List<Book> book1;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycart);

        book1 = new ArrayList<>();
        db = openOrCreateDatabase("datab" , Context.MODE_PRIVATE , null);



        try{
            Cursor c = db.rawQuery("SELECT * FROM cart_table", null);
           if (c != null && c.getCount()>0)
           {
               while (c.moveToNext())
               {
                   String title = c.getString(0);
                   String desc = c.getString(1);
                   String cat = c.getString(2);
                   int thumb = c.getInt(3);
                   int price = c.getInt(4);
                   int itemid = c.getInt(5);
                   book1.add(new Book(title,cat,desc,thumb,itemid,price));
               }
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

/*
        while (c.moveToNext())
        {
            String title = c.getString(0);
            String desc = c.getString(1);
            String cat = c.getString(2);
            int thumb = c.getInt(3);
            int price = c.getInt(4);
            int itemid = c.getInt(5);
            book1.add(new Book(title,cat,desc,thumb,itemid,price));
        }
*/

        RecyclerView myrv = (RecyclerView)findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter  = new RecyclerViewAdapter(this,book1);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);
    db.close();
    }
    public void foo2(View v){
        Intent p=new Intent(mycart.this,nav_bar.class);
        startActivity(p);
    }
    public void foo1(View v)
    {

        SharedPreferences p = getSharedPreferences("file.txt",Context.MODE_PRIVATE);
        int r=p.getInt("total1",9);
        if(r==0|r==9){
            Toast.makeText(getApplicationContext(),"CART IS EMPTY",Toast.LENGTH_LONG).show();
        }
        else {
            Intent obj = new Intent(this, checkout1.class);
            //Toast.makeText(getApplicationContext(), String.valueOf(r), Toast.LENGTH_LONG).show();

            obj.putExtra("total", r);
            //Log.i(null, "foo1: p");
            startActivity(obj);
        }
    }
}
