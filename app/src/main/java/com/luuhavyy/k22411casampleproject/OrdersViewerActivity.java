package com.luuhavyy.k22411casampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.luuhavyy.adapters.OrdersViewerAdapter;
import com.luuhavyy.connectors.OrdersViewerConnector;
import com.luuhavyy.connectors.SQLiteConnector;
import com.luuhavyy.models.OrdersViewer;

import java.util.ArrayList;

public class OrdersViewerActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_ORDER_DETAILS = 100;
    ListView lvOrdersViewer;
    OrdersViewerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_orders_viewer);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addViews();
    }

    private void addViews() {
        lvOrdersViewer = findViewById(R.id.lvOrdersViewer);

        SQLiteConnector connector = new SQLiteConnector(this);
        OrdersViewerConnector ovc = new OrdersViewerConnector();

        ArrayList<OrdersViewer> list = ovc.getAllOrdersViewer(connector.openDatabase());

        adapter = new OrdersViewerAdapter(this, R.layout.item_ordersviewer, list);
        lvOrdersViewer.setAdapter(adapter);

        // Xử lý click item để mở chi tiết với orderId
        lvOrdersViewer.setOnItemClickListener((parent, view, position, id) -> {
            OrdersViewer selectedOrder = adapter.getItem(position);
            if (selectedOrder != null) {
                Intent intent = new Intent(OrdersViewerActivity.this, OrderDetailsActivity.class);
                intent.putExtra("orderId", selectedOrder.getId());
                startActivityForResult(intent, REQUEST_CODE_ORDER_DETAILS);
            }
        });
    }

    // Nếu cần nhận kết quả trả về từ OrderDetailsActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ORDER_DETAILS && resultCode == RESULT_OK) {
            // Xử lý khi OrderDetailsActivity trả về (nếu cần)
        }
    }
}
