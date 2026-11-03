
package com.example.citafacil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CrearCuenta extends AppCompatActivity {

    // Componentes de la interfaz
    private ImageButton P2_BotonAtras;
    private EditText P2_TextoNombre;
    private EditText P2_TextoCorreo;
    private EditText P2_TextoContrasena;
    private EditText P2_TextoContrasena2;
    private CheckBox P2_check;
    private Button P2_BotonCrearCuenta;
    private TextView P2_TextoIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.pantalla_crear_cuenta);

        // Referencias a los elementos XML
        P2_BotonAtras = findViewById(R.id.P2_BotonAtras);
        P2_TextoNombre = findViewById(R.id.P2_TextoNombre);
        P2_TextoCorreo = findViewById(R.id.P2_TextoCorreo);
        P2_TextoContrasena = findViewById(R.id.P2_TextoContrasena);
        P2_TextoContrasena2 = findViewById(R.id.P2_TextoContrasena2);
        P2_check = findViewById(R.id.P2_check);
        P2_BotonCrearCuenta = findViewById(R.id.P2_BotonCrearCuenta);
        P2_TextoIniciar = findViewById(R.id.P2_TextoIniciar);

        // Volver a la pantalla principal
        P2_BotonAtras.setOnClickListener(v -> {
            Intent intent = new Intent(CrearCuenta.this, MainActivity.class);
            startActivity(intent);
        });

        // Crear cuenta
        P2_BotonCrearCuenta.setOnClickListener(v -> {
            Intent intent = new Intent(CrearCuenta.this, PantallaPrincipal.class);
            startActivity(intent);
        });

        // Ir a iniciar sesión
        P2_TextoIniciar.setOnClickListener(v -> {
            Intent intent = new Intent(CrearCuenta.this, InicioSesion.class);
            startActivity(intent);
        });
    }
}
