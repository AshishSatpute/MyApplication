package com.melayer.roomsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText email, name, number;
    Button done;

    AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        name = findViewById(R.id.name);
        number = findViewById(R.id.number);

        done = findViewById(R.id.done);


        appDatabase = AppDatabase.getDatabase(getApplicationContext());
        final List<UserModel> list = appDatabase.userDao().getAll();
        if (list != null && !list.isEmpty()) {
            Log.i("ashish", "onCreate: " + list.toString());
        }

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserModel userModel = new UserModel();
                userModel.setEmailId(email.getText().toString());
                userModel.setName(name.getText().toString());
                userModel.setContactNumber(number.getText().toString());
                appDatabase.userDao().addUser(userModel);
                Log.e("Ashish", "onClick: " + userModel.getName());
                appDatabase.userDao().getAll();
                Log.e("Ashish", "onClick: ");



            }
        });

    }


    public String getemail() {
        return email.getText().toString();
    }
}
