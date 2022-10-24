package com.saadullahkhan.i190474;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SongTitleFragment extends Fragment {
    ImageView titlePlay;
    ImageView titlePause;
    ImageView titleIcon1;
    ImageView titleIcon2;
    ImageView titleIcon3;
    ImageView titleIcon4;
    ImageView titleIcon5;
    ImageView titlebar1;
    ImageView titlebar2;
    ImageView back,chatButton;


    TextView titleTime1;
    TextView titleTime2;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        chatButton = getView().findViewById(R.id.chatButton);
        titlePause = getView().findViewById(R.id.titlePause);
        titlePlay = getView().findViewById(R.id.titlePlay);
        titleIcon1 = getView().findViewById(R.id.titleIcon1);
        titleIcon2 = getView().findViewById(R.id.titleIcon2);
        titleIcon3 = getView().findViewById(R.id.titleIcon3);
        titleIcon4 = getView().findViewById(R.id.titleIcon4);
        titleIcon5 = getView().findViewById(R.id.titleIcon5);
        titleTime1 = getView().findViewById(R.id.titleTime1);
        titleTime2 = getView().findViewById(R.id.titleTime2);
        titlebar1 = getView().findViewById(R.id.titleBar1);
        titlebar2 = getView().findViewById(R.id.titleBar2);
        back = getView().findViewById(R.id.backSongTitle);
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
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity().getApplicationContext(),ChattingActivity.class));
            }
        });

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_song_title,container,false);
    }
}
