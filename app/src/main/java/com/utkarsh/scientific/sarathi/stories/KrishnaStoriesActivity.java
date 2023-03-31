package com.utkarsh.scientific.sarathi.stories;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.utkarsh.scientific.sarathi.R;

import java.util.ArrayList;
import java.util.List;

public class KrishnaStoriesActivity extends AppCompatActivity {


    RecyclerView mStoryRecyclerView;
    ProgressBar progressBar;
    DatabaseReference databaseReference;
    ValueEventListener valueEventListener;
    List<StoryModal> storyModalList;
    StoryRvAdapter storyRvAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_krishna_stories);


        databaseReference = FirebaseDatabase.getInstance().getReference().child("krishnaStories");
        mStoryRecyclerView = findViewById(R.id.rvStories);

        progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);

        mStoryRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        storyModalList = new ArrayList<>();
        storyRvAdapter = new StoryRvAdapter(KrishnaStoriesActivity.this, storyModalList);
        mStoryRecyclerView.setAdapter(storyRvAdapter);

        valueEventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                storyModalList.clear();
                for (DataSnapshot dss : snapshot.getChildren()) {
                    StoryModal storyModal = dss.getValue(StoryModal.class);
//                    audioModel.setaDesc(
                    storyModalList.add(storyModal);
                }
                storyRvAdapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(KrishnaStoriesActivity.this, "" + error.getMessage(), Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);

            }
        });


    }
}