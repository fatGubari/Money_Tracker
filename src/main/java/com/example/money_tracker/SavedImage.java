package com.example.money_tracker;

public class SavedImage {
    String title,photo;
    int Id;

    public SavedImage() {
    }

    public SavedImage(String title, String photo) {
        this.title = title;
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

}
