package com.example.citafacil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmarCita extends AppCompatActivity {

    private Button btnVolver, btnConfirmar;
    private ImageButton btnAtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_confirmarcita);

        // 1. Vincular los componentes del XML con los IDs correctos
        btnVolver = findViewById(R.id.P6_BotonVolver);
        btnConfirmar = findViewById(R.id.P6_BotonConfirmar);
        btnAtras = findViewById(R.id.P6_BotonAtras);

        // 2. Lógica del botón "Volver a buscar" -> Navega a la pantalla de fecha y hora (P5)
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Vuelve a la pantalla de horario y fecha
                Intent intent = new Intent(ConfirmarCita.this, NegocioHorayFecha.class);
                // Opcional: limpiar la pila para que vuelva ordenadamente
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        // 3. Lógica del botón "Confirmar cita" -> Navega a la pantalla de cita confirmada (P7)
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Aquí puedes guardar la cita en la base de datos si lo requieres antes de avanzar

                Intent intent = new Intent(ConfirmarCita.this, CitaConfirmada.class);
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
