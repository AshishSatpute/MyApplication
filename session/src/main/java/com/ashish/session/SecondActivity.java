package com.ashish.session;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    public static final String TAG=SecondActivity.class.getCanonicalName();
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        context = SecondActivity.this;
        Log.i(TAG, "onCreate: ");
    }

    public void logout(View view) {
        SharedPreferences sp = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove("loginDone");
        editor.commit();
        Log.i(TAG, "logout: "+sp.getString("loginDone",null));
        startActivity(new Intent(context,MainActivity.class));
    }
}
