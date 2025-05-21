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

    public void generate_product_dataset()
    {
        Category c1 = new Category(1, "Sunglasses", 110);
        categories.add(c1);
        Category c2 = new Category(2, "Prescription Glasses", 120);
        categories.add(c2);
        Category c3 = new Category(3, "Fashion Glasses", 130);
        categories.add(c3);
        Category c4 = new Category(4, "Blue Light Blocking Glasses", 140);
        categories.add(c4);
        Category c5 = new Category(5, "Safety Glasses", 150);
        categories.add(c5);
        Category c6 = new Category(6, "Contact Lenses", 160);
        categories.add(c6);
        Category c7 = new Category(7, "Men's Frames", 170);
        categories.add(c7);
        Category c8 = new Category(8, "Women's Frames", 180);
        categories.add(c8);
        Category c9 = new Category(9, "Kids' Glasses", 190);
        categories.add(c9);
        Category c10 = new Category(10, "Eyewear Accessories", 200);
        categories.add(c10);

        // ===== Category c1 - Sunglasses =====
        Product p1 = new Product(1, "Ray-Ban Aviator Sunglasses", 10, 149.99, c1.getId());
        c1.addProduct(p1);

        Product p2 = new Product(2, "Oakley Holbrook Sunglasses", 15, 139.99, c1.getId());
        c1.addProduct(p2);

        Product p3 = new Product(3, "Gucci GG0061S Sunglasses", 8, 299.99, c1.getId());
        c1.addProduct(p3);

        Product p4 = new Product(4, "Prada PR01OS Sunglasses", 12, 199.99, c1.getId());
        c1.addProduct(p4);

        Product p5 = new Product(5, "Versace VE4361 Sunglasses", 5, 249.99, c1.getId());
        c1.addProduct(p5);

// ===== Category c2 - Prescription Glasses =====
        Product p6 = new Product(6, "Warby Parker Durand Glasses", 20, 95.00, c2.getId());
        c2.addProduct(p6);

        Product p7 = new Product(7, "Zenni Rectangle Glasses", 30, 39.99, c2.getId());
        c2.addProduct(p7);

        Product p8 = new Product(8, "EyeBuyDirect Prism Glasses", 18, 70.00, c2.getId());
        c2.addProduct(p8);

        Product p9 = new Product(9, "Specsavers Oval Glasses", 12, 59.99, c2.getId());
        c2.addProduct(p9);

        Product p10 = new Product(10, "LensCrafters Round Glasses", 10, 120.00, c2.getId());
        c2.addProduct(p10);

// ===== Category c3 - Fashion Glasses =====
        Product p11 = new Product(11, "Gucci Fashion Glasses", 10, 220.00, c3.getId());
        c3.addProduct(p11);

        Product p12 = new Product(12, "Dior Stellaire Glasses", 15, 310.00, c3.getId());
        c3.addProduct(p12);

        Product p13 = new Product(13, "Chanel Butterfly Glasses", 7, 350.00, c3.getId());
        c3.addProduct(p13);

        Product p14 = new Product(14, "Tom Ford Cat Eye Glasses", 9, 320.00, c3.getId());
        c3.addProduct(p14);

        Product p15 = new Product(15, "Burberry Round Glasses", 14, 260.00, c3.getId());
        c3.addProduct(p15);

// ===== Category c4 - Blue Light Blocking Glasses =====
        Product p16 = new Product(16, "Felix Gray Nash Glasses", 20, 95.00, c4.getId());
        c4.addProduct(p16);

        Product p17 = new Product(17, "MVMT Everscroll Glasses", 22, 75.00, c4.getId());
        c4.addProduct(p17);

        Product p18 = new Product(18, "Pixel Buteo Glasses", 25, 85.00, c4.getId());
        c4.addProduct(p18);

        Product p19 = new Product(19, "Gunnar Optiks Glasses", 30, 59.99, c4.getId());
        c4.addProduct(p19);

        Product p20 = new Product(20, "Cyxus Blue Light Glasses", 28, 39.99, c4.getId());
        c4.addProduct(p20);

// ===== Category c5 - Safety Glasses =====
        Product p21 = new Product(21, "3M Virtua Safety Glasses", 50, 7.99, c5.getId());
        c5.addProduct(p21);

        Product p22 = new Product(22, "Dewalt Anti-Fog Safety Glasses", 40, 10.99, c5.getId());
        c5.addProduct(p22);

        Product p23 = new Product(23, "Honeywell Uvex Safety Glasses", 35, 12.99, c5.getId());
        c5.addProduct(p23);

        Product p24 = new Product(24, "Pyramex Fortress Safety Glasses", 30, 8.99, c5.getId());
        c5.addProduct(p24);

        Product p25 = new Product(25, "Bollé Safety Rush+ Glasses", 20, 14.99, c5.getId());
        c5.addProduct(p25);

        // ===== Category c6 - Contact Lenses =====
        c6.addProduct(new Product(26, "Acuvue Oasys Lenses", 50, 35.99, c6.getId()));
        c6.addProduct(new Product(27, "Biofinity Lenses", 40, 25.99, c6.getId()));
        c6.addProduct(new Product(28, "Air Optix Lenses", 30, 29.99, c6.getId()));
        c6.addProduct(new Product(29, "Dailies AquaComfort", 20, 19.99, c6.getId()));
        c6.addProduct(new Product(30, "Bausch + Lomb Ultra", 25, 24.99, c6.getId()));

        // ===== Category c7 - Men's Frames =====
        c7.addProduct(new Product(31, "Ray-Ban RX5184 Frames", 15, 150.00, c7.getId()));
        c7.addProduct(new Product(32, "Oakley OX8156 Frames", 12, 180.00, c7.getId()));
        c7.addProduct(new Product(33, "Persol PO3050V Frames", 10, 220.00, c7.getId()));
        c7.addProduct(new Product(34, "Tom Ford FT5504 Frames", 8, 250.00, c7.getId()));
        c7.addProduct(new Product(35, "Gucci GG0011O Frames", 7, 300.00, c7.getId()));

        // ===== Category c8 - Women's Frames =====
        c8.addProduct(new Product(36, "Versace VE3186 Frames", 15, 210.00, c8.getId()));
        c8.addProduct(new Product(37, "Chanel CH3281 Frames", 10, 320.00, c8.getId()));
        c8.addProduct(new Product(38, "Kate Spade Lucyann Frames", 12, 175.00, c8.getId()));
        c8.addProduct(new Product(39, "Prada PR16MV Frames", 8, 270.00, c8.getId()));
        c8.addProduct(new Product(40, "Michael Kors MK4058 Frames", 14, 140.00, c8.getId()));

        // ===== Category c9 - Kids' Glasses =====
        c9.addProduct(new Product(41, "Ray-Ban Junior RJ9052S", 20, 69.99, c9.getId()));
        c9.addProduct(new Product(42, "Miraflex New Baby Glasses", 30, 85.00, c9.getId()));
        c9.addProduct(new Product(43, "Disney Princess Glasses", 25, 55.00, c9.getId()));
        c9.addProduct(new Product(44, "Nike Kids 5538 Glasses", 18, 90.00, c9.getId()));
        c9.addProduct(new Product(45, "Oakley Youth OY8005 Glasses", 12, 99.00, c9.getId()));

        // ===== Category c10 - Eyewear Accessories =====
        c10.addProduct(new Product(46, "Lens Cleaning Kit", 100, 9.99, c10.getId()));
        c10.addProduct(new Product(47, "Glasses Case", 120, 12.99, c10.getId()));
        c10.addProduct(new Product(48, "Eyeglass Repair Kit", 80, 8.99, c10.getId()));
        c10.addProduct(new Product(49, "Microfiber Cloth Pack", 150, 5.99, c10.getId()));
        c10.addProduct(new Product(50, "Eyewear Chain", 60, 14.99, c10.getId()));

    }


}
