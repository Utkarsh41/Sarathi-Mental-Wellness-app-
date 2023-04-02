package com.utkarsh.scientific.sarathi.activityPack.sleepcycle;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.utkarsh.scientific.sarathi.R;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class StartSleep extends AppCompatActivity {

    CardView mEndSleep;
    ImageView anchorIv;
    TextView timeView;
    Animation circleAnim;
    String time;

    private int seconds = 0;

    // Is the stopwatch running?
    private boolean running;

    private boolean wasRunning;

    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_sleep);

        timeView = findViewById(R.id.time_view);
        anchorIv = findViewById(R.id.AcIv);
        circleAnim = AnimationUtils.loadAnimation(this, R.anim.circleanim);
        dbHandler = new DBHandler(StartSleep.this);
        mEndSleep = findViewById(R.id.endSleepCV);


        Calendar calendar = Calendar.getInstance();
        String ajjKiDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());



        if (savedInstanceState != null) {

            seconds
                    = savedInstanceState
                    .getInt("seconds");
            running
                    = savedInstanceState
                    .getBoolean("running");
            wasRunning
                    = savedInstanceState
                    .getBoolean("wasRunning");
        }
        runTimer();


        mEndSleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String currTimeva = timeView.getText().toString();

                dbHandler.addNewCourse("Date:"+ajjKiDate,"Sleep Duration:"+currTimeva);

                Toast.makeText(StartSleep.this, "Data saved", Toast.LENGTH_SHORT).show();
                finish();

            }
        });

    }


    @Override
    public void onSaveInstanceState(
            Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState
                .putInt("seconds", seconds);
        savedInstanceState
                .putBoolean("running", running);
        savedInstanceState
                .putBoolean("wasRunning", wasRunning);
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (wasRunning) {
            running = true;
        }
    }

    public void onClickStart(View view) {
        running = true;
        anchorIv.startAnimation(circleAnim);
    }
    public void onClickStop(View view) {
        running = false;

    }


    public void onClickReset(View view) {
        running = false;
        seconds = 0;
    }

    private void runTimer() {


        final TextView timeView
                = (TextView) findViewById(
                R.id.time_view);

        final Handler handler
                = new Handler();

        handler.post(new Runnable() {
            @Override

            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                time
                        = String
                        .format(Locale.getDefault(),
                                "%d:%02d:%02d", hours,
                                minutes, secs);

                timeView.setText(time);

                if (running) {
                    ++seconds;
                }


                handler.postDelayed(this, 1000);
            }
        });
    }
}