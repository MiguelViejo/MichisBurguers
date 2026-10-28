package com.michi.michisburguers;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.inicio), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Nombre que nos pasa el login
        String usuario = getIntent().getStringExtra("Nickname");

        TextView tvBienvenida = findViewById(R.id.textBienvenida);
        tvBienvenida.setText(getString(R.string.bienvenido, usuario));

        Button btnVerCarta = findViewById(R.id.btnVerCarta);
        Button btnMiPerfil = findViewById(R.id.btnMiPerfil);
        Button btnCerrarSesion = findViewById(R.id.btnCerrarSesion);

        btnVerCarta.setOnClickListener(v -> {
            Intent intent = new Intent(InicioActivity.this, ActivityDashBoard.class);
            startActivity(intent);
        });

        btnMiPerfil.setOnClickListener(v -> {
            Intent intent = new Intent(InicioActivity.this, ProfileActivity.class);
            intent.putExtra("Nickname", usuario);
            startActivity(intent);
        });

        // Cierra esta pantalla y vuelve al login
        btnCerrarSesion.setOnClickListener(v -> finish());
    }
}
