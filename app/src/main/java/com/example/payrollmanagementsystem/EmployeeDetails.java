package com.example.payrollmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class EmployeeDetails extends AppCompatActivity {
    TextView empId;
    TextView name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);

        name = findViewById(R.id.empName);
        empId = findViewById(R.id.empId);

        Intent intent = getIntent();

        String id =intent.getStringExtra("eId");

        empId.setText(id);
        name.setText(intent.getStringExtra("eName"));

    }
}
