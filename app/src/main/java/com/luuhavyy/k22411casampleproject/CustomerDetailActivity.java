package com.luuhavyy.k22411casampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    Button bthNew, btnSave, btnRemove;

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
        addEvents();
    }

    private void addEvents() {
        bthNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                do_new();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                do_save();
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                do_remove();
            }
        });
    }

    private void do_remove() {

    }

    private void do_save() {
        // khoi tao doi tuong tu giao dien
        Customer c=new Customer();
        c.setId(Integer.parseInt(edt_customer_id.getText().toString()));
        c.setName(edt_customer_name.getText().toString());
        c.setEmail(edt_customer_email.getText().toString());
        c.setUsername(edt_customer_username.getText().toString());
        c.setPhone(edt_customer_phone.getText().toString());
        c.setPassword(edt_customer_password.getText().toString());


        //lay intent tu man hinh goi no de su dung
        Intent intent=getIntent();
        //dong goi Customer vao intent
        intent.putExtra("NEW_CUSTOMER", c);
        //dong dau de gui du lieu ve
        setResult(1000, intent);

        //sau do bat buoc phai dong man hinh nay lai
        //vi dien thoai kh cho phep cung 1 luc tai 1 vi tri co 2 man hinh
        //mac du dt co chua nang chia man hinh ra nhieu phan
        //de hien thi nhieu phan mem
        finish();
    }

    private void do_new() {
    }


    private void addViews() {
        edt_customer_id=findViewById(R.id.edtCustomerId);
        edt_customer_name=findViewById(R.id.edtCustomerName);
        edt_customer_email=findViewById(R.id.edtCustomerEmail);
        edt_customer_username=findViewById(R.id.edtCustomerUsername);
        edt_customer_phone=findViewById(R.id.edtCustomerPhone);
        edt_customer_password=findViewById(R.id.edtCustomerPassword);
        display_customer_details();

        bthNew=findViewById(R.id.btnNew);
        btnSave=findViewById(R.id.btnSave);
        btnRemove=findViewById(R.id.btnRemove);
    }

    private void display_customer_details() {
        // lay intent
        Intent intent=getIntent();
        // Lay customer lie n quan ten bien dat trong intent
        Customer c = (Customer) intent.getSerializableExtra("SELECTED_CUSTOMER");

        if (c==null) // phai co kh no bao loi
            return;

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