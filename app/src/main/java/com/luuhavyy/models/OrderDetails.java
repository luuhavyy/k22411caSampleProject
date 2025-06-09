package com.luuhavyy.models;

public class OrderDetails extends Orders{
    private int id;
    private int productId;
    private String productName;
    private int quantity;
    private double price;
    private double discount;
    private double VAT;
    private double TotalValue;

    // Constructor rỗng (nếu cần)
    public OrderDetails() {
    }

    // Getter - Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getVAT() {
        return VAT;
    }

    public void setVAT(double VAT) {
        this.VAT = VAT;
    }

    public double getTotalValue() {
        return TotalValue;
    }

    public void setTotalValue(double totalValue) {
        TotalValue = totalValue;
    }

//    // TotalValue tính theo công thức: quantity * price * (1 - discount) * (1 + VAT)
//    public double getTotalValue() {
//        return quantity * price * (1 - discount) * (1 + VAT);
//    }
}
