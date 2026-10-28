package com.michi.michisburguers;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Register extends AppCompatActivity {

    private static final int LONGITUD_MINIMA_CONTRASENIA = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText etUsuario = findViewById(R.id.EditTextRegUsuario);
        EditText etCorreo = findViewById(R.id.EditTextRegCorreo);
        EditText etContrasenia = findViewById(R.id.EditTextRegContrasena);
        EditText etRepetir = findViewById(R.id.EditTextRegRepetir);
        Button btnCrearCuenta = findViewById(R.id.btnCrearCuenta);
        Button btnYaTengoCuenta = findViewById(R.id.btnYaTengoCuenta);

        // Comprueba cada campo y marca en rojo el primero que esté mal
        btnCrearCuenta.setOnClickListener(v -> {
            String usuario = etUsuario.getText().toString().trim();
            String correo = etCorreo.getText().toString().trim();
            String contrasenia = etContrasenia.getText().toString();
            String repetir = etRepetir.getText().toString();

            if (usuario.isEmpty()) {
                etUsuario.setError("Escribe un nombre de usuario");
                etUsuario.requestFocus();
            } else if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
                etCorreo.setError("Escribe un correo válido");
                etCorreo.requestFocus();
            } else if (contrasenia.length() < LONGITUD_MINIMA_CONTRASENIA) {
                etContrasenia.setError("Mínimo " + LONGITUD_MINIMA_CONTRASENIA + " caracteres");
                etContrasenia.requestFocus();
            } else if (!contrasenia.equals(repetir)) {
                etRepetir.setError("Las contraseñas no coinciden");
                etRepetir.requestFocus();
            } else {
                Toast.makeText(this, "Cuenta creada para " + usuario, Toast.LENGTH_LONG).show();
                finish();
            }
        });

        // Vuelve a la pantalla de login
        btnYaTengoCuenta.setOnClickListener(v -> finish());
    }
}
