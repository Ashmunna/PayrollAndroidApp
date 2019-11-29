package com.example.payrollmanagementsystem.service;

import com.example.payrollmanagementsystem.model.Employee;
import com.example.payrollmanagementsystem.model.EmployeeAllowances;
import com.example.payrollmanagementsystem.model.EmployeeDeduction;
import com.example.payrollmanagementsystem.model.UserInfo;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface EmployeeService {
    @GET("/showemp")
    Call<List<Employee>> showEmp();

    @POST("/createemp")
    Call<Employee> register(
            @Body Employee employee
    );

    @GET("/showUseradmin/{id}")
    Call<Employee> showEmpById(@Path("id") long id);

    @POST("/calculatesalary")
    Call<EmployeeAllowances> saveSalary(
            @Body EmployeeAllowances employeeAllowances
    );
    @GET("/salaryRest/{id}")
    Call<EmployeeAllowances> showAllowancesById(@Path("id") long id);

    @POST("/calculatesnetalary")
    Call<EmployeeDeduction> saveNetSalary(
            @Body EmployeeDeduction employeeDeduction
    );
    @POST("/register")
    Call<UserInfo> registerUser(
            @Body UserInfo UserInfo
    );
    @GET("/showe")
    Call<List<EmployeeDeduction>> showId();
    @GET("/showe-salarry-sheet")
    Call<List<EmployeeDeduction>> showSalarySheet();

    @GET("/showeid")
    Call<List<EmployeeAllowances>> showAllowancesId();

}
