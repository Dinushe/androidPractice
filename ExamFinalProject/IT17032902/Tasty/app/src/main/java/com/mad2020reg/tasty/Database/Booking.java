package com.mad2020reg.tasty.Database;

import android.provider.BaseColumns;

public class Booking {
    Booking(){
    }

    public static class BookingDetails implements BaseColumns{
        public static final String TABLE_NAME = "booking";
        public static final String COLUMN_NAME_GUEST_CONTACT ="gContact";
        public static final String COLUMN_NAME_BOOKING_CATEGORY="category";
        public static final String COLUMN_NAME_TABLE_NO ="tableNo";
        public static final String COLUMN_NAME_TABLE_BOOKING_CHARGE = "tableCharges";


    }
}
