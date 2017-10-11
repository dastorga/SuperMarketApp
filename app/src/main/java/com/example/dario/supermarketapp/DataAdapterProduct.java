package com.example.dario.supermarketapp;


public class DataAdapterProduct {

    public String ImageURL;
    public String ImageTitle;
    public String Price;
    public String Description;


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

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getPrice() {
        return  this.Price;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getDescription() {
        return  this.Description;
    }

}
