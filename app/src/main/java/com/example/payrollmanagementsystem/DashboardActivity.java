package com.example.payrollmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {

    Button btnAddEmp;
    Button btnSalaryAllowances;
    Button btnSalaryDeduction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        btnAddEmp = findViewById(R.id.btn_add_emp);
        btnSalaryAllowances = findViewById(R.id.btn_Salary_Allowances);
        btnSalaryDeduction = findViewById(R.id.btn_Salary_Deduction);

        btnAddEmp.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),AddEmployeeActivity.class);
                    startActivity(intent);
            }
        });

        btnSalaryAllowances.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SalaryAllowancesActivity.class);
                startActivity(intent);
            }
        });

        btnSalaryDeduction.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SalaryDeductionActivity.class);
                startActivity(intent);
            }
        });
    }
}
