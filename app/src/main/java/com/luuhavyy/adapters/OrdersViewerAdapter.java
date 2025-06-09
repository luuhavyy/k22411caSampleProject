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
import com.luuhavyy.models.OrdersViewer;

import java.util.List;

public class OrdersViewerAdapter extends ArrayAdapter<OrdersViewer> {
    private final Activity context;
    private final int resource;

    public OrdersViewerAdapter(@NonNull Activity context, int resource, @NonNull List<OrdersViewer> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(resource, null);

        OrdersViewer ov = getItem(position);
        if (ov == null) return item;

        TextView txtOrderCode = item.findViewById(R.id.txtOrderCode);
        TextView txtOrderDate = item.findViewById(R.id.txtOrderDate);
        TextView txtEmployeeName = item.findViewById(R.id.txtEmployeeName);
        TextView txtCustomerName = item.findViewById(R.id.txtCustomerName);
        TextView txtTotalValue = item.findViewById(R.id.txtTotalValue);

        txtOrderCode.setText(ov.getOrderCode());
        txtOrderDate.setText(ov.getOrderDate());
        txtEmployeeName.setText(ov.getEmployeeName());
        txtCustomerName.setText(ov.getCustomerName());
        txtTotalValue.setText(String.valueOf(ov.getFinalTotal()));

        return item;
    }
}
