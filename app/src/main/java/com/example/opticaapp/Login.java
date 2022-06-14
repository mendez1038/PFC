package com.example.opticaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class Login extends AppCompatActivity {

    // Create variables
    Button signUpVisibility,loginVisibility,signUpActivity,loginActivity,password;
    EditText nickname, pw, name,surname,phone,userPw,phonePw;
    LinearLayout layout,layout2;
    DbHandler dbHandler;
    User user;
    AlertDialog.Builder builder;
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Init variables
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
        builder = new AlertDialog.Builder(Login.this);

        //inflater = requireActivity().getLayoutInflater();

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
        loginActivity.setOnClickListener(v -> {

            String nick = nickname.getText().toString();
            String pass = pw.getText().toString();
            String alertP = getString(R.string.alert_pass);
            String alertU = getString(R.string.alert_user);

            user = dbHandler.readUser(nick);


            if(user != null){
                if (pass.equals(user.getPassword())){

                    // Meter usuario en sesión

                    Intent intent=new Intent(Login.this, Home.class);
                    startActivity(intent);
                    finish();

                } else{
                    Toast.makeText(Login.this, alertP,Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(Login.this, alertU,Toast.LENGTH_SHORT).show();
            }
        });

        // Cambiamos de Activity al hacer el registro
        signUpActivity.setOnClickListener(v -> {

            String nick = nickname.getText().toString();
            String pass = pw.getText().toString();
            String n = name.getText().toString();
            String s = surname.getText().toString();
            String p = phone.getText().toString();
            String alertS = getString(R.string.alert_signup);


            if (nick.isEmpty() || pass.isEmpty() || n.isEmpty() || s.isEmpty() || p.isEmpty()) {
                Toast.makeText(Login.this, alertS,Toast.LENGTH_SHORT).show();

            } else {
                dbHandler.saveNewUser(new User(nick,n,s,p,pass,null,null,null,null,"user"));

                Intent intent=new Intent(Login.this, Home.class);
                startActivity(intent);
                finish();
            }

        });

        // Recuperar contraseña
        password.setOnClickListener(v -> {

            View vista = View.inflate(this,R.layout.dialog,null);
            String alertU = getString(R.string.alert_user);
            String alertP = getString(R.string.alert_phone);

            builder = new AlertDialog.Builder(this);
            builder.setTitle("Recuperar contraseña");
            builder.setMessage("Escribe tus datos para recibir tu contraseña por whatsapp");
            builder.setView(vista);
            builder.setPositiveButton("Enviar", (dialog, which) -> {
                userPw = vista.findViewById(R.id.usernamePw);
                phonePw = vista.findViewById(R.id.phonePw);
                String nickPw = userPw.getText().toString();
                String pPw = phonePw.getText().toString();
                user = dbHandler.readUser(nickPw);

                if(user != null){
                    if (pPw.equals(user.getPhone())){

                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.putExtra(Intent.EXTRA_TEXT, user.getPassword());
                        intent.setType("text/plain");
                        intent.setPackage("com.whatsapp");
                        // Checking whether Whatsapp
                        // is installed or not
                        /*if (intent.resolveActivity(getPackageManager()) == null) {
                            Toast.makeText(Login.this, "Please install whatsapp first.", Toast.LENGTH_SHORT).show();
                            return;
                        }*/
                        // Starting Whatsapp
                        startActivity(intent);

                    } else{
                        Toast.makeText(Login.this, alertP,Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Login.this, alertU,Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNegativeButton("Cancelar", (dialog, id) -> {});
            dialog = builder.create();
            dialog.show();

        });
    }

    // Cancelamos la función de la flecha hacia atrás
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}