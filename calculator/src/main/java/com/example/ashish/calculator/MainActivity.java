package com.example.ashish.calculator;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.toUnsignedString;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button Addition, Subtraction, Division, Multipication;
    EditText FirstNo, SecondNo;
    TextView textView;
    float op1;
    float op2;
     float res;
    String fin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Addition = (Button) findViewById(R.id.add);
        Subtraction = (Button) findViewById(R.id.sub);
        Multipication = (Button) findViewById(R.id.mult);
        Division = (Button) findViewById(R.id.div);

        FirstNo = findViewById(R.id.editText1);
        SecondNo = findViewById(R.id.editText2);

        textView = findViewById(R.id.textView3);


        Addition.setOnClickListener(this);
        Subtraction.setOnClickListener(this);
        Multipication.setOnClickListener(this);
        Division.setOnClickListener(this);

    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
         switch (view.getId())
         {
             case R.id.add:
                 op1= parseFloat(FirstNo.getText().toString());
                 op2= parseFloat(SecondNo.getText().toString());
                 res=op1+op2;
                 textView.setText(Float.toString(res));
                 break;

             case R.id.sub:

                 op1= parseFloat(FirstNo.getText().toString());
                 op2= parseFloat(SecondNo.getText().toString());
                 res=op1-op2;
                 textView.setText(Float.toString(res));
                 break;


             case R.id.mult:

                 op1= parseFloat(FirstNo.getText().toString());
                 op2= parseFloat(SecondNo.getText().toString());
                 res=op1*op2;
                 textView.setText(Float.toString(res));
                 break;


             case R.id.div:

                 op1= parseFloat(FirstNo.getText().toString());
                 op2= parseFloat(SecondNo.getText().toString());
                 res=op1/op2;
                 textView.setText(Float.toString(res));
                 break;

         }

    }
}
