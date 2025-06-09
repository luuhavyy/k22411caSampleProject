package com.luuhavyy.k22411casampleproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.luuhavyy.adapters.PaymentMethodAdapter;
import com.luuhavyy.connectors.PaymentMethodConnector;
import com.luuhavyy.connectors.SQLiteConnector;
import com.luuhavyy.models.ListPaymentMethod;
import com.luuhavyy.models.PaymentMethod;

import java.util.ArrayList;

public class PaymentMethodActivity extends AppCompatActivity {

    ListView lvPaymentMethod;
    PaymentMethodAdapter adapter;
    ListPaymentMethod lpm;
    String DATABASE_NAME="SalesDatabase.db";
    private static final String DB_PATH_SUFFIX = "/databases/";
    SQLiteDatabase database=null;
    PaymentMethodConnector pmc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_payment_method);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
    }

    private void addViews() {
        lvPaymentMethod=findViewById(R.id.lvPaymentMethod);
        adapter=new PaymentMethodAdapter(
                PaymentMethodActivity.this,
                R.layout.item_payment_method
        );

        lvPaymentMethod.setAdapter(adapter);
        lpm=new ListPaymentMethod();
        //lpm.gen_payment_method();

        //CACH 1: dung ket noi sql o file model/listpm
        /*database = openOrCreateDatabase(DATABASE_NAME,
                Context.MODE_PRIVATE, null);
        lpm.getAllPaymentMethod(database);
        adapter.addAll(lpm.getPaymentMethods());*/

        //CACH 2: dung connector
        pmc=new PaymentMethodConnector();
        SQLiteConnector connector=new SQLiteConnector(this);
        ArrayList<PaymentMethod>datasets=pmc.getAllPaymentMethods(connector.openDatabase());
        adapter.addAll(datasets);

    }
}