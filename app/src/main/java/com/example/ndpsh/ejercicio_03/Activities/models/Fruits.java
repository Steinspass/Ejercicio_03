package com.example.ndpsh.ejercicio_03.Activities.models;

/**
 *  Created by Naim on 30/10/18
 */
public class Fruits {

    public String name;
    public String specs;
    public int limit;
    public int imgback;
    public int imgicon;

    public Fruits () {

    }

        public Fruits(String name, String specs, int limit, int imgback, int imgicon) {
            this.name = name;
            this.specs = specs;
            this.limit = limit;
            this.imgback = imgback;
            this.imgicon = imgicon;
        }

        public String getName() {
        return name;
        }

        public void setName(String name) {
        this.name = name;
        }

        public String getSpecs() {
        return specs;
        }

        public void setSpecs(String specs) {
        this.specs = specs;
        }

        public int getLimit() {
        return limit;
        }

        public void setLimit(int limit) {
        this.limit = limit;
        }

        public int getImgback() {
        return imgback;
        }

        public void setImgback(int imgback) {
        this.imgback = imgback;
        }

        public int getImgicon() {
        return imgicon;
        }

        public void setImgicon(int imgicon) {
        this.imgicon = imgicon;
        }
}
