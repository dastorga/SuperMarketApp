package com.example.dario.supermarketapp;


public class DataAdapter {

    public String ImageURL;
    public String ImageTitle;
    public String Adress;

    public String getImageUrl() {
        return ImageURL;
    }

    public void setImageUrl(String imageServerUrl) {
        this.ImageURL = imageServerUrl;
    }

    public String getImageTitle() {
        return ImageTitle;
    }

    public void setImageTitle(String Imagetitlename) {
        this.ImageTitle = Imagetitlename;
    }

    public void setAdress(String Adress) {
        this.Adress = Adress;
    }

    public String getAdress() {
        return  this.Adress;
    }

}
