package com.saadullahkhan.i190474;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class Home extends AppCompatActivity {

    BottomNavigationView bottomNav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNav = findViewById(R.id.bottomNavigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new HomeFragment(),"home").commit();
        bottomNav.getMenu().findItem(R.id.bNavHome).setChecked(true);
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.bNavHome){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new HomeFragment(),"home").addToBackStack(null).commit();
                }else if(item.getItemId() == R.id.bNavLiked){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new LikedFragment(),"liked").addToBackStack(null).commit();
                }else if(item.getItemId() == R.id.bNavLater){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new LaterFragment(),"later").addToBackStack(null).commit();
                }else if(item.getItemId() == R.id.bNavSearch){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new SearchFragment(),"search").addToBackStack(null).commit();
                }else if(item.getItemId() == R.id.bNavAdd){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new AddFragment(),"add").addToBackStack(null).commit();
                }
                return true;
            }
        });
        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                if(getSupportFragmentManager().findFragmentByTag("home") != null && getSupportFragmentManager().findFragmentByTag("home").isVisible()){
                    bottomNav.getMenu().findItem(R.id.bNavHome).setChecked(true);
                }else if(getSupportFragmentManager().findFragmentByTag("liked") != null && getSupportFragmentManager().findFragmentByTag("liked").isVisible()){
                    bottomNav.getMenu().findItem(R.id.bNavLiked).setChecked(true);
                }else if(getSupportFragmentManager().findFragmentByTag("later") != null && getSupportFragmentManager().findFragmentByTag("later").isVisible()){
                    bottomNav.getMenu().findItem(R.id.bNavLater).setChecked(true);
                }else if(getSupportFragmentManager().findFragmentByTag("search") != null && getSupportFragmentManager().findFragmentByTag("search").isVisible()){
                    bottomNav.getMenu().findItem(R.id.bNavSearch).setChecked(true);
                }else if(getSupportFragmentManager().findFragmentByTag("add") != null && getSupportFragmentManager().findFragmentByTag("add").isVisible()){
                    bottomNav.getMenu().findItem(R.id.bNavAdd).setChecked(true);
                }else if(getSupportFragmentManager().findFragmentByTag("uploadMusic") != null && getSupportFragmentManager().findFragmentByTag("uploadMusic").isVisible()){
                    bottomNav.getMenu().findItem(R.id.bNavAdd).setChecked(true);
                }else if(getSupportFragmentManager().findFragmentByTag("record") != null && getSupportFragmentManager().findFragmentByTag("record").isVisible()){
                    bottomNav.getMenu().findItem(R.id.bNavAdd).setChecked(true);
                }else if(getSupportFragmentManager().findFragmentByTag("selectPlayList") != null && getSupportFragmentManager().findFragmentByTag("selectPlayList").isVisible()){
                    bottomNav.getMenu().findItem(R.id.bNavAdd).setChecked(true);
                }else if(getSupportFragmentManager().findFragmentByTag("songTitle") != null && getSupportFragmentManager().findFragmentByTag("songTitle").isVisible()){
                    bottomNav.getMenu().findItem(R.id.bNavHome).setChecked(true);
                }else if(getSupportFragmentManager().findFragmentByTag("postComment") != null && getSupportFragmentManager().findFragmentByTag("postComment").isVisible()){
                    bottomNav.getMenu().findItem(R.id.bNavHome).setChecked(true);
                }else if(getSupportFragmentManager().findFragmentByTag("profile") != null && getSupportFragmentManager().findFragmentByTag("profile").isVisible()){
                    bottomNav.getMenu().findItem(R.id.bNavHome).setChecked(true);
                }else if(getSupportFragmentManager().findFragmentByTag("editProfile") != null && getSupportFragmentManager().findFragmentByTag("editProfile").isVisible()){
                    bottomNav.getMenu().findItem(R.id.bNavHome).setChecked(true);
                }
            }
        });

    }
}