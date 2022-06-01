package com.example.opticaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class Login extends AppCompatActivity {

    // Init variables
    Button signUpVisibility;
    Button loginVisibility;
    Button signUpActivity;
    Button loginActivity;
    Button password;

    EditText name;
    EditText surname;
    EditText phone;

    LinearLayout layout;
    LinearLayout layout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signUpVisibility = findViewById(R.id.btn_signup);
        loginVisibility = findViewById(R.id.btn_login2);
        signUpActivity = findViewById(R.id.btn_signup2);
        loginActivity = findViewById(R.id.btn_login);

        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.btn_password);
        layout = findViewById(R.id.layout);
        layout2 = findViewById(R.id.layout2);

        signUpVisibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setVisibility(View.VISIBLE);
                surname.setVisibility(View.VISIBLE);
                phone.setVisibility(View.VISIBLE);
                password.setVisibility(View.GONE);
                loginActivity.setVisibility(View.GONE);
                signUpActivity.setVisibility(View.VISIBLE);
                layout.setVisibility(View.GONE);
                layout2.setVisibility(View.VISIBLE);
            }
        });
        loginVisibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setVisibility(View.GONE);
                surname.setVisibility(View.GONE);
                phone.setVisibility(View.GONE);
                password.setVisibility(View.VISIBLE);
                loginActivity.setVisibility(View.VISIBLE);
                signUpActivity.setVisibility(View.GONE);
                layout.setVisibility(View.VISIBLE);
                layout2.setVisibility(View.GONE);
            }
        });

    }
}