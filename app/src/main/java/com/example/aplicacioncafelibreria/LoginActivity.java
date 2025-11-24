package com.example.aplicacioncafelibreria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;
public class LoginActivity extends AppCompatActivity {

    EditText etUsuario, etContrasena;
    Button btnLogin, btnCrearCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Referencias del XML
        etUsuario = findViewById(R.id.etUsuario);
        etContrasena = findViewById(R.id.etContrasena);
        btnLogin = findViewById(R.id.btnLogin);
        btnCrearCuenta = findViewById(R.id.btnCrearCuenta);

        // BOTÓN LOGIN
        btnLogin.setOnClickListener(v -> {

            String usuario = etUsuario.getText().toString().trim();
            String contrasena = etContrasena.getText().toString().trim();

            // SharedPreferences correctamente inicializado
            SharedPreferences prefs = getSharedPreferences("usuarios", MODE_PRIVATE);

            String userGuardado = prefs.getString("usuario", "");
            String passGuardada = prefs.getString("contrasena", "");

            // Validación
            if ((usuario.equals("admin") && contrasena.equals("1234")) ||
                    (usuario.equals(userGuardado) && contrasena.equals(passGuardada))) {

                Toast.makeText(this, "Bienvenido " + usuario, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MenuActivity.class));
                finish();

            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        });

        // BOTÓN CREAR CUENTA
        btnCrearCuenta.setOnClickListener(v ->
                startActivity(new Intent(this, CrearCuentaActivity.class))
        );
    }
}