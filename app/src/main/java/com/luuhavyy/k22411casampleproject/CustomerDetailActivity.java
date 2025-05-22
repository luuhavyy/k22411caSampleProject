package com.luuhavyy.k22411casampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.luuhavyy.models.Customer;

public class CustomerDetailActivity extends AppCompatActivity {
    EditText edt_customer_id;
    EditText edt_customer_name;
    EditText edt_customer_email;
    EditText edt_customer_username;
    EditText edt_customer_phone;
    EditText edt_customer_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_customer_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
    }

    private void addViews() {
        edt_customer_id=findViewById(R.id.edtCustomerId);
        edt_customer_name=findViewById(R.id.edtCustomerName);
        edt_customer_email=findViewById(R.id.edtCustomerEmail);
        edt_customer_username=findViewById(R.id.edtCustomerUsername);
        edt_customer_phone=findViewById(R.id.edtCustomerPhone);
        edt_customer_password=findViewById(R.id.edtCustomerPassword);
        display_customer_details();
    }

    private void display_customer_details() {
        // lay intent
        Intent intent=getIntent();
        // Lay customer lie n quan ten bien dat trong intent
        Customer c = (Customer) intent.getSerializableExtra("SELECTED_CUSTOMER");

        // neu truyen so vao thi can dua ve chuoi no moi chay dc
        edt_customer_id.setText(c.getId()+"");
        // kh can chuoi ne
        edt_customer_name.setText(c.getName());
        edt_customer_email.setText(c.getEmail());
        edt_customer_username.setText(c.getUsername());
        edt_customer_phone.setText(c.getPhone());
        edt_customer_password.setText(c.getPassword());
    }
}