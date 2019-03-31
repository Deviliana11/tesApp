package com.example.tesapp.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.tesapp.R;
import com.example.tesapp.home.adapter.AdapterRecycler;
import com.example.tesapp.model.News;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.rvListNews)
    RecyclerView rvListNews;

    private AdapterRecycler mAdapter;
    private List<News> list= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        setView();

        rvListNews.setAdapter(mAdapter);


    }

    private void setView(){
        list.add(new News(R.drawable.news_satu, "Wisuda BSI DESKRIPSI", "Wisuda BSI") );
        list.add(new News(R.drawable.news_dua, "Seminar Eterpreneur BSI", "Seminar Universitas BSI") );
        list.add(new News(R.drawable.doraemon, "Walpapper Doraemon11", "Walpapper doraemon Lucu") );
        list.add(new News(R.drawable.news_satu, getString(R.string.title_news_satu),
                getString(R.string.desc_news_satu)));


        mAdapter = new AdapterRecycler(list, this);
        rvListNews .setLayoutManager(new LinearLayoutManager(this));

    }
}
