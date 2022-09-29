package com.saadullahkhan.i190474;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelectPlaylist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_playlist);
    }
    public void onRecordSelect(View v){
        finish();
    }
    public void onHomeSelect(View v){
        startActivity(new Intent(SelectPlaylist.this, Home.class));
    }


}