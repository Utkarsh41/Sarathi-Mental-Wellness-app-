package com.utkarsh.scientific.sarathi.audioTherapyPack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.utkarsh.scientific.sarathi.R;

import java.io.IOException;
import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongAdapterViewHolder> {

    Context context;
    List<AudioModel>ListAudioModels;

    public SongAdapter(Context context, List<AudioModel> listAudioModels) {
        this.context = context;
        ListAudioModels = listAudioModels;
    }

    public void filterList(List<AudioModel> filterlist) {
        ListAudioModels = filterlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SongAdapter.SongAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_item, parent, false);
        return new SongAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongAdapter.SongAdapterViewHolder holder, int position) {
            AudioModel audioModel = ListAudioModels.get(position);
            holder.titleTv.setText(audioModel.getaTitle());
            holder.descTv.setText(audioModel.getaDesc());
    }

    @Override
    public int getItemCount() {
        return ListAudioModels.size();
    }

    public class SongAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView titleTv,descTv;
//        Button playButtonMy;
        public SongAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.audioName_tv);
            descTv = itemView.findViewById(R.id.audioDesc_tv);
//            playButtonMy = itemView.findViewById(R.id.playButton);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            try {
                ((AudioTherapy)context).playSong(ListAudioModels,getAdapterPosition());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
