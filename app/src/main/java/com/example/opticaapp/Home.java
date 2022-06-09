package com.example.opticaapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    // Create variables
    LinearLayout profile,catalogue,settings,logout,customerList,photosList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Init variables
        profile = findViewById(R.id.btn_profile);
        catalogue = findViewById(R.id.btn_catalogue);
        settings = findViewById(R.id.btn_settings);
        logout = findViewById(R.id.btn_logout);
        customerList = findViewById(R.id.btn_customerList);
        photosList = findViewById(R.id.btn_photosList);


        // Acciones al hacer click en los botones de Perfil, Catalogo, Ajustes, Cerrar Sesión, Lista de Clientes y Lista de Fotos
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

        settings.setOnClickListener(v -> Toast.makeText(getApplicationContext(),R.string.Settings,Toast.LENGTH_SHORT).show());

        logout.setOnClickListener(v -> {
            Intent intent=new Intent(Home.this, MainActivity.class);
            Bundle b = new Bundle();
            b.putString("key","Out tro");
            intent.putExtras(b);
            startActivity(intent);
            finish();
        });

        customerList.setOnClickListener(v -> Toast.makeText(getApplicationContext(), "Customer List",Toast.LENGTH_SHORT).show());

        photosList.setOnClickListener(v -> Toast.makeText(getApplicationContext(), "Photos List",Toast.LENGTH_SHORT).show());

    }

    // Cancelamos la función de la flecha hacia atrás
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}