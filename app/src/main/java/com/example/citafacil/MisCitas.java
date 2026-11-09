
package com.example.citafacil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MisCitas extends AppCompatActivity {

    // Componentes de la interfaz
    private Button P8_BotonDetalles1;
    private Button P8_BotonDetalles2;
    private Button P8_BotonCancelar1;
    private Button P8_BotonCancelar2;
    private Button P8_BotonInicio;
    private ImageButton P8_BotonVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.pantalla_miscitas);

        // Referencias a los elementos XML
        P8_BotonDetalles1 = findViewById(R.id.P8_BotonDetalles1);
        P8_BotonDetalles2 = findViewById(R.id.P8_BotonDetalles2);
        P8_BotonCancelar1 = findViewById(R.id.P8_BotonCancelar1);
        P8_BotonCancelar2 = findViewById(R.id.P8_BotonCancelar2);
        P8_BotonInicio = findViewById(R.id.P8_BotonInicio);
        P8_BotonVolver = findViewById(R.id.P8_BotonVolver);

        // Ver detalles de la cita 1
        P8_BotonDetalles1.setOnClickListener(v -> abrirDetalleCita());

        // Ver detalles de la cita 2
        P8_BotonDetalles2.setOnClickListener(v -> abrirDetalleCita());

        // Cancelar cita 1
        P8_BotonCancelar1.setOnClickListener(v -> abrirCancelarCita());

        // Cancelar cita 2
        P8_BotonCancelar2.setOnClickListener(v -> abrirCancelarCita());

        // Volver a inicio
        P8_BotonInicio.setOnClickListener(v -> volverPrincipal());

        // Botón volver
        P8_BotonVolver.setOnClickListener(v -> volverPrincipal());
    }

    private void abrirDetalleCita() {
        Intent intent = new Intent(MisCitas.this, DetalleCita.class);
        startActivity(intent);
    }

    private void abrirCancelarCita() {
        Intent intent = new Intent(MisCitas.this, CancelarCita.class);
        startActivity(intent);
    }

    private void volverPrincipal() {
        Intent intent = new Intent(MisCitas.this, PantallaPrincipal.class);
        startActivity(intent);
        finish();
    }
}
