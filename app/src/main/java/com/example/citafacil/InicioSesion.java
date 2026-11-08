
package com.example.citafacil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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
        P1_Atras.setOnClickListener(v -> finish());

        // Iniciar sesión
        P1_BotonIniciar.setOnClickListener(v -> {

            String correo = P1_TextoCorreo.getText().toString().trim();
            String contrasena = P1_Contrasena.getText().toString().trim();

            // Comprobar campos vacíos
            if (correo.isEmpty()) {
                P1_TextoCorreo.setError("Introduce tu correo electrónico");
                P1_TextoCorreo.requestFocus();
                return;
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
                P1_TextoCorreo.setError("Introduce un correo válido");
                P1_TextoCorreo.requestFocus();
                return;
            }

            if (contrasena.isEmpty()) {
                P1_Contrasena.setError("Introduce tu contraseña");
                P1_Contrasena.requestFocus();
                return;
            }

            // NAVEGACIÓN PROVISIONAL
            // Aquí conectaremos la base de datos para verificar
            // que el usuario y la contraseña sean correctos.

            Toast.makeText(this,
                    "Datos introducidos correctamente",
                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(
                    InicioSesion.this,
                    PantallaPrincipal.class
            );

            intent.putExtra("modo_invitado", false);
            intent.putExtra("correo_usuario", correo);

            startActivity(intent);
        });

        // Ir a crear cuenta
        P1_TextoRegistrar.setOnClickListener(v -> {
            Intent intent = new Intent(
                    InicioSesion.this,
                    CrearCuenta.class
            );
            startActivity(intent);
        });
    }
}
