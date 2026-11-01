package com.example.citafacil;

import static androidx.core.content.ContextCompat.startActivity;
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

}
private EditText P1_TextoCorreo;
private EditText P1_Contraseña;
private ImageButton P1_Atras;
private Button P1_BotonIniciar;
private TextView P1_TextoRegistrar;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_main);

    TextoCorreo = findViewById(R.id.P1_TextoCorreo);
    Contrasena = findViewById(R.id.P1_TextoContrasena);
    Atras = findViewById(R.id.P1_BotonAtras);
    Iniciar = findViewById(R.id.P1_BotonIniciar);
    Registrar = findViewById(R.id.P1_TextoRegistrar);


    Atras.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(InicioSesion.this, MainActivity.class);
            startActivity(intent);
        }
    });

    Iniciar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(InicioSesion.this, PantallaPrincipal.class);
            startActivity(intent);
        }
    });
    Registrar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(InicioSesion.this, CrearCuenta.class);
            startActivity(intent);
        }
    });

}
