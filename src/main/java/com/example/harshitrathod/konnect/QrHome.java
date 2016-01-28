package com.example.harshitrathod.konnect;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;

public class QrHome extends AppCompatActivity {

    Button scan,editInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        scan=(Button) findViewById(R.id.button3);
        editInfo=(Button)findViewById(R.id.button4);


        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Scan.class);
                startActivity(i);
            }
        });


        editInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),AddUser.class);
                startActivity(i);
            }
        });





        SharedPreferences sharedpreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String data="{";
        data=data+"name:\""+sharedpreferences.getString("name","Bot")+"\",";
        data=data+"email:\""+sharedpreferences.getString("email","Bot")+"\",";
        data=data+"mobile:\""+sharedpreferences.getString("mobile","Bot")+"\",";
        data=data+"website:\""+sharedpreferences.getString("website","Bot")+"\",";
        data=data+"designation:\""+sharedpreferences.getString("designation","Bot")+"\",";
        data=data+"organization:\""+sharedpreferences.getString("organization","Bot")+"\",";
        data=data+"bio:\""+sharedpreferences.getString("bio","Bot")+"\"";
        data=data+"}";

        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int width = point.x;
        int height = point.y;
        int smallerDimension = width < height ? width : height;
        smallerDimension = smallerDimension * 3/4;
        //Encode with a QR Code image
        QRCodeEncoder qrCodeEncoder = new QRCodeEncoder(data,
                null,
                Contents.Type.TEXT,
                BarcodeFormat.QR_CODE.toString(),
                smallerDimension);
        try {
            Bitmap bitmap = qrCodeEncoder.encodeAsBitmap();
            ImageView myImage = (ImageView) findViewById(R.id.imageView);
            myImage.setImageBitmap(bitmap);

        } catch (WriterException e) {
            e.printStackTrace();
        }



    }
}
