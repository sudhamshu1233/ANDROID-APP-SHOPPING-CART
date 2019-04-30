package com.example.recycler_view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class television extends AppCompatActivity {

    List<Book> book1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);
        book1 = new ArrayList<>();
        book1.add(new Book("SONY 4k UHD Oled TV","TELEVISONS","Desc1",R.drawable.t1,62,200000));
        book1.add(new Book("SONY LED 65","TELEVISONS","Desc 2",R.drawable.t2,63,90000));
        book1.add(new Book("LG 4k UHD Oled TV 65","TELEVISONS","Desc 3",R.drawable.t3,64,200000));
        book1.add(new Book("SAMSUNG 4k LED 65","TELEVISONS","Desc 4",R.drawable.t4,65,60000));
        book1.add(new Book("SANYO FULL HD","TELEVISONS","Desc 5",R.drawable.t5,66,40000));
        book1.add(new Book("MI LED 4C PRO","TELEVISONS","Desc 6",R.drawable.t6,67,30000));
        book1.add(new Book("LG 43 FULL HD","TELEVISONS","Desc 7",R.drawable.t7,68,35000));
        book1.add(new Book("LG 4k UHD LED","TELEVISONS","Desc 8",R.drawable.t8,69,50000));
        book1.add(new Book("TCL 40","TELEVISONS","Desc 9",R.drawable.t9,70,20000));
        book1.add(new Book("MI LED TV 4 PRO","TELEVISONS","Desc 9",R.drawable.t10,71,65000));
        RecyclerView myrv = (RecyclerView)findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter  = new RecyclerViewAdapter(this,book1);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);
    }


}
