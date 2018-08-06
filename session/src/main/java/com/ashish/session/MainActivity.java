package com.ashish.session;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String TAG=MainActivity.class.getCanonicalName();
    Context context;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context =MainActivity.this;
        Log.i(TAG, "onCreate: ");
        checkcond();

    }

    private void checkcond() {
        SharedPreferences sp = getSharedPreferences("prefs", MODE_PRIVATE);
        String val = sp.getString("loginDone", null);
        Log.i(TAG, "getSharedPreferences: "+val);

        if (val !=null){
            Intent intent = new Intent(context,SecondActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            Log.i(TAG, "onCreate: Intent");
            finish();
        }
    }

    public void login(View view) {
        Log.i(TAG, "login: ");
        SharedPreferences sp = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("loginDone","loginDone");
        editor.commit();
        editor.apply();

        Log.i(TAG, "login: " +sp.getString("loginDone",null));
        startActivity(new Intent(context,SecondActivity.class));
    }
}
