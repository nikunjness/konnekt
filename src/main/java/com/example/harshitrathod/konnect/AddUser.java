package com.example.harshitrathod.konnect;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddUser extends AppCompatActivity {
    EditText name,email,mobile,website,designation,organization,bio;
    Button submit,clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user2);
        name=(EditText)findViewById(R.id.editText);
        email=(EditText)findViewById(R.id.editText2);
        mobile=(EditText)findViewById(R.id.editText3);
        website=(EditText)findViewById(R.id.editText4);
        designation=(EditText)findViewById(R.id.editText5);
        organization=(EditText)findViewById(R.id.editText6);
        bio=(EditText)findViewById(R.id.editText7);
        submit=(Button) findViewById(R.id.button);
        clear=(Button) findViewById(R.id.button2);

        SharedPreferences sharedpreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        name.setText(sharedpreferences.getString("name",""));
        email.setText(sharedpreferences.getString("email",""));
        mobile.setText(sharedpreferences.getString("mobile",""));
        website.setText(sharedpreferences.getString("website",""));
        designation.setText(sharedpreferences.getString("designation",""));
        organization.setText(sharedpreferences.getString("organization",""));
        bio.setText(sharedpreferences.getString("bio",""));

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                email.setText("");
                mobile.setText("");
                website.setText("");
                designation.setText("");
                organization.setText("");
                bio.setText("");

            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedpreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("name",name.getText().toString());
                editor.putString("email",email.getText().toString());
                editor.putString("mobile", mobile.getText().toString());
                editor.putString("website", website.getText().toString());
                editor.putString("designation", designation.getText().toString());
                editor.putString("organization", organization.getText().toString());
                editor.putString("bio", bio.getText().toString());
                 editor.commit();
                Intent i=new Intent(getApplicationContext(),Main.class);
                startActivity(i);
            }
        });

    }
}
