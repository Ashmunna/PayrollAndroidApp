package com.example.payrollmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.payrollmanagementsystem.connection.RetrofitConnection;
import com.example.payrollmanagementsystem.model.UserInfo;
import com.example.payrollmanagementsystem.service.EmployeeService;

import java.util.Date;

public class UserRegistrationActivity extends AppCompatActivity {
    EditText editTextuser_name;
    EditText editTextuser_email;
    EditText editTextuser_username;
    EditText editTextuser_password;
    Button button_user_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
        editTextuser_name=findViewById(R.id.user_name);
        editTextuser_email=findViewById(R.id.user_email);
        editTextuser_username=findViewById(R.id.user_password);
        editTextuser_password=findViewById(R.id.user_password);
        button_user_save=findViewById(R.id.btn_user_save);
        button_user_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName=editTextuser_name.getText().toString();
                String userEmail=editTextuser_email.getText().toString();
                String userUsername=editTextuser_username.getText().toString();
                String userPassword=editTextuser_password.getText().toString();
                EmployeeService service = RetrofitConnection.getRetrofitInstance().create(EmployeeService.class);
                UserInfo userInfo=new UserInfo();
                userInfo.setFirstName(fullName);
                userInfo.setEmail(userEmail);
                userInfo.setUsername(userUsername);
                userInfo.setPassword(userPassword);
                userInfo.setCreatedDate(new Date().toString());
                Call<UserInfo> call=service.registerUser(userInfo);
                call.enqueue(new Callback<UserInfo>() {
                    @Override
                    public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                        UserInfo userInfo1=response.body();
                        Toast.makeText(getApplicationContext()," Save successfully",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<UserInfo> call, Throwable t) {
                        Toast.makeText(getApplicationContext()," Save Failed",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
