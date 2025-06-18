package com.luuhavyy.adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.luuhavyy.k22411casampleproject.R;
import com.luuhavyy.k22411casampleproject.SendSMSActivity;
import com.luuhavyy.k22411casampleproject.TelephonyActivity;
import com.luuhavyy.models.TelephonyInfor;
import com.luuhavyy.utils.NetworkUtils;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.List;

public class TeleponyInforAdapter extends ArrayAdapter<TelephonyInfor> {
    Activity context;
    int resource;

    private List<TelephonyInfor> originalList = new ArrayList<>();

    public List<TelephonyInfor> getOriginalList() {
        return originalList;
    }

    public void setOriginalList(List<TelephonyInfor> originalList) {
        this.originalList = originalList;
    }

    public TeleponyInforAdapter(@NonNull Activity context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public void add(@Nullable TelephonyInfor object) {
        super.add(object);
        if (object != null) {
            originalList.add(object);
        }
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View item = inflater.inflate(this.resource, null);

        TextView txtTelephonyInforName = item.findViewById(R.id.txtTelephonyInforName);
        TextView txtTelephonyInforPhone = item.findViewById(R.id.txtTelephonyInforPhone);

        TelephonyInfor ti = getItem(position);
        txtTelephonyInforName.setText(ti.getDisplayName());
        txtTelephonyInforPhone.setText(ti.getPhoneNumber());

        ImageView imgCallDirect = item.findViewById(R.id.imgCallDirect);
        imgCallDirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TelephonyActivity) context).callDirect(ti);
            }
        });

        ImageView imgCallDial = item.findViewById(R.id.imgCallDialup);
        imgCallDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TelephonyActivity) context).callDialup(ti);
            }
        });

        ImageView imgSms = item.findViewById(R.id.imgSms);
        imgSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SendSMSActivity.class);
                intent.putExtra("TI", ti);
                context.startActivity(intent);
            }
        });

        return item;
    }

    public void filterList(String carrier) {
        clear();
        List<TelephonyInfor> snapshot = new ArrayList<>(originalList);

        for (TelephonyInfor ti : snapshot) {
            if (NetworkUtils.getCarrier(ti.getPhoneNumber()).equals(carrier)) {
                super.add(ti);
            }
        }

        notifyDataSetChanged();
    }

    public void resetList() {
        clear();
        addAll(originalList);
        notifyDataSetChanged();
    }
}
