package com.example.lenovo.jcart;

import static android.R.attr.name;
import static android.R.attr.password;

/**
 * Created by Lenovo on 6/28/2018.
 */

public class User {
    String name,email,password;
    public User(){}
    public User(String name,String email,String Password){
        this.name=name;
        this.email=email;
        this.password=password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
