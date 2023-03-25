package com.utkarsh.scientific.sarathi.audioTherapyPack;

public class AudioModel {

    String aTitle,aDesc,aUrl;

    public AudioModel(){}

    public AudioModel(String aTitle, String aDesc, String aUrl) {
        this.aTitle = aTitle;
        this.aDesc = aDesc;
        this.aUrl = aUrl;
    }

    public String getaTitle() {
        return aTitle;
    }

    public void setaTitle(String aTitle) {
        this.aTitle = aTitle;
    }

    public String getaDesc() {
        return aDesc;
    }

    public void setaDesc(String aDesc) {
        this.aDesc = aDesc;
    }

    public String getaUrl() {
        return aUrl;
    }

    public void setaUrl(String aUrl) {
        this.aUrl = aUrl;
    }
}
