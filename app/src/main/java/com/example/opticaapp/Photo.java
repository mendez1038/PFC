package com.example.opticaapp;

import android.content.ContentValues;

public class Photo {

    // Atributos de la clase
    private String id;
    private String url;

    // Constructor
    public Photo(String id, String url){
        this.id = id;
        this.url = url;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String ref){id = ref;}

    public String getUrl() {
        return url;
    }

    public void setUrl(String enlace){url = enlace;}

    // Método para insertar valores
    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(PhotoContract.PhotoEntry.ID, id);
        values.put(PhotoContract.PhotoEntry.URL, url);
        return values;
    }
}
