package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UploadMusic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_music);
    }

    public void onRecordUpload(View v){
        startActivity(new Intent(UploadMusic.this, Record.class));
    }
    public void onAddUpload(View v){
        startActivity(new Intent(UploadMusic.this, AddMusic.class));
    }
}