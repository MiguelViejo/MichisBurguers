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

public class RecuperarContrasenaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recuperar_contrasena);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.recuperar), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText etCorreo = findViewById(R.id.EditTextCorreo);
        Button btnEnviar = findViewById(R.id.btnEnviar);
        Button btnVolver = findViewById(R.id.btnVolver);

        // Comprueba que el correo tenga un formato válido antes de "enviarlo"
        btnEnviar.setOnClickListener(v -> {
            String correo = etCorreo.getText().toString().trim();

            if (Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
                Toast.makeText(this, "Te hemos enviado un correo a " + correo, Toast.LENGTH_LONG).show();
                finish();
            } else {
                etCorreo.setError("Escribe un correo válido");
            }
        });

        // Vuelve a la pantalla de login
        btnVolver.setOnClickListener(v -> finish());
    }
}
