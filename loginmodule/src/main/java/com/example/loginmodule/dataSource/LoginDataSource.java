package com.example.loginmodule.dataSource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import com.example.loginmodule.dataModel.LoginDataModel;

import java.util.ArrayList;

/**
 * Created by WIN07 on 10/15/2017.
 */

public class LoginDataSource extends DatabaseHelper {
    private String TAG = LoginDataSource.class.getSimpleName();

    private SQLiteDatabase database;

    private static final String TABLE_NAME_LOGIN = "login";
    private static final String COLUMN_LOGIN_ID = "login_id";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";

    public static final String CREATE_TABLE_LOGIN = " CREATE TABLE "
            + TABLE_NAME_LOGIN
            + " ("
            + COLUMN_LOGIN_ID
            + " INTEGER PRIMARY KEY, "
            + COLUMN_USERNAME
            + " TEXT NOT NULL, "
            + COLUMN_PASSWORD
            + " TEXT NOT NULL"
            + " );";

    private final String[] allColumns = {COLUMN_LOGIN_ID, COLUMN_USERNAME, COLUMN_PASSWORD};

    public LoginDataSource(Context context) {
        super(context);
    }


    public void insertLoginDetails(LoginDataModel loginDataModel) {
        Log.e(TAG, "insertLoginDetails: ");
        database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USERNAME, loginDataModel.getUsername());
        contentValues.put(COLUMN_PASSWORD, loginDataModel.getPassword());

        long insertedId = database.insert(TABLE_NAME_LOGIN, null, contentValues);
        Log.e(TAG, "insertLoginDetails: " + insertedId);
        database.close();
    }

    public ArrayList<LoginDataModel> selectLoginDetails() {
        Log.e(TAG, "selectLoginDetails: ");
        ArrayList<LoginDataModel> loginDataModelArrayList = new ArrayList<>();
        database = getReadableDatabase();
//        String selection = COLUMN_USERNAME + " = ? ";
//        String[] selectionArgument = {k};
        Cursor cursor = database.query(TABLE_NAME_LOGIN, allColumns, null, null, null, null, null);

        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                LoginDataModel loginDataModel = new LoginDataModel();
                loginDataModel.setUsername(cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME)));
                loginDataModel.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD)));
                loginDataModelArrayList.add(loginDataModel);
            }
        }
        cursor.close();
        database.close();
        return loginDataModelArrayList;
    }
}
