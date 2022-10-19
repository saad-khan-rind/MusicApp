package com.saadullahkhan.i190474;

import android.graphics.Bitmap;
import android.net.Uri;

public class PlayList {
    String name;
    int numberOfSongs;
    Uri dp;

    public PlayList(String name, int numberOfSongs, Uri dp) {
        this.name = name;
        this.numberOfSongs = numberOfSongs;
        this.dp = dp;
    }
    public PlayList(String name) {
        this.name = name;
        this.numberOfSongs = 0;
        this.dp = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfSongs() {
        return numberOfSongs;
    }

    public void setNumberOfSongs(int numberOfSongs) {
        this.numberOfSongs = numberOfSongs;
    }

    public Uri getDp() {
        return dp;
    }

    public void setDp(Uri dp) {
        this.dp = dp;
    }
}
