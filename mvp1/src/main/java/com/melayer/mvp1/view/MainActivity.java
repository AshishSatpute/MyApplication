package com.melayer.mvp1.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.melayer.mvp1.contract.MainActivityContract;
import com.melayer.mvp1.presenter.MainActivityPresenter;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    TextView mTextView;
    Button mButton;
    MainActivityContract.Presenter mPresenter;

    public static final String TAG=MainActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"oncreate");
        mPresenter = new MainActivityPresenter(this);
        Log.i(TAG,"MainActivityPresenter");

    }


    @Override
    public void initView() {
        Log.i(TAG,"initView");
        mTextView = findViewById(R.id.textView);
        mButton = findViewById(R.id.btnShow);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"onClick");
                mPresenter.myClick(v);
            }
        });
    }


    @Override
    public void setViewData(String data) {
        mTextView.setText(data);
    }
}
