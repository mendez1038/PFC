package com.example.opticaapp;

import android.content.ContentValues;

public class Photo {

    private String id;
    private String url;

    public Photo(String id, String url){
        this.id = id;
        this.url = url;
    }


    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(PhotoContract.PhotoEntry.ID, id);
        values.put(PhotoContract.PhotoEntry.URL, url);
        return values;
    }
}
