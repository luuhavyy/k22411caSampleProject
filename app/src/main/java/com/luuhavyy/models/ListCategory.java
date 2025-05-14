package com.luuhavyy.models;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ListCategory {
    private ArrayList<Category> categories;
    public ListCategory(){
        categories=new ArrayList<>();
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }
    public void addCategory(Category cgr)
    {
        categories.add(cgr);
    }

    public void generate_sample_dataset()
    {
        categories.add(new Category(1, "Sunglasses"));
        categories.add(new Category(2, "Prescription Glasses"));
        categories.add(new Category(3, "Fashion Glasses"));
        categories.add(new Category(4, "Blue Light Blocking Glasses"));
        categories.add(new Category(5, "Safety Glasses"));
        categories.add(new Category(6, "Contact Lenses"));
        categories.add(new Category(7, "Men's Frames"));
        categories.add(new Category(8, "Women's Frames"));
        categories.add(new Category(9, "Kids' Glasses"));
        categories.add(new Category(10, "Eyewear Accessories"));
    }


}
