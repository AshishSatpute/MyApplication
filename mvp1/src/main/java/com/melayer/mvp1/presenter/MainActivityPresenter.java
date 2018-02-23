package com.melayer.mvp1.presenter;

import android.util.Log;
import android.view.View;

import com.melayer.mvp1.view.MainActivity;
import com.melayer.mvp1.contract.MainActivityContract;
import com.melayer.mvp1.model.MainActivityModel;

/**
 * Created by ashish on 17/2/18.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private MainActivityContract.View mView;
    private MainActivityContract.Model mModel;

    public static final String TAG = MainActivityPresenter.class.getCanonicalName();

    public MainActivityPresenter(MainActivity view) {
        Log.i(TAG, "MainActivityPresenter con");
        mView = view;
        initPresenter();

    }

    private void initPresenter() {
        Log.i(TAG, "initPresentor ");
        mModel = new MainActivityModel();
        mView.initView();
    }


    @Override
    public void myClick(View view) {
        String data = mModel.getData();
        mView.setViewData(data);
    }
}
