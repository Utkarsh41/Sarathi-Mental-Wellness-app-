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
        // initializing our all variables.
        sleepModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(SleepHistory.this);

        // getting our course array
        // list from db handler class.
        sleepModalArrayList = dbHandler.readCourses();

        // on below line passing our array list to our adapter class.
        sleepAdapter = new SleepAdapter(sleepModalArrayList, SleepHistory.this);
        coursesRV = findViewById(R.id.idRVCourses);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SleepHistory.this, RecyclerView.VERTICAL, false);
        coursesRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        coursesRV.setAdapter(sleepAdapter);

    }
}