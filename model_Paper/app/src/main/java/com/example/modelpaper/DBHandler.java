package com.example.modelpaper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler {

    public static final String key_rowID = "_ID";
    public static final String key_name = "_userName";
    public static final String key_dob = "_dateOfBirth";
    public static final String key_gender = "_Gender";

    private final String DATABASE_NAME = "DBHandler";
    private final String DATABASE_TABLE = "UserInfo";
    private final int DATABASE_VERSION = 1;

    private DBHelper ourHelper;
    private final Context ourContext;
    private SQLiteDatabase ourDatabase;


    public DBHandler(Context ourContext) {
        this.ourContext = ourContext;
    }

    private class DBHelper extends SQLiteOpenHelper {

        public DBHelper (Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
/*
            CREATE TABLE ContactsTable (_id INTEGER PRIMARY KEY AUTOINCREMENT,
                                        _name TEXT NOT NULL,
                                        _cell TEXT NOT NULL);*/

            String sqlCode = "CREATE TABLE " + DATABASE_TABLE + " (" +
                    key_rowID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    key_name + " TEXT NOT NULL," +
                    key_dob + " TEXT NOT NULL," +
                    key_gender + "TEXT NOT NULL);";

            db.execSQL(sqlCode);
        }
    }

    public DBHandler open() throws SQLException {
        ourHelper = new DBHelper(ourContext);
        ourDatabase = ourHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        ourHelper.close();
    }

    public long addInfo(String name, String dob){

        ContentValues cv = new ContentValues();
        cv.put(key_name,name);
        cv.put(key_dob,dob);
        return ourDatabase.insert(DATABASE_TABLE,null,cv);
    }

    public Boolean updateInfor(String rowID,String name, String dob, String gender){
        ContentValues cv = new ContentValues();
        cv.put(key_name,name);
        cv.put(key_dob,dob);
        cv.put(key_gender,gender);
        long result = ourDatabase.update(DATABASE_TABLE,cv,key_rowID + "=?", new String[]{rowID});

        if (result == -1){
            return false;
        }else {
            return true;
        }
    }

    public String readAllInfor(){
        String [] columns = new String[]{key_rowID,key_name,key_dob,key_gender};
        Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null,null,null,null,null);

        String result = "";

        int iRowID = c.getColumnIndex(key_rowID);
        int iName = c.getColumnIndex(key_name);
        int iDob = c.getColumnIndex(key_dob);
        int iGender = c.getColumnIndex(key_gender);

        for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
            result = result + c.getString(iRowID) + ": " + c.getString(iName) + " " + c.getString(iDob) + " " + c.getString(iGender) +"\n";
        }

        c.close();

        return result;
    }

    public String [] readAllInfor(String rowID){

        Cursor c = ourDatabase.rawQuery("Select * from UserInfo where _ID = ?",new String[]{rowID});

        String result = "";
        String name = "";
        String dob = "";
        String gender = "";

        int iRowID = c.getColumnIndex(key_rowID);
        int iName = c.getColumnIndex(key_name);
        int iDob = c.getColumnIndex(key_dob);
        int iGender = c.getColumnIndex(key_gender);


        for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
            result = result + c.getString(iRowID) + ": " + c.getString(iName) + " " + c.getString(iDob) + " " + c.getString(iGender) +"\n";
        }

        name = c.getString(iName);
        dob = c.getString(iDob);
        gender = c.getString(iGender);

        String[] ar = new String[3];
        ar[0] = name;
        ar[1] = dob;
        ar[2] = gender;

        c.close();

        return ar;

    }

    public long deleteInfo(String rowID){

        return ourDatabase.delete(DATABASE_TABLE,key_rowID + "=?", new String[]{rowID});

    }


}
