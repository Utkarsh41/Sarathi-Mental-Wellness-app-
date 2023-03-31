package com.utkarsh.scientific.sarathi.stories;

public class StoryModal {
    String storyTitle, storyDesc, imgUrl;

    StoryModal() {
    }

    public StoryModal(String storyTitle, String storyDesc, String imgUrl) {
        this.storyTitle = storyTitle;
        this.storyDesc = storyDesc;
        this.imgUrl = imgUrl;
    }

    public String getStoryTitle() {
        return storyTitle;
    }

    public void setStoryTitle(String storyTitle) {
        this.storyTitle = storyTitle;
    }

    public String getStoryDesc() {
        return storyDesc;
    }

    public void setStoryDesc(String storyDesc) {
        this.storyDesc = storyDesc;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


}
