package com.example.carousellayout2;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageDetailsActivity extends AppCompatActivity {

    public static final String TAG = ImageDetailsActivity.class.getSimpleName();
    private static final String DRAWABLE_RESOURE = "resource";
    private Context context;
    private ImageView imageView;
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);
        this.context = context;
        Log.i(TAG, "onCreate: ");

        imageView = findViewById(R.id.img);
        button = findViewById(R.id.btnClose);

        int drawbleResource = getIntent().getIntExtra(DRAWABLE_RESOURE, 0);
        imageView.setImageResource(drawbleResource);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: ");
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Log.i(TAG, "onBackPressed: ");
        finish();
    }
}
