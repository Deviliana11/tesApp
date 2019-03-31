package com.example.tesapp.home.adapter;

import android.R;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.card.MaterialCardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.tesapp.model.News;

import butterknife.BindView;
import butterknife.ButterKnife;

//public class ViewHolder extends RecyclerView.ViewHolder {


//        @BindView(R.id.img)
//        RoundedImageView imgNews;
//        @BindView(R.id.textViewTitleNews)
//        TextView txtTitle;
//        @BindView(R.id.textViewDescNews)
//        TextView txtDesc;
//        @BindView(R.id.cardNews)
//        MaterialCardView cardNews;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            ButterKnife.bind(this, itemView);
//        }
//
//
//        public void bindView(final News news){
//            txtTitle.setText(news.title);
//            txtDesc.setText(news.desc);
//            imgNews.setImageResource(news.img);
//
//            cardNews.setOnClickListener(v -> {
//                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
//                intent.putExtra(DetailActivity.EXTRA_DESC, news.desc);
//                intent.putExtra(DetailActivity.EXTRA_TITLE, news.title);
//                intent.putExtra(DetailActivity.EXTRA_IMG, news.img);
//                itemView.getContext().startActivity(intent);
//            });




//        }

//    }