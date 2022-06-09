package com.example.opticaapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class UserData extends AppCompatActivity {

    // Create variables
    TextView nickname,miopia,hm,astigmatismo,comments;
    User cursorCourses;
    DbHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

        // Init variables
       nickname = findViewById(R.id.textView);
       miopia = findViewById(R.id.tv_miopia);
       hm = findViewById(R.id.tv_hm);
       astigmatismo = findViewById(R.id.tv_astigmatismo);
       comments = findViewById(R.id.tv_comentarios);
       db = new DbHandler(UserData.this);


       // Recoger el nick actual de la sesion
       cursorCourses = db.readUser("pedroca");


       nickname.setText(cursorCourses.getNickname());
       miopia.setText(cursorCourses.getMiopia());
       hm.setText(cursorCourses.getHm());
       astigmatismo.setText(cursorCourses.getAstigmatismo());
       comments.setText(cursorCourses.getComments());
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(UserData.this, Home.class);
        startActivity(intent);
        finish();
        //onBackPressed();
    }
}