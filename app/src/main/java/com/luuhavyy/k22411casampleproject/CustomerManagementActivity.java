package com.luuhavyy.k22411casampleproject;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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
import androidx.annotation.Nullable;
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
    final int ID_CREATE_NEW_CUSTOMER=1;
    final int ID_UPDATE_CUSTOMER=2;
    String DATABASE_NAME="SalesDatabase.db";
    private static final String DB_PATH_SUFFIX = "/databases/";
    SQLiteDatabase database=null;

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

        // lc.generate_sample_dataset(); // de goi len bo nho man hinh // bo gia lap
        // lay dtb thuc
        database = openOrCreateDatabase(DATABASE_NAME,
                Context.MODE_PRIVATE, null);

        lc.getAllCustomers(database);
        adapter.addAll(lc.getCustomers());

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
        Intent intent=new Intent(CustomerManagementActivity.this,
                CustomerDetailActivity.class);

        //startActivity(intent);
        startActivityForResult(intent,ID_CREATE_NEW_CUSTOMER); //b1


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==ID_CREATE_NEW_CUSTOMER && resultCode==1000)
        {
        //lay ket qua ra;
        Customer c= (Customer) data.getSerializableExtra("NEW_CUSTOMER");
        //toi day co 2 th luu moi hay update
            process_save_customer(c);
        }

    }

    private void process_save_customer(Customer c) {
        boolean result=lc.isExisting(c);
        if(result==true)//tuc la da ton tai
            return;//khong them moi
            //con neu ta muon cap nhat thi viet tiep code cap nhat
        // cac ma lenh duoi day la them moi customer
        lc.addCustomer(c);
        adapter.clear();
        adapter.addAll(lc.getCustomers());
    }
}