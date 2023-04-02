package com.utkarsh.scientific.sarathi.activityPack.sleepcycle;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "sleepdb";

    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "mysleep";

    private static final String ID_COL = "id";

    private static final String NAME_D = "mdate";

    private static final String DURATION_T = "duration";


    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_D + " TEXT,"
                + DURATION_T + " TEXT)";

        db.execSQL(query);
    }

    public void addNewCourse(String sleepDate, String sleepDuration) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NAME_D, sleepDate);
        values.put(DURATION_T, sleepDuration);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public ArrayList<SleepModel> readCourses()
    {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses
                = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);


        ArrayList<SleepModel> courseModalArrayList
                = new ArrayList<>();
        if (cursorCourses.moveToFirst()) {
            do {

                courseModalArrayList.add(new SleepModel(
                        cursorCourses.getString(1),
                        cursorCourses.getString(2)));
            } while (cursorCourses.moveToNext());

        }

        cursorCourses.close();
        return courseModalArrayList;
    }

}
