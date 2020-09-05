package com.example.pradipa_11rpl1_2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainMenuActivity extends AppCompatActivity {

    CardView menu1;
    CardView menu2;
    Button testbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);
        menu1 = (CardView)findViewById(R.id.menu1);
        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ListData.class));
            }
        });
        menu2 = (CardView)findViewById(R.id.menu2);
        menu2.setOnClickListener((new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "test", Toast.LENGTH_LONG);
                toast.show();
            }
        }));
        testbutton = (Button)findViewById(R.id.testbutton);
        testbutton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ListData.class));
            }
        });
    }
}