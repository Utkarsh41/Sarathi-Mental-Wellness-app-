package com.utkarsh.scientific.sarathi.activityPack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.utkarsh.scientific.sarathi.R;
import com.utkarsh.scientific.sarathi.activityPack.mobileusage.MobileUsage;
import com.utkarsh.scientific.sarathi.activityPack.moodtrack.MoodTracker;
import com.utkarsh.scientific.sarathi.activityPack.sleepcycle.SleepCycleM;

import io.reactivex.rxjava3.internal.operators.maybe.MaybeObserveOn;

public class ActivityProgressTrack extends AppCompatActivity {

    CardView moodTrackerCv,sleepCycleCv,mobUsageCv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_track);

        moodTrackerCv = findViewById(R.id.MoodTrackerCV);
        sleepCycleCv = findViewById(R.id.SleepTrackerCV);
        mobUsageCv =findViewById(R.id.MobileUsageCV);

        moodTrackerCv.setOnClickListener(view -> startActivity(new Intent(ActivityProgressTrack.this, MoodTracker.class)));

        sleepCycleCv.setOnClickListener(view -> startActivity(new Intent(ActivityProgressTrack.this, SleepCycleM.class)));
        mobUsageCv.setOnClickListener(view -> {
            startActivity(new Intent(ActivityProgressTrack.this, MobileUsage.class));
        });
    }
}