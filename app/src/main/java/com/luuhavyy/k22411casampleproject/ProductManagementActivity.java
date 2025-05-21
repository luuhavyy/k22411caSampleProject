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
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.luuhavyy.models.Category;
import com.luuhavyy.models.ListCategory;
import com.luuhavyy.models.ListProduct;
import com.luuhavyy.models.Product;

public class ProductManagementActivity extends AppCompatActivity {

    Spinner spinnerCategory;
    ArrayAdapter<Category> adapterCategory;
    ListCategory listCategory = new ListCategory();
    ListView lvProduct;
    ArrayAdapter<Product> adapterProduct;
    ListProduct listProduct = new ListProduct();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_management);
        addViews();
        addEvent();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addEvent() {
        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Category c = adapterCategory.getItem(position);
                displayProductByCategory(c);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product p = adapterProduct.getItem(position);
                openProductDetailActivity(p);
            }
        });
    }

    private void openProductDetailActivity(Product p) {
        Intent intent=new Intent(ProductManagementActivity.this,
                ProductDetailActivity.class);
        intent.putExtra("SELECTED_PRODUCT", p);
        startActivity(intent);
    }

    private void displayProductByCategory(Category c) {
        adapterProduct.clear(); // Xóa dữ liệu cũ
        adapterProduct.addAll(c.getProducts()); // Thêm sản phẩm của category được chọn
    }


    private void addViews() {
        // spinner
        spinnerCategory = findViewById(R.id.spinnerCategory);
        adapterCategory = new ArrayAdapter<>(
                ProductManagementActivity.this,
                android.R.layout.simple_spinner_item
        );
        adapterCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapterCategory);

        listCategory.generate_product_dataset();

        adapterCategory.addAll(
                listCategory.getCategories()
        );
        
        
        // listview

        lvProduct = findViewById(R.id.lvProduct);
        adapterProduct = new ArrayAdapter<>(
                ProductManagementActivity.this,
                android.R.layout.simple_list_item_1);


        lvProduct.setAdapter(adapterProduct);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.option_menu_product, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.menu_add_product)
        {
            Toast.makeText(ProductManagementActivity.this,
                    "Mo man hinh them product moi", Toast.LENGTH_LONG).show();
            openAddNewProduct();
        }
        else if (item.getItemId()==R.id.menu_manage_categories)
        {
            Toast.makeText(ProductManagementActivity.this,
                    "Mo man hinh qly category",Toast.LENGTH_LONG).show();
            // tim hieu firebase cloud message
        } else if (item.getItemId()==R.id.menu_product_help)
        {
            Toast.makeText(ProductManagementActivity.this,
                    "Cuu tui voi!!!",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void openAddNewProduct() {
    }
}
