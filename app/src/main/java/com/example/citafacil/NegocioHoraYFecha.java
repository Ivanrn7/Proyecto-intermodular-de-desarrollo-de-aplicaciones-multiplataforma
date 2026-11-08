
package com.example.citafacil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class NegocioHoraYFecha extends AppCompatActivity {

    private Button btnContinuar;
    private ImageButton btnAtras;
    private CalendarView calendario;
    private TimePicker timePicker;

    private int anoSeleccionado;
    private int mesSeleccionado;
    private int diaSeleccionado;

    private int horaSeleccionada;
    private int minutoSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_negocio_horayfecha);

        // Vincular componentes
        btnContinuar = findViewById(R.id.P5_BotonContinuar);
        btnAtras = findViewById(R.id.P5_BotonAtras);
        calendario = findViewById(R.id.P5_Calendario);
        timePicker = findViewById(R.id.P5_Hora);

        // Inicializar fecha actual
        Calendar calendar = Calendar.getInstance();

        anoSeleccionado = calendar.get(Calendar.YEAR);
        mesSeleccionado = calendar.get(Calendar.MONTH);
        diaSeleccionado = calendar.get(Calendar.DAY_OF_MONTH);

        // Capturar fecha seleccionada
        calendario.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            anoSeleccionado = year;
            mesSeleccionado = month;
            diaSeleccionado = dayOfMonth;
        });

        // Continuar a confirmar cita
        btnContinuar.setOnClickListener(v -> {

            if (android.os.Build.VERSION.SDK_INT >=
                    android.os.Build.VERSION_CODES.M) {

                horaSeleccionada = timePicker.getHour();
                minutoSeleccionado = timePicker.getMinute();

            } else {
                horaSeleccionada = timePicker.getCurrentHour();
                minutoSeleccionado = timePicker.getCurrentMinute();
            }

            Intent intent = new Intent(
                    NegocioHoraYFecha.this,
                    ConfirmarCita.class
            );

            intent.putExtra("AÑO", anoSeleccionado);
            intent.putExtra("MES", mesSeleccionado);
            intent.putExtra("DIA", diaSeleccionado);
            intent.putExtra("HORA", horaSeleccionada);
            intent.putExtra("MINUTO", minutoSeleccionado);

            startActivity(intent);
        });

        // Volver atrás
        btnAtras.setOnClickListener(v -> finish());
    }
}