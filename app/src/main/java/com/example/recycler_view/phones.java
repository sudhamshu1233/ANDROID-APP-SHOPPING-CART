package com.example.recycler_view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class phones extends AppCompatActivity {
    List<Book> book1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);
        book1 = new ArrayList<>();
        book1.add(new Book("SAMSUNG S10+","PHONES","Desc1",R.drawable.p1,42,80000));
        book1.add(new Book("MI 7 PRO","PHONES","Desc 2",R.drawable.p2,43,17000));
        book1.add(new Book("HUAEWI P30 PRO","PHONES","Desc 3",R.drawable.p3,44,100000));
        book1.add(new Book("SAMSUNG FOLD","PHONES","Desc 4",R.drawable.p4,45,200000));
        book1.add(new Book("IPHONE XS MAX","PHONES","Desc 5",R.drawable.p5,46,120000));
        book1.add(new Book("ONEPLUS 6T","PHONES","Desc 6",R.drawable.p6,47,42000));
        book1.add(new Book("SAMSUNG S9+","PHONES","Desc 7",R.drawable.p7,48,50000));
        book1.add(new Book("PIXEL 3XL","PHONES","Desc 8",R.drawable.p8,49,90000));
        book1.add(new Book("SAMSUNG A80","PHONES","Desc 9",R.drawable.p9,50,60000));
        book1.add(new Book("HUAEWI MATE 20 PRO","PHONES","Desc 9",R.drawable.p10,51,70000));
        RecyclerView myrv = (RecyclerView)findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter  = new RecyclerViewAdapter(this,book1);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);
    }
}
