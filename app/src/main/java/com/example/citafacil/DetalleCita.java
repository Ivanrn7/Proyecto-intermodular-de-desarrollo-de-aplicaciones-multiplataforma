package com.example.citafacil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class DetalleCita extends AppCompatActivity {

    private Button btnReprogramar, btnCancelar;
    private ImageButton btnAtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_detallecita);

        // 1. Vincular los componentes del XML con los IDs correctos
        btnReprogramar = findViewById(R.id.P9_BotonReprogramar);
        btnCancelar = findViewById(R.id.P9_BotonCancelar);
        btnAtras = findViewById(R.id.P9_BotonAtras);

        // 2. Lógica del botón Reprogramar - Navega a pantalla_negocio_horayfecha
        btnReprogramar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalleCita.this, NegocioHorayFecha.class);
                startActivity(intent);
            }
        });

        // 3. Lógica del botón Cancelar - Navega a la pantalla de cancelación
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalleCita.this, CancelarCita.class);
                startActivity(intent);
            }
        });

        // 4. Lógica del botón Atras superior
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}