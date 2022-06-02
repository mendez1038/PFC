package com.example.opticaapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    //Init variables

    LinearLayout profile;
    LinearLayout catalogue;
    LinearLayout settings;
    LinearLayout logout;
    LinearLayout customerList;
    LinearLayout photosList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        profile = findViewById(R.id.btn_profile);
        catalogue = findViewById(R.id.btn_catalogue);
        settings = findViewById(R.id.btn_settings);
        logout = findViewById(R.id.btn_logout);
        customerList = findViewById(R.id.btn_customerList);
        photosList = findViewById(R.id.btn_photosList);

        profile.setOnClickListener(v -> {
            Intent intent=new Intent(Home.this, UserData.class);
            startActivity(intent);
            finish();
        });

        catalogue.setOnClickListener(v -> {
            Intent intent=new Intent(Home.this, Gallery.class);
            startActivity(intent);
            finish();
        });

        settings.setOnClickListener(v -> Toast.makeText(getApplicationContext(),"Ajustes",Toast.LENGTH_SHORT).show());

        logout.setOnClickListener(v -> {
            Intent intent=new Intent(Home.this, MainActivity.class);
            Bundle b = new Bundle();
            b.putString("key","outtro");
            intent.putExtras(b);
            startActivity(intent);
            finish();
        });

        customerList.setOnClickListener(v -> Toast.makeText(getApplicationContext(), "Lista clientes",Toast.LENGTH_SHORT).show());

        photosList.setOnClickListener(v -> Toast.makeText(getApplicationContext(), "Lista fotos",Toast.LENGTH_SHORT).show());

    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}