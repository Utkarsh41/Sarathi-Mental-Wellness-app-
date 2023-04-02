package com.utkarsh.scientific.sarathi.selfHelpBooksPack;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.utkarsh.scientific.sarathi.R;
import com.utkarsh.scientific.sarathi.audioTherapyPack.AudioModel;

import java.util.List;

public class Adapter extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ItemClickListerner listerner;
    private final Context context;
    public TextView bookTitle;

    public Adapter(@NonNull View itemView) {
        super(itemView);
        context = itemView.getContext();
        bookTitle=itemView.findViewById(R.id.bookName_tv);
    }

    @Override
    public void onClick(View view) {
        listerner.onClick(view,getAdapterPosition(),false);
    }
}

// Sarathi@2023krishna
