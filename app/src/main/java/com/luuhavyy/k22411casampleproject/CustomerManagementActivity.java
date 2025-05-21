package com.luuhavyy.k22411casampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.luuhavyy.models.Customer;
import com.luuhavyy.models.ListCustomer;

public class CustomerManagementActivity extends AppCompatActivity {

    ListView lvCustomer;
    ArrayAdapter<Customer> adapter;
    ListCustomer lc=new ListCustomer();

    MenuItem menu_broadcast_advertising;
    MenuItem menu_new_customer;
    MenuItem menu_help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_customer_management);
        addViews();
        addEvents();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addEvents() {
        lvCustomer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Customer c=adapter.getItem(position);
                openCustomerDetailActivity(c);
            }
        });
    }

    private void openCustomerDetailActivity(Customer c) {
        Intent intent=new Intent(CustomerManagementActivity.this,
                CustomerDetailActivity.class);
        intent.putExtra("SELECTED_CUSTOMER", c);
        startActivity(intent);

    }

    private void addViews() {
        lvCustomer=findViewById(R.id.lvCustomer);
        adapter=new ArrayAdapter<>(
                CustomerManagementActivity.this,
                android.R.layout.simple_list_item_1);
        lc.generate_sample_dataset(); // de goi len bo nho man hinh
        adapter.addAll(lc.getCustomers()); // de no tu dong ve

        lvCustomer.setAdapter(adapter);

        menu_new_customer=findViewById(R.id.menu_new_customer);
        menu_broadcast_advertising=findViewById(R.id.menu_broadcast_advertising);
        menu_help=findViewById(R.id.menu_help);
    }

    // Them sau khi co option menu xml
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.option_menu_customer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.menu_new_customer)
        {
            Toast.makeText(CustomerManagementActivity.this,
                    "Mo man hinh them KH moi", Toast.LENGTH_LONG).show();
            openNewCustomerActivity();
        } 
        else if (item.getItemId()==R.id.menu_broadcast_advertising) 
        {
            Toast.makeText(CustomerManagementActivity.this,
                    "Ban tin quang cao toi hang loat KH",Toast.LENGTH_LONG).show(); 
            // tim hieu firebase cloud message
        } else if (item.getItemId()==R.id.menu_help) 
        {
            Toast.makeText(CustomerManagementActivity.this,
                    "Cuu tui voi!!!",Toast.LENGTH_LONG).show();    
        }
        return super.onOptionsItemSelected(item);
    }


    private void openNewCustomerActivity() {
        // hom sau lam 26/5 - rat kho
    }
}