package com.example.practice.Model;

public class Stations  {
    public Stations(int id, String title, String englishTitle, int line, String address, String lang, String lat, String description) {
        Id = id;
        this.title = title;
        EnglishTitle = englishTitle;
        this.line = line;
        this.address = address;
        this.lang = lang;
        this.lat = lat;
        this.description = description;
    }

    int Id;
    String title;
    String EnglishTitle;
    int line;
    String address;
    String lat;
    String lang;
    String description;

    public Stations(){

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEnglishTitle() {
        return EnglishTitle;
    }

    public void setEnglishTitle(String englishTitle) {
        EnglishTitle = englishTitle;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
