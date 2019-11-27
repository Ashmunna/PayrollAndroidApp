package com.example.payrollmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class EmployeeDetails extends AppCompatActivity {
    TextView empId;
    TextView name;
    TextView SName;
    TextView EDob;
    TextView EGender;
    TextView EMail;
    TextView EContact;
    TextView EAddress;
    TextView EDepartment;
    TextView EDesignation;
    TextView EStatus;
    TextView EDoh;
    TextView BS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);

        empId = findViewById(R.id.empId);
        name = findViewById(R.id.empName);
        SName = findViewById(R.id.empSName);
        EDob = findViewById(R.id.eDob);
        EGender = findViewById(R.id.eGender);
        EMail = findViewById(R.id.eMail);
        EContact = findViewById(R.id.eContact);
        EAddress = findViewById(R.id.eAddress);
        EDepartment = findViewById(R.id.eDepartment);
        EDesignation = findViewById(R.id.eDesignation);
        EStatus = findViewById(R.id.eStatus);
        EDoh = findViewById(R.id.eDoh);
        BS = findViewById(R.id.eBasicsalary);

        Intent intent = getIntent();

        String id =intent.getStringExtra("eId");
        empId.setText(id);
        name.setText(intent.getStringExtra("eName"));
        SName.setText(intent.getStringExtra("eSurName"));
        EDob.setText(intent.getStringExtra("eDob"));
        EGender.setText(intent.getStringExtra("eGender"));
        EMail.setText(intent.getStringExtra("eMail"));
        EContact.setText(intent.getStringExtra("eContact"));
        EAddress.setText(intent.getStringExtra("eAddress"));
        EDepartment.setText(intent.getStringExtra("eDepartment"));
        EDesignation.setText(intent.getStringExtra("eDesignation"));
        EStatus.setText(intent.getStringExtra("eStatus"));
        EDoh.setText(intent.getStringExtra("eDoh"));
        String bs = intent.getStringExtra("eBasicSalary");
        BS.setText(bs);

    }
}
