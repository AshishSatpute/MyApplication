package com.example.ashish.calculator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button Addition, Subtraction, Division, Multipication;
    EditText FirstNo, SecondNo;
    TextView textView;
    float op1;
    float op2;
    float res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Addition = findViewById(R.id.add);
        Subtraction = findViewById(R.id.sub);
        Multipication = findViewById(R.id.mult);
        Division = findViewById(R.id.div);

        FirstNo = findViewById(R.id.editText1);
        SecondNo = findViewById(R.id.editText2);

        textView = findViewById(R.id.textView3);

        Addition.setOnClickListener(this);
        Subtraction.setOnClickListener(this);
        Multipication.setOnClickListener(this);
        Division.setOnClickListener(this);

    }

    public void onNext(View view){

        Bundle bundle = new Bundle();
        bundle.putString("text",((TextView)findViewById(R.id.textView3)).getText().toString());

        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent,1000);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000 && resultCode == RESULT_OK && data != null) {
            String text = data.getStringExtra("text");
            ((TextView) findViewById(R.id.textView3)).setText(text);
        }
    }
    public boolean validaton() {

        if (FirstNo.getText().toString().trim().length() == 0) {
            Toast.makeText(this, "Enter First Number", Toast.LENGTH_SHORT).show();
            return false;
        } else if (SecondNo.getText().toString().trim().length() == 0) {
            Toast.makeText(this, "Enter Second Number", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                if (validaton()) {
                    op1 = Float.parseFloat(FirstNo.getText().toString());
                    op2 = Float.parseFloat(SecondNo.getText().toString());
                    res = op1 + op2;
                    textView.setText("" + res);
                }
                break;

            case R.id.sub:
                if (validaton()) {
                    op1 = Float.parseFloat(FirstNo.getText().toString());
                    op2 = Float.parseFloat(SecondNo.getText().toString());
                    res = op1 - op2;
                    textView.setText("" + res);
                }
                break;


            case R.id.mult:

                if (validaton()) {
                    op1 = Float.parseFloat(FirstNo.getText().toString());
                    op2 = Float.parseFloat(SecondNo.getText().toString());
                    res = op1 + op2;
                    textView.setText("" + res);
                }
                break;

            case R.id.div:
                if (validaton()) {
                    op1 = Float.parseFloat(FirstNo.getText().toString());
                    op2 = Float.parseFloat(SecondNo.getText().toString());
                    res = op1 / op2;
                    textView.setText("" + res);
                }
                break;
        }
    }
}
