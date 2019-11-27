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
import com.example.payrollmanagementsystem.model.EmployeeDeduction;

import java.util.List;

public class AdapterId extends ArrayAdapter<EmployeeDeduction> {
    private Context context;
    private List<EmployeeDeduction> employeeId;

    public AdapterId(@NonNull Context context, List<EmployeeDeduction> employeeId) {
        super(context,R.layout.idforsalarysheet_layout,employeeId);
        this.context=context;
        this.employeeId=employeeId;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.idforsalarysheet_layout, parent, false);

        TextView empID = convertView.findViewById(R.id.eid);


        empID.setText(String.valueOf(employeeId.get(position).getId()));
//        basicSalary.setText(String.valueOf(employee.get(position).getBasicSalary()));
        return convertView;
    }
}
