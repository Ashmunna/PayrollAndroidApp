package com.example.payrollmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.payrollmanagementsystem.connection.RetrofitConnection;
import com.example.payrollmanagementsystem.model.Employee;
import com.example.payrollmanagementsystem.model.EmployeeAllowances;
import com.example.payrollmanagementsystem.service.EmployeeService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SalaryAllowancesActivity extends AppCompatActivity {
    EditText  allowances_search;
    EditText editTextAllowanceName;
    EditText editTextbasicSalary;
    EditText editTextHouserent;
    EditText editTextMedical;
    EditText editTextGrossSalary;

    Button btnEmployeeAllowanceSave;
    Button  btnAllowances_search;
    Employee employee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_salary_allowances);
        allowances_search=findViewById(R.id.allowances_search);
        editTextAllowanceName = findViewById(R.id.allowances_name);
        editTextbasicSalary=findViewById(R.id.basicsalary);
        editTextHouserent = findViewById(R.id.houserent);
        editTextMedical = findViewById(R.id.medical);
        editTextGrossSalary = findViewById(R.id.gross_salary);
        btnEmployeeAllowanceSave = findViewById(R.id.btn_allowances_save);
        btnAllowances_search=findViewById(R.id.btn_allowances_search);
        btnAllowances_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = allowances_search.getText().toString();
                long id= Long.parseLong(name);
                EmployeeService service = RetrofitConnection.getRetrofitInstance().create(EmployeeService.class);
                Call<Employee> call=service.showEmpById(id);
                call.enqueue(new Callback<Employee>() {
                    @Override
                    public void onResponse(Call<Employee> call, Response<Employee> response) {
                        employee =response.body();
                        editTextAllowanceName.setText(employee.getFirstName());
                        editTextbasicSalary.setText(String.valueOf(employee.getBasicSalary()));
                    }

                    @Override
                    public void onFailure(Call<Employee> call, Throwable t) {

                    }
                });
            }
        });
        btnEmployeeAllowanceSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String al_name = editTextAllowanceName.getText().toString();
                double basicSalary=Double.parseDouble(editTextbasicSalary.getText().toString());
                double houserent =basicSalary *(Double.parseDouble(editTextHouserent.getText().toString())/100);
                double medical = basicSalary*(Double.parseDouble(editTextMedical.getText().toString())/100);
                double grosssalary = basicSalary + houserent + medical;

                EmployeeService service = RetrofitConnection.getRetrofitInstance().create(EmployeeService.class);
                EmployeeAllowances employeeAllowances=new EmployeeAllowances();
                employeeAllowances.setEmpId(employee.getId());
                employeeAllowances.setFirstName(al_name);
                employeeAllowances.setBasicSalary(basicSalary);
                employeeAllowances.setHouserent(houserent);
                employeeAllowances.setMa(medical);
                employeeAllowances.setTs(grosssalary);
                Call<EmployeeAllowances> call=service.saveSalary(employeeAllowances);
                call.enqueue(new Callback<EmployeeAllowances>() {
                    @Override
                    public void onResponse(Call<EmployeeAllowances> call, Response<EmployeeAllowances> response) {
                        EmployeeAllowances s=response.body();
                        editTextGrossSalary.setText(String.valueOf(s.getTs()));
                        Toast.makeText(getApplicationContext(),"Calculate salary Save successfully",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<EmployeeAllowances> call, Throwable t) {

                    }
                });

            }

        });
    }
}
