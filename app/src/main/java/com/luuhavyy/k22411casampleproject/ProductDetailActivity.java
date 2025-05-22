package com.luuhavyy.k22411casampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.luuhavyy.models.Product;

public class ProductDetailActivity extends AppCompatActivity {

    EditText edtProductId, edtProductName, edtProductQuantity, edtProductPrice, edtProductCateId, edtProductImageId;
    Button btnNewProduct, btnSaveProduct, btnRemoveProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
    }

    private void addViews() {
        edtProductId = findViewById(R.id.edtProductId);
        edtProductName = findViewById(R.id.edtProductName);
        edtProductQuantity = findViewById(R.id.edtProductQuantity);
        edtProductPrice = findViewById(R.id.edtProductPrice);
        edtProductCateId = findViewById(R.id.edtProductCateId);
        edtProductImageId = findViewById(R.id.edtProductImageId);

        display_product_details();

        btnNewProduct = findViewById(R.id.btnNewProduct);
        btnSaveProduct = findViewById(R.id.btnSaveProduct);
        btnRemoveProduct = findViewById(R.id.btnRemoveProduct);


    }

    private void display_product_details() {
        Intent intent=getIntent();
        Product p = (Product) intent.getSerializableExtra("SELECTED_PRODUCT");

        edtProductId.setText(String.valueOf(p.getId()));
        edtProductName.setText(p.getName());
        edtProductQuantity.setText(String.valueOf(p.getQuantity()));
        edtProductPrice.setText(String.valueOf(p.getPrice()));
        edtProductCateId.setText(String.valueOf(p.getCateid()));
        edtProductImageId.setText(String.valueOf(p.getImage_id()));

    }
}