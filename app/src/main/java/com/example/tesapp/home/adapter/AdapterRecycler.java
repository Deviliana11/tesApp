package com.example.tesapp.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.card.MaterialCardView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.tesapp.R;
import com.example.tesapp.detail.DetailBeritaActivity;
import com.example.tesapp.model.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by
 * Name    : Lukmanul Hakim
 * on      : 09, March, 2019
 */
public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.MyViewHolder>{

    private List<News> list = new ArrayList<>();
    private Context context;

    public AdapterRecycler(List<News> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_list_berita, viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.imageView.setImageResource(list.get(i).img);
        myViewHolder.text1.setText(list.get(i).title);
        myViewHolder.text2.setText(list.get(i).desc);
        myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parseData(list.get(i).img,list.get(i).desc,list.get(i).title);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView text1, text2;
        private MaterialCardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img1);
            text1 = itemView.findViewById(R.id.txt1);
            text2 = itemView.findViewById(R.id.txt2);
            cardView = itemView.findViewById(R.id.cardNews);

        }
    }
    private void parseData (int img, String desc, String title){
        Intent intent = new Intent(context, DetailBeritaActivity.class);

        intent.putExtra("img", img);
        intent.putExtra("desc", desc);
        intent.putExtra("title", title);

        context.startActivity(intent);
    }
}
