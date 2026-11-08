package com.example.citafacil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.EditText;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class PantallaPrincipal extends AppCompatActivity {

    private EditText P3_TextoBuscar;
    private ImageButton P3_Notificacion;
    private ImageButton P3_BotonBuscar;
    private ImageView P3_BotonPeluqueria;
    private ImageView P3_BotonSalud;
    private ImageView P3_BotonEstetica;
    private ImageView P3_BotonDeporte;
    private ImageView P3_BotonOtros;
    private ImageView P3_BotonRestauracion;
    private ImageView P3_BotonMascotas;
    private ImageView P3_BotonMas;
    private ImageButton P3_BotonHome;
    private ImageButton P3_BotonCalendario;
    private ImageButton P3_BotonFavoritos;
    private ImageButton P3_BotonUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.pantalla_principal);

        // Buscador
        P3_TextoBuscar = findViewById(R.id.P3_TextoBuscar);
        P3_BotonBuscar = findViewById(R.id.P3_BotonBuscar);

        // Notificaciones
        P3_Notificacion = findViewById(R.id.P3_Notificacion);

        // Categorías
        P3_BotonPeluqueria = findViewById(R.id.P3_BotonPeluqueria);
        P3_BotonSalud = findViewById(R.id.P3_BotonSalud);
        P3_BotonEstetica = findViewById(R.id.P3_BotonEstetica);
        P3_BotonDeporte = findViewById(R.id.P3_BotonDeporte);
        P3_BotonOtros = findViewById(R.id.P3_BotonOtros);
        P3_BotonRestauracion = findViewById(R.id.P3_BotonRestauracion);
        P3_BotonMascotas = findViewById(R.id.P3_BotonMascotas);
        P3_BotonMas = findViewById(R.id.P3_BotonMas);
        P3_Notificacion = findViewById(R.id.P3_Notificacion);
        P3_BotonCalendario = findViewById(R.id.P3_BotonCalendario);
        P3_BotonFavoritos = findViewById(R.id.P3_BotonFavoritos);
        P3_BotonUsuario = findViewById(R.id.P3_BotonUsuario);


        // Barra inferior
        P3_BotonHome = findViewById(R.id.P3_BotonHome);
        P3_BotonCalendario = findViewById(R.id.P3_BotonCalendario);
        P3_BotonFavoritos = findViewById(R.id.P3_BotonFavoritos);
        P3_BotonUsuario = findViewById(R.id.P3_BotonUsuario);

       /* // Todas las categorías abren la misma pantalla
        P3_BotonPeluqueria.setOnClickListener(v ->
                abrirNegocios("Peluquería"));

        P3_BotonSalud.setOnClickListener(v ->
                abrirNegocios("Salud"));

        P3_BotonEstetica.setOnClickListener(v ->
                abrirNegocios("Estética"));

        P3_BotonDeporte.setOnClickListener(v ->
                abrirNegocios("Deporte"));

        P3_BotonOtros.setOnClickListener(v ->
                abrirNegocios("Otros"));

        P3_BotonRestauracion.setOnClickListener(v ->
                abrirNegocios("Restauración"));

        P3_BotonMascotas.setOnClickListener(v ->
                abrirNegocios("Mascotas"));

        P3_BotonMas.setOnClickListener(v ->
                abrirNegocios("Más"));
*/
        // Botón de inicio: ya estamos en la pantalla principal
        P3_BotonHome.setOnClickListener(v -> {
            // No hace falta navegar.
        });
/*
        // Buscador: pendiente de conectar con los negocios
        P3_BotonBuscar.setOnClickListener(v -> {
            String busqueda = P3_TextoBuscar.getText().toString().trim();

            if (!busqueda.isEmpty()) {
                abrirNegocios(busqueda);
            } else {
                P3_TextoBuscar.setError("Escribe qué estás buscando");
            }
        });
    }*/
/*
    private void abrirNegocios(String categoria) {
        Intent intent = new Intent(
                PantallaPrincipal.this, NegocioServicios.class
        );

        intent.putExtra("categoria", categoria);
        startActivity(intent);
    }*/
    }
}
