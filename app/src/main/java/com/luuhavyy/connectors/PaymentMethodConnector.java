package com.luuhavyy.connectors;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.luuhavyy.models.Customer;
import com.luuhavyy.models.PaymentMethod;

import java.util.ArrayList;

public class PaymentMethodConnector {
    public ArrayList<PaymentMethod> getAllPaymentMethods(SQLiteDatabase database)
    {
        Cursor cursor = database.rawQuery("SELECT * FROM PaymentMethod",
                null);
        ArrayList<PaymentMethod> datasets=new ArrayList<>();
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String description = cursor.getString(2);

            PaymentMethod pm=new PaymentMethod();
            pm.setId(id);
            pm.setDescription(description);
            pm.setName(name);

            datasets.add(pm);
        }
        cursor.close();
        return datasets;
    }
}
