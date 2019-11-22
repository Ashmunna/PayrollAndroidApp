package com.example.payrollmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.payrollmanagementsystem.connection.RetrofitConnection;
import com.example.payrollmanagementsystem.model.EmployeeAllowances;
import com.example.payrollmanagementsystem.model.EmployeeDeduction;
import com.example.payrollmanagementsystem.service.EmployeeService;

public class SalaryDeductionActivity extends AppCompatActivity {

    EditText editTextDeductionName;
    EditText editTextTax;
    EditText editTextProvident;
    EditText editTextNetPay;
    EditText editTextDeduction_search;
    Button btnEmployeeDeductionSave;
    Button  btnDeduction_search;
    EmployeeAllowances employeeAllowances;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary_deduction);
        editTextDeduction_search=findViewById(R.id.deduction_search);
        editTextDeductionName = findViewById(R.id.deduction_name);
        editTextTax = findViewById(R.id.tax);
        editTextProvident = findViewById(R.id.provident);
        editTextNetPay = findViewById(R.id.netpay);
        btnEmployeeDeductionSave = findViewById(R.id.btn_deduction_save);
        btnDeduction_search=findViewById(R.id.btn_Search);


        btnDeduction_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextDeduction_search.getText().toString();
                long id= Long.parseLong(name);
                EmployeeService service = RetrofitConnection.getRetrofitInstance().create(EmployeeService.class);
                Call<EmployeeAllowances>call=service.showAllowancesById(id);
                call.enqueue(new Callback<EmployeeAllowances>() {
                    @Override
                    public void onResponse(Call<EmployeeAllowances> call, Response<EmployeeAllowances> response) {
                        employeeAllowances=response.body();
                        editTextDeductionName.setText(employeeAllowances.getFirstName());
                    }

                    @Override
                    public void onFailure(Call<EmployeeAllowances> call, Throwable t) {

                    }
                });
            }
        });
        btnEmployeeDeductionSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String de_name = editTextDeductionName.getText().toString();
                double grosssalary=employeeAllowances.getTs();
                double mealcharge =grosssalary * (Double.parseDouble(editTextTax.getText().toString())/100);
                double provident =grosssalary * (Double.parseDouble(editTextProvident.getText().toString())/100);
                double netpay =grosssalary-mealcharge-provident;
                EmployeeService service = RetrofitConnection.getRetrofitInstance().create(EmployeeService.class);
                EmployeeDeduction employeeDeduction=new EmployeeDeduction();
                employeeDeduction.setFirstName(de_name);
                employeeDeduction.setEmpId(employeeAllowances.getEmpId());
                employeeDeduction.setEmail(employeeAllowances.getEmail());
                employeeDeduction.setDepartment(employeeAllowances.getDepartment());
                employeeDeduction.setDesignation(employeeAllowances.getDesignation());
                employeeDeduction.setGrossSalary(employeeAllowances.getTs());
                employeeDeduction.setMealcharge(mealcharge);
                employeeDeduction.setLifeinsurance(provident);
                employeeDeduction.setNetpay(netpay);
                Call<EmployeeDeduction> call=service.saveNetSalary(employeeDeduction);
                call.enqueue(new Callback<EmployeeDeduction>() {
                    @Override
                    public void onResponse(Call<EmployeeDeduction> call, Response<EmployeeDeduction> response) {
                        EmployeeDeduction employeeDeduction=response.body();
                        editTextNetPay.setText(String.valueOf(employeeDeduction.getNetpay()));
                        Toast.makeText(getApplicationContext(),"Salary Deduction Save successfully",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<EmployeeDeduction> call, Throwable t) {

                    }
                });
            }

        });
    }
}
