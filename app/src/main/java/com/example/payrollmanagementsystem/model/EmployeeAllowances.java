package com.example.payrollmanagementsystem.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmployeeAllowances {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("emp_id")
    @Expose
    private Integer empId;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("surname")
    @Expose
    private String surname;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("department")
    @Expose
    private String department;
    @SerializedName("designation")
    @Expose
    private String designation;
    @SerializedName("basic_salary")
    @Expose
    private Double basicSalary;
    @SerializedName("overtime_amount")
    @Expose
    private Double overtimeAmount;
    @SerializedName("houserent")
    @Expose
    private Double houserent;
    @SerializedName("ma")
    @Expose
    private Double ma;
    @SerializedName("tfa")
    @Expose
    private Double tfa;
    @SerializedName("oa")
    @Expose
    private Double oa;
    @SerializedName("ts")
    @Expose
    private Double ts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Double getOvertimeAmount() {
        return overtimeAmount;
    }

    public void setOvertimeAmount(Double overtimeAmount) {
        this.overtimeAmount = overtimeAmount;
    }

    public Double getHouserent() {
        return houserent;
    }

    public void setHouserent(Double houserent) {
        this.houserent = houserent;
    }

    public Double getMa() {
        return ma;
    }

    public void setMa(Double ma) {
        this.ma = ma;
    }

    public Double getTfa() {
        return tfa;
    }

    public void setTfa(Double tfa) {
        this.tfa = tfa;
    }

    public Double getOa() {
        return oa;
    }

    public void setOa(Double oa) {
        this.oa = oa;
    }

    public Double getTs() {
        return ts;
    }

    public void setTs(Double ts) {
        this.ts = ts;
    }
}
