package com.example.payrollmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    AutoCompleteTextView autoCompleteTextView;
    Button btnEmployeeAllowanceSave;
    Button  btnAllowances_search;
    Employee employee;
    List<Employee> employeeId=new ArrayList<>();
    String empid[];
    private static final String TAG = "Logging Example";
    ArrayAdapter<String> adapterId;
    EmployeeService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_salary_allowances);
        autoCompleteTextView=findViewById(R.id.salary_allowance_search);
        editTextAllowanceName = findViewById(R.id.allowances_name);
        editTextbasicSalary=findViewById(R.id.basicsalary);
        editTextHouserent = findViewById(R.id.houserent);
        editTextMedical = findViewById(R.id.medical);
        editTextGrossSalary = findViewById(R.id.gross_salary);
        btnEmployeeAllowanceSave = findViewById(R.id.btn_allowances_save);
        btnAllowances_search=findViewById(R.id.btn_allowances_search);




                service = RetrofitConnection.getRetrofitInstance().create(EmployeeService.class);

                final Call<List<Employee>> call2=service.showEmp();
                call2.enqueue(new Callback<List<Employee>>() {
                    @Override
                    public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                        employeeId=response.body();

                        empid=new String[employeeId.size()];
                        Log.e(TAG, "Received an exception " + employeeId.size() );
                        for (int i=0; i<employeeId.size(); i++){
                            empid[i]=String.valueOf(employeeId.get(i).getId());
                        }
                        adapterId=new ArrayAdapter<String>(SalaryAllowancesActivity.this,android.R.layout.simple_list_item_1,empid);
                        autoCompleteTextView.setAdapter(adapterId);

                    }

                    @Override
                    public void onFailure(Call<List<Employee>> call, Throwable t) {
                        Log.e(TAG, "Rabbi" + employeeId.size() );
                    }
                });
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = autoCompleteTextView.getText().toString();
                long longId=Long.parseLong(name);
                Call<Employee> cal1=service.showEmpById(longId);
                cal1.enqueue(new Callback<Employee>() {
                    @Override
                    public void onResponse(Call<Employee> call, Response<Employee> response) {
                        employee =response.body();
                        editTextAllowanceName.setText(employee.getFirstName());
                        editTextbasicSalary.setText(String.valueOf(employee.getBasicSalary()));
                    }

                    @Override
                    public void onFailure(Call<Employee> call, Throwable t) {
                        Log.e(TAG, "Rabbi" + employeeId.size() );
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
