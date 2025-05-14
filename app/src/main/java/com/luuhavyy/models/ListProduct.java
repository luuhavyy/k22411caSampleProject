package com.luuhavyy.models;

import java.util.ArrayList;

public class ListProduct {
    private ArrayList<Product> products;

    public ListProduct() {
        products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void generate_sample_dataset() {
        products.add(new Product(1, "Ray-Ban Aviator Sunglasses", 10, 149.99, 1)); // Sunglasses
        products.add(new Product(2, "Oakley Safety Glasses", 20, 89.99, 5));       // Safety Glasses
        products.add(new Product(3, "Tom Ford Fashion Glasses", 15, 199.99, 3));   // Fashion Glasses
        products.add(new Product(4, "Blue Light Glasses Classic", 25, 49.99, 4));  // Blue Light Blocking
        products.add(new Product(5, "Daily Contact Lenses (30 Pack)", 50, 29.99, 6)); // Contact Lenses
        products.add(new Product(6, "Men's Metal Frame Glasses", 30, 99.99, 7));   // Men's Frames
        products.add(new Product(7, "Women's Round Frame Glasses", 28, 89.99, 8)); // Women's Frames
        products.add(new Product(8, "Kids’ Flexible Glasses", 40, 59.99, 9));      // Kids' Glasses
        products.add(new Product(9, "Lens Cleaning Kit", 100, 9.99, 10));          // Eyewear Accessories
        products.add(new Product(10, "Prescription Glasses - Basic", 18, 129.99, 2)); // Prescription Glasses
    }
}
