package com.example.opticaapp;

import android.provider.BaseColumns;

public class PhotoContract {

    public static abstract class PhotoEntry implements BaseColumns{
        public  static final String TABLE_NAME = "photo";

        public static final String ID = "id";
        public static final String URL = "url";
    }
}
