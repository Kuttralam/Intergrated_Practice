package com.example.kuttr.integratedpractice;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class Main4Activity extends AppCompatActivity implements View.OnClickListener {

        Button b1,b2;
        ImageView iv1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main4);
            b1=findViewById(R.id.b1);
            b2=findViewById(R.id.b2);
            iv1=findViewById(R.id.iv1);

            b1.setOnClickListener(this);
            b2.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)
        {
            if(v.getId()==b1.getId())
            {
                Intent cameraIntent = new Intent
                        (android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent,44);
            }

            if(v.getId()==b2.getId())
            {
                Intent i = new Intent(this,Main5Activity.class);
                startActivity(i);}
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 44)
            {
                Bitmap photo = (Bitmap)
                        data.getExtras().get("data");
                iv1.setImageBitmap(photo);
            }
        }
}


