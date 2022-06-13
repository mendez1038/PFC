package com.example.opticaapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHandler extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Optica.db";

    public DbHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Create Table Users
        db.execSQL("CREATE TABLE " + UserContract.UserEntry.TABLE_NAME + " ("
                + UserContract.UserEntry.NICKNAME + " TEXT PRIMARY KEY,"
                + UserContract.UserEntry.NAME + " TEXT NOT NULL,"
                + UserContract.UserEntry.SURNAME + " TEXT NOT NULL,"
                + UserContract.UserEntry.PHONE + " TEXT NOT NULL,"
                + UserContract.UserEntry.PASSWORD + " TEXT NOT NULL,"
                + UserContract.UserEntry.MIOPIA + " TEXT,"
                + UserContract.UserEntry.HM + " TEXT,"
                + UserContract.UserEntry.ASTIGMATISMO + " TEXT,"
                + UserContract.UserEntry.COMMENTS + " TEXT,"
                + UserContract.UserEntry.ROL + " TEXT NOT NULL)");

        // Create Table Photos
        db.execSQL("CREATE TABLE " + PhotoContract.PhotoEntry.TABLE_NAME + "("
        + PhotoContract.PhotoEntry.ID + "TEXT PRIMARY KEY,"
        + PhotoContract.PhotoEntry.URL + "TEXT NOT NULL)");

        // Insert data
        insertDataUser(db);
        insertDataPhoto(db);
    }
    // Datos de prueba
    private void insertDataPhoto(SQLiteDatabase db) {
        savePhoto(db, new Photo("Rayban 341","https://d2r9epyceweg5n.cloudfront.net/stores/001/302/367/products/erika-sepia-341-79f3ad5d443ef35d9115987384356675-640-0.jpg"));
        savePhoto(db, new Photo("Rayban 331","https://d2r9epyceweg5n.cloudfront.net/stores/001/302/367/products/erika-sepia-341-79f3ad5d443ef35d9115987384356675-640-0.jpg"));
        savePhoto(db, new Photo("Rayban 321","https://d2r9epyceweg5n.cloudfront.net/stores/001/302/367/products/erika-sepia-341-79f3ad5d443ef35d9115987384356675-640-0.jpg"));

    }
    // Datos de prueba
    private void insertDataUser(SQLiteDatabase db) {
        saveUser(db, new User("admin", "Administrador",
                "CEO", "626408214",
                "admin", "","","","","admin"));
        saveUser(db, new User("mendez1038", "David",
                "Mendez", "666777888",
                "1234", "0-0","0-0","0.5-0.75","Ojo de palo","user"));
        saveUser(db, new User("pedroca", "Pedro",
                "Casares", "666555444",
                "1234", "0-0","1-0.5","0-0","Revisión en 6 meses","user"));
        saveUser(db, new User("silviasa", "Silvia",
                "Saco", "666222000",
                "1234", "0-0","0-0","0-0","Vista perfecta","user"));
    }


    public long saveUser(SQLiteDatabase db, User user){
        return db.insert(UserContract.UserEntry.TABLE_NAME, UserContract.UserEntry.MIOPIA, user.toContentValues());
    }

    // Insertar nuevo usuario
    public void saveNewUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(UserContract.UserEntry.TABLE_NAME,null, user.toContentValues());
        db.close();
    }

    public long savePhoto(SQLiteDatabase db, Photo photo){
        return db.insert(PhotoContract.PhotoEntry.TABLE_NAME, null, photo.toContentValues());
    }

    public Cursor getAllUsers(){
        return getReadableDatabase().query(UserContract.UserEntry.TABLE_NAME,null,null,null,null,null,null, null);
    }

    public Cursor getUserByNick(String nick){
        return getReadableDatabase().rawQuery("SELECT * FROM " + UserContract.UserEntry.TABLE_NAME + " WHERE "+ UserContract.UserEntry.NICKNAME + " LIKE ? ", new String[]{nick});
    }

    public Cursor getAllPhotos(){
        return getReadableDatabase().query(PhotoContract.PhotoEntry.TABLE_NAME,null,null,null,null,null,null, null);
    }

    public Cursor getPhotoById(String id){
        return getReadableDatabase().query(PhotoContract.PhotoEntry.TABLE_NAME,null, PhotoContract.PhotoEntry.ID + " LIKE ? ", new String[]{id}, null, null, null, null);
    }

    // Consultar usuario por nick
    public User readUser(String nick){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + UserContract.UserEntry.TABLE_NAME + " WHERE " + UserContract.UserEntry.NICKNAME + " LIKE ? ", new String[]{nick});
        User u = null;
        if (cursorCourses.moveToFirst()){
            u = new User(cursorCourses.getString(0),
                    cursorCourses.getString(1),
                    cursorCourses.getString(2),
                    cursorCourses.getString(3),
                    cursorCourses.getString(4),
                    cursorCourses.getString(5),
                    cursorCourses.getString(6),
                    cursorCourses.getString(7),
                    cursorCourses.getString(8),
                    cursorCourses.getString(9));
        }

        cursorCourses.close();
        return u;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
