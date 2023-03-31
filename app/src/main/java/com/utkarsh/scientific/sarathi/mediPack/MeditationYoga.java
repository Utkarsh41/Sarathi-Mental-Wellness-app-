package com.utkarsh.scientific.sarathi.mediPack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;

import com.utkarsh.scientific.sarathi.R;

public class MeditationYoga extends AppCompatActivity {

    CardView yog,be;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation_yoga);

        yog=findViewById(R.id.ExerciseCd1);
        be=findViewById(R.id.ExerciseCd3);

        yog.setOnClickListener(view -> {
            Intent i=new Intent(this,Yoga.class);
            startActivity(i);
        });

        be.setOnClickListener(view -> {
            Intent i=new Intent(this,BreathingEx.class);
            startActivity(i);
        });

    }
}