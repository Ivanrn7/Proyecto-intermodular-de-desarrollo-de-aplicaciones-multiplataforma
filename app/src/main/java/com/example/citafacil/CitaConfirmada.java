package com.example.citafacil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class CitaConfirmada extends AppCompatActivity {

    private Button btnVolverInicio, btnVolverCitas;
    private ImageButton btnAtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_citaconfirmada);

        // 1. Vincular los componentes del XML con los IDs correctos
        btnVolverInicio = findViewById(R.id.P7_BotonInicio);
        btnVolverCitas = findViewById(R.id.P7_BotonCitas);
        btnAtras = findViewById(R.id.P7_BotonAtras);

        // 2. Lógica del botón "Volver a inicio" -> Navega a la pantalla principal
        btnVolverInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CitaConfirmada.this, PantallaPrincipal.class);
                // Limpia el historial para que la pantalla principal sea la raiz actual
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        // 3. Lógica del botón "Volver a citas" -> Navega a la pantalla de Mis Citas (P8)
        btnVolverCitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Reemplaza 'PantallaMisCitas' si tu clase Java tiene un nombre diferente
                Intent intent = new Intent(CitaConfirmada.this, MisCitas.class);
                startActivity(intent);
            }
        });

        // 4. Lógica del botón de flecha atrás superior
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
