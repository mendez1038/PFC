package com.example.opticaapp;

import android.provider.BaseColumns;

public class UserContract {

    public static abstract class UserEntry implements BaseColumns{

        public static final String TABLE_NAME = "user";

        public static final String NICKNAME = "nickname";
        public static final String NAME = "name";
        public static final String SURNAME = "surname";
        public static final String PHONE = "phone";
        public static final String PASSWORD = "password";
        public static final String MIOPIA = "miopia";
        public static final String HM = "hm";
        public static final String ASTIGMATISMO = "astigmatismo";
        public static final String COMMENTS = "comments";
        public static final String ROL = "rol";


    }
}
