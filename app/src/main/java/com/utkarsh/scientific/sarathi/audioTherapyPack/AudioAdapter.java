package com.utkarsh.scientific.sarathi.audioTherapyPack;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.utkarsh.scientific.sarathi.R;
import com.utkarsh.scientific.sarathi.selfHelpBooksPack.ItemClickListerner;

public class AudioAdapter extends RecyclerView.ViewHolder implements View.OnClickListener {


    public ItemClickListerner listerner;
    private final Context context;

    public TextView audioTitle,audioDes;
    public ImageView mplayButton,mpauseButton;

    public AudioAdapter(@NonNull View itemView) {
        super(itemView);
        context = itemView.getContext();
        audioTitle=itemView.findViewById(R.id.audioName_tv);
        audioDes=itemView.findViewById(R.id.audioDesc_tv);
        mplayButton = itemView.findViewById(R.id.playButton);

          }


    @Override
    public void onClick(View view) {
        listerner.onClick(view,getAdapterPosition(),false);
    }
}
