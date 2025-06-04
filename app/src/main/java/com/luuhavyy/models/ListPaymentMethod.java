package com.luuhavyy.models;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ListPaymentMethod {
    ArrayList<PaymentMethod> paymentMethods;

    public ListPaymentMethod() {
        // Khởi tạo danh sách để tránh NullPointerException
        paymentMethods = new ArrayList<>();
    }

    public ArrayList<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(ArrayList<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public void gen_payment_method() {
        // Xóa dữ liệu cũ nếu có, để tránh trùng lặp khi gọi nhiều lần
        paymentMethods.clear();

        paymentMethods.add(new PaymentMethod(1, "Banking Account", "Bank transfer"));
        paymentMethods.add(new PaymentMethod(2, "MOMO", "ewallet"));
        paymentMethods.add(new PaymentMethod(3, "Cash", "cash pay"));
        paymentMethods.add(new PaymentMethod(4, "COD", "cash on delivery"));
    }
    public void getAllPaymentMethod(SQLiteDatabase database)
    {
        Cursor cursor = database.rawQuery("SELECT * FROM PaymentMethod",
                null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String description = cursor.getString(2);

            PaymentMethod pm=new PaymentMethod();
            pm.setId(id);
            pm.setDescription(description);
            pm.setName(name);

            paymentMethods.add(pm);
        }
        cursor.close();
    }
}
