package com.luuhavyy.models;

import androidx.annotation.NonNull;

public class PaymentMethod {
    private int id;
    private String name;
    private String description;

    public PaymentMethod() {
    }

    public PaymentMethod(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public PaymentMethod(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NonNull
    @Override
    public String toString() {
        return this.name;
    }
}
