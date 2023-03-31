package com.utkarsh.scientific.sarathi.activityPack.moodtrack;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
public class DBHandler extends SQLiteOpenHelper
{
    private static final String DB_NAME = "mynotesdb";
    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "allnotes";

    private static final String ID_COL = "id";

    private static final String NOTE_DATE = "notedate";

    private static final String NOTE_DESC = "notedesc";

    public DBHandler(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NOTE_DATE + " TEXT,"
                + NOTE_DESC + " TEXT)";
        db.execSQL(query);
    }

    public void addNewNote(String noteDate, String noteDesc)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NOTE_DATE,noteDate);
        values.put(NOTE_DESC,noteDesc);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public ArrayList<NoteModel> readNotes()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorNotes = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        ArrayList<NoteModel> noteModalArrayList = new ArrayList<>();
        if (cursorNotes.moveToFirst())
        {
            do
            {
                noteModalArrayList.add(new NoteModel(
                        cursorNotes.getString(1),
                        cursorNotes.getString(2)));
            } while (cursorNotes.moveToNext());
        }
        cursorNotes.close();
        return noteModalArrayList;
    }
}