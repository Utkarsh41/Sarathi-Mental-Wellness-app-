package com.utkarsh.scientific.sarathi.activityPack.sleepcycle;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.utkarsh.scientific.sarathi.R;

import java.util.ArrayList;

public class SleepHistory extends AppCompatActivity {

    private ArrayList<SleepModel> sleepModalArrayList;
    private DBHandler dbHandler;
    private SleepAdapter sleepAdapter;
    private RecyclerView coursesRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_history);

        coursesRV = findViewById(R.id.idRVCourses);
        sleepModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(SleepHistory.this);

        sleepModalArrayList = dbHandler.readCourses();

        sleepAdapter = new SleepAdapter(sleepModalArrayList, SleepHistory.this);
        coursesRV = findViewById(R.id.idRVCourses);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SleepHistory.this, RecyclerView.VERTICAL, false);
        coursesRV.setLayoutManager(linearLayoutManager);

        coursesRV.setAdapter(sleepAdapter);

    }
}