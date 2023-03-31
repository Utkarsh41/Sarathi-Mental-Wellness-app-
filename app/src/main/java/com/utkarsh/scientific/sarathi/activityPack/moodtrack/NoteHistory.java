package com.utkarsh.scientific.sarathi.activityPack.moodtrack;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.utkarsh.scientific.sarathi.R;

import java.util.ArrayList;

public class NoteHistory extends AppCompatActivity
{
    private ArrayList<NoteModel> noteModalArrayList;
    private DBHandler dbHandler;
    private NoteAdapter noteAdapter;
    private RecyclerView noteRV;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_history);

        noteRV = findViewById(R.id.idRVNotes);
        noteModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(NoteHistory.this);
        noteModalArrayList = dbHandler.readNotes();
        noteAdapter = new NoteAdapter(noteModalArrayList, NoteHistory.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(NoteHistory.this, RecyclerView.VERTICAL, false);
        noteRV.setLayoutManager(linearLayoutManager);
        noteRV.setAdapter(noteAdapter);
    }
}
