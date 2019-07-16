package com.example.kuttr.integratedpractice;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Main3Activity extends AppCompatActivity implements View.OnClickListener{
    EditText et,ett;
    Button bb1,bb2,bb3,bb4;
    String n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Bundle b = getIntent().getExtras();
         n = b.getString("phones");

        bb1 = (Button) findViewById(R.id.bb1);
        bb2 = (Button) findViewById(R.id.bb2);
        bb3 = (Button) findViewById(R.id.bb3);
        bb4 = (Button) findViewById(R.id.bb4);

        et = (EditText) findViewById(R.id.et);
        ett = (EditText) findViewById(R.id.ett);

        bb1.setOnClickListener(this);
        bb2.setOnClickListener(this);
        bb3.setOnClickListener(this);
        bb4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == bb1.getId()) {
            //Dialer
            Intent i = new Intent(
                    Intent.ACTION_DIAL,
                    Uri.parse("tel:" + n));
            startActivity(i);
        }

        if (v.getId() == bb2.getId()) {

            //another way to pass
            // the phone number
            Intent i = new Intent
                    (Intent.ACTION_CALL);
            i.setData
                    (Uri.parse("tel:" + n));
            // The below if condition will be auto
            // suggessted if not given.
            if (ActivityCompat.checkSelfPermission
                    (this, Manifest.permission.CALL_PHONE)
                    != PackageManager.PERMISSION_GRANTED)
            {// add the following line for runtime permission request
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        123);
                return;
            }

            startActivity(i);

        }

        if (v.getId() == bb3.getId())
        {
            String msg = ett.getText().toString();
            //Getting intent and PendingIntent instance
            // Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            // PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, intent,0);
//Get the SmsManager instance and call the sendTextMessage method to send message
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(n, null, msg, null, null);
            Toast.makeText(getApplicationContext(), "Message Sent successfully!",
                    Toast.LENGTH_LONG).show();

        }

        if (v.getId() == bb4.getId())
        {
            String url;
            url = et.getText().toString();
            Intent i;
            if (v.getId() == bb4.getId()) {
                if(url.startsWith("http://"))
                    i = new Intent
                            (Intent.ACTION_VIEW,Uri.parse(url));
                else
                    i = new Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("http://"+url));
                startActivity(i);
            }

        }
    }
}
