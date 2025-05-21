package com.luuhavyy.models;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;

public class Category implements Serializable {
    private int id;
    private String name;
    private int image_id;
    private ArrayList<Product> products; // them vao de co ds sp thuoc category

    public Category() {
        products=new ArrayList<>();
    }

    public Category(int id, String name, int image_id) { // kh lay Array vi minh chua biet trc nen loai khoi constructor day du
        this.id = id;
        this.name = name;
        this.image_id = image_id;
        products=new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
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
    @NonNull
    @Override
    public String toString() {
        String infor=id+"-"+name;
        return infor;
    }

    public void addProduct(Product p)
    {
        products.add(p);
    }
    public void removeProduct(int id) // xoa tren bo nho, khac xoa tren dtb
    {
        Product p=null;
        for (Product item : products)
        {
            if(item.getId()==id)
            {
                p=item;
                break;
            }
        }
        if (p!=null)
        {
            products.remove(p);
        }
    }
}
