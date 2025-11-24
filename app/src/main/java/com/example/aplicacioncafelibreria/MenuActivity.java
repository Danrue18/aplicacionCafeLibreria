package com.example.aplicacioncafelibreria;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    Button btnTema, btnMisionVision, btnQuienes, btnGaleria,
            btnVideo, btnContacto, btnRedes, btnSimulacion, btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnTema = findViewById(R.id.btnTema);
        btnMisionVision = findViewById(R.id.btnMisionVision);
        btnQuienes = findViewById(R.id.btnQuienes);
        btnGaleria = findViewById(R.id.btnGaleria);
        btnVideo = findViewById(R.id.btnVideo);
        btnContacto = findViewById(R.id.btnContacto);
        btnRedes = findViewById(R.id.btnRedes);
        btnSimulacion = findViewById(R.id.btnSimulacion);
        btnSalir = findViewById(R.id.btnSalir);

        btnTema.setOnClickListener(v -> startActivity(new Intent(this, TemaPrincipalActivity.class)));
        btnMisionVision.setOnClickListener(v -> startActivity(new Intent(this, MisionVisionActivity.class)));
        btnQuienes.setOnClickListener(v -> startActivity(new Intent(this, QuienesSomosActivity.class)));
        btnGaleria.setOnClickListener(v -> startActivity(new Intent(this, GaleriaActivity.class)));
        btnVideo.setOnClickListener(v -> startActivity(new Intent(this, VideoActivity.class)));
        btnContacto.setOnClickListener(v -> startActivity(new Intent(this, ContactoActivity.class)));
        btnRedes.setOnClickListener(v -> startActivity(new Intent(this, RedesActivity.class)));

        // FALTABA ESTE
        btnSimulacion.setOnClickListener(v ->
                startActivity(new Intent(this, SimulacionActivity.class)));

        // CIERRE DE SESIÓN REAL
        btnSalir.setOnClickListener(v -> {
            Intent i = new Intent(this, PresentacionActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
            finish();
        });
    }
}
