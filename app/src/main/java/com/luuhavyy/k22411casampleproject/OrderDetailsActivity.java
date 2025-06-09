package com.luuhavyy.k22411casampleproject;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.luuhavyy.adapters.OrderDetailsAdapter;
import com.luuhavyy.connectors.OrderDetailsConnector;
import com.luuhavyy.connectors.SQLiteConnector;
import com.luuhavyy.models.OrderDetails;

import java.util.ArrayList;

public class OrderDetailsActivity extends AppCompatActivity {
    ListView lvOrderDetails;
    OrderDetailsAdapter adapter;

    TextView txtOrderId, txtOrderCode, txtOrderDate, txtTotalValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order_details);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Khai báo TextView
        txtOrderId = findViewById(R.id.txtOrderId);
        txtOrderCode = findViewById(R.id.txtOrderCode);
        txtOrderDate = findViewById(R.id.txtOrderDate);
        txtTotalValue = findViewById(R.id.txtFinalTotal);

        lvOrderDetails = findViewById(R.id.lvOrderDetails);

        // Mở database và lấy dữ liệu
        SQLiteConnector connector = new SQLiteConnector(this);
        OrderDetailsConnector odc = new OrderDetailsConnector();

        // Lấy orderId từ intent
        int orderId = getIntent().getIntExtra("orderId", -1);
        if (orderId == -1) {
            finish();
            return;
        }

        // Lấy danh sách chi tiết order theo orderId
        ArrayList<OrderDetails> list = odc.getOrderDetailsByOrderId(connector.openDatabase(), orderId);
        adapter = new OrderDetailsAdapter(this, R.layout.item_orderdetails, list);
        lvOrderDetails.setAdapter(adapter);

        // Hiển thị các thông tin tổng quan order
        // Tạm tính tổng cuối theo công thức: sum(quantity * price * (1 - discount) * (1 + VAT))
        double totalFinalValue = 0;
        for (OrderDetails od : list) {
            totalFinalValue += od.getQuantity() * od.getPrice() * (1 - od.getDiscount()) * (1 + od.getVAT());
        }

        // Gán giá trị lên TextView
        txtOrderId.setText(String.valueOf(orderId));
        // Nếu bạn có thể lấy thêm orderCode và orderDate từ intent hoặc database thì set thêm
        // Ví dụ giả sử bạn truyền qua intent hoặc lấy thêm trong connector:
        String orderCode = getIntent().getStringExtra("orderCode");
        String orderDate = getIntent().getStringExtra("orderDate");
        if (orderCode != null) txtOrderCode.setText(orderCode);
        if (orderDate != null) txtOrderDate.setText(orderDate);

        txtTotalValue.setText(String.format("%.2f", totalFinalValue));
    }
}
