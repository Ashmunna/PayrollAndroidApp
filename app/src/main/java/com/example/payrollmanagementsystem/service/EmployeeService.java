package com.example.payrollmanagementsystem.service;

import com.example.payrollmanagementsystem.model.Employee;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface EmployeeService {
    @GET("/showemp")
    Call<List<Employee>> showEmp();

    @POST("/createemp")
    Call<Employee> register(
            @Body Employee employee
    );
}
