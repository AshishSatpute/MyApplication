package com.example.ashish.mvpdemo.login;

/**
 * Created by aniruddha on 14/9/17.
 */

public interface LoginPresenter {

    boolean checkUserNameAvalability(String userName);

    boolean doLoin(String userName, String pass);
}
