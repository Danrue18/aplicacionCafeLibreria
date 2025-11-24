package com.example.aplicacioncafelibreria;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class RedesActivity extends AppCompatActivity {

    ImageButton btnInstagram, btnFacebook, btnX, btnTiktok;
    Button btnAbrirInstagram, btnAbrirFacebook, btnAbrirX, btnAbrirTiktok, btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redes);

        btnInstagram = findViewById(R.id.btnInstagram);
        btnFacebook = findViewById(R.id.btnFacebook);
        btnX = findViewById(R.id.btnX);
        btnTiktok = findViewById(R.id.btnTiktok);

        btnAbrirInstagram = findViewById(R.id.btnAbrirInstagram);
        btnAbrirFacebook = findViewById(R.id.btnAbrirFacebook);
        btnAbrirX = findViewById(R.id.btnAbrirX);
        btnAbrirTiktok = findViewById(R.id.btnAbrirTiktok);
        btnVolver = findViewById(R.id.btnVolver);

        // ==== AQUI ESTABA TU ERROR (referencia al método abrirUrl) ====

        btnInstagram.setOnClickListener(v -> abrirUrl("https://www.instagram.com"));
        btnFacebook.setOnClickListener(v -> abrirUrl("https://www.facebook.com"));
        btnX.setOnClickListener(v -> abrirUrl("https://www.twitter.com"));
        btnTiktok.setOnClickListener(v -> abrirUrl("https://www.tiktok.com"));

        btnAbrirInstagram.setOnClickListener(v -> abrirUrl("https://www.instagram.com"));
        btnAbrirFacebook.setOnClickListener(v -> abrirUrl("https://www.facebook.com"));
        btnAbrirX.setOnClickListener(v -> abrirUrl("https://www.twitter.com"));
        btnAbrirTiktok.setOnClickListener(v -> abrirUrl("https://www.tiktok.com"));

        btnVolver.setOnClickListener(v ->
                startActivity(new Intent(this, MenuActivity.class)));
    }

    // ==== ESTE MÉTODO ES OBLIGATORIO ====
    private void abrirUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
