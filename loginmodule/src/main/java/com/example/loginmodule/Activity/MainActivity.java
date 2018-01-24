package com.example.loginmodule.Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginmodule.R;
import com.example.loginmodule.dataModel.LoginDataModel;
import com.example.loginmodule.dataSource.LoginDataSource;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String TAG = MainActivity.class.getSimpleName();
    private Context context;
    private EditText editTextPassword, editTextUsername;
    private Button buttonClear, buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        initViews();
        setListener();
    }

    private void setListener() {
        Log.e(TAG, "setListener: ");
        buttonLogin.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
    }

    private void initViews() {
        Log.e(TAG, "initViews: ");
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonClear = findViewById(R.id.buttonClear);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonLogin:
                doLogin();
                break;

            case R.id.buttonClear:
                getLoginDetails();
                break;
        }
    }

    private void getLoginDetails() {
        Log.e(TAG, "getLoginDetails: ");
        LoginDataSource loginDataSource = new LoginDataSource(context);
        ArrayList<LoginDataModel> loginDataModelArrayList = loginDataSource.selectLoginDetails();
        Toast.makeText(context, "KAILAS " + loginDataModelArrayList.size(), Toast.LENGTH_SHORT).show();
    }

    private void doLogin() {
        Log.e(TAG, "doLogin: ");
        LoginDataModel loginDataModel = new LoginDataModel();
        loginDataModel.setUsername(editTextUsername.getText().toString());
        loginDataModel.setPassword(editTextPassword.getText().toString());

        LoginDataSource loginDataSource = new LoginDataSource(context);
        loginDataSource.insertLoginDetails(loginDataModel);


        /*FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("login");

        myRef.setValue(loginDataModel);


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                LoginDataModel value = dataSnapshot.getValue(LoginDataModel.class);
                Log.e(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        */
    }
}