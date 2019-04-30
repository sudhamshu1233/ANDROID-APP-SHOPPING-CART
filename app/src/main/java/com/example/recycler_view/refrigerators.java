package com.example.recycler_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class refrigerators extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        List<Book> book1;


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);
        book1 = new ArrayList<>();
        book1.add(new Book("Samsung l1 192","REFRIGERATOR","Desc1",R.drawable.r3,52,60000));
        book1.add(new Book("WHRILPOOL 256","REFRIGERATOR","Desc 2",R.drawable.r4,53,70000));
        book1.add(new Book("WHRILPOOL 192","REFRIGERATOR","Desc 3",R.drawable.r5,54,75000));
        book1.add(new Book("HAIER 195","REFRIGERATOR","Desc 4",R.drawable.r6,55,35000));
        book1.add(new Book("WHIRLPOOL 190","REFRIGERATOR","Desc 5",R.drawable.r7,56,70000));
        book1.add(new Book("SAMSUNG 253","REFRIGERATOR","Desc 6",R.drawable.r8,57,76000));
        book1.add(new Book("HAIER 170","REFRIGERATOR","Desc 7",R.drawable.r9,58,69000));
        book1.add(new Book("HAIER 320","REFRIGERATOR","Desc 8",R.drawable.r10,59,40000));
        book1.add(new Book("SAMSUNG 594","REFRIGERATOR","Desc 9",R.drawable.r11,60,560000));
        book1.add(new Book("SAMSUNG 604","REFRIGERATOR","Desc 9",R.drawable.r12,61,6000000));
        RecyclerView myrv = (RecyclerView)findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter  = new RecyclerViewAdapter(this,book1);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);
    }

}

