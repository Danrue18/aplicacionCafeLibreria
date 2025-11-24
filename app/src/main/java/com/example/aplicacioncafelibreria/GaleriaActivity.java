package com.example.aplicacioncafelibreria;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GaleriaActivity extends AppCompatActivity {

    Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria); // Asegúrate que tu XML se llame activity_galeria.xml 😊

        btnVolver = findViewById(R.id.btnVolver);

        btnVolver.setOnClickListener(v -> {
            Intent intent = new Intent(GaleriaActivity.this, MenuActivity.class);
            startActivity(intent);
            finish(); // Cierra esta pantalla para evitar que se acumule en el stack
        });
    }
}