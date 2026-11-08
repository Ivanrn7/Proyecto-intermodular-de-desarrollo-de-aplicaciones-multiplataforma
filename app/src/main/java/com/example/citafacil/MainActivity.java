package com.example.citafacil;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button registro;
    private Button iniciar;
    private TextView invitado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        registro = findViewById(R.id.main_BotonRegistrarse);
        iniciar = findViewById(R.id.main_botonIniciar);
        invitado = findViewById(R.id.main_BotonInvitado);

        // Ir a registro
        registro.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CrearCuenta.class);
            startActivity(intent);
        });

        // Ir a inicio de sesión
        iniciar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, InicioSesion.class);
            startActivity(intent);
        });

        // Entrar como invitado
        invitado.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PantallaPrincipal.class);
            intent.putExtra("modo_invitado", true);
            startActivity(intent);
        });

        // Adaptación a los márgenes del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top,
                    systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
