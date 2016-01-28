package com.example.harshitrathod.konnect;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        SharedPreferences sharedpreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
      if(sharedpreferences.contains("name"))
        {
            Intent i=new Intent(this,QrHome.class);
            startActivity(i);
        }
        else
        {
            Intent i=new Intent(this,AddUser.class);
            startActivity(i);
        }
    }
}
