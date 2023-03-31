package com.utkarsh.scientific.sarathi.activityPack.moodtrack;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.utkarsh.scientific.sarathi.R;

import java.text.DateFormat;
import java.util.Calendar;

public class MoodHistory extends AppCompatActivity
{
    TextView title;
    CalendarView calendar;
    Button addNote, viewButton;
    EditText todaysNote;
    String currDate;
    private DBHandler dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_history);

        dbh = new DBHandler(MoodHistory.this);

        Calendar c= Calendar.getInstance();
        currDate= DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        calendar = findViewById(R.id.calendar);
        title = findViewById(R.id.MoodHistoryTitle);

        calendar.setOnDateChangeListener((view, y, m, d) ->
        {
            currDate=DateFormat.getDateInstance(DateFormat.FULL).format(view.getDate());
             title.setText((String) (d + "/" + m + "/" + y));
        });

        todaysNote = findViewById(R.id.note);
        addNote = findViewById(R.id.addButton);
        viewButton = findViewById(R.id.viewButton);

        addNote.setOnClickListener(view ->
        {
            String note=todaysNote.getText().toString();
            if (note.isEmpty())
            {
                Toast.makeText(MoodHistory.this, "Write a little", Toast.LENGTH_SHORT).show();
            }
            else
            {
                dbh.addNewNote(currDate,note);
                todaysNote.setText("");
                Toast.makeText(MoodHistory.this, "Yay! New Note Added", Toast.LENGTH_SHORT).show();
            }
        });
        viewButton.setOnClickListener(view -> startActivity(new Intent(MoodHistory.this,NoteHistory.class)));
    }
}