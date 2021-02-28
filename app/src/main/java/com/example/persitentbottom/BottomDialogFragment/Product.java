package com.example.persitentbottom.BottomDialogFragment;

import java.io.Serializable;

public class Product implements Serializable {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product(String name) {
        this.name = name;
    }
}
