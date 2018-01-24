package com.example.simplesqlite.Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.simplesqlite.DataModel.LoginDataModel;
import com.example.simplesqlite.DataSource.LoginDataSource;
import com.example.simplesqlite.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String TAG = MainActivity.class.getSimpleName();
    private Context context;
    private EditText editTextUsername, editTextPassword;
    private Button buttonLogin, buttongetLoginDetails;
    private TextView tvname, tvpassword;
    LoginDataModel loginDataModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        initViews();
        setListener();
    }

    private void initViews() {
        Log.e(TAG, "initViews: ");
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttongetLoginDetails = findViewById(R.id.buttongetLoginDetails);
        tvname = findViewById(R.id.tvname);
       // tvpassword = findViewById(R.id.tvpassword);
    }

    private void setListener() {
        Log.e(TAG, "setListener: ");
        buttonLogin.setOnClickListener(this);
        buttongetLoginDetails.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Log.e(TAG, "onClick: ");
        switch (view.getId()) {
            case R.id.buttonLogin:
                doLogin();
                break;

            case R.id.buttongetLoginDetails:
                getLoginDetails();
                break;
        }
    }

    private void getLoginDetails() {
        Log.e(TAG, "getLoginDetails: ");
        LoginDataSource loginDataSource = new LoginDataSource(context);
        ArrayList<LoginDataModel> loginDataModelArrayList = loginDataSource.selectLoginDetails();
        Toast.makeText(context, "Ashish " + loginDataModelArrayList.size(),Toast.LENGTH_SHORT).show();
        Log.e(TAG, "getLoginDetails: " + loginDataModelArrayList);
    }

    private void doLogin() {
        Log.e(TAG, "doLogin: ");
        LoginDataModel loginDataModel = new LoginDataModel();
        loginDataModel.setUsername(editTextUsername.getText().toString());
        loginDataModel.setPassword(editTextPassword.getText().toString());

        //SQLite DB
        LoginDataSource loginDataSource = new LoginDataSource(context);
        loginDataSource.insertLoginDetails(loginDataModel);

    }
}
