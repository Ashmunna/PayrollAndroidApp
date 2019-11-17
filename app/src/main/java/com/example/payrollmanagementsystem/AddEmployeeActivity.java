package com.example.payrollmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddEmployeeActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextEmail;
    EditText editTextDesignation;
    EditText editTextBasicSalary;
    Button btnEmployeeSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        editTextName = findViewById(R.id.name);
        editTextEmail = findViewById(R.id.email);
        editTextDesignation = findViewById(R.id.designation);
        editTextBasicSalary = findViewById(R.id.basicsalary);
        btnEmployeeSave = findViewById(R.id.btn_employee_save);


        btnEmployeeSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String name = editTextName.getText().toString();
                String email = editTextEmail.getText().toString();
                String designation = editTextDesignation.getText().toString();
                int basicsalary = Integer.parseInt(editTextBasicSalary.getText().toString());


                if (name.isEmpty() || email.isEmpty() || designation.isEmpty() || basicsalary<=0) {
                    String showMessage = "Empty field";
                    Toast.makeText(getApplicationContext(), showMessage, Toast.LENGTH_LONG).show();
                } else {

                    String showMessage = "Employee name: " + name + "\n Email is : " + email + "\n Designation is : " + designation + "\n Basic Salary is : " + basicsalary;
                    Toast.makeText(getApplicationContext(),showMessage,Toast.LENGTH_LONG).show();

                }
            }

        });
    }
}
