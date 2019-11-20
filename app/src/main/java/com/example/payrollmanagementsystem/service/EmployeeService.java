package com.example.payrollmanagementsystem.service;

import com.example.payrollmanagementsystem.model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EmployeeService {
    @GET("/showemp")
    Call<List<Employee>> showEmp();
}
