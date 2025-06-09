package com.luuhavyy.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.luuhavyy.k22411casampleproject.R;
import com.luuhavyy.models.OrderDetails;

import java.util.List;

public class OrderDetailsAdapter extends ArrayAdapter<OrderDetails> {
    private final Activity context;
    private final int resource;

    public OrderDetailsAdapter(@NonNull Activity context, int resource, @NonNull List<OrderDetails> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View item = convertView;
        if (item == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            item = inflater.inflate(resource, parent, false);
        }

        OrderDetails od = getItem(position);
        if (od == null) return item;

        TextView txtProductId = item.findViewById(R.id.txtProductId);
        TextView txtProductName = item.findViewById(R.id.txtProductName);
        TextView txtQuantity = item.findViewById(R.id.txtQuantity);
        TextView txtPrice = item.findViewById(R.id.txtPrice);
        TextView txtDiscount = item.findViewById(R.id.txtDiscount);
        TextView txtVAT = item.findViewById(R.id.txtVAT);
        TextView txtTotalValue = item.findViewById(R.id.txtTotalValue);

        // Hiển thị dữ liệu
        txtProductId.setText(String.valueOf(od.getProductId()));
        txtProductName.setText(od.getProductName());
        txtQuantity.setText(String.valueOf(od.getQuantity()));
        txtPrice.setText(String.format("%.2f", od.getPrice()));
        txtDiscount.setText(String.format("%.2f%%", od.getDiscount() * 100)); //db: 0.1 -> hien thi: 10%
        txtVAT.setText(String.format("%.2f%%", od.getVAT() * 100));
        txtTotalValue.setText(String.format("%.2f", od.getTotalValue()));


        return item;
    }
}
