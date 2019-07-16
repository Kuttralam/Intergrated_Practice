package com.example.kuttr.integratedpractice;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Main6Activity extends AppCompatActivity implements View.OnClickListener {
        Button b1, b2, b3;
        TextView tv;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main6);

            b1 = findViewById(R.id.b1);
            b2 = findViewById(R.id.b2);
            b3 = findViewById(R.id.b3);
            tv = findViewById(R.id.tv);

            b1.setOnClickListener(this);
            b2.setOnClickListener(this);
            b3.setOnClickListener(this);

            final BluetoothAdapter mBluetoothAdapter =
                    BluetoothAdapter.getDefaultAdapter();
            if (mBluetoothAdapter == null) {
                tv.append("device not supported");
            }

        }

        @Override
        public void onClick(View v) {
            final BluetoothAdapter mBluetoothAdapter =
                    BluetoothAdapter.getDefaultAdapter();
            if (v.getId() == b1.getId()) {
                if (mBluetoothAdapter == null) {
                    tv.append(":Cannot turn on");
                    return;
                }

                if (!mBluetoothAdapter.isEnabled()) {
                    Intent enableBtIntent =
                            new Intent
                                    (BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivity(enableBtIntent);

                }
            }
            if (v.getId() == b2.getId()) {

                if (mBluetoothAdapter == null) {
                    tv.append("Cannot make " +
                            "the device discoverable");
                    return;
                }

                if (!mBluetoothAdapter.isDiscovering()) {

                    if (mBluetoothAdapter == null) {
                        tv.append("device not supported");
                        return;
                    }
                    Toast.makeText(getApplicationContext(), "MAKING YOUR DEVICE DISCOVERABLE",
                            Toast.LENGTH_LONG);
                    Intent enableBtIntent =
                            new Intent
                                    (BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                    startActivity(enableBtIntent);
                }

            }

            if (v.getId() == b3.getId()) {
                if (mBluetoothAdapter == null)
                {
                    tv.append("Cannot turn off");
                    return;
                }
                mBluetoothAdapter.disable();
                Toast.makeText(getApplicationContext(), "TURNING_OFF BLUETOOTH", Toast.LENGTH_LONG);
            }

        }
    }


