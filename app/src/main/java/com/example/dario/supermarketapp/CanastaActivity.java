package com.example.dario.supermarketapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class CanastaActivity extends AppCompatActivity {

    Button btnCanastaAlta,btnCanastaBasica,btnCanastaMedia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canasta);
        btnCanastaBasica = (Button) findViewById(R.id.btnCanastaBasica);
        btnCanastaMedia = (Button) findViewById(R.id.btnCanastaMedia);
        btnCanastaAlta = (Button) findViewById(R.id.btnCanastaAlta);

        btnCanastaBasica.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SuperActivity.class));
            }
        });

        btnCanastaMedia.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SuperActivity.class));
            }
        });

        btnCanastaAlta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SuperActivity.class));
            }
        });

    }
}
