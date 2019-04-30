package com.example.recycler_view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recycler_view.R;

import org.w3c.dom.Text;

public class title1 extends AppCompatActivity
{

    ImageView im;
    TextView title,desc,cat,pr;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        SQLiteDatabase db;

        db = openOrCreateDatabase("datab" , Context.MODE_PRIVATE , null);
        db.execSQL("CREATE TABLE IF NOT EXISTS cart_table(Title VARCHAR,Description VARCHAR,Category VARCHAR,Thumbnail INT,Price INT,ItemId INT);");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title1);

        // receive data

        Intent obj = getIntent();
        String Title = obj.getExtras().getString("Title");
        int Price = obj.getExtras().getInt("Price");
        int Item_Id = obj.getExtras().getInt("Id");
        String Category = obj.getExtras().getString("Category");
        String Description = obj.getExtras().getString("Description");
        int Thumbnail = obj.getExtras().getInt("Thumbnail");
        int q=0;

        pr = (TextView)findViewById(R.id.price_id);
        title = (TextView)findViewById(R.id.title_id);
        desc = (TextView)findViewById(R.id.desc_id);
        im = (ImageView)findViewById(R.id.bookthumbnail);
        cat = (TextView)findViewById(R.id.category_id);


        title.setText(Title);
        desc.setText(Description);
        cat.setText(Category);
        im.setImageResource(Thumbnail);
        pr.setText(String.valueOf(Price));

        Cursor c1 = db.rawQuery("SELECT * FROM cart_table WHERE ItemId='"+Item_Id+"'", null);
        c1.moveToFirst();
        if(c1.getCount() ==0)
        {
            //disable rm
            Button b;
            b=(Button)findViewById(R.id.remove);
            b.setEnabled(false);
        }
        else{
            Button b1;
            b1=(Button)findViewById(R.id.add);
            b1.setEnabled(false);
        }
    }

    public void add_cart(View v)
    {
        SQLiteDatabase db;
        db = openOrCreateDatabase("datab" , Context.MODE_PRIVATE , null);
        //int q=0;
        Intent obj = getIntent();
        String Title = obj.getExtras().getString("Title");
        int Price = obj.getExtras().getInt("Price");
        int ItemId = obj.getExtras().getInt("Id");
        String Category = obj.getExtras().getString("Category");
        String Description = obj.getExtras().getString("Description");
        int Thumbnail = obj.getExtras().getInt("Thumbnail");


        db.execSQL("INSERT INTO cart_table VALUES('" + Title + "','" + Description +"','"+Category+"','"+Thumbnail+"','"+Price+"','"+ItemId+
               "');");

        Toast.makeText(getApplicationContext(),"Succesfully Added",Toast.LENGTH_SHORT).show();
        SharedPreferences p = getSharedPreferences("file.txt",Context.MODE_PRIVATE);
        if(p.contains("total1")){
            SharedPreferences.Editor editor = p.edit();
            int q=p.getInt("total1",9);
            q=q+Price;
            editor.putInt("total1",q);
            //Toast.makeText(getApplicationContext(),String.valueOf(Price),Toast.LENGTH_SHORT).show();
            editor.commit();




        }
        else{
            SharedPreferences.Editor editor = p.edit();
            editor.putInt("total1",Price);
            //Toast.makeText(getApplicationContext(),String.valueOf(Price),Toast.LENGTH_SHORT).show();
            editor.commit();


        }
        db.close();
        finish();
    }

    public void rm_cart(View v)
    {
        Intent obj = getIntent();
        int Item_Id = obj.getExtras().getInt("Id");
        int Price = obj.getExtras().getInt("Price");
        SQLiteDatabase db;
        db = openOrCreateDatabase("datab" , Context.MODE_PRIVATE , null);
        db.execSQL("DELETE FROM cart_table WHERE ItemId ='"+ Item_Id+"'");
        SharedPreferences p = getSharedPreferences("file.txt",Context.MODE_PRIVATE);
        if(p.contains("total1")){
            SharedPreferences.Editor editor = p.edit();
            int q=p.getInt("total1",9);
            if(q>0) {
                q = q - Price;
                editor.putInt("total1", q);
                //Toast.makeText(getApplicationContext(), String.valueOf(Price), Toast.LENGTH_SHORT).show();
                editor.commit();
            }




        }

        Toast.makeText(getApplicationContext(),"Item Removed From Cart!!",Toast.LENGTH_SHORT).show();
        Intent obj6 = new Intent(title1.this ,mycart.class);
        startActivity(obj6);
    }

}
