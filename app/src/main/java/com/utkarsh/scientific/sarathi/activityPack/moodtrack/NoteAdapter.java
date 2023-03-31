package com.utkarsh.scientific.sarathi.activityPack.moodtrack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.utkarsh.scientific.sarathi.R;

import java.util.ArrayList;

public class NoteAdapter  extends RecyclerView.Adapter<NoteAdapter.ViewHolder>
{
    private ArrayList<NoteModel> noteModelArrayList;
    private Context context;
     public NoteAdapter(ArrayList<NoteModel> noteModelArrayList, Context context)
     {
        this.noteModelArrayList = noteModelArrayList;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rvitem_mood, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        NoteModel modal = noteModelArrayList.get(position);
        holder.noteDate.setText(modal.getNoteDate());
        holder.noteDesc.setText(modal.getNoteDesc());
    }

    @Override
    public int getItemCount()
    {
        return noteModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView noteDate,noteDesc;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            noteDate= itemView.findViewById(R.id.displayNoteDate);
            noteDesc = itemView.findViewById(R.id.displayNoteDesc);
        }
    }
}
