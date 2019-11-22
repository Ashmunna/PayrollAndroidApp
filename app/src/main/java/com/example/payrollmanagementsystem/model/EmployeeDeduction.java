package com.example.payrollmanagementsystem.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmployeeDeduction {

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
    @SerializedName("gross_salary")
    @Expose
    private Double grossSalary;
    @SerializedName("lifeinsurance")
    @Expose
    private Double lifeinsurance;
    @SerializedName("advance")
    @Expose
    private Double advance;
    @SerializedName("mealcharge")
    @Expose
    private Double mealcharge;
    @SerializedName("contribution_pf")
    @Expose
    private Double contributionPf;
    @SerializedName("other")
    @Expose
    private Double other;
    @SerializedName("netpay")
    @Expose
    private Double netpay;

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

    public Double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(Double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public Double getLifeinsurance() {
        return lifeinsurance;
    }

    public void setLifeinsurance(Double lifeinsurance) {
        this.lifeinsurance = lifeinsurance;
    }

    public Double getAdvance() {
        return advance;
    }

    public void setAdvance(Double advance) {
        this.advance = advance;
    }

    public Double getMealcharge() {
        return mealcharge;
    }

    public void setMealcharge(Double mealcharge) {
        this.mealcharge = mealcharge;
    }

    public Double getContributionPf() {
        return contributionPf;
    }

    public void setContributionPf(Double contributionPf) {
        this.contributionPf = contributionPf;
    }

    public Double getOther() {
        return other;
    }

    public void setOther(Double other) {
        this.other = other;
    }

    public Double getNetpay() {
        return netpay;
    }

    public void setNetpay(Double netpay) {
        this.netpay = netpay;
    }

}