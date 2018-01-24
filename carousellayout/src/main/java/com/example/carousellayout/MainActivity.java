package com.example.carousellayout;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import in.goodiebag.carouselpicker.CarouselPicker;

public class MainActivity extends AppCompatActivity {

    CarouselPicker carouselPicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       carouselPicker = findViewById(R.id.carouselPicker1);

       //cp1 with all img

        List<CarouselPicker.PickerItem> pickerItems = new ArrayList<>();
        pickerItems.add(new CarouselPicker.DrawableItem(R.drawable.background));
        pickerItems.add(new CarouselPicker.DrawableItem(R.drawable.backgraoound));

        CarouselPicker.CarouselViewAdapter imageAdapter = new CarouselPicker.CarouselViewAdapter(this,pickerItems,0);
        carouselPicker.setAdapter(imageAdapter);

    }
}