package com.ashish.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class AddDataSource extends DatabaseHelper {


    SQLiteDatabase database;
    private static final String TABLE_NAME_LOGIN = "save";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";

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
}