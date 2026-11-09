
package com.example.citafacil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class PantallaPrincipal extends AppCompatActivity {

    private EditText P3_TextoBuscar;

    private ImageButton P3_Notificacion;
    private ImageButton P3_BotonBuscar;

    // Categorías
    private ImageButton P3_BotonPeluqueria;
    private ImageButton P3_BotonSalud;
    private ImageButton P3_BotonEstetica;
    private ImageButton P3_BotonDeporte;
    private ImageButton P3_BotonOtros;
    private ImageButton P3_BotonRestauracion;
    private ImageButton P3_BotonMascotas;
    private ImageButton P3_BotonMas;

    // Barra inferior
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

        // Barra inferior
        P3_BotonHome = findViewById(R.id.P3_BotonHome);
        P3_BotonCalendario = findViewById(R.id.P3_BotonCalendario);
        P3_BotonFavoritos = findViewById(R.id.P3_BotonFavoritos);
        P3_BotonUsuario = findViewById(R.id.P3_BotonUsuario);

        // Categorías: todas abren la misma pantalla
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

        // Buscador
        P3_BotonBuscar.setOnClickListener(v -> {
            String busqueda = P3_TextoBuscar.getText().toString().trim();

            if (!busqueda.isEmpty()) {
                abrirNegocios(busqueda);
            } else {
                P3_TextoBuscar.setError("Escribe qué estás buscando");
                P3_TextoBuscar.requestFocus();
            }
        });

        // Inicio: ya estamos en la pantalla principal
        P3_BotonHome.setOnClickListener(v -> {
            // No necesita navegar.
        });
    }

    // Método para abrir la pantalla de negocios
    private void abrirNegocios(String categoria) {

        Intent intent = new Intent(
                PantallaPrincipal.this,
                NegocioServicios.class
        );

        intent.putExtra("categoria", categoria);
        startActivity(intent);
    }
}