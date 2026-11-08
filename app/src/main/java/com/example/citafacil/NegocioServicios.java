package com.example.citafacil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NegocioServicios extends AppCompatActivity {

    private TextView txtCortePelo, txtAfeitado;
    private Button btnVolverInferior;
    private ImageButton btnAtrasSuperior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_negocio_servicios);

        // 1. Vincular los componentes del XML con sus IDs exactos
        txtCortePelo = findViewById(R.id.p4_BotonCorte);
        txtAfeitado = findViewById(R.id.p4_BotonAfeitado);
        btnVolverInferior = findViewById(R.id.p4_BotonVolver);
        btnAtrasSuperior = findViewById(R.id.P4_BotonAtras);

        // 2. Clic en "Corte de pelo" - Lleva a PantallaNegocioHorayFecha
        txtCortePelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NegocioServicios.this, NegocioHoraYFecha.class);
                intent.putExtra("SERVICIO_SELECCIONADO", "Corte de pelo");
                startActivity(intent);
            }
        });

        // 3. Clic en "Afeitado" - Lleva a PantallaNegocioHorayFecha
        txtAfeitado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NegocioServicios.this, NegocioHoraYFecha.class);
                intent.putExtra("SERVICIO_SELECCIONADO", "Afeitado");
                startActivity(intent);
            }
        });

        // 4. Botón inferior "volver" - Lleva a la pantalla principal
        btnVolverInferior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irAPantallaPrincipal();
            }
        });

        // 5. Botón de flecha atrás superior - Lleva a la pantalla principal
        btnAtrasSuperior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irAPantallaPrincipal();
            }
        });
    }

    // Método auxiliar para navegar a la PantallaPrincipal de forma limpia
    private void irAPantallaPrincipal() {
        Intent intent = new Intent(NegocioServicios.this, PantallaPrincipal.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}