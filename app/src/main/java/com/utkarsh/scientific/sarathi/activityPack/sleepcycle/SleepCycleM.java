package com.utkarsh.scientific.sarathi.activityPack.sleepcycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.utkarsh.scientific.sarathi.R;

public class SleepCycleM extends AppCompatActivity {

    CardView startSleepCv,historyCv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_cycle_m);


        startSleepCv = findViewById(R.id.startSleepCV);
        historyCv = findViewById(R.id.sleepHistoryCV);


        startSleepCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SleepCycleM.this,StartSleep.class));
            }
        });

        historyCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SleepCycleM.this,SleepHistory.class));
            }
        });

    }
}