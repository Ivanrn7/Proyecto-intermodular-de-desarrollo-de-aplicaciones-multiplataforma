package com.example.citafacil;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

public class CrearCuenta extends AppCompatActivity {

    private ImageButton P2_BotonAtras;
    private EditText P2_TextoNombre;
    private EditText P2_TextoCorreo;
    private EditText P2_TextoContrasena;
    private EditText P2_TextoContrasena2;
    private CheckBox P2_check;
    private Button P2_BotonCrearCuenta;
    private EditText P2_TextoIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Atras = findViewById(R.id.P2_BotonAtras);
        Nombre = findViewById(R.id.P2_TextoNombre);
        Correo = findViewById(R.id.P2_TextoCorreo);
        Contrasena = findViewById(R.id.P2_TextoContrasena);
        Contrasena2 = findViewById(R.id.P2_TextoContrasena2);
        Check = findViewById(R.id.P2_check);
        Crear = findViewById(R.id.P2_BotonCrearCuenta);
        Iniciar = findViewById(R.id.P2_TextoIniciar);

        Atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrearCuenta.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrearCuenta.this, PantallaPrincipal.class);
                startActivity(intent);
            }
        });

        Iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrearCuenta.this, PantallaPrincipal.class);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}