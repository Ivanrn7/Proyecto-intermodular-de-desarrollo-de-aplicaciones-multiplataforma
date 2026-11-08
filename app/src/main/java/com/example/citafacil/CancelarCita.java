package com.example.citafacil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CancelarCita extends AppCompatActivity {

    private Button btnCancelar, btnVolver;
    private ImageButton btnAtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_cancelarcita);

        // 1. Vincular los componentes del XML con los IDs correctos
        btnCancelar = findViewById(R.id.P10_BotonCancelar);
        btnVolver = findViewById(R.id.P10_BotonVolver);
        btnAtras = findViewById(R.id.P10_BotonAtras);

        // 2. Lógica del botón de confirmar cancelación
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Añadir la lógica para eliminar o cancelar la cita en tu base de datos / backend

                Toast.makeText(CancelarCita.this, "Cita cancelada con éxito", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(CancelarCita.this, PantallaPrincipal.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        // 3. Lógica del botón volver
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cierra la pantalla actual y regresa a la anterior
                finish();
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
