package com.example.musicselector;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class SongListAdapter extends RecyclerView.Adapter<SongListAdapter.SongViewHolder> {

    private LinkedList<String> songs;
    private LayoutInflater songListLinflater;

    class SongViewHolder extends RecyclerView.ViewHolder{
        public final TextView songTitleTextView;
        final SongListAdapter slAdaptor;

        public SongViewHolder(View itemView, SongListAdapter adapter) {
            super(itemView);
            songTitleTextView = itemView.findViewById(R.id.song_title);
            this.slAdaptor = adapter;
        }

    }

    public SongListAdapter(Context context, LinkedList<String> songs){
        this.songs = songs;
        songListLinflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public SongListAdapter.SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View songView = songListLinflater.inflate(R.layout.music_list_item,parent,false);
        return new SongViewHolder(songView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull SongListAdapter.SongViewHolder holder, int position) {
        String currentSongText = songs.get(position);
        holder.songTitleTextView.setText(currentSongText);
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }
}
