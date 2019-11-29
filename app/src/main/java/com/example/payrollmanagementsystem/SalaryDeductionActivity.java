package com.example.payrollmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.payrollmanagementsystem.connection.RetrofitConnection;
import com.example.payrollmanagementsystem.model.Employee;
import com.example.payrollmanagementsystem.model.EmployeeAllowances;
import com.example.payrollmanagementsystem.model.EmployeeDeduction;
import com.example.payrollmanagementsystem.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

public class SalaryDeductionActivity extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;
    EditText editTextDeductionName;
    EditText editTextTax;
    EditText editTextProvident;
    EditText editTextNetPay;
    EditText editTextDeduction_search;
    Button btnEmployeeDeductionSave;
    Button  btnDeduction_search;
    EmployeeAllowances employeeAllowances;
    List<EmployeeAllowances> employeeId=new ArrayList<>();
    String empid[];
    EmployeeService service;
    private static final String TAG = "Logging Example";
    ArrayAdapter<String> adapterId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary_deduction);
        autoCompleteTextView=findViewById(R.id.deduction_search);
        editTextDeductionName = findViewById(R.id.deduction_name);
        editTextTax = findViewById(R.id.tax);
        editTextProvident = findViewById(R.id.provident);
        editTextNetPay = findViewById(R.id.netpay);
        btnEmployeeDeductionSave = findViewById(R.id.btn_deduction_save);
        btnDeduction_search=findViewById(R.id.btn_Search);


         service = RetrofitConnection.getRetrofitInstance().create(EmployeeService.class);
        Call<List<EmployeeAllowances>> call2=service.showAllowancesId();
         call2.enqueue(new Callback<List<EmployeeAllowances>>() {
             @Override
             public void onResponse(Call<List<EmployeeAllowances>> call, Response<List<EmployeeAllowances>> response) {
                 employeeId=response.body();
                 empid=new String[employeeId.size()];
                 Log.e(TAG, "Received an exception " + employeeId.size() );
                 for (int i=0; i<employeeId.size(); i++){
                     empid[i]=String.valueOf(employeeId.get(i).getId());

                 }

                 adapterId=new ArrayAdapter<String>(SalaryDeductionActivity.this,android.R.layout.simple_list_item_1,empid);
                 autoCompleteTextView.setAdapter(adapterId);

             }

             @Override
             public void onFailure(Call<List<EmployeeAllowances>> call, Throwable t) {

             }
         });





        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = autoCompleteTextView.getText().toString();
                long longId= Long.parseLong(name);

                Call<EmployeeAllowances>call=service.showAllowancesById(longId);
                call.enqueue(new Callback<EmployeeAllowances>() {
                    @Override
                    public void onResponse(Call<EmployeeAllowances> call, Response<EmployeeAllowances> response) {
                        EmployeeAllowances employeeAllowances=response.body();
                        Log.e(TAG, "Received rabbi " + employeeAllowances);
                        editTextDeductionName.setText(employeeAllowances.getFirstName());

                    }

                    @Override
                    public void onFailure(Call<EmployeeAllowances> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"Data not Found  successfully",Toast.LENGTH_SHORT).show();

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
