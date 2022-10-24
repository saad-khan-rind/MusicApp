package com.saadullahkhan.i190474;

import static android.content.ContentValues.TAG;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    Button drawer;
    DrawerLayout drawerLayout;
    LinearLayout song;
    ImageView postComment;
    RecyclerView recyclerViewPlaylist;
    HomePlayListAdapter playListAdapter;
    List<PlayList> listPlayList;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        drawer = getView().findViewById(R.id.drawerButton);
        drawerLayout = getView().findViewById(R.id.drawerLayout);
        song = getView().findViewById(R.id.homeSong);
        postComment = getView().findViewById(R.id.homePostComment);
        recyclerViewPlaylist = getView().findViewById(R.id.homePlaylistRecyclerView);

        listPlayList = new ArrayList<>();

        playListAdapter = new HomePlayListAdapter(listPlayList,getActivity().getApplicationContext());
        RecyclerView.LayoutManager lm = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.HORIZONTAL,true);
        recyclerViewPlaylist.setLayoutManager(lm);
        recyclerViewPlaylist.setAdapter(playListAdapter);

        NavigationView navView = getView().findViewById(R.id.nav);

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.i1){
                    Fragment fragment = new ProfileFragment();
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainer, fragment, "profile");
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                if(id == R.id.i2){
                    Fragment fragment = new EditProfileFragment();
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainer, fragment, "editProfile");
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                if(id == R.id.i3){
                    FirebaseAuth.getInstance().signOut();
                    getActivity().finish();
                }
                return true ;
            }
        });
        drawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);

            }
        });
        song.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new SongTitleFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer, fragment, "songTitle");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        postComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new PostCommentFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer, fragment, "postComment");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
    }
}
