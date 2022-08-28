package com.selimhatipoglu.movieapp;

import android.widget.ImageView;

public class RecylerModel {
    private String image, title,topic,star,time;

    public RecylerModel(String image, String title, String topic, String star, String time) {
        this.image = image;
        this.title = title;
        this.topic = topic;
        this.star = star;
        this.time = time;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
