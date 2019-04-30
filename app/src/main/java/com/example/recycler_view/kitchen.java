package com.example.recycler_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class kitchen extends AppCompatActivity {

    List<Book> book1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);
        book1 = new ArrayList<>();
        book1.add(new Book("CANNON EDS 5D MARK IV","K&A","Desc1",R.drawable.k2,22,30000));
        book1.add(new Book("VOLTAS AC","K&A","Desc 2",R.drawable.k3,23,50000));
        book1.add(new Book("SAMSUNG AC 1.5 ton","K&A","Desc 3",R.drawable.k4,24,60000));
        book1.add(new Book("KORYO AC","K&A","Desc 4",R.drawable.k5,25,25000));
        book1.add(new Book("BAJAJ GX1 MIXER GRINDER","K&A","Desc 5",R.drawable.k6,26,3000));
        book1.add(new Book("LG 21461BP MICRO OVEN","K&A","Desc 6",R.drawable.k7,27,5000));
        book1.add(new Book("IFB 17L MICRO OVEN","K&A","Desc 7",R.drawable.k8,28,5000));
        book1.add(new Book("TABLE FAN","K&A","Desc 8",R.drawable.k9,29,1000));
        book1.add(new Book("LED LIGHT","K&A","Desc 9",R.drawable.k10,30,500));
        book1.add(new Book("ALEXA ECHO","K&A","Desc 9",R.drawable.k11,31,7000));
        RecyclerView myrv = (RecyclerView)findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter  = new RecyclerViewAdapter(this,book1);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);
    }


}
