package com.young1014.kcouple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class D_DayActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dday);


        getSupportActionBar().setTitle(G.nickname);
        getSupportActionBar().setSubtitle(G.gender);
    }

    public void clickNext(View view) {

            startActivity( new Intent(D_DayActivity.this, My_Informan.class) );

    }
}