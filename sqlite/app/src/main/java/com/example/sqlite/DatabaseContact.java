package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseContact {
    public static final String key_rowID = "_id";
    public static final String key_name = "_name";
    public static final String key_cell = "_cell";

    private final String DATABASE_NAME = "databaseContacts";
    private final String DATABASE_TABLE = "contactTable";
    private final int DATABASE_VERSION = 1;

    private DBHelper ourHelper;
    private final Context ourContext;
    private SQLiteDatabase ourDatabase;


    public DatabaseContact(Context ourContext) {
        this.ourContext = ourContext;
    }

    private class DBHelper extends SQLiteOpenHelper{

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
                    key_cell + " TEXT NOT NULL);";

            db.execSQL(sqlCode);
        }
    }

    public DatabaseContact open() throws SQLException{
        ourHelper = new DBHelper(ourContext);
        ourDatabase = ourHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        ourHelper.close();
    }

    public long createEntry(String name, String cell){

        ContentValues cv = new ContentValues();
        cv.put(key_name,name);
        cv.put(key_cell,cell);
        return ourDatabase.insert(DATABASE_TABLE,null,cv);
    }

    public String getData(){
        String [] columns = new String[]{key_rowID,key_name,key_cell};
        Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null,null,null,null,null);

        String result = "";

        int iRowID = c.getColumnIndex(key_rowID);
        int iName = c.getColumnIndex(key_name);
        int iCell = c.getColumnIndex(key_cell);

        for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
            result = result + c.getString(iRowID) + ": " + c.getString(iName) + " " + c.getString(iCell) + "\n";
        }

        c.close();

        return result;
    }

    public long deleteEntry(String rowID){

        return ourDatabase.delete(DATABASE_TABLE,key_rowID + "=?", new String[]{rowID});

    }

    public long updateEntry(String rowID,String name, String cell){

        ContentValues cv = new ContentValues();
        cv.put(key_name,name);
        cv.put(key_cell,cell);
        return ourDatabase.update(DATABASE_TABLE,cv,key_rowID + "=?", new String[]{rowID});

    }

}
