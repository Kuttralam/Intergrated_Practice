package com.example.kuttr.integratedpractice;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.kuttr.periodicalsample.R;

import static android.util.Patterns.PHONE;

public class Main2Activity extends AppCompatActivity {
TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv1=findViewById(R.id.tv1);
        Bundle b = getIntent().getExtras();

        String n = b.getString("PHONE");
        String j = b.getString("email");
        String vmail=b.getString("vmail");
        String spinner=b.getString("spinner");

        String test = " \n Mobile: "+ n +"\n Email:  "+j + "\n Vmail:  " + vmail+ "\n spinner:  " + spinner;
        tv1.setText(test);

    }
}
