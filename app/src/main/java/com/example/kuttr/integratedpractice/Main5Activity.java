package com.example.kuttr.integratedpractice;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import java.io.IOException;

public class Main5Activity extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        iv=findViewById(R.id.iv1);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId()==b1.getId())
        {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction
                    (Intent.ACTION_GET_CONTENT);
            startActivityForResult
                    (intent,3);

        }
        if(v.getId()==b2.getId())
        {
            Intent i = new Intent(this,Main6Activity.class);
            startActivity(i);}
    }
    @Override
    protected void onActivityResult
            (int requestCode,
             int resultCode, Intent data) {
        super.onActivityResult
                (requestCode, resultCode, data);
        if (requestCode == 3
                && resultCode == RESULT_OK
                && data != null
                && data.getData() != null)
        {
            try {
                Bitmap bitmap = MediaStore.
                        Images.Media.
                        getBitmap(getContentResolver(),
                                data.getData());
                ImageView imageView =  findViewById(R.id.iv);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
