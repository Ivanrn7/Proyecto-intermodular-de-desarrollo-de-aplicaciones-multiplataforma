
package com.example.citafacil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class InicioSesion extends AppCompatActivity {

    // Componentes de la interfaz
    private EditText P1_TextoCorreo;
    private EditText P1_Contrasena;
    private ImageButton P1_Atras;
    private Button P1_BotonIniciar;
    private TextView P1_TextoRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.pantalla_inicio_sesion);

        // Referencias a los elementos XML
        P1_TextoCorreo = findViewById(R.id.P1_TextoCorreo);
        P1_Contrasena = findViewById(R.id.P1_TextoContrasena);
        P1_Atras = findViewById(R.id.P1_BotonAtras);
        P1_BotonIniciar = findViewById(R.id.P1_BotonIniciar);
        P1_TextoRegistrar = findViewById(R.id.P1_TextoRegistrar);

        // Volver a la pantalla anterior
        P1_Atras.setOnClickListener(v -> {
            Intent intent = new Intent(InicioSesion.this, MainActivity.class);
            startActivity(intent);
        });

        // Iniciar sesión
        P1_BotonIniciar.setOnClickListener(v -> {
            Intent intent = new Intent(InicioSesion.this, PantallaPrincipal.class);
            startActivity(intent);
        });

        // Ir a crear cuenta
        P1_TextoRegistrar.setOnClickListener(v -> {
            Intent intent = new Intent(InicioSesion.this, CrearCuenta.class);
            startActivity(intent);
        });
    }
}
