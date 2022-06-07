package com.example.opticaapp;

import android.content.ContentValues;

public class User {

    private String nickname;
    private String name;
    private String surname;
    private String phone;
    private String password;
    private String miopia;
    private String hm;
    private String astigmatismo;
    private String comments;
    private String rol;

    public User(String nickname, String name, String surname, String phone, String password, String miopia, String hm, String astigmatismo,String comments, String rol){
        this.nickname = nickname;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.password = password;
        this.miopia = miopia;
        this.hm = hm;
        this.astigmatismo = astigmatismo;
        this.comments = comments;
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getMiopia() {
        return miopia;
    }

    public String getHm() {
        return hm;
    }

    public String getAstigmatismo() {
        return astigmatismo;
    }

    public String getComments() {
        return comments;
    }

    public String getRol() {
        return rol;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(UserContract.UserEntry.NICKNAME, nickname);
        values.put(UserContract.UserEntry.NAME, name);
        values.put(UserContract.UserEntry.SURNAME, surname);
        values.put(UserContract.UserEntry.PHONE, phone);
        values.put(UserContract.UserEntry.PASSWORD, password);
        values.put(UserContract.UserEntry.MIOPIA, miopia);
        values.put(UserContract.UserEntry.HM, hm);
        values.put(UserContract.UserEntry.ASTIGMATISMO, astigmatismo);
        values.put(UserContract.UserEntry.COMMENTS, comments);
        values.put(UserContract.UserEntry.ROL, rol);
        return values;
    }
}
