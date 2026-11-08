package com.example.citafacil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class NegocioHoraYFecha extends AppCompatActivity {

    private Button btnContinuar;
    private ImageButton btnAtras;
    private CalendarView calendario;
    private TimePicker timePicker;

    // Variables opcionales para guardar la fecha y hora seleccionadas
    private int anoSeleccionado, mesSeleccionado, diaSeleccionado;
    private int horaSeleccionada, minutoSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_negocio_horayfecha);

        // 1. Vincular los componentes del XML con los IDs correctos
        btnContinuar = findViewById(R.id.P5_BotonContinuar);
        btnAtras = findViewById(R.id.P5_BotonAtras);
        calendario = findViewById(R.id.P5_Calendario);
        timePicker = findViewById(R.id.P5_Hora);

        // Inicializar con la fecha actual
        Calendar calendar = Calendar.getInstance();
        anoSeleccionado = calendar.get(Calendar.YEAR);
        mesSeleccionado = calendar.get(Calendar.MONTH);
        diaSeleccionado = calendar.get(Calendar.DAY_OF_MONTH);

        // 2. Listener para capturar la fecha seleccionada en el CalendarView
        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                anoSeleccionado = year;
                mesSeleccionado = month;
                diaSeleccionado = dayOfMonth;
            }
        });

        // 3. Lógica del botón Continuar -> Navega a la pantalla de confirmar cita (P6)
        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener la hora y minuto del TimePicker (compatible con API moderna y antigua)
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    horaSeleccionada = timePicker.getHour();
                    minutoSeleccionado = timePicker.getMinute();
                } else {
                    horaSeleccionada = timePicker.getCurrentHour();
                    minutoSeleccionado = timePicker.getCurrentMinute();
                }

                // Opcional: Puedes pasar los datos seleccionados mediante un Intent a la siguiente pantalla
                Intent intent = new Intent(NegocioHorayFecha.this, ConfirmarCita.class);
                intent.putExtra("AÑO", anoSeleccionado);
                intent.putExtra("MES", mesSeleccionado);
                intent.putExtra("DIA", diaSeleccionado);
                intent.putExtra("HORA", horaSeleccionada);
                intent.putExtra("MINUTO", minutoSeleccionado);

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