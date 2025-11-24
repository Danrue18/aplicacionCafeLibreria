package com.example.aplicacioncafelibreria;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CrearCuentaActivity extends AppCompatActivity {

    EditText etNuevoUsuario, etNuevaContrasena;
    Button btnRegistrar, btnVolverLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);

        // ENLAZAR XML
        etNuevoUsuario = findViewById(R.id.etNuevoUsuario);
        etNuevaContrasena = findViewById(R.id.etNuevaContrasena);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnVolverLogin = findViewById(R.id.btnVolverLogin);

        // ACCIÓN DEL BOTÓN REGISTRAR
        btnRegistrar.setOnClickListener(v -> {

            String nuevoUsuario = etNuevoUsuario.getText().toString().trim();
            String nuevaContrasena = etNuevaContrasena.getText().toString().trim();

            if (nuevoUsuario.isEmpty() || nuevaContrasena.isEmpty()) {
                Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
                return;
            }

            // GUARDAR DATOS
            SharedPreferences prefs = getSharedPreferences("usuarios", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("usuario", nuevoUsuario);
            editor.putString("contrasena", nuevaContrasena);
            editor.apply();

            Toast.makeText(this, "Cuenta creada correctamente", Toast.LENGTH_SHORT).show();

            // VOLVER AL LOGIN
            Intent intent = new Intent(CrearCuentaActivity.this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });

        // ACCIÓN DEL BOTÓN VOLVER A LOGIN
        btnVolverLogin.setOnClickListener(v -> {
            Intent intent = new Intent(CrearCuentaActivity.this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });
    }
}
