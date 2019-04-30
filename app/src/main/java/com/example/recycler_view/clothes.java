package com.example.recycler_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class clothes extends AppCompatActivity {

    List<Book> book1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);
        book1 = new ArrayList<>();
        book1.add(new Book("DENIM JEANS","PANTS","Desc1",R.drawable.denim_jeans,0,500));
        book1.add(new Book("PEARLS OCEAN WHITE","SHIRT","Desc 2",R.drawable.pearl_ocean_white,1,499));
        book1.add(new Book("UD FABRIC","SHIRT","Desc 3",R.drawable.udfabric,2,699));
        book1.add(new Book("RK TRENDS","T SHIRT","Desc 4",R.drawable.rktrends,3,400));
        book1.add(new Book("RIDING JEANS","PANTS","Desc 5",R.drawable.riding,4,600));
        book1.add(new Book("RED BROWN SHIRT","SHIRT","Desc 6",R.drawable.redbrown,5,488));
        book1.add(new Book("RED SHIRT","SHIRT","Desc 7",R.drawable.red,6,899));
        book1.add(new Book("BROWN JEANS","PANTS","Desc 8",R.drawable.jeansbrown,7,799));
        book1.add(new Book("BLACK COTTON","SHIRT","Desc 9",R.drawable.black_satin,8,549));
        book1.add(new Book("PEARL RED SHIRT","SHIRT","Desc 10",R.drawable.pearlred,9,688));

        RecyclerView myrv = (RecyclerView)findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter  = new RecyclerViewAdapter(this,book1);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);
    }
}
