package com.example.aplicacioncafelibreria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
public class ContactoActivity extends AppCompatActivity {

    Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        btnVolver = findViewById(R.id.btnVolver);

        btnVolver.setOnClickListener(v ->
                startActivity(new Intent(this, MenuActivity.class))
        );
    }
}
