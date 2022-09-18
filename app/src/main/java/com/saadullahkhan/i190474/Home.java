package com.saadullahkhan.i190474;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;


public class Home extends AppCompatActivity {

    Button drawer;
    DrawerLayout drawerLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        drawer = findViewById(R.id.drawerButton);
        drawerLayout = findViewById(R.id.drawerLayout);

        NavigationView navView = findViewById(R.id.nav);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.i1){
                    startActivity(new Intent(Home.this, Profile.class));
                }
                if(id == R.id.i2){
                    startActivity(new Intent(Home.this, EditProfile.class));
                }
                if(id == R.id.i3){
                    startActivity(new Intent(Home.this, SignIn.class));
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
    }

    public void onAddHome(View v){
        startActivity(new Intent(Home.this, AddMusic.class));
    }
    public void onSearchHome(View v){
        startActivity(new Intent(Home.this, Search.class));
    }
    public void onCommentHome(View v){
        startActivity(new Intent(Home.this, PostComment.class));
    }
    public void onLikedHome(View v){
        startActivity(new Intent(Home.this, Liked.class));
    }
    public void onLaterHome(View v){
        startActivity(new Intent(Home.this, Later.class));
    }
    public void onTitleHome(View v){
        startActivity(new Intent(Home.this, SongTitle.class));
    }

}