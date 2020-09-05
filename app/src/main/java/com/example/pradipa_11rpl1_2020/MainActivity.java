package com.example.pradipa_11rpl1_2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.SharedPreferences;

public class MainActivity extends AppCompatActivity {

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    EditText etusername;
    EditText etpassword;
    Button btnlogin;
    Button btnregist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref = getSharedPreferences("login", MODE_PRIVATE);
        etusername = (EditText)findViewById(R.id.etusername);
        etpassword = (EditText)findViewById(R.id.etpassword);
        btnlogin = (Button)findViewById(R.id.btnlogin);
        btnregist = (Button)findViewById((R.id.btnregist));
        btnlogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (etusername.getText().toString().equalsIgnoreCase("admin") && etpassword.getText().toString().equals("login")){
                    //save sp
                    editor = pref.edit();
                    editor.putString("username", etusername.getText().toString());
                    editor.putString("status", "login");
                    editor.apply();

                    //msk main
                    startActivity(new Intent(getApplicationContext(), MainMenuActivity.class));

                    finish();
                }
            }
        });
        btnregist.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });
    }
}