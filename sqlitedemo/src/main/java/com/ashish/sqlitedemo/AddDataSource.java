package com.ashish.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class AddDataSource extends DatabaseHelper {


    SQLiteDatabase database;
    private static final String TABLE_NAME_LOGIN = "save";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";

    public static final String CREATE_TABLE_LOGIN = " CREATE TABLE "
            + TABLE_NAME_LOGIN
            + " ("
            + COLUMN_USERNAME
            + " TEXT NOT NULL, "
            + COLUMN_PASSWORD
            + " TEXT NOT NULL"
            + " );";

    private final String[] allColumns = {COLUMN_USERNAME, COLUMN_PASSWORD};
    public AddDataSource(Context context) {
        super(context);
    }

    public void insertDetails(DataModel dataModel){

        Log.i(TAG, "insertDetails: ");
        database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USERNAME,dataModel.getName());
        contentValues.put(COLUMN_PASSWORD,dataModel.getPass());

        long insertedId = database.insert(TABLE_NAME_LOGIN, null, contentValues);
        Log.i(TAG, "insertDetails: "+insertedId);
        Log.i(TAG,"::"+dataModel.getName());
        Log.i(TAG,"::"+dataModel.getPass());
    }

    public Cursor read(SQLiteDatabase database){

        String[] projections = {COLUMN_USERNAME,COLUMN_PASSWORD};

        Cursor cursor = database.query(TABLE_NAME_LOGIN,projections,null,null,null,null,null);
        return cursor;
    }


    /*private void read() {

        SQLiteDatabase database = getReadableDatabase();

        Cursor cursor = read(database);

        while (cursor.moveToNext()) {
            DataModel dataModel= new DataModel();

            String name= cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME));
            String pass= cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD));

        }
    }*/

}