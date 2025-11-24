package com.example.aplicacioncafelibreria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PresentacionActivity extends AppCompatActivity {

    Button btnContinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentacion);

        btnContinuar = findViewById(R.id.btnContinuar);

        btnContinuar.setOnClickListener(v ->
                startActivity(new Intent(this, LoginActivity.class))
        );
    }
}

