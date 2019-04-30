package com.example.recycler_view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class nav_bar extends AppCompatActivity {

    SQLiteDatabase db;
    TextView tv1,tv2,tv3,tv4;
    SharedPreferences pr;
    SharedPreferences p;
    DrawerLayout dl;
    ActionBarDrawerToggle abdt;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_bar);

        tv1 = (TextView)findViewById(R.id.un2);
        tv3 = (TextView)findViewById(R.id.email2);
        tv4 = (TextView)findViewById(R.id.contact2);
        pr = getSharedPreferences("myfile",MODE_PRIVATE);

        String my_uname = pr.getString("username",null);
        db = openOrCreateDatabase("db1" , Context.MODE_PRIVATE , null);
        Cursor c1 = db.rawQuery("SELECT * FROM signup_table WHERE uname='"+my_uname+"'", null);
        c1.moveToFirst();
        String my_em = c1.getString(2);
        String my_contact = c1.getString(3);
        tv1.setText(my_uname);
        tv3.setText(my_em);
        tv4.setText(my_contact);


        dl = (DrawerLayout)findViewById(R.id.draw);
        abdt =new ActionBarDrawerToggle(this,dl,R.string.Open,R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(abdt);
        abdt.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final NavigationView nav_view = (NavigationView)findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                int id = item.getItemId();
                if(id == R.id.cart)
                {
                    Intent obj = new Intent(nav_bar.this , mycart.class);
                    startActivity(obj);
                }

                else if(id == R.id.profile)
                {
                    Intent obj = new Intent(nav_bar.this , profile.class);
                    startActivity(obj);
                }



                else if(id == R.id.send)
                {
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, "Your Message");
                    sendIntent.setType("text/plain");
                    sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
                    sendIntent.putExtra(Intent.EXTRA_EMAIL, "shopon@gmail.com");
                    startActivity(sendIntent);
                }

                else if(id == R.id.signout)
                {
                    SharedPreferences.Editor editor = pr.edit();

                    editor.clear();
                    editor.commit();

                    Intent obj = new Intent(nav_bar.this ,start_activity.class);
                    startActivity(obj);
                }


                else if(id == R.id.shop)
                {
                    Intent obj = new Intent(nav_bar.this ,shop.class);
                    startActivity(obj);
                }

                return true;



            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}
