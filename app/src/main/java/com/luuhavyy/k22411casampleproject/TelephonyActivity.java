package com.luuhavyy.k22411casampleproject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.luuhavyy.adapters.TeleponyInforAdapter;
import com.luuhavyy.models.TelephonyInfor;
import com.luuhavyy.utils.NetworkUtils;

public class TelephonyActivity extends AppCompatActivity {
    ListView lvTelephonyInfor;
    TeleponyInforAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_telephony);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
        readAllContacts();
        addEvents();
    }

    private void readAllContacts() {
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = getContentResolver().query(uri, null, null, null);
        adapter.clear();
        adapter.getOriginalList().clear();
        while (cursor.moveToNext()) {
            int nameIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
            String name = cursor.getString(nameIndex);
            int phoneIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            String phone = cursor.getString(phoneIndex);

            TelephonyInfor ti = new TelephonyInfor();
            ti.setDisplayName(name);
            ti.setPhoneNumber(phone);
            adapter.add(ti);
        }
        cursor.close();
    }

    private void addViews() {
        lvTelephonyInfor = findViewById(R.id.lvTelephonyInfor);
        adapter = new TeleponyInforAdapter(this, R.layout.item_telephonyinfor);
        lvTelephonyInfor.setAdapter(adapter);
    }

    private void addEvents() {
        lvTelephonyInfor.setOnItemClickListener((parent, view, position, id) -> {
            TelephonyInfor ti = adapter.getItem(position);
            callDialup(ti);
        });

        lvTelephonyInfor.setOnItemLongClickListener((parent, view, position, id) -> {
            TelephonyInfor ti = adapter.getItem(position);
            sendSms(ti, "Hello from LuuHaVy's App");
            return true;
        });
    }

    public void sendSms(TelephonyInfor ti, String content) {
        final SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(ti.getPhoneNumber(), null, content, null, null);
        Toast.makeText(TelephonyActivity.this, "Đã gửi tin nhắn tới " + ti.getPhoneNumber(), Toast.LENGTH_LONG).show();
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    public void sendSmsPendingIntent(TelephonyInfor ti, String content) {
        final SmsManager sms = SmsManager.getDefault();
        Intent msgSent = new Intent("ACTION_MSG_SENT");
        final PendingIntent pendingMsgSent = PendingIntent.getBroadcast(this, 0, msgSent, PendingIntent.FLAG_IMMUTABLE);
        registerReceiver(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                int result = getResultCode();
                String msg = "Send OK";
                if (result != Activity.RESULT_OK) {
                    msg = "Send failed";
                }
                Toast.makeText(TelephonyActivity.this, msg, Toast.LENGTH_LONG).show();
            }
        }, new IntentFilter("ACTION_MSG_SENT"));

        sms.sendTextMessage(ti.getPhoneNumber(), null, content, pendingMsgSent, null);
    }

    public void callDirect(TelephonyInfor ti) {
        Uri uri = Uri.parse("tel:" + ti.getPhoneNumber());
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(uri);
        startActivity(intent);
    }

    public void callDialup(TelephonyInfor ti) {
        Uri uri = Uri.parse("tel:" + ti.getPhoneNumber());
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(uri);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu_telephony, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_viettel) {
            adapter.filterList("Viettel");
            return true;
        } else if (id == R.id.action_mobifone) {
            adapter.filterList("Mobifone");
            return true;
        } else if (id == R.id.action_vinaphone) {
            adapter.filterList("Vinaphone");
            return true;
        } else if (id == R.id.action_vietnamobile) {
            adapter.filterList("Vietnamobile");
            return true;
        } else if (id == R.id.action_all) {
            adapter.resetList();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
