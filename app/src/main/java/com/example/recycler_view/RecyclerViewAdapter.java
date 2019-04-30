package com.example.recycler_view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>
{
    private Context mContext;
    private List<Book> mData;

    public RecyclerViewAdapter(Context mConetxt, List<Book> mData) {
        this.mContext = mConetxt;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i)
    {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view  = mInflater.inflate(R.layout.cardview,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int position)
    {

        myViewHolder.tv_book_title.setText(mData.get(position).getTitle());
        myViewHolder.img_book_thumbnail.setImageResource(mData.get(position).getThumbnail());

        // set on click listeners
        myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent obj = new Intent(mContext  ,title1.class);
                obj.putExtra("Category",mData.get(position).getCategory());
                obj.putExtra("Price",mData.get(position).getPrice());
                obj.putExtra("Id",mData.get(position).getId());
                obj.putExtra("Title" , mData.get(position).getTitle());
                obj.putExtra("Description" , mData.get(position).getDescription());
                obj.putExtra("Thumbnail" , mData.get(position).getThumbnail());
                mContext.startActivity(obj);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_book_title;
        ImageView img_book_thumbnail;
        CardView cardView;

        public MyViewHolder(View itemView)
        {
            super(itemView);

            tv_book_title = (TextView) itemView.findViewById(R.id.book_title_id);
            img_book_thumbnail = (ImageView) itemView.findViewById(R.id.book_img_id);
            cardView = (CardView)itemView.findViewById(R.id.cardview_id);

        }
    }
}
