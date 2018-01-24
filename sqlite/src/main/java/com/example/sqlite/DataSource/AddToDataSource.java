package com.example.sqlite.DataSource;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.sqlite.DataModel.AddDataModel;

/**
 * Created by ashish on 23/1/18.
 */

public class AddToDataSource extends DatabaseHelper {
    private String TAG = AddToDataSource.class.getSimpleName();
    private SQLiteDatabase database;

    private static final String TABLE_NAME_ADD = "add";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";

    public AddToDataSource(Context context) {
        super(context);
    }

    public static final String CREATE_TABLE_ADD = " CREATE TABLE "
            + TABLE_NAME_ADD
            + " ("
            + COLUMN_USERNAME
            + " TEXT NOT NULL, "
            + COLUMN_PASSWORD
            + " TEXT NOT NULL"
            + " );";

    public void addData(AddDataModel addDataModel) {
        Log.i(TAG, "addData: ");
        database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USERNAME, addDataModel.getName());
        contentValues.put(COLUMN_PASSWORD, addDataModel.getPassword());
        long insertedId = database.insert(TABLE_NAME_ADD, null, contentValues);
        Log.i(TAG, "addData: " + insertedId);
    }
}