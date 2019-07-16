package com.example.kuttr.integratedpractice;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener{
    EditText et1,et2;
    Button b1,b2,b3,b4,b5,b6;
    Spinner s1;
    CheckBox cb;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1= findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);

        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(this);
        b2 = findViewById(R.id.b2);
        b2.setOnClickListener(this);
        b3 = findViewById(R.id.b3);
        b3.setOnClickListener(this);
        b4 = findViewById(R.id.b4);
        b4.setOnClickListener(this);
        b5 = findViewById(R.id.b5);
        b5.setOnClickListener(this);
        b6 = findViewById(R.id.b6);
        b6.setOnClickListener(this);

        s1 = findViewById(R.id.s1);
        ArrayAdapter ad1 = ArrayAdapter.createFromResource
                (this,R.array.color,
                        android.R.layout.simple_list_item_activated_1);
        s1.setAdapter(ad1);
        s1.setOnItemSelectedListener(this);
        Log.d("In oncreate","spinner 1 set");

        cb=findViewById(R.id.cb);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==b1.getId())
        {
            et1.setText(" ");
        }

        if(v.getId()==b2.getId())
        {
            et2.setText(" ");
        }

        if(v.getId()==b3.getId())
        {
            if (et1.length() > 0 && et2.length() > 0 )
            {
                Intent i = new Intent
                        (MainActivity.this,
                                Main2Activity.class);
                if (cb.isChecked()) {
                    i.putExtra("vmail", "Voicemail Activated");
                }
                if (!cb.isChecked()) {
                    i.putExtra("vmail", "Voicemail Deactivated");

                }
                i.putExtra("PHONE", et1.getText().toString());
                i.putExtra("email", et2.getText().toString());
                i.putExtra("spinner", tv.getText().toString());
                startActivityForResult(i, 5);
            }
            if(et1.length() == 0 | et2.length() == 0| et1.length() == 0 && et2.length() == 0)
            {
                AlertDialog.Builder al =
                        new AlertDialog.Builder(
                                MainActivity.this);
                al.setTitle("Alert please fill the details ");
                al.setMessage("Do you want to continue?");
                al.setCancelable(false);

                al.setIcon(R.drawable.ic_launcher_background);

                al.setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(),
                                        "You clicked on YES :   ", Toast.LENGTH_SHORT).show();


                            }
                        });
                al.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();

                            }
                        });

                al.show();

            }

        }


        if(v.getId()==b4.getId())
        {
            et1.setText(" ");
            et2.setText(" ");
            if(cb.isChecked()){
                cb.setSelected(false); }
        }

        if(v.getId()==b5.getId())
        {
            Intent i = new Intent
                    (MainActivity.this,
                            Main3Activity.class);
            i.putExtra("phones",et1.getText().toString());
            startActivityForResult(i,5);
        }

        if(v.getId()==b6.getId())
        {
            Intent i = new Intent
                    (MainActivity.this,
                            Main4Activity.class);
            startActivity(i);
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



            Log.d("MainActivity","Spinner1");
             tv = (TextView)view;
            Toast.makeText(this,
                    "First spinner: "+
                            tv.getText().toString(),
                    Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        Toast.makeText(this,
                "Nothing selected",
                Toast.LENGTH_SHORT).show();
        Log.d("MainActivity","Nothing selected");


    }
}
