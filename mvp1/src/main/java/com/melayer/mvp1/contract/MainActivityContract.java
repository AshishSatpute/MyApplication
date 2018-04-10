package com.melayer.mvp1.contract;


/**
 * Created by ashish on 17/2/18.
 */

public interface MainActivityContract {

    interface View {
        void initView();

        void setViewData(String dada);

    }

    interface Presenter {
        void myClick(android.view.View view);
    }

    interface Model {
        String getData();
    }
}
