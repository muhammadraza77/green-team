package com.example.mujtaba.greenteam;

/**
 * Created by Mujtaba on 1/3/2019.
 */

public class video {
    private String Thumbnail;
    private String id;
    private String Title;
    private String Description;
    private String Likes;
    private String Dislikes;

    public video(String thumbnail, String id, String title, String description, String likes, String dislikes) {
        Thumbnail = thumbnail;
        this.id = id;
        Title = title;
        Description = description;
        Likes = likes;
        Dislikes = dislikes;
    }

    public video() {
    }

    public String getThumbnail() {

        return Thumbnail;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public String getLikes() {
        return Likes;
    }

    public String getDislikes() {
        return Dislikes;
    }
}
