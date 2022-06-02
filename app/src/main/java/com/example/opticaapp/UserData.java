package com.example.opticaapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class UserData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(UserData.this, Home.class);
        startActivity(intent);
        finish();
        //onBackPressed();
    }
}