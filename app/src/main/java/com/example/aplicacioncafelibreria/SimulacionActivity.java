package com.example.aplicacioncafelibreria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SimulacionActivity extends AppCompatActivity {

    Spinner spCafes, spLibros, spTortas;
    CheckBox chkCombo;
    Button btnCalcular, btnVolverMenu, btnPagar;
    TextView tvResultado, tvAhorro;
    RadioGroup grupoPago;

    double totalFinal = 0;

    // Precios
    double[] preciosCafe = {6000, 12500, 16000, 15000, 11300, 0};
    double[] preciosLibro = {200000, 380000, 500000 , 180000, 200000, 0};
    double[] preciosTorta = {15700, 18000, 16000, 17200, 9900, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulacion);

        spCafes = findViewById(R.id.spCafes);
        spLibros = findViewById(R.id.spLibros);
        spTortas = findViewById(R.id.spTortas);
        chkCombo = findViewById(R.id.chkCombo);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnVolverMenu = findViewById(R.id.btnVolverMenu);
        tvResultado = findViewById(R.id.tvResultado);
        tvAhorro = findViewById(R.id.tvAhorro);
        grupoPago = findViewById(R.id.grupoPago);
        btnPagar = findViewById(R.id.btnPagar);

        // Datos para los spinners
        String[] cafes = {"Café 1 - $6000", "Café 2 - $12500", "Café 3 - $16000", "Café 4 - $15000", "Café 5 - $11300", "Ninguno"};
        String[] libros = {"Libro 1 - $200000", "Libro 2 - $380000", "Libro 3 - $500000", "Libro 4 - $180000", "Libro 5 - $200000", "Ninguno"};
        String[] tortas = {"Torta 1 - $15700", "Torta 2 - $18000", "Torta 3 - $17200", "Torta 4 - $9900", "Torta 5 - $10300", "Ninguno"};

        spCafes.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, cafes));
        spLibros.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, libros));
        spTortas.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, tortas));

        // VALIDADOR AUTOMÁTICO PARA EL COMBO
        agregarValidadorCombo();

        btnCalcular.setOnClickListener(v -> calcularTotal());
        btnPagar.setOnClickListener(v -> procesarPago());

        btnVolverMenu.setOnClickListener(v ->
                startActivity(new Intent(this, MenuActivity.class))
        );
    }

    private void agregarValidadorCombo() {

        // Listener para que revise cada vez que cambien algo
        androidx.appcompat.widget.AppCompatSpinner.OnItemSelectedListener listener =
                new androidx.appcompat.widget.AppCompatSpinner.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(android.widget.AdapterView<?> parent, android.view.View view, int position, long id) {
                        validarCombo();
                    }

                    @Override
                    public void onNothingSelected(android.widget.AdapterView<?> parent) {}
                };

        spCafes.setOnItemSelectedListener(listener);
        spLibros.setOnItemSelectedListener(listener);
        spTortas.setOnItemSelectedListener(listener);

        // Listener para cuando intenten marcar el combo
        chkCombo.setOnClickListener(v -> {
            if (!validarCombo()) {
                chkCombo.setChecked(false);
                Toast.makeText(this, "Debes seleccionar café, libro y torta para aplicar combo", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validarCombo() {
        int cafe = spCafes.getSelectedItemPosition();
        int libro = spLibros.getSelectedItemPosition();
        int torta = spTortas.getSelectedItemPosition();

        boolean valido =
                cafe != preciosCafe.length - 1 &&
                        libro != preciosLibro.length - 1 &&
                        torta != preciosTorta.length - 1;

        chkCombo.setEnabled(valido);

        if (!valido) chkCombo.setChecked(false);

        return valido;
    }

    private void calcularTotal() {
        double cafe = preciosCafe[spCafes.getSelectedItemPosition()];
        double libro = preciosLibro[spLibros.getSelectedItemPosition()];
        double torta = preciosTorta[spTortas.getSelectedItemPosition()];

        double total = cafe + libro + torta;
        double ahorro = 0;

        if (chkCombo.isChecked()) {
            ahorro = (cafe + libro) * 0.15;
            total -= ahorro;
        }

        totalFinal = total;

        tvResultado.setText("Total: $" + (int) total);
        tvAhorro.setText(chkCombo.isChecked() ? "Ahorro con combo: $" + (int) ahorro : "");
    }

    private void procesarPago() {

        if (totalFinal == 0) {
            Toast.makeText(this, "Primero calcula el total", Toast.LENGTH_SHORT).show();
            return;
        }

        int id = grupoPago.getCheckedRadioButtonId();

        if (id == -1) {
            Toast.makeText(this, "Selecciona un método de pago", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton seleccionado = findViewById(id);
        String metodo = seleccionado.getText().toString();

        // Nuevo comportamiento para Domicilio
        if (metodo.equals("Domicilio")) {
            Toast.makeText(this,
                    "Pedido a domicilio en proceso...\nTotal: $" + (int) totalFinal,
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this,
                    "Pago realizado con " + metodo + "\nTotal: $" + (int) totalFinal,
                    Toast.LENGTH_LONG).show();
        }
    }
}

