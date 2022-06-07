package com.example.opticaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    // Init variables
    Button signUpVisibility,loginVisibility,signUpActivity,loginActivity,password;

    EditText nickname, pw, name,surname,phone;

    LinearLayout layout,layout2;

    DbHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Asociamos los elementos a las variables
        signUpVisibility = findViewById(R.id.btn_signup);
        loginVisibility = findViewById(R.id.btn_login2);
        signUpActivity = findViewById(R.id.btn_signup2);
        loginActivity = findViewById(R.id.btn_login);

        nickname = findViewById(R.id.nickname);
        pw = findViewById(R.id.password);
        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.btn_password);
        layout = findViewById(R.id.layout);
        layout2 = findViewById(R.id.layout2);
        dbHandler = new DbHandler(Login.this);


        // Cambiamos el diseño al pulsar en el botón de crear cuenta
        signUpVisibility.setOnClickListener(v -> {
            name.setVisibility(View.VISIBLE);
            surname.setVisibility(View.VISIBLE);
            phone.setVisibility(View.VISIBLE);
            password.setVisibility(View.GONE);
            loginActivity.setVisibility(View.GONE);
            signUpActivity.setVisibility(View.VISIBLE);
            layout.setVisibility(View.GONE);
            layout2.setVisibility(View.VISIBLE);
        });

        // Cambiamos el diseño al pulsar en el botón de iniciar sesión
        loginVisibility.setOnClickListener(v -> {
            name.setVisibility(View.GONE);
            surname.setVisibility(View.GONE);
            phone.setVisibility(View.GONE);
            password.setVisibility(View.VISIBLE);
            loginActivity.setVisibility(View.VISIBLE);
            signUpActivity.setVisibility(View.GONE);
            layout.setVisibility(View.VISIBLE);
            layout2.setVisibility(View.GONE);
        });


        // Cambiamos de Activity al iniciar sesión
        signUpActivity.setOnClickListener(v -> {

            String nick = nickname.getText().toString();
            String pass = pw.getText().toString();
            String n = name.getText().toString();
            String s = surname.getText().toString();
            String p = phone.getText().toString();

            if (nick.isEmpty() || pass.isEmpty() || n.isEmpty() || s.isEmpty() || p.isEmpty()) {
                Toast.makeText(Login.this, "Rellena todos los campos",Toast.LENGTH_SHORT).show();
                return;
            }

            dbHandler.saveNewUser(new User(nick,n,s,p,pass,null,null,null,null,"user"));

            Intent intent=new Intent(Login.this, Home.class);
            startActivity(intent);
            finish();
        });

        // Cambiamos de Activity al hacer el registro
        loginActivity.setOnClickListener(v -> {
            Intent intent=new Intent(Login.this, Home.class);
            startActivity(intent);
            finish();
        });
    }

    // Cancelamos la función de la flecha hacia atrás
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}