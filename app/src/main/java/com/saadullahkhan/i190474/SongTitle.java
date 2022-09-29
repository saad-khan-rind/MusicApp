package com.saadullahkhan.i190474;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SongTitle extends AppCompatActivity {
    ImageView titlePlay;
    ImageView titlePause;
    ImageView titleIcon1;
    ImageView titleIcon2;
    ImageView titleIcon3;
    ImageView titleIcon4;
    ImageView titleIcon5;
    ImageView titlebar1;
    ImageView titlebar2;


    TextView titleTime1;
    TextView titleTime2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_title);
        titlePause = findViewById(R.id.titlePause);
        titlePlay = findViewById(R.id.titlePlay);
        titleIcon1 = findViewById(R.id.titleIcon1);
        titleIcon2 = findViewById(R.id.titleIcon2);
        titleIcon3 = findViewById(R.id.titleIcon3);
        titleIcon4 = findViewById(R.id.titleIcon4);
        titleIcon5 = findViewById(R.id.titleIcon5);
        titleTime1 = findViewById(R.id.titleTime1);
        titleTime2 = findViewById(R.id.titleTime2);
        titlebar1 = findViewById(R.id.titleBar1);
        titlebar2 = findViewById(R.id.titleBar2);
        titlePlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titlePause.setVisibility(View.VISIBLE);
                titlePlay.setVisibility(View.INVISIBLE);
                titleIcon1.setVisibility(View.INVISIBLE);
                titleIcon2.setVisibility(View.INVISIBLE);
                titleIcon3.setVisibility(View.INVISIBLE);
                titleIcon4.setVisibility(View.INVISIBLE);
                titleIcon5.setVisibility(View.INVISIBLE);
                titleTime2.setVisibility(View.VISIBLE);
                titleTime1.setVisibility(View.INVISIBLE);
                titlebar1.setVisibility(View.INVISIBLE);
                titlebar2.setVisibility(View.VISIBLE);
            }
        });
        titlePause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titlePause.setVisibility(View.INVISIBLE);
                titlePlay.setVisibility(View.VISIBLE);
                titleIcon1.setVisibility(View.VISIBLE);
                titleIcon2.setVisibility(View.VISIBLE);
                titleIcon3.setVisibility(View.VISIBLE);
                titleIcon4.setVisibility(View.VISIBLE);
                titleIcon5.setVisibility(View.VISIBLE);
                titleTime2.setVisibility(View.INVISIBLE);
                titleTime1.setVisibility(View.VISIBLE);
                titlebar1.setVisibility(View.VISIBLE);
                titlebar2.setVisibility(View.INVISIBLE);
            }
        });
    }
    public void onHomeTitle(View v){
        finish();
    }
}