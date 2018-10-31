package com.example.ndpsh.ejercicio_03.Activities.models;

/**
 *  Created by Naim on 30/10/18
 */
public class Fruits {

    public String name;
    public String specs;
    public int quantity;
    public int imgback;

    // Valores accesibles estáticamente
    public static final int LIMIT_QUANTITY = 10;
    public static final int RESET_VALUE_QUANTITY = 0;


    public Fruits () {

    }

        public Fruits(String name, String specs, int limit, int imgback ) {
            this.name = name;
            this.specs = specs;
            this.quantity = quantity;
            this.imgback = imgback;

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

        public int getQuantity() {
        return quantity;
        }

        public void setQuantity(int quantity) {
        this.quantity = quantity;
        }

        public int getImgback() {
        return imgback;
        }

        public void setImgback(int imgback) {
        this.imgback = imgback;
        }

    // Añadir cantidad
    public void addQuantity(int quantity) {
        if (this.quantity < LIMIT_QUANTITY)
            this.quantity += quantity;
    }

    // Reset cantidad
    public void resetQuantity() {
        this.quantity = RESET_VALUE_QUANTITY;
    }


}
