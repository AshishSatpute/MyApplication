package com.example.loginmodule.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.loginmodule.R;


public class Registration extends AppCompatActivity {

    EditText etname, etEmail, etPass, etMobileNo, etDesignation;
    Button btnRegitration;
    TextView tvlogin;

    private AwesomeValidation awesomeValidation;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_activity);

        etname = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etUserPass);
        etMobileNo = findViewById(R.id.etUserNumber);
        etDesignation = findViewById(R.id.etDesignation);
        btnRegitration = findViewById(R.id.btnRegister);
        tvlogin = (TextView) findViewById(R.id.tvLogin);

        tvlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(this,LoginPage.class);
                startActivity(intent);*/
            }
        });

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this, R.id.etName, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.etEmail, Patterns.EMAIL_ADDRESS, R.string.email_error);
        awesomeValidation.addValidation(this, R.id.etUserPass, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.password_error);
        awesomeValidation.addValidation(this, R.id.etDesignation, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.designation_error);


        btnRegitration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doRegistration();
            }

            private void doRegistration() {
                String name = etname.getText().toString();
                String email = etEmail.getText().toString();
                String pass = etPass.getText().toString();
                String designation = etDesignation.getText().toString();


                if (awesomeValidation.validate()) {
                    Toast.makeText(Registration.this, "Validation Success", Toast.LENGTH_SHORT).show();


                    sharedPreferences = getSharedPreferences("Register", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putString("name", name);
                    editor.putString("email", email);
                    editor.putString("pass", pass);
                    editor.putString("desig", designation);
                    editor.commit();

                    Intent intent = new Intent(getApplicationContext(), LoginPage.class);
                    startActivity(intent);
                }
            }
        });

    }
}
