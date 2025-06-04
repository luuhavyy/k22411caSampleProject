package com.luuhavyy.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.luuhavyy.k22411casampleproject.R;
import com.luuhavyy.models.PaymentMethod;

public class PaymentMethodAdapter extends ArrayAdapter<PaymentMethod> {
    Activity context;
    int resource;
    Typeface typeface;

    public PaymentMethodAdapter(@NonNull Activity context, int resource) {
        super(context, resource);
        this.context=context;
        this.resource=resource;

        this.typeface=Typeface.createFromAsset(
                this.context.getAssets(),
                "fonts/TMC-Ong Do.TTF"
        );
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View item=inflater.inflate(resource,null);
        // lay doi tuong phuong thuc thanh toan o vi tri position
        PaymentMethod pm=getItem(position);
        TextView txtName=item.findViewById(R.id.txtPaymentMethodName);
        TextView txtDescription=item.findViewById(R.id.txtPaymentMethodDescription);
        txtName.setText(pm.getName());
        txtDescription.setText(pm.getDescription());

        txtName.setTypeface(this.typeface);
        return item;
    }
}
