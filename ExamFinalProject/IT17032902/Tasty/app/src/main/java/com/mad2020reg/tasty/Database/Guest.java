package com.mad2020reg.tasty.Database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class Guest {
    Guest(){
    }



    public static class GuestDetails implements BaseColumns{
        public static final String TABLE_NAME = "guest";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_GUEST_NAME = "guestName";
        public static final String COLUMN_NAME_EMAIL = "email";
        public static final String COLUMN_NAME_CONTACT = "contact";

    }
}
