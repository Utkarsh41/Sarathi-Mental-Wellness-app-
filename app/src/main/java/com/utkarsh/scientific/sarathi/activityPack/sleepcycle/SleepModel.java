package com.utkarsh.scientific.sarathi.activityPack.sleepcycle;

public class SleepModel {

    private String mDate,mTime;
    private int id;

    public SleepModel(String mDate, String mTime) {
        this.mDate = mDate;
        this.mTime = mTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }
}
