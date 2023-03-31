package com.utkarsh.scientific.sarathi.activityPack.moodtrack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import com.utkarsh.scientific.sarathi.R;

public class MoodTracker extends AppCompatActivity {

    CardView moodhistory,moodtest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_tracker);
        moodhistory=findViewById(R.id.MoodHistoryCV);
        moodtest=findViewById(R.id.MoodTestCV);

        moodhistory.setOnClickListener(view ->
        {
            Intent i=new Intent(MoodTracker.this,MoodHistory.class);
            startActivity(i);
        });
        moodtest.setOnClickListener(view ->
        {
            Intent i=new Intent(MoodTracker.this,MoodTest.class);
            startActivity(i);
        });
    }

}