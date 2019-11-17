package com.example.payrollmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SalaryDeductionActivity extends AppCompatActivity {

    EditText editTextDeductionName;
    EditText editTextTax;
    EditText editTextProvident;
    EditText editTextNetPay;
    Button btnEmployeeDeductionSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary_deduction);
        editTextDeductionName = findViewById(R.id.deduction_name);
        editTextTax = findViewById(R.id.tax);
        editTextProvident = findViewById(R.id.provident);
        editTextNetPay = findViewById(R.id.netpay);
        btnEmployeeDeductionSave = findViewById(R.id.btn_deduction_save);


        btnEmployeeDeductionSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String de_name = editTextDeductionName.getText().toString();
                int tax = Integer.parseInt(editTextTax.getText().toString());
                int provident = Integer.parseInt(editTextProvident.getText().toString());
                int netpay = Integer.parseInt(editTextNetPay.getText().toString());


                if (de_name.isEmpty() || tax<=0 || provident<=0 || netpay<=0) {
                    String showMessage = "Empty field";
                    Toast.makeText(getApplicationContext(), showMessage, Toast.LENGTH_LONG).show();
                } else {

                    String showMessage = "Employee name: " + de_name + "\n Tax is : " + tax + "\n Provident is : " + provident  + "\n Gross Salary is : " + netpay;
                    Toast.makeText(getApplicationContext(),showMessage,Toast.LENGTH_LONG).show();

                }
            }

        });
    }
}
