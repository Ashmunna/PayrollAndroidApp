package com.example.payrollmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SalaryDetails extends AppCompatActivity {

    TextView dId;
    TextView empId;
    TextView name;
    TextView SName;
    TextView EMail;

    TextView EDepartment;
    TextView EDesignation;
    TextView GS;
    TextView Advance;
    TextView Provident;
    TextView Tax;
    TextView LifeInsurance;
    TextView Other;
    TextView NetPay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary_details2);

        dId = findViewById(R.id.d_id);
        empId = findViewById(R.id.emp_id);

        name = findViewById(R.id.empName);
        SName = findViewById(R.id.empSName);
        EMail = findViewById(R.id.eMail);

        EDepartment = findViewById(R.id.eDepartment);
        EDesignation = findViewById(R.id.eDesignation);
        GS = findViewById(R.id.eGsalary);
        Advance = findViewById(R.id.eAdvance);
        Provident = findViewById(R.id.eProvident);
        Tax = findViewById(R.id.eTax);
        LifeInsurance = findViewById(R.id.eLifeinsurence);
        Other = findViewById(R.id.eOther);
        NetPay = findViewById(R.id.eNetPay);

        Intent intent = getIntent();

        String d_id =intent.getStringExtra("dId");
        dId.setText(d_id);

        String emp_id =intent.getStringExtra("eId");
        empId.setText(emp_id);

        name.setText(intent.getStringExtra("eName"));
        SName.setText(intent.getStringExtra("eSurName"));
        EMail.setText(intent.getStringExtra("eMail"));
        EDepartment.setText(intent.getStringExtra("eDepartment"));
        EDesignation.setText(intent.getStringExtra("eDesignation"));

        String gs = intent.getStringExtra("eGrossSalary");
        GS.setText(gs);

        String advance = intent.getStringExtra("eAdvance");
        Advance.setText(advance);

        String provident = intent.getStringExtra("eProvident");
        Provident.setText(provident);

        String tax = intent.getStringExtra("eTax");
        Tax.setText(tax);

        String lifeinsurance = intent.getStringExtra("eLifeInsurance");
        LifeInsurance.setText(lifeinsurance);

        String other = intent.getStringExtra("eOther");
        Other.setText(other);

        String netpay = intent.getStringExtra("eNetSalary");
        NetPay.setText(netpay);

    }
}