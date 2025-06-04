package com.luuhavyy.connectors;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.luuhavyy.models.Employee;
import com.luuhavyy.models.ListEmployee;

public class EmployeeConnector {
    Activity context;
    String DATABASE_NAME="SalesDatabase.db";
    private static final String DB_PATH_SUFFIX = "/databases/";
    SQLiteDatabase database=null;
    public EmployeeConnector()
    {

    }

    public EmployeeConnector(Activity context) {
        this.context = context;
    }

    public Employee login(Activity context,String usr, String pwd)
    {
        //truy van sqlite database
        database = context.openOrCreateDatabase(DATABASE_NAME,
                Context.MODE_PRIVATE, null);

        Cursor cursor = database.rawQuery(
                "SELECT * FROM Employee WHERE UserName = ? AND Password = ?",
                new String[]{usr, pwd}
        );
        Employee emp=null;
        if (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String phone = cursor.getString(2);
            String email = cursor.getString(3);
            String username = cursor.getString(4);
            String password = cursor.getString(5);
            int saveInfor = cursor.getInt(6);

            emp = new Employee();
            emp.setId(id);
            emp.setName(name);
            emp.setEmail(email);
            emp.setPhone(phone);
            emp.setUsername(username);
            emp.setPassword(password);
            emp.setSaveinfor(saveInfor==1?true:false);

            // TODO: làm gì đó với dữ liệu lấy ra
        }

        cursor.close();

        return emp;
    }
    public Employee login(String usr, String pwd)
    {
        ListEmployee le=new ListEmployee();
        le.generate_sample_dataset();
        for(Employee e : le.getEmployees())
        {
            if(e.getUsername().equalsIgnoreCase(usr) && e.getPassword().equals(pwd))
            {
                return e;
            }
        }
        return null;
    }
}
