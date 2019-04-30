package com.example.recycler_view;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class elect extends AppCompatActivity {

    List<Book> book1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);
        book1 = new ArrayList<>();
        book1.add(new Book("DELL INSPIRON","LAPTOPS","Desc1",R.drawable.dell_inspiron,32,70000));
        book1.add(new Book("ASUS TUF GAMING LAPTOP","LAPTOPS","Desc 2",R.drawable.asus,33,10000));
        book1.add(new Book("DELL INSPIRON","LAPTOPS","Desc 3",R.drawable.delli,34,60000));
        book1.add(new Book("LENOVO LEGYON GAMING","LAPTOPS","Desc 4",R.drawable.lenovol,35,90000));
        book1.add(new Book("MSI LAPTOP","LAPTOPS","Desc 5",R.drawable.msi,36,110000));
        book1.add(new Book("ALIENWARE LAPTOP","LAPTOPS","Desc 6",R.drawable.alien,37,200000));
        book1.add(new Book("HP OMEN GAMING LAPTOP","LAPTOPS","Desc 7",R.drawable.hpo,38,110000));
        book1.add(new Book("MACBOOK PRO 13","LAPTOPS","Desc 8",R.drawable.mac,39,150000));
        book1.add(new Book("MACBOOK AIR","LAPTOPS","Desc 9",R.drawable.maca,40,100000));
        book1.add(new Book("SURFACE PRO","LAPTOPS","Desc 9",R.drawable.mi,41,120000));
        RecyclerView myrv = (RecyclerView)findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter  = new RecyclerViewAdapter(this,book1);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);
    }
}
