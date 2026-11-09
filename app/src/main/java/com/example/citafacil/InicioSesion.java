
package com.example.citafacil;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.citafacil.model.LoginRequest;
import com.example.citafacil.model.LoginResponse;
import com.example.citafacil.network.ApiClient;
import com.example.citafacil.network.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InicioSesion extends AppCompatActivity {

    // Componentes de la interfaz
    private EditText P1_TextoCorreo;
    private EditText P1_Contrasena;
    private ImageButton P1_BotonAtras;
    private Button P1_BotonIniciar;
    private TextView P1_TextoRegistrar;

    // Servicio de comunicación con el backend
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.pantalla_inicio_sesion);

        // Inicializar servicio API
        apiService = ApiClient.getApiService();

        // Referencias a los elementos XML
        P1_TextoCorreo = findViewById(R.id.P1_TextoCorreo);
        P1_Contrasena = findViewById(R.id.P1_TextoContrasena);
        P1_BotonAtras = findViewById(R.id.P1_BotonAtras);
        P1_BotonIniciar = findViewById(R.id.P1_BotonIniciar);
        P1_TextoRegistrar = findViewById(R.id.P1_TextoRegistrar);

        // Volver a la pantalla anterior
        P1_BotonAtras.setOnClickListener(v -> finish());

        // Iniciar sesión
        P1_BotonIniciar.setOnClickListener(v -> iniciarSesion());

        // Ir a crear cuenta
        P1_TextoRegistrar.setOnClickListener(v -> {
            Intent intent = new Intent(
                    InicioSesion.this,
                    CrearCuenta.class
            );

            startActivity(intent);
        });
    }

    private void iniciarSesion() {

        String correo = P1_TextoCorreo.getText().toString().trim();
        String contrasena = P1_Contrasena.getText().toString();

        // Comprobar correo vacío
        if (correo.isEmpty()) {
            P1_TextoCorreo.setError("Introduce tu correo electrónico");
            P1_TextoCorreo.requestFocus();
            return;
        }

        // Comprobar formato del correo
        if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            P1_TextoCorreo.setError("Introduce un correo válido");
            P1_TextoCorreo.requestFocus();
            return;
        }

        // Comprobar contraseña vacía
        if (contrasena.isEmpty()) {
            P1_Contrasena.setError("Introduce tu contraseña");
            P1_Contrasena.requestFocus();
            return;
        }

        // Desactivar botón mientras se realiza la petición
        P1_BotonIniciar.setEnabled(false);

        // Crear objeto con las credenciales
        LoginRequest request = new LoginRequest(correo, contrasena);

        // Enviar petición al backend
        apiService.iniciarSesion(request).enqueue(new Callback<LoginResponse>() {

            @Override
            public void onResponse(
                    Call<LoginResponse> call,
                    Response<LoginResponse> response
            ) {

                P1_BotonIniciar.setEnabled(true);

                if (response.isSuccessful() && response.body() != null) {

                    LoginResponse loginResponse = response.body();

                    // Guardar información de autenticación
                    SharedPreferences preferences =
                            getSharedPreferences("CitaFacil", MODE_PRIVATE);

                    preferences.edit()
                            .putString("token", loginResponse.getToken())
                            .putString("tipo", loginResponse.getTipo())
                            .putLong("expiraEn", loginResponse.getExpiraEn())
                            .apply();

                    Toast.makeText(
                            InicioSesion.this,
                            "Inicio de sesión correcto",
                            Toast.LENGTH_SHORT
                    ).show();

                    // Acceder a la pantalla principal
                    Intent intent = new Intent(
                            InicioSesion.this,
                            PantallaPrincipal.class
                    );

                    intent.putExtra("modo_invitado", false);
                    intent.putExtra("correo_usuario", correo);

                    startActivity(intent);
                    finish();

                } else {

                    Toast.makeText(
                            InicioSesion.this,
                            "Error al iniciar sesión. Código: " + response.code(),
                            Toast.LENGTH_LONG
                    ).show();
                }
            }

            @Override
            public void onFailure(
                    Call<LoginResponse> call,
                    Throwable t
            ) {

                P1_BotonIniciar.setEnabled(true);

                Toast.makeText(
                        InicioSesion.this,
                        "Error de conexión: " + t.getMessage(),
                        Toast.LENGTH_LONG
                ).show();
            }
        });
    }
}
