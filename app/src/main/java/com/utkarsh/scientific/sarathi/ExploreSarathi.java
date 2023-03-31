package com.utkarsh.scientific.sarathi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.utkarsh.scientific.sarathi.activityPack.ActivityProgressTrack;
import com.utkarsh.scientific.sarathi.audioTherapyPack.AudioTherapy;
import com.utkarsh.scientific.sarathi.egitaPack.EGita;
import com.utkarsh.scientific.sarathi.gamepack.Games;
import com.utkarsh.scientific.sarathi.mediPack.MeditationYoga;
import com.utkarsh.scientific.sarathi.sarathiChatbot.SrMainActivity;
import com.utkarsh.scientific.sarathi.selfHelpBooksPack.SelfHelpBooks;
import com.utkarsh.scientific.sarathi.stories.KrishnaStoriesActivity;

public class ExploreSarathi extends AppCompatActivity {
    
    private CardView mTalkWithKrishna,mEGita,mSelfHelpBook,mAudioTherapy,mMeditationYoga,mGames,mActivityProgress,mstory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_sarathi);
        
        mTalkWithKrishna = findViewById(R.id.cv_KrishnaChatbot);
        mEGita = findViewById(R.id.cv_Gita);
        mSelfHelpBook = findViewById(R.id.cv_Selfhelpbook);
        mAudioTherapy = findViewById(R.id.cv_Audiotherapy);
        mMeditationYoga = findViewById(R.id.cv_MeditationndYoga);
        mGames = findViewById(R.id.cardViewGames);
        mActivityProgress = findViewById(R.id.cv_ActivityProgress);
        mstory = findViewById(R.id.storySarathiCv);

        mTalkWithKrishna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ExploreSarathi.this, SrMainActivity.class);
                startActivity(i);
            }
        });
        mEGita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ExploreSarathi.this, EGita.class);
                startActivity(i);
            }
        });
        mSelfHelpBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ExploreSarathi.this, SelfHelpBooks.class);
                startActivity(i);
            }
        });
        mAudioTherapy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ExploreSarathi.this, AudioTherapy.class);
                startActivity(i);
            }
        });
        mMeditationYoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ExploreSarathi.this, MeditationYoga.class);
                startActivity(i);
            }
        });

        mGames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ExploreSarathi.this, Games.class);
                startActivity(i);
            }
        });
        mActivityProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ExploreSarathi.this, ActivityProgressTrack.class);
                startActivity(i);
            }
        });

        mstory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ExploreSarathi.this, KrishnaStoriesActivity.class);
                startActivity(i);
            }
        });

    }
}