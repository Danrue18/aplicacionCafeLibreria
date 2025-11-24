package com.example.aplicacioncafelibreria;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
public class TemaPrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema_principal);

        Button btnVolver = findViewById(R.id.btnVolver);

        btnVolver.setOnClickListener(v ->
                startActivity(new Intent(this, MenuActivity.class)));
    }
}