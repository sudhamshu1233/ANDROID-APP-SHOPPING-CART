package com.example.recycler_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class books extends AppCompatActivity {

    List<Book> book1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);
        book1 = new ArrayList<>();

        book1.add(new Book("KITE RUNNER","HORROR","Desc 2",R.drawable.kite,10,435));
        book1.add(new Book("PAX","CHILDREN","Desc 2",R.drawable.pax,11,233));
        book1.add(new Book("THE DAY YOU BEGIN","STORY BOOK","Desc 4",R.drawable.theday,12,300));
        book1.add(new Book("CHARLOTTIES WEB","FICTION","Desc 5",R.drawable.charlotti,13,700));
        book1.add(new Book("THE WORLDS WORST CHILDREN","CHILDREN","Desc 9",R.drawable.theworlds,14,1200));
        book1.add(new Book("HARRY POTTER","CHILDREN","Desc 6",R.drawable.harry,15,2500));
        book1.add(new Book("SCIENCE- FICTION FANTASY","FICTION","Desc 7",R.drawable.science,16,560));
        book1.add(new Book("ROOM ON THE BROOM","STORY BOOK","Desc 8",R.drawable.room,17,455));
        book1.add(new Book("GRANDPA'S GREAT ESCAPE","CHILDREN","Desc 9",R.drawable.grandpa,18,900));
        book1.add(new Book("NEW SCARY","HORROR","Desc 9",R.drawable.new_scary,19,900));
        book1.add(new Book("POPULAR FICTION","FICTION","Desc 9",R.drawable.popular,20,897));
        RecyclerView myrv = (RecyclerView)findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter  = new RecyclerViewAdapter(this,book1);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);
    }
}
