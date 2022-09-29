package com.saadullahkhan.i190474;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Later extends AppCompatActivity {
    TextView likedOption ;
    RadioButton playlist ;
    RadioButton music ;
    RadioGroup toggle ;
    Resources res ;
    LinearLayout playlistLayout;
    LinearLayout musicLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_later);
        res = getResources();
        likedOption = findViewById(R.id.stringLater);
        playlist = findViewById(R.id.playlistLater);
        music = findViewById(R.id.musicLater);
        toggle = findViewById(R.id.toggleLater);
        playlistLayout = findViewById(R.id.playLaterList);
        musicLayout = findViewById(R.id.musicLaterList);
        toggle.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (playlist.isChecked()){
                    likedOption.setText(res.getString(R.string.optionL));
                    playlistLayout.setVisibility(View.VISIBLE);
                    musicLayout.setVisibility(View.INVISIBLE);


                }else{
                    likedOption.setText(res.getString(R.string.optionR));
                    playlistLayout.setVisibility(View.INVISIBLE);
                    musicLayout.setVisibility(View.VISIBLE);
                }

            }
        });
    }
    public void onHomeLater(View v){
        finish();
    }
}