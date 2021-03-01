package com.mad2020reg.tasty.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/****Question 03 (a) ****/

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import static com.mad2020reg.tasty.Database.Booking.BookingDetails.COLUMN_NAME_BOOKING_CATEGORY;
import static com.mad2020reg.tasty.Database.Booking.BookingDetails.COLUMN_NAME_GUEST_CONTACT;
import static com.mad2020reg.tasty.Database.Booking.BookingDetails.COLUMN_NAME_TABLE_BOOKING_CHARGE;
import static com.mad2020reg.tasty.Database.Booking.BookingDetails.COLUMN_NAME_TABLE_NO;
import static com.mad2020reg.tasty.Database.Guest.GuestDetails.COLUMN_NAME_CONTACT;
import static com.mad2020reg.tasty.Database.Guest.GuestDetails.COLUMN_NAME_EMAIL;
import static com.mad2020reg.tasty.Database.Guest.GuestDetails.COLUMN_NAME_GUEST_NAME;
import static com.mad2020reg.tasty.Database.Guest.GuestDetails.COLUMN_NAME_ID;
import static com.mad2020reg.tasty.Database.Guest.GuestDetails.TABLE_NAME;
import static com.mad2020reg.tasty.Database.Takeaway.TakeawayDetails.COLUMN_NAME_TAKEAWAY_CAT;
import static com.mad2020reg.tasty.Database.Takeaway.TakeawayDetails.COLUMN_NAME_TAKEAWAY_CHARGE;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Tasty.db";
    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_ENTRIES_guest =

                /****Question 03 (b)- (i) ****/

                 "CREATE TABLE " + TABLE_NAME + " (" +
                         COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                         COLUMN_NAME_GUEST_NAME + " TEXT NOT NULL," +
                         COLUMN_NAME_EMAIL + " TEXT NOT NULL," +
                         COLUMN_NAME_CONTACT + "TEXT NOT NULL);";

                db.execSQL(SQL_CREATE_ENTRIES_guest);



        String SQL_CREATE_ENTRIES_booking =

                /****Question 03 (b)- (ii) ****/

                "CREATE TABLE " + Booking.BookingDetails.TABLE_NAME + " (" +
                        COLUMN_NAME_TABLE_NO + " INTEGER PRIMARY KEY, " +
                        COLUMN_NAME_GUEST_NAME + " TEXT NOT NULL," +
                        COLUMN_NAME_BOOKING_CATEGORY + " TEXT NOT NULL," +
                        COLUMN_NAME_TABLE_BOOKING_CHARGE + " TEXT NOT NULL," +
                        COLUMN_NAME_GUEST_CONTACT + "TEXT NOT NULL);";



                db.execSQL(SQL_CREATE_ENTRIES_booking);



        String SQL_CREATE_ENTRIES_takeaway =


                /****Question 03 (b)- (iii) ****/

                "CREATE TABLE " + Takeaway.TakeawayDetails.TABLE_NAME+ " (" +
                        Takeaway.TakeawayDetails.COLUMN_NAME_GUEST_CONTACT + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NAME_TAKEAWAY_CAT + " TEXT NOT NULL," +
                        COLUMN_NAME_TAKEAWAY_CHARGE + "TEXT NOT NULL);";



        db.execSQL(SQL_CREATE_ENTRIES_takeaway);




    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    /****Question 03 (c) ****/

    public long addGuest(String name,String email,String contact){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();


        // statements?


        values.put(COLUMN_NAME_GUEST_NAME,name);
        values.put(COLUMN_NAME_EMAIL,email);
        values.put(COLUMN_NAME_CONTACT,contact);

        return db.insert(TABLE_NAME,null,values);



    }

    /****Question 03 (d) ****/

    public long addBooking(String name, String category, String contact, String tblNo){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        // statements?


        values.put(COLUMN_NAME_GUEST_CONTACT,name);
        values.put(COLUMN_NAME_BOOKING_CATEGORY,category);
        values.put(COLUMN_NAME_TABLE_BOOKING_CHARGE,contact);
        values.put(COLUMN_NAME_TABLE_NO,tblNo);

        return db.insert(TABLE_NAME,null,values);



    }

    /****Question 03 (e) ****/
    public long addTakeaway(/*****************/){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        // statements?



    }

    //View Data

    public List getGuests(){




        /****Question 03 (f) ****/




    }

    public List getBookings(){




        /****Question 03 (g) ****/



    }

    public List getTakeaways(){


        /****Question 03 (h) ****/

    }



}
