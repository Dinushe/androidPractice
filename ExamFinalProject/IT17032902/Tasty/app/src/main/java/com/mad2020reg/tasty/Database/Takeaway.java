package com.mad2020reg.tasty.Database;

import android.provider.BaseColumns;

public class Takeaway {
    Takeaway(){}

    public static class TakeawayDetails implements BaseColumns{
        public static final String TABLE_NAME = "takeaway";
        public static final String COLUMN_NAME_GUEST_CONTACT ="gContact";
        public static final String COLUMN_NAME_TAKEAWAY_CAT = "category";
        public static final String COLUMN_NAME_TAKEAWAY_CHARGE = "takeawayCharges";

    }
}
