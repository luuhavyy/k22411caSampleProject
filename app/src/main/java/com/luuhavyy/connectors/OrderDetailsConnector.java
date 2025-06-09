package com.luuhavyy.connectors;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.luuhavyy.models.OrderDetails;

import java.util.ArrayList;

public class OrderDetailsConnector {

    public ArrayList<OrderDetails> getOrderDetailsByOrderId(SQLiteDatabase database, int orderId) {
        ArrayList<OrderDetails> datasets = new ArrayList<>();

        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("SELECT ");
        sqlBuilder.append("o.Id AS OrderId, ");
        sqlBuilder.append("od.Id AS OrderDetailsId, ");
        sqlBuilder.append("o.Code AS OrderCode, ");
        sqlBuilder.append("o.OrderDate AS OrderDate, ");
        sqlBuilder.append("od.ProductId, ");
        sqlBuilder.append("p.Name AS ProductName, ");
        sqlBuilder.append("od.Quantity, ");
        sqlBuilder.append("od.Price, ");
        sqlBuilder.append("od.Discount, ");
        sqlBuilder.append("od.VAT, ");
        sqlBuilder.append("ROUND(od.Quantity * od.Price * (1 - od.Discount) * (1 + od.VAT), 2) AS TotalValue ");
        sqlBuilder.append("FROM OrderDetails od ");
        sqlBuilder.append("INNER JOIN Orders o ON o.Id = od.OrderId ");
        sqlBuilder.append("INNER JOIN Product p ON od.ProductId = p.Id ");
        sqlBuilder.append("WHERE o.Id = ?");

        Cursor cursor = database.rawQuery(sqlBuilder.toString(), new String[]{String.valueOf(orderId)});

        while (cursor.moveToNext()) {
            OrderDetails od = new OrderDetails();

            od.setId(cursor.getInt(0));
            od.setId(cursor.getInt(1));
            od.setCode(cursor.getString(2));
            od.setOrderDate(cursor.getString(3));
            od.setProductId(cursor.getInt(4));
            od.setProductName(cursor.getString(5));
            od.setQuantity(cursor.getInt(6));
            od.setPrice(cursor.getDouble(7));
            od.setDiscount(cursor.getDouble(8));
            od.setVAT(cursor.getDouble(9));

            // Gán totalValue trực tiếp (nếu muốn override công thức tự động)
            od.setTotalValue(cursor.getDouble(10)); // bạn cần thêm setTotalValue vào model

            datasets.add(od);
        }

        cursor.close();
        return datasets;
    }
}
