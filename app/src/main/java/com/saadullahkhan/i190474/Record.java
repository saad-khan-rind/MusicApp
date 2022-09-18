package com.saadullahkhan.i190474;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Record extends AppCompatActivity {
    ImageView record1 ;
    ImageView record2 ;
    ImageView record3 ;
    ImageView record4 ;
    ImageView recordBar ;


    TextView recordTime;
    TextView recordTime2;
    TextView recordTime3;
    TextView recordNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        record1 = findViewById(R.id.recordBtn1);
        record2 = findViewById(R.id.recordBtn2);
        record3 = findViewById(R.id.recordBtn3);
        record4 = findViewById(R.id.recordBtn4);
        recordBar = findViewById(R.id.recordBar);
        recordTime = findViewById(R.id.recordTime);
        recordTime2 = findViewById(R.id.recordTime2);
        recordTime3 = findViewById(R.id.recordTime3);
        recordNext = findViewById(R.id.recordNext);
        record1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                recordTime3.setVisibility(View.INVISIBLE);

                recordBar.setVisibility(View.INVISIBLE);
                recordTime2.setVisibility(View.INVISIBLE);
                record3.setVisibility(View.INVISIBLE);
                record1.setVisibility(View.INVISIBLE);
                record2.setVisibility(View.VISIBLE);
                record4.setVisibility(View.INVISIBLE);
                recordTime.setVisibility(View.VISIBLE);
                recordNext.setVisibility(View.INVISIBLE);
            }
        });
        record2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                record4.setVisibility(View.INVISIBLE);
                recordTime3.setVisibility(View.INVISIBLE);
                recordBar.setVisibility(View.INVISIBLE);
                recordTime2.setVisibility(View.VISIBLE);
                record3.setVisibility(View.VISIBLE);
                record1.setVisibility(View.VISIBLE);
                record2.setVisibility(View.INVISIBLE);
                recordTime.setVisibility(View.INVISIBLE);
                recordNext.setVisibility(View.VISIBLE);
            }
        });
        record3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                record4.setVisibility(View.VISIBLE);
                recordTime3.setVisibility(View.VISIBLE);
                recordBar.setVisibility(View.VISIBLE);
                recordTime2.setVisibility(View.INVISIBLE);
                record3.setVisibility(View.INVISIBLE);
                record1.setVisibility(View.VISIBLE);
                record2.setVisibility(View.INVISIBLE);
                recordTime.setVisibility(View.INVISIBLE);
                recordNext.setVisibility(View.VISIBLE);

            }
        });
        record4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                record4.setVisibility(View.INVISIBLE);
                recordTime3.setVisibility(View.INVISIBLE);
                recordBar.setVisibility(View.INVISIBLE);
                recordTime2.setVisibility(View.INVISIBLE);
                record3.setVisibility(View.INVISIBLE);
                record1.setVisibility(View.VISIBLE);
                record2.setVisibility(View.INVISIBLE);
                recordTime.setVisibility(View.INVISIBLE);
                recordNext.setVisibility(View.INVISIBLE);

            }
        });

    }
    public void onUploadRecord(View v){
        startActivity(new Intent(Record.this, UploadMusic.class));
    }
    public void onSelectRecord(View v){
        startActivity(new Intent(Record.this, SelectPlaylist.class));
    }

}