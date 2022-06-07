package com.example.opticaapp;

import android.content.ContentValues;

public class User {

    // Atributos
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

    // Constructor
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

    // Getters & Setters
    public String getPassword() {
        return password;
    }

    public void setPassword(String pw){password = pw;}

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String s){nickname = s;}

    public String getName() {
        return name;
    }

    public void setName(String s){name = s;}

    public String getSurname() {
        return surname;
    }

    public void setSurname(String s){surname = s;}

    public String getPhone() {
        return phone;
    }

    public void setPhone(String s){phone = s;}

    public String getMiopia() {
        return miopia;
    }

    public void setMiopia(String s){miopia = s;}

    public String getHm() {
        return hm;
    }

    public void setHm(String s){hm = s;}

    public String getAstigmatismo() {
        return astigmatismo;
    }

    public void setAstigmatismo(String s){astigmatismo = s;}

    public String getComments() {
        return comments;
    }

    public void setComments(String s){comments = s;}

    public String getRol() {
        return rol;
    }

    public void setRol(String s){rol = s;}

    // Método para insertar valores
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
