package com.saadullahkhan.i190474;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AddMusic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_music);
    }
    public void onHomeAdd(View v){
        startActivity(new Intent(AddMusic.this, Home.class));
    }

    public void onUploadAdd(View v){
        startActivity(new Intent(AddMusic.this, UploadMusic.class));
    }
}