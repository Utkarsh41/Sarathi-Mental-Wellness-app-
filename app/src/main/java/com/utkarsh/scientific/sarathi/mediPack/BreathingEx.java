package com.utkarsh.scientific.sarathi.mediPack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.utkarsh.scientific.sarathi.R;

public class BreathingEx extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathing_ex);

        CardView br1,br2,br3,br4,br5,br6,br7,br8,br9;
        TextView brTv1,brTv2,brTv3,brTv4,brTv5,brTv6,brTv7,brTv8,brTv9;
        brTv1 = findViewById(R.id.Breathing1);
        brTv2 = findViewById(R.id.Breathing2);
        brTv3 = findViewById(R.id.Breathing3);
        brTv4 = findViewById(R.id.Breathing4);
        brTv5 = findViewById(R.id.Breathing5);
        brTv6 = findViewById(R.id.Breathing6);
        brTv7 = findViewById(R.id.Breathing7);
        brTv8 = findViewById(R.id.Breathing8);


        br1=findViewById(R.id.Breathingcd1);
        br2=findViewById(R.id.Breathingcd2);
        br3=findViewById(R.id.Breathingcd3);
        br4=findViewById(R.id.Breathingcd4);
        br5=findViewById(R.id.Breathingcd5);
        br6=findViewById(R.id.Breathingcd6);
        br7=findViewById(R.id.Breathingcd7);
        br8=findViewById(R.id.Breathingcd8);



        br1.setOnClickListener(view -> {
            Intent i=new Intent(BreathingEx.this,Breathingdes.class);
            String temp = (String) brTv1.getText();
            i.putExtra("AssanName",temp);
            startActivity(i);
        });

        br2.setOnClickListener(view -> {
            Intent i=new Intent(BreathingEx.this,Breathingdes.class);
            String temp = (String) brTv2.getText();
            i.putExtra("AssanName",temp);
            startActivity(i);
        });

        br3.setOnClickListener(view -> {
            Intent i=new Intent(BreathingEx.this,Breathingdes.class);
            String temp = (String) brTv3.getText();
            i.putExtra("AssanName",temp);
            startActivity(i);
        });

        br4.setOnClickListener(view -> {
            Intent i=new Intent(BreathingEx.this,Breathingdes.class);
            String temp = (String) brTv4.getText();
            i.putExtra("AssanName",temp);
            startActivity(i);
        });

        br5.setOnClickListener(view -> {
            Intent i=new Intent(BreathingEx.this,Breathingdes.class);
            String temp = (String) brTv5.getText();
            i.putExtra("AssanName",temp);
            startActivity(i);
        });

        br6.setOnClickListener(view -> {
            Intent i=new Intent(BreathingEx.this,Breathingdes.class);
            String temp = (String) brTv6.getText();
            i.putExtra("AssanName",temp);
            startActivity(i);
        });

        br7.setOnClickListener(view -> {
            Intent i=new Intent(BreathingEx.this,Breathingdes.class);
            String temp = (String) brTv7.getText();
            i.putExtra("AssanName",temp);
            startActivity(i);
        });

        br8.setOnClickListener(view -> {
            Intent i=new Intent(BreathingEx.this,Breathingdes.class);
            String temp = (String) brTv8.getText();
            i.putExtra("AssanName",temp);
            startActivity(i);
        });




    }
}