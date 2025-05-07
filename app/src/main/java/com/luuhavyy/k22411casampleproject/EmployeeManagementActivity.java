package com.luuhavyy.k22411casampleproject;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EmployeeManagementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_employee_management);
        addViews();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            ScrollView scrollView = findViewById(R.id.main);
            scrollView.post(() -> {
                int scrollContentHeight = scrollView.getChildAt(0).getHeight();
                int scrollViewHeight = scrollView.getHeight();
                Log.d("ScrollCheck", "Content height: " + scrollContentHeight + ", View height: " + scrollViewHeight);
            });

            return insets;

        });
    }

    private void addViews() {
        TableLayout tableLayout = findViewById(R.id.tblEmployees);
        Resources res = getResources();

        for (int i = 1; i <= 50; i++) {
            TableRow row = new TableRow(this);

            TextView tvId = new TextView(this);
            tvId.setText(String.valueOf(i));
            tvId.setTextSize(20);
            tvId.setPadding(8, 8, 8, 8);

            TextView tvName = new TextView(this);
            int nameResId = res.getIdentifier("emp_name_" + i, "string", getPackageName());
            tvName.setText(res.getString(nameResId));
            tvName.setTextSize(20);
            tvName.setPadding(8, 8, 8, 8);

            TextView tvPosition = new TextView(this);
            tvPosition.setText(res.getString(R.string.emp_position_default));
            tvPosition.setTextSize(20);
            tvPosition.setPadding(8, 8, 8, 8);

            row.addView(tvId);
            row.addView(tvName);
            row.addView(tvPosition);

            tableLayout.addView(row);
        }
    }
}
