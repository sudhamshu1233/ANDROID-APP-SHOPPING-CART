package com.example.recycler_view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class checkout1 extends AppCompatActivity {
    Button b1;
    EditText t1;
    EditText t2;
    int q=0;
    String h;
    String h1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout1);
        //Intent i=getIntent();

        Bundle extras = getIntent().getExtras();
        q=extras.getInt("total");

        Toast.makeText(getApplicationContext(),String.valueOf(q),Toast.LENGTH_LONG).show();
       t1=findViewById(R.id.e1);

        //=t1.getText().toString();

       t2=findViewById(R.id.e2);

        //Toast.makeText(getApplicationContext(),q,Toast.LENGTH_LONG).show();
       b1=findViewById(R.id.button);
       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i=new Intent(checkout1.this,checkout3.class);
               i.putExtra("total",q);
               h=t1.getText().toString();
               h1=t2.getText().toString();
               i.putExtra("add",h1+" "+h);
               Toast.makeText(getApplicationContext(),h,Toast.LENGTH_LONG).show();
               startActivity(i);



           }
       });







    }
}
