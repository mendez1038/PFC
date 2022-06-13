package com.example.opticaapp;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class List extends AppCompatActivity {


    ListView listview;
    ArrayList<String> names;
    DbHandler db;
    Cursor cursor;
    SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listview = findViewById(R.id.listView);
        names = new ArrayList<>();
        db = new DbHandler(List.this);
        adapter = new SimpleCursorAdapter(
                List.this, // Context context
                R.layout.adapter, // int layout
                db.getUserByNick("admin"), // Cursor c
                new String[]{UserContract.UserEntry.NICKNAME}, // String[] from
                new int[]{R.id.textViewAdapter}, // int[] to
                SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER // int flags
        );

        listview.setAdapter(adapter);

        listview.setOnItemClickListener((AdapterView<?> adapterView, View view, int position, long id) -> {

            Toast.makeText(List.this, "Detalle", Toast.LENGTH_LONG).show();
        });

    }
}