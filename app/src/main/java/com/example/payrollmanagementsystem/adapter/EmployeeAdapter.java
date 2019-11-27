package com.example.payrollmanagementsystem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.payrollmanagementsystem.R;
import com.example.payrollmanagementsystem.model.Employee;

import java.util.List;

public class EmployeeAdapter extends ArrayAdapter<Employee> {

    private Context context;
    private List<Employee> employee;

    public EmployeeAdapter(@NonNull Context context, List<Employee> employee) {
        super(context, R.layout.employee_layout, employee);
        this.context = context;
        this.employee = employee;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.employee_layout, parent, false);

        TextView empID = convertView.findViewById(R.id.empID);
        TextView firstName = convertView.findViewById(R.id.firstName);
        TextView designation = convertView.findViewById(R.id.designation);
        TextView details = convertView.findViewById(R.id.workqualitycmnt);

        empID.setText(String.valueOf(employee.get(position).getId()));
        firstName.setText(employee.get(position).getFirstName());
        designation.setText(employee.get(position).getDesignation());
//        basicSalary.setText(String.valueOf(employee.get(position).getBasicSalary()));
        return convertView;
    }
}
