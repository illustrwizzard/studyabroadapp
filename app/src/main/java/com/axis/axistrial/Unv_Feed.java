package com.axis.axistrial;

public class Unv_Feed {
    String university_name;
    String feed;
    String feed_image;
    String youtube;
    public Unv_Feed(String university_name,String feed,String feed_image,String youtube) {
        this.university_name=university_name;
        this.feed=feed;
        this.feed_image=feed_image;
        this.youtube=youtube;
    }

    public String getUniversity_name() {
        return university_name;
    }

    public void setUniversity_name(String university_name) {
        this.university_name = university_name;
    }

    public String getFeed() {
        return feed;
    }

    public void setFeed(String feed) {
        this.feed = feed;
    }

    public String getFeed_image() {
        return feed_image;
    }

    public void setFeed_image(String feed_image) {
        this.feed_image = feed_image;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }
}
