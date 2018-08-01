package com.example.lenovo.jcart;

/**
 * Created by Lenovo on 7/12/2018.
 */


public class Cart1 {
    String email, item_name, item_brand, item_price;

    public Cart1() {
    }

    public Cart1(String email, String item_name, String item_brand, String item_price) {
        this.email = email;
        this.item_brand = item_brand;
        this.item_price = item_price;
        this.item_name = item_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_brand() {
        return item_brand;
    }

    public void setItem_brand(String item_brand) {
        this.item_brand = item_brand;
    }

    public String getItem_price() {
        return item_price;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }
}
