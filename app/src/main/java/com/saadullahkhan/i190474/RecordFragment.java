package com.saadullahkhan.i190474;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class RecordFragment extends Fragment {
    ImageView record1 ;
    ImageView record2 ;
    ImageView record3 ;
    ImageView record4 ;
    ImageView recordBar ;
    Button back;


    TextView recordTime;
    TextView recordTime2;
    TextView recordTime3;
    TextView recordNext;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        back = getView().findViewById(R.id.backRecord);
        record1 = getView().findViewById(R.id.recordBtn1);
        record2 = getView().findViewById(R.id.recordBtn2);
        record3 = getView().findViewById(R.id.recordBtn3);
        record4 = getView().findViewById(R.id.recordBtn4);
        recordBar = getView().findViewById(R.id.recordBar);
        recordTime = getView().findViewById(R.id.recordTime);
        recordTime2 = getView().findViewById(R.id.recordTime2);
        recordTime3 = getView().findViewById(R.id.recordTime3);
        recordNext = getView().findViewById(R.id.recordNext);
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
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
        recordNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new SelectPlayListFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer, fragment, "selectPlayList");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_record,container,false);
    }
}
