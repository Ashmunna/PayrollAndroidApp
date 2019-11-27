package com.example.payrollmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.payrollmanagementsystem.adapter.EmployeeAdapter;
import com.example.payrollmanagementsystem.connection.RetrofitConnection;
import com.example.payrollmanagementsystem.model.Employee;
import com.example.payrollmanagementsystem.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShowEmployeeActivity extends AppCompatActivity {
    private  static  final String TAG = ShowEmployeeActivity.class.getSimpleName();

    private ListView employeeLv;
    private EmployeeAdapter employeeAdapter;
    List<Employee> employee = new ArrayList<>();

    public ShowEmployeeActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_employee);
        employeeLv=findViewById(R.id.employeeLv);
        EmployeeService service = RetrofitConnection.getRetrofitInstance().create(EmployeeService.class);

        Call<List<Employee>> call=service.showEmp();

        call.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                employee= response.body();
                employeeAdapter= new EmployeeAdapter(ShowEmployeeActivity.this,employee);
                employeeLv.setAdapter(employeeAdapter);
                Log.e(TAG, ":::::::::"+employee.size());

                employeeLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent  = new Intent(ShowEmployeeActivity.this,EmployeeDetails.class);
                        String emp_id = String.valueOf(employee.get(position).getId());
                        String b_salary = String.valueOf(employee.get(position).getBasicSalary());
                        intent.putExtra("eId", emp_id);
                        intent.putExtra("eName",employee.get(position).getFirstName());
                        intent.putExtra("eSurName",employee.get(position).getSurname());
                        intent.putExtra("eDob",employee.get(position).getDob());
                        intent.putExtra("eGender",employee.get(position).getGender());
                        intent.putExtra("eMail",employee.get(position).getEmail());
                        intent.putExtra("eContact",employee.get(position).getContactNo());
                        intent.putExtra("eAddress",employee.get(position).getAddress());
                        intent.putExtra("eDepartment",employee.get(position).getDepartment());
                        intent.putExtra("eDesignation",employee.get(position).getDesignation());
                        intent.putExtra("eStatus",employee.get(position).getStatus());
                        intent.putExtra("eDoh",employee.get(position).getDoh());
                        intent.putExtra("eBasicSalary", b_salary);

                        startActivity(intent);

                    }
                });


            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {

                Log.e(TAG, ":::::::::RabbyMunnaSaiquatSorry"+call);
                t.printStackTrace();
            }

        });
    }
}
