package com.example.opticaapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Camera extends AppCompatActivity {

    // Inicializamos variables
    ImageView img;
    Button take, save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        // Vinculamos los elementos del XML a variables
        img = findViewById(R.id.iv_photo);
        take = findViewById(R.id.btn_photo);
        save = findViewById(R.id.btn_save_photo);
        //SharedPreferences preferencias = getSharedPreferences("DB", Context.MODE_PRIVATE);

        // Comprobar que tenemos permisos para acceder a la camara
        permisos();

        // Acceder a la camara
        take.setOnClickListener((View view) -> {
            int id;
            id = view.getId();
            if (id == R.id.iv_photo){
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, 0);
            }
        });
    }

    private void permisos(){
        int permisos = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if (permisos != PackageManager.PERMISSION_GRANTED){
            Log.i("Aviso", "No se tiene permiso para utilizar la camara");
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA},255);
        } else{
            Log.i("Mensaje", "Permisos concedidos");
        }
    }


    // Almacenar la foto sacada y mostrarla en la app
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK){
            Bundle b = data.getExtras();
            Bitmap bm = (Bitmap) b.get("data");
            img.setImageBitmap(bm);
        }
    }


}