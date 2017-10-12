package com.example.dario.supermarketapp;


public class DataAdapterProduct {

    private String ImageURL;
    private String ImageTitle;
    private String Price;
    private String Description;


    public String getImageUrlProduct() {
        return ImageURL;
    }

    public void setImageUrlProduct(String imageServerUrl) {
        this.ImageURL = imageServerUrl;
    }

    public String getImageTitleProduct() {
        return ImageTitle;
    }

    public void setImageTitleProduct(String Imagetitlename) {
        this.ImageTitle = Imagetitlename;
    }

    public void setPriceProduct(String Price) {
        this.Price = Price;
    }

    public String getPriceProduct() {
        return  this.Price;
    }

    public void setDescriptionProduct(String Description) {
        this.Description = Description;
    }

    public String getDescriptionProduct() {
        return  this.Description;
    }

}
