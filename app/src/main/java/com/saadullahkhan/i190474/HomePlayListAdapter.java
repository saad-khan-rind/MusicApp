package com.saadullahkhan.i190474;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HomePlayListAdapter extends RecyclerView.Adapter<HomePlayListAdapter.MyViewHolder> {
    List<PlayList> ls;
    Context c;

    public HomePlayListAdapter(List<PlayList> ls, Context c) {
        this.ls = ls;
        this.c = c;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(c).inflate(R.layout.home_play_list_row,parent,false);
        return new MyViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(ls.get(position).getName());
        holder.dp.setImageURI(ls.get(position).getDp());
    }

    @Override
    public int getItemCount() {
        return ls.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        ImageView dp;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.homePlaylistName);
            dp = itemView.findViewById(R.id.homePlaylistDP);
        }
    }
}
