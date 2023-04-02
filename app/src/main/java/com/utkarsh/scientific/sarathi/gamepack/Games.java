package com.utkarsh.scientific.sarathi.gamepack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;

import com.utkarsh.scientific.sarathi.R;

public class Games extends AppCompatActivity {

    CardView g1,g2,g3,g4,g5,g6,g7,g8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);

        g1=findViewById(R.id.Game1CV);
        g2=findViewById(R.id.Game2CV);
        g3=findViewById(R.id.Game3CV);
        g4=findViewById(R.id.Game4CV);
        g5=findViewById(R.id.Game5CV);
        g6=findViewById(R.id.Game6CV);
        g7=findViewById(R.id.Game7CV);
        g8=findViewById(R.id.Game8CV);

        g1.setOnClickListener(view ->
        {
            Intent i=new Intent(Games.this,GameView.class);
            String temp ="Mathisfun";
            i.putExtra("url", temp);
            startActivity(i);
        });
        g2.setOnClickListener(view -> {
            Intent i=new Intent(Games.this,GameView.class);
            String temp ="Mindgames";
            i.putExtra("url", temp);
            startActivity(i);
        });
        g3.setOnClickListener(view -> {
            Intent i=new Intent(Games.this,GameView.class);
            String temp ="Smartbrainpuzzles";
            i.putExtra("url", temp);
            startActivity(i);
        });
        g4.setOnClickListener(view -> {
            Intent i=new Intent(Games.this,GameView.class);
            String temp ="Pokigames";
            i.putExtra("url", temp);
            startActivity(i);
        });
        g5.setOnClickListener(view -> {
            Intent i=new Intent(Games.this,GameView.class);
            String temp ="Fastgames";
            i.putExtra("url", temp);
            startActivity(i);
        });
        g6.setOnClickListener(view ->
        {
            Intent i=new Intent(Games.this,GameView.class);
            String temp ="Entanglement";
            i.putExtra("url", temp);
            startActivity(i);
        });
        g7.setOnClickListener(view ->
        {
            Intent i=new Intent(Games.this,GameView.class);
            String temp ="Gridland";
            i.putExtra("url", temp);
            startActivity(i);
        });
        g8.setOnClickListener(view ->
        {
            Intent i=new Intent(Games.this,GameView.class);
            String temp ="Threesjs";
            i.putExtra("url", temp);
            startActivity(i);
        });



    }
}