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
        anchorIv.startAnimation(circleAnim);
        dbHandler = new DBHandler(StartSleep.this);
        mEndSleep = findViewById(R.id.endSleepCV);


        Calendar calendar = Calendar.getInstance();
        String ajjKiDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        Toast.makeText(StartSleep.this, ""+ajjKiDate, Toast.LENGTH_SHORT).show();
        Log.d("AJJ KI Date",ajjKiDate);



        if (savedInstanceState != null) {

            // Get the previous state of the stopwatch
            // if the activity has been
            // destroyed and recreated.
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


    // Save the state of the stopwatch
    // if it's about to be destroyed.

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

    // If the activity is paused,
    // stop the stopwatch.
    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = running;
        running = false;
    }

    // If the activity is resumed,
    // start the stopwatch
    // again if it was running previously.
    @Override
    protected void onResume() {
        super.onResume();
        if (wasRunning) {
            running = true;
        }
    }

    // Start the stopwatch running
    // when the Start button is clicked.
    // Below method gets called
    // when the Start button is clicked.
    public void onClickStart(View view) {
        running = true;
    }

    // Stop the stopwatch running
    // when the Stop button is clicked.
    // Below method gets called
    // when the Stop button is clicked.
    public void onClickStop(View view) {
        running = false;
    }

    // Reset the stopwatch when
    // the Reset button is clicked.
    // Below method gets called
    // when the Reset button is clicked.
    public void onClickReset(View view) {
        running = false;
        seconds = 0;
    }

    // Sets the NUmber of seconds on the timer.
    // The runTimer() method uses a Handler
    // to increment the seconds and
    // update the text view.
    private void runTimer() {

        // Get the text view.
        final TextView timeView
                = (TextView) findViewById(
                R.id.time_view);

        // Creates a new Handler
        final Handler handler
                = new Handler();

        // Call the post() method,
        // passing in a new Runnable.
        // The post() method processes
        // code without a delay,
        // so the code in the Runnable
        // will run almost immediately.
        handler.post(new Runnable() {
            @Override

            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                // Format the seconds into hours, minutes,
                // and seconds.
                time
                        = String
                        .format(Locale.getDefault(),
                                "%d:%02d:%02d", hours,
                                minutes, secs);

                // Set the text view text.
                timeView.setText(time);

                // If running is true, increment the
                // seconds variable.
                if (running) {
                    ++seconds;
                }

                // Post the code again
                // with a delay of 1 second.
                handler.postDelayed(this, 1000);
            }
        });
    }
}