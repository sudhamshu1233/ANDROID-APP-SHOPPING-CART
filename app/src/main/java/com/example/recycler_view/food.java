package com.example.recycler_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class food extends AppCompatActivity {

    List<Book> book1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);
        book1 = new ArrayList<>();
        book1.add(new Book("VADA","FOOD","Desc 2",R.drawable.vada,21,50));
        book1.add(new Book("SAMOSA","FOOD","Desc 3",R.drawable.samosa,22,50));
        book1.add(new Book("SANDWITCH","FOOD","Desc 4",R.drawable.sandwitch,23,90));
        book1.add(new Book("ROTI","FOOD","Desc 5",R.drawable.roti,24,80));
        book1.add(new Book("FANTA","DRINKS","Desc 9",R.drawable.fanta,25,60));
        book1.add(new Book("BURGER","FOOD","Desc 6",R.drawable.burger,26,200));
        book1.add(new Book("PIZZA","FOOD","Desc 7",R.drawable.pizza,27,350));
        book1.add(new Book("SALAD","FOOD","Desc 8",R.drawable.salad,28,40));
        book1.add(new Book("FRENCH FRIES","FOOD","Desc 9",R.drawable.frenchfries,29,60));
        book1.add(new Book("COKE","FOOD","Desc 9",R.drawable.coke,30,40));
        RecyclerView myrv = (RecyclerView)findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter  = new RecyclerViewAdapter(this,book1);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);
    }
}
