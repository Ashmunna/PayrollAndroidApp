package com.example.payrollmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {

    Button btnAddEmp;
    Button btnShowEmployee;
    Button btnSalaryAllowances;
    Button btnSalaryDeduction;
    Button btnLogout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        btnAddEmp = findViewById(R.id.btn_add_emp);
        btnShowEmployee = findViewById(R.id.btn_show_employee);
        btnSalaryAllowances = findViewById(R.id.btn_Salary_Allowances);
        btnSalaryDeduction = findViewById(R.id.btn_Salary_Deduction);
        btnLogout = findViewById(R.id.btn_logout);


        btnAddEmp.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),AddEmployeeActivity.class);
                    startActivity(intent);
            }
        });

        btnShowEmployee.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ShowEmployeeActivity.class);
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

        btnLogout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}
