package com.example.citafacil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

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

        // Volver atrás
        P2_BotonAtras.setOnClickListener(v -> finish());

        // Crear cuenta
        P2_BotonCrearCuenta.setOnClickListener(v -> {

            String nombre = P2_TextoNombre.getText().toString().trim();
            String correo = P2_TextoCorreo.getText().toString().trim();
            String contrasena = P2_TextoContrasena.getText().toString();
            String contrasena2 = P2_TextoContrasena2.getText().toString();

            // Comprobar nombre
            if (nombre.isEmpty()) {
                P2_TextoNombre.setError("Introduce tu nombre");
                P2_TextoNombre.requestFocus();
                return;
            }

            // Comprobar correo
            if (correo.isEmpty()) {
                P2_TextoCorreo.setError("Introduce tu correo");
                P2_TextoCorreo.requestFocus();
                return;
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
                P2_TextoCorreo.setError("Introduce un correo válido");
                P2_TextoCorreo.requestFocus();
                return;
            }

            // Comprobar contraseña
            if (contrasena.isEmpty()) {
                P2_TextoContrasena.setError("Introduce una contraseña");
                P2_TextoContrasena.requestFocus();
                return;
            }

            if (contrasena.length() < 8) {
                P2_TextoContrasena.setError("Mínimo 8 caracteres");
                P2_TextoContrasena.requestFocus();
                return;
            }

            // Comprobar confirmación
            if (!contrasena.equals(contrasena2)) {
                P2_TextoContrasena2.setError("Las contraseñas no coinciden");
                P2_TextoContrasena2.requestFocus();
                return;
            }

            // Comprobar términos
            if (!P2_check.isChecked()) {
                Toast.makeText(this,
                        "Debes aceptar los términos y condiciones",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            // Registro pendiente de conectar con la BD
            Toast.makeText(this,
                    "Datos correctos. Pendiente de registrar en la BD",
                    Toast.LENGTH_LONG).show();

        });

        // Ir a iniciar sesión
        P2_TextoIniciar.setOnClickListener(v -> {
            Intent intent = new Intent(CrearCuenta.this, InicioSesion.class);
            startActivity(intent);
        });
    }
}