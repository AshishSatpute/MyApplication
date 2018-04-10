package com.melayer.mvp1.model;

import com.melayer.mvp1.contract.MainActivityContract;

/**
 * Created by ashish on 17/2/18.
 */

public class MainActivityModel implements MainActivityContract.Model{
    @Override
    public String getData() {
        return "Hiiiii";
    }
}
