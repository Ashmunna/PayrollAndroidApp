package com.example.payrollmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.payrollmanagementsystem.connection.RetrofitConnection;
import com.example.payrollmanagementsystem.model.Employee;
import com.example.payrollmanagementsystem.service.EmployeeService;

import java.io.IOException;
import java.util.Date;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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


                final String designation = editTextDesignation.getText().toString();
                final double basicsalary = Double.parseDouble(editTextBasicSalary.getText().toString());
                EmployeeService service = RetrofitConnection.getRetrofitInstance().create(EmployeeService.class);
                Employee newEmployee= new Employee();
                newEmployee.setFirstName(name);
                newEmployee.setJoingDate(new Date());

                Call<Employee> call=service.register(newEmployee);

                    call.enqueue(new Callback<Employee>() {

                        @Override
                        public void onResponse(Call<Employee> call, Response<Employee> response) {
                            Employee s=response.body();
                            Toast.makeText(getApplicationContext(),"Employee Save successfully",Toast.LENGTH_SHORT).show();
                            editTextName.getText().clear();
                            editTextEmail.getText().clear();
                            editTextDesignation.getText().clear();
                            editTextBasicSalary.getText().clear();
                            Log.d(designation,"::fgdfsg:::::::"+s);

                        }

                        @Override
                        public void onFailure(Call<Employee> call, Throwable t) {

                        }
                    });


                }






        });
    }
}
