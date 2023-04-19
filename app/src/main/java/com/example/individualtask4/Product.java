package com.example.individualtask4;

import java.io.Serializable;

public class Product implements Serializable {
    String name, Id;
    int price, image;
    boolean box;
    Product(String Id, String describe, int price, int image, boolean box) {
        this.Id = Id;
        this.name = describe;
        this.price = price;
        this.image = image;
        this.box = box;
    }
}