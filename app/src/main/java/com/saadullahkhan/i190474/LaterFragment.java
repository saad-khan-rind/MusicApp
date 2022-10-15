package com.saadullahkhan.i190474;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LaterFragment extends Fragment {
    TextView likedOption ;
    RadioButton playlist ;
    RadioButton music ;
    RadioGroup toggle ;
    Resources res ;
    LinearLayout playlistLayout;
    LinearLayout musicLayout;
    Button back;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        res = getResources();
        back = getView().findViewById(R.id.backLater);
        likedOption = getView().findViewById(R.id.stringLater);
        playlist = getView().findViewById(R.id.playlistLater);
        music = getView().findViewById(R.id.musicLater);
        toggle = getView().findViewById(R.id.toggleLater);
        playlistLayout = getView().findViewById(R.id.playLaterList);
        musicLayout = getView().findViewById(R.id.musicLaterList);
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
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_later,container,false);
    }
}
