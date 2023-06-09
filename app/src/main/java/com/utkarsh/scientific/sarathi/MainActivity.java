package com.utkarsh.scientific.sarathi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView mquoteTv;
    private   android.widget.Button exploreSarathiButton;
    private ImageSlider mImageSlider;
    SeekBar mseekbarforMentalState;
    int currentprogress;
    String mintprogress = "0";

    String[] myQuotes = {"There are three gates to self-destruction and hell: Lust, Anger & Greed.",
            "A man is made by his beliefs. As he believes. So he becomes.",
            "The Key to happiness is the reduction of desires.",
            "Do everything you have to do, but not with ego, not with lust, not with envy but with love, compassion, humility, and devotion.",
            "Happiness is a state of mind, that has nothing to do with the external world.",
            "Set your heart upon your work but never its reward."
    };
    String[] happy = { "The mind is restless and difficult to restrain, but it is subdued by practice.",
            "The mind acts like an enemy for those who do not control it.",
            "Live a well-balanced life, it will bring peace.",
            "Why do you worry unnecessarily? Whom do you fear? Who can kill you? The soul is neither born nor dies.",
            "Your present is all you have.",
            "Play Your obligatory duty, because the action is far better than inaction."
    };
    String[] sad = { "To sustain the health of your mind, you have to find your temperament and act in line with it.",
            "Fear not. What is not real never was and never will be. What is real always was and cannot be destroyed.",
            "The mind is restless and difficult to restrain, but it is subdued by practice.",
            "Even the wise are confused about what is action and what is inaction",
            "Play Your obligatory duty, because the action is far better than inaction.",
            "Do not let your heart be troubled. Trust in Krishna."
    };
    ImageView stateImgIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageSlider = findViewById(R.id.imageSlider);
        exploreSarathiButton = findViewById(R.id.exploreSarathiBtn);
        mquoteTv=findViewById(R.id.quoteTv);

        mseekbarforMentalState = findViewById(R.id.seekbarForMstate);
        stateImgIv = findViewById(R.id.mentalStateIv);

        mseekbarforMentalState.setMax(100);
        mseekbarforMentalState.setProgress(45);

        ArrayList<SlideModel>slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://media.istockphoto.com/id/1078375966/photo/radha-krishna-deity-idol-iskcon-temple-pune-maharashtra.jpg?s=612x612&w=0&k=20&c=AN-C70pIqUv_qHGWoJFk8TGqT2DugsoIY3TZisPWAjU=", ScaleTypes.FIT));
//        slideModels.add(new SlideModel("https://media.istockphoto.com/id/825661616/photo/radha-krishna.jpg?s=612x612&w=0&k=20&c=0NKVsOX-niSvV4mSoR85g13xaTdwW2NLXnuDw_cVVdk=", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://t3.ftcdn.net/jpg/05/37/17/08/240_F_537170831_OniDsuoqNdJqDwTbHK9AMmmrnSBN5cse.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://media.istockphoto.com/id/1256464257/photo/hindu-god-krishna.jpg?s=612x612&w=0&k=20&c=dIw1s35P59535go_imkdd7MN4R_iMq1584F3pqhrM4c=", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://media.istockphoto.com/id/1063960518/photo/hindu-god-krishna.jpg?b=1&s=170667a&w=0&k=20&c=gQVFsmBQw50-3X4RQagwmJ58yZIwP623oZG_E2SDIJU=", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://images.unsplash.com/photo-1625580917212-e86139d26e1c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OHx8a3Jpc2huYXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://media.istockphoto.com/id/1460979015/photo/mahabharat-rath.jpg?b=1&s=170667a&w=0&k=20&c=pmcna0imdoVAQ_PDkzRH3UKtrtEltLkgeoMzQY1kDGs=", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://media.istockphoto.com/id/962532758/photo/a-statue-of-the-hindu-god-krishna-and-his-devotee-arjuna-at-parmarth-niketan-in-rishikesh.jpg?b=1&s=170667a&w=0&k=20&c=5nutJ_J-d0X_ejHX2-6ba69EwqrLu-SaBdHrNgZ0wns=", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://t4.ftcdn.net/jpg/00/34/67/81/240_F_34678175_G1Naqk8Yz1fcX5yeVr6RKZtTbv4EkkZr.jpg", ScaleTypes.FIT));
        mImageSlider.setImageList(slideModels,ScaleTypes.FIT);


        mseekbarforMentalState.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentprogress = progress;
                mintprogress = String.valueOf(currentprogress);

                if(currentprogress<=20){
                    stateImgIv.setImageResource(R.drawable.sad);
                    Random rand = new Random();
                    int qNum = rand.nextInt(5);
                    String str = sad[qNum]+"\n\t-Shri Krishna";
                    mquoteTv.setText(str);
                }
                if(currentprogress>20 && currentprogress<=40){
                    stateImgIv.setImageResource(R.drawable.neutral);
                    Random rand = new Random();
                    int qNum = rand.nextInt(5);
                    String str = myQuotes[qNum]+"\n\t-Shri Krishna";
                    mquoteTv.setText(str);
                }
                if(currentprogress>40 && currentprogress<=60){

                    stateImgIv.setImageResource(R.drawable.happiness);
                    Random rand = new Random();
                    int qNum = rand.nextInt(5);
                    String str = happy[qNum]+"\n\t-Shri Krishna";
                    mquoteTv.setText(str);

                }
                if(currentprogress>60 && currentprogress<=80){
                    stateImgIv.setImageResource(R.drawable.smilingface);
                    Random rand = new Random();
                    int qNum = rand.nextInt(5);
                    String str = happy[qNum]+"\n\t-Shri Krishna";
                    mquoteTv.setText(str);
                }
                if(currentprogress>80) {
                    stateImgIv.setImageResource(R.drawable.laughing);
                    Random rand = new Random();
                    int qNum = rand.nextInt(5);
                    String str = happy[qNum]+"\n\t-Shri Krishna";
                    mquoteTv.setText(str);
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Random rand = new Random();
        int qNum = rand.nextInt(5);
        String str = happy[qNum]+"\n\t-Shri Krishna";
        mquoteTv.setText(str);


        exploreSarathiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,ExploreSarathi.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_ut, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.action_AboutUs){
            Intent i = new Intent(MainActivity.this, AboutUs.class);
            startActivity(i);
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }

}