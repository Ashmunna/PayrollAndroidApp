package com.example.payrollmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import com.example.payrollmanagementsystem.adapter.AdapterId;
import com.example.payrollmanagementsystem.adapter.EmployeeAdapter;
import com.example.payrollmanagementsystem.adapter.SalarySheetAdapter;
import com.example.payrollmanagementsystem.connection.RetrofitConnection;
import com.example.payrollmanagementsystem.model.EmployeeDeduction;
import com.example.payrollmanagementsystem.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SalarySheetActivity extends AppCompatActivity {
    private ListView employeesalarySheet;
     AutoCompleteTextView autoCompleteTextView;
    private static final String TAG = "Logging Example";
    SalarySheetAdapter salarySheetAdapter;
     List<EmployeeDeduction> empId=new ArrayList<>();
    List<EmployeeDeduction> salarySheet=new ArrayList<>();

    String empid[];

   ArrayAdapter<String> adapterId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary_sheet);
        autoCompleteTextView=findViewById(R.id.salary_sheet_search);
        employeesalarySheet =findViewById(R.id.employeesalarySheet);


        EmployeeService service = RetrofitConnection.getRetrofitInstance().create(EmployeeService.class);

        Call<List<EmployeeDeduction>> call2=service.showSalarySheet();

        call2.enqueue(new Callback<List<EmployeeDeduction>>() {
            @Override
            public void onResponse(Call<List<EmployeeDeduction>> call, Response<List<EmployeeDeduction>> response) {
                salarySheet=response.body();
                salarySheetAdapter=new SalarySheetAdapter(SalarySheetActivity.this,salarySheet);
                employeesalarySheet.setAdapter(salarySheetAdapter);
                Log.e(TAG, ":::::::::"+salarySheet.size());
            }

            @Override
            public void onFailure(Call<List<EmployeeDeduction>> call, Throwable t) {

            }
        });




        Call<List<EmployeeDeduction>> call=service.showId();
        call.enqueue(new Callback<List<EmployeeDeduction>>() {
            @Override
            public void onResponse(Call<List<EmployeeDeduction>> call, Response<List<EmployeeDeduction>> response) {
                empId=response.body();
                empid=new String[empId.size()];
                Log.e(TAG, "Received an exception " + empId.size() );
                for (int i=0; i<empId.size(); i++){
                    empid[i]=String.valueOf(empId.get(i).getId());
                }
                adapterId=new ArrayAdapter<String>(SalarySheetActivity.this,android.R.layout.simple_list_item_1,empid);
                autoCompleteTextView.setAdapter(adapterId);



            }

            @Override
            public void onFailure(Call<List<EmployeeDeduction>> call, Throwable t) {
                Log.e(TAG, "Received an exception " + empId.size() );
            }
        });
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                long serchId=Long.parseLong(autoCompleteTextView.getText().toString());
                
            }
        });

    }
}
