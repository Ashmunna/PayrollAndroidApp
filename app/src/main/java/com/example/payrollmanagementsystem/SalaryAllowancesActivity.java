package com.example.payrollmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SalaryAllowancesActivity extends AppCompatActivity {

    EditText editTextAllowanceName;
    EditText editTextHouserent;
    EditText editTextMedical;
    EditText editTextGrossSalary;
    Button btnEmployeeAllowanceSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary_allowances);
        editTextAllowanceName = findViewById(R.id.allowances_name);
        editTextHouserent = findViewById(R.id.houserent);
        editTextMedical = findViewById(R.id.medical);
        editTextGrossSalary = findViewById(R.id.gross_salary);
        btnEmployeeAllowanceSave = findViewById(R.id.btn_allowances_save);


        btnEmployeeAllowanceSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String al_name = editTextAllowanceName.getText().toString();
                int houserent = Integer.parseInt(editTextHouserent.getText().toString());
                int medical = Integer.parseInt(editTextMedical.getText().toString());
                int grosssalary = Integer.parseInt(editTextGrossSalary.getText().toString());


                if (al_name.isEmpty() || houserent<=0 || medical<=0 || grosssalary<=0) {
                    String showMessage = "Empty field";
                    Toast.makeText(getApplicationContext(), showMessage, Toast.LENGTH_LONG).show();
                } else {

                    String showMessage = "Employee name: " + al_name + "\n Houserent is : " + houserent + "\n Medical Allowances is : " + medical + "\n Gross Salary is : " + grosssalary;
                    Toast.makeText(getApplicationContext(),showMessage,Toast.LENGTH_LONG).show();

                }
            }

        });
    }
}
