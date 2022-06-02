package com.example.opticaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            // Creamos el splash para que la portada dure 2 segundos
            new Timer().schedule(new TimerTask(){
                @Override
                public void run(){
                    Bundle bundle = getIntent().getExtras();
                    if (bundle!= null){
                        String vision = bundle.getString("key", "intro");
                        if (vision.equals("outtro")){
                            System.exit(0);
                        }else {
                            Intent intent=new Intent(MainActivity.this, Login.class);
                            startActivity(intent);
                            finish();
                        }
                    } else {
                        Intent intent=new Intent(MainActivity.this, Login.class);
                        startActivity(intent);
                        finish();
                    }
                }

            },2000);


    }
}