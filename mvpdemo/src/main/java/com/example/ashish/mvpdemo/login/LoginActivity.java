package com.example.ashish.mvpdemo.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.ashish.mvpdemo.MyApp;
import com.example.ashish.mvpdemo.R;


public class LoginActivity extends AppCompatActivity implements LoginView {

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenterImpl(this);

        MyApp app = (MyApp) this.getApplication();
        //app.getSocket().getOutputStream().write("".getBytes());
    }

    @Override
    public void login(String usNm, String pass) {
        presenter.doLoin(usNm, pass);
    }

    @Override
    public void showTickMark(boolean tick) {

    }
}
