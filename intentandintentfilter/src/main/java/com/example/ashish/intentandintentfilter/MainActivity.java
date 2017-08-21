package com.example.ashish.intentandintentfilter;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goNext(View view) {

        our();
    }

    private void calltofirstActivity() {
        Intent intent = new Intent();
        intent.setAction("com.ash.action.FIRST");
        intent.addCategory("android.intent.category.DEFAULT");
        startActivity(intent);
    }

    private void our() {
        Intent intent = new Intent();
        intent.setAction("com.ash.action.FIRST");
        intent.setData(Uri.parse("http://google.com"));

        startActivity(intent);
    }

    private void web() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://google.com"));

        startActivity(intent);
    }

    private void dial() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        startActivity(intent);
    }

    private void call() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel://9145996507"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

    }
}
