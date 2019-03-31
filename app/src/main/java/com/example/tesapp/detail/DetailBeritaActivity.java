package com.example.tesapp.detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.tesapp.R;

import java.net.URI;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailBeritaActivity extends AppCompatActivity {

    @BindView(R.id.relativeToolbar)
    RelativeLayout relativeToolbar;
    @BindView(R.id.detailImage)
    ImageView detailImage;
    @BindView(R.id.detailTitle)
    TextView detailTitle;
    @BindView(R.id.detailDesc)
    TextView detailDesc;
    @BindView(R.id.detailCallCenter)
    ImageView detailCallCenter;
    //tesdetail

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_berita);
        ButterKnife.bind(this);

        String title = getIntent().getStringExtra("title");
        String desc = getIntent().getStringExtra("desc");
        int img = getIntent().getIntExtra("img", 0);

        detailImage.setImageResource(img);
        detailTitle.setText(title);
        detailDesc.setText(desc);

        detailDesc.setText(desc);

        detailCallCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = "0822-7100124";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:" + phoneNumber));
                startActivity(dialPhoneIntent);
            }
        });
    }
}
