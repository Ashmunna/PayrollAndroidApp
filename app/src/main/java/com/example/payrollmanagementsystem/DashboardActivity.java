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
    Button btnSalarySheet;
    Button btnSalaryReports;
    Button btnLogout;
    Button btnPayment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        btnAddEmp = findViewById(R.id.btn_add_emp);
        btnShowEmployee = findViewById(R.id.btn_show_employee);
        btnSalaryAllowances = findViewById(R.id.btn_Salary_Allowances);
        btnSalaryDeduction = findViewById(R.id.btn_Salary_Deduction);
        btnLogout = findViewById(R.id.btn_logout);
        btnSalarySheet =findViewById(R.id.btn_salary_sheet);
        btnSalaryReports =findViewById(R.id.btn_salary_reports);
        btnPayment =findViewById(R.id.btn_salary_payment);


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

        btnSalarySheet.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SalarySheetActivity.class);
                startActivity(intent);
            }

        });

        btnSalaryReports.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SalaryReportsActivity.class);
                startActivity(intent);
            }

        });

        btnPayment.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SalaryPaymentActivity.class);
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
