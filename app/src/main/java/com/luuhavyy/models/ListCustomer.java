package com.luuhavyy.models;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListCustomer {
    private ArrayList<Customer> customers;

    public ListCustomer() {
        customers=new ArrayList<>();
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public void addCustomer(Customer c)
    {
        customers.add(c);
    }

    public void generate_sample_dataset()
    {
        addCustomer(new Customer(1, "Teo", "teo@gmail.com", "0909076665", "teo", "123"));
        addCustomer(new Customer(2, "Ti", "ti@gmail.com", "0909076655", "ti", "123"));
        addCustomer(new Customer(3, "An", "an@gmail.com", "0909076645", "an", "123"));
        addCustomer(new Customer(4, "Bich", "bich@gmail.com", "0909076635", "bich", "123"));
        addCustomer(new Customer(5, "Cao", "cao@gmail.com", "0909076625", "cao", "123"));
        addCustomer(new Customer(6, "Duy", "duy@gmail.com", "0909076615", "duy", "123"));
        addCustomer(new Customer(7, "Hai", "hai@gmail.com", "0909076605", "hai", "123"));
        addCustomer(new Customer(8, "Hoang", "hoang@gmail.com", "0909076595", "hoang", "123"));
        addCustomer(new Customer(9, "Kien", "kien@gmail.com", "0909076585", "kien", "123"));
        addCustomer(new Customer(10, "Linh", "linh@gmail.com", "0909076575", "linh", "123"));
    }
}
