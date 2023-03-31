package com.utkarsh.scientific.sarathi.activityPack.moodtrack;
public class NoteModel
{
    private String noteDate, noteDesc;
    private int id;
    public NoteModel(String noteDate, String noteDesc)
    {
        this.noteDate = noteDate;
        this.noteDesc = noteDesc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(String noteDate) {
        this.noteDate = noteDate;
    }
    public String getNoteDesc() {
        return noteDesc;
    }

    public void setNoteDesc(String noteDesc) {
        this.noteDesc = noteDesc;
    }
}
