package com.example.dario.supermarketapp.dummy;

/**
 * Created by Juned on 2/8/2017.
 */

public class DataAdapter
{
    public String ImageURL;
    public String ImageTitle;

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

}