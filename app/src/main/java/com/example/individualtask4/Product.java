package com.example.individualtask4;

public class Product {
    String name, Id;
    int price;
    int image;
    boolean box;

    Product(String _Id, String _describe, int _price, int _image, boolean _box) {
        Id = _Id;
        name = _describe;
        price = _price;
        image = _image;
        box = _box;
    }
}