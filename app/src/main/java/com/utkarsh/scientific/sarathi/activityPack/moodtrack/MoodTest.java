package com.utkarsh.scientific.sarathi.activityPack.moodtrack;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.utkarsh.scientific.sarathi.R;

public class MoodTest extends AppCompatActivity {
    ImageView i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20;

    String loadMoodVidUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_test);
        i1 = findViewById(R.id.awesome);
        i2 = findViewById(R.id.vibechecked);
        i3 = findViewById(R.id.lovedit);
        i4 = findViewById(R.id.cool);
        i5 = findViewById(R.id.party);
        i6 = findViewById(R.id.fun);
        i7 = findViewById(R.id.good);
        i8 = findViewById(R.id.nice);
        i9 = findViewById(R.id.lol);
        i10 = findViewById(R.id.surprised);
        i11 = findViewById(R.id.neutral);
        i12 = findViewById(R.id.notsure);
        i13 = findViewById(R.id.slightysad);
        i14 = findViewById(R.id.sad);
        i15 = findViewById(R.id.dislike);
        i16 = findViewById(R.id.notgood);
        i17 = findViewById(R.id.veryangry);
        i18 = findViewById(R.id.angryandsad);
        i19 = findViewById(R.id.unhappy);
        i20 = findViewById(R.id.cry);

        i1.setOnClickListener(view ->
        {
            Toast.makeText(MoodTest.this, "Awesome Day for the awesome you!", Toast.LENGTH_SHORT).show();
            loadMoodVidUrl = getString(R.string.happyLink);

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(loadMoodVidUrl));
            startActivity(intent);
        });
        i2.setOnClickListener(view ->
        {
            Toast.makeText(MoodTest.this, "Day passed the vibe check! B)", Toast.LENGTH_SHORT).show();loadMoodVidUrl = getString(R.string.happyLink);

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(loadMoodVidUrl));
            startActivity(intent);
        });
        i3.setOnClickListener(view ->
        {
            Toast.makeText(MoodTest.this, "Lovely Day for the lovely you!", Toast.LENGTH_SHORT).show();
            loadMoodVidUrl = getString(R.string.happyLink);

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(loadMoodVidUrl));
            startActivity(intent);
        });
        i4.setOnClickListener(view ->
        {
            Toast.makeText(MoodTest.this, "Cool Day for the super cool you!", Toast.LENGTH_SHORT).show();loadMoodVidUrl = getString(R.string.happyLink);

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(loadMoodVidUrl));
            startActivity(intent);
        });
        i5.setOnClickListener(view ->
        {
            Toast.makeText(MoodTest.this, "Full-on party today!", Toast.LENGTH_SHORT).show();
            loadMoodVidUrl = getString(R.string.happyLink);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(loadMoodVidUrl));
            startActivity(intent);
        });
        i6.setOnClickListener(view ->
        {
            Toast.makeText(MoodTest.this, "Fun Day for the fun you!", Toast.LENGTH_SHORT).show();
            loadMoodVidUrl = getString(R.string.happyLink);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(loadMoodVidUrl));
            startActivity(intent);
        });
        i7.setOnClickListener(view ->
        {
            Toast.makeText(MoodTest.this, "Good Day today 8>", Toast.LENGTH_SHORT).show();
            loadMoodVidUrl = getString(R.string.happyLink);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(loadMoodVidUrl));
            startActivity(intent);
        });
        i8.setOnClickListener(view ->
        {
            Toast.makeText(MoodTest.this, "Nice Day for the very nice you!", Toast.LENGTH_SHORT).show();
            loadMoodVidUrl = getString(R.string.happyLink);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(loadMoodVidUrl));
            startActivity(intent);
        });
        i9.setOnClickListener(view ->
        {
            Toast.makeText(MoodTest.this, "haha lol nice XD", Toast.LENGTH_SHORT).show();
            loadMoodVidUrl = getString(R.string.notsureLink);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(loadMoodVidUrl));
            startActivity(intent);
        });
        i10.setOnClickListener(view ->
        {
            Toast.makeText(MoodTest.this, "Why were you surprised? Write about it", Toast.LENGTH_SHORT).show();  loadMoodVidUrl = getString(R.string.notsureLink);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(loadMoodVidUrl));
            startActivity(intent);
        });
        i11.setOnClickListener(view ->
        {
            Toast.makeText(MoodTest.this, "Keep Taking care of yourself :)", Toast.LENGTH_SHORT).show();  loadMoodVidUrl = getString(R.string.notsureLink);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(loadMoodVidUrl));
            startActivity(intent);
        });
        i12.setOnClickListener(view ->
        {
            Toast.makeText(MoodTest.this, "Wrting about it can help figure it out ;)", Toast.LENGTH_SHORT).show();  loadMoodVidUrl = getString(R.string.notsureLink);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(loadMoodVidUrl));
            startActivity(intent);
        });
        i13.setOnClickListener(view ->
        {
            Toast.makeText(MoodTest.this, "Playing games can help refocus", Toast.LENGTH_SHORT).show();
            loadMoodVidUrl = getString(R.string.slightlysadLink);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(loadMoodVidUrl));
            startActivity(intent);
        });
        i14.setOnClickListener(view ->
        {
            Toast.makeText(MoodTest.this, "Calling your loved ones always helps", Toast.LENGTH_SHORT).show();
            loadMoodVidUrl = getString(R.string.slightlysadLink);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(loadMoodVidUrl));
            startActivity(intent);
        });
        i15.setOnClickListener(view ->
        {
            Toast.makeText(MoodTest.this, "Listening to audio might help", Toast.LENGTH_SHORT).show();
            loadMoodVidUrl = getString(R.string.sadLink);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(loadMoodVidUrl));
            startActivity(intent);
        });
        i16.setOnClickListener(view ->
        {
            Toast.makeText(MoodTest.this, "Talking to Kanha can help", Toast.LENGTH_SHORT).show();
            loadMoodVidUrl = getString(R.string.sadLink);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(loadMoodVidUrl));
            startActivity(intent);
        });
        i17.setOnClickListener(view ->
        {
            Toast.makeText(MoodTest.this, "Anger is always momentary", Toast.LENGTH_SHORT).show();
            loadMoodVidUrl = getString(R.string.angryLink);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(loadMoodVidUrl));
            startActivity(intent);
        });
        i18.setOnClickListener(view ->
        {
            Toast.makeText(MoodTest.this, "Things take time. Talk to Kanha", Toast.LENGTH_SHORT).show();
            loadMoodVidUrl = getString(R.string.unhappyLink);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(loadMoodVidUrl));
            startActivity(intent);
        });
        i19.setOnClickListener(view ->
        {
            Toast.makeText(MoodTest.this, "Help comes to those who seek it", Toast.LENGTH_SHORT).show();
            loadMoodVidUrl = getString(R.string.unhappyLink);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(loadMoodVidUrl));
            startActivity(intent);
        });
        i20.setOnClickListener(view ->
        {
            Toast.makeText(MoodTest.this, "Kanha is always with you", Toast.LENGTH_SHORT).show();
            loadMoodVidUrl = getString(R.string.unhappyLink);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(loadMoodVidUrl));
            startActivity(intent);
        });


    }

}