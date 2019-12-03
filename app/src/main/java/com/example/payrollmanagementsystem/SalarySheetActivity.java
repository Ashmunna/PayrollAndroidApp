package com.example.payrollmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        employeesalarySheet =findViewById(R.id.employeeSalarySheet);


        EmployeeService service = RetrofitConnection.getRetrofitInstance().create(EmployeeService.class);

        Call<List<EmployeeDeduction>> call2=service.showId();

        call2.enqueue(new Callback<List<EmployeeDeduction>>() {
            @Override
            public void onResponse(Call<List<EmployeeDeduction>> call, Response<List<EmployeeDeduction>> response) {
                salarySheet=response.body();
                salarySheetAdapter=new SalarySheetAdapter(SalarySheetActivity.this,salarySheet);
                employeesalarySheet.setAdapter(salarySheetAdapter);
                Log.e(TAG, ":::::::::"+salarySheet.size());

                employeesalarySheet.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent sdetail  = new Intent(SalarySheetActivity.this,SalaryDetails.class);
                        String d_id = String.valueOf(salarySheet.get(position).getId());
                        String emp_id = String.valueOf(salarySheet.get(position).getEmpId());
                        String g_salary = String.valueOf(salarySheet.get(position).getGrossSalary());
                        String n_salary = String.valueOf(salarySheet.get(position).getNetpay());
                        String advance = String.valueOf(salarySheet.get(position).getAdvance());
                        String provident = String.valueOf(salarySheet.get(position).getContributionPf());
                        String lifeinsurance = String.valueOf(salarySheet.get(position).getLifeinsurance());
                        String tax = String.valueOf(salarySheet.get(position).getMealcharge());
                        String other = String.valueOf(salarySheet.get(position).getOther());

                        sdetail.putExtra("dId", d_id);
                        sdetail.putExtra("eId", emp_id);
                        sdetail.putExtra("eName",salarySheet.get(position).getFirstName());
                        sdetail.putExtra("eSurName",salarySheet.get(position).getSurname());
                        sdetail.putExtra("eMail",salarySheet.get(position).getEmail());
                        sdetail.putExtra("eDepartment",salarySheet.get(position).getDepartment());
                        sdetail.putExtra("eDesignation",salarySheet.get(position).getDesignation());
                        sdetail.putExtra("eGrossSalary", g_salary);
                        sdetail.putExtra("eAdvance",advance);
                        sdetail.putExtra("eProvident",provident);
                        sdetail.putExtra("eTax",tax);
                        sdetail.putExtra("eLifeInsurance",lifeinsurance);
                        sdetail.putExtra("eOther",other);
                        sdetail.putExtra("eNetSalary", n_salary);

                        startActivity(sdetail);

                    }
                });
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
