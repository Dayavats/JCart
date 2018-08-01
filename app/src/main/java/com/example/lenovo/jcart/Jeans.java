package com.example.lenovo.jcart;

/**
 * Created by Lenovo on 6/17/2018.
 */

public class Jeans {
    String category,brand,size,price,image,name;
    public Jeans(){}

    public Jeans(String category, String brand, String size, String price, String image, String name) {
        this.category = category;
        this.brand = brand;
        this.size = size;
        this.price = price;
        this.image = image;
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public String getBrand() {
        return brand;
    }

    public String getSize() {
        return size;
    }

    public String getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}


