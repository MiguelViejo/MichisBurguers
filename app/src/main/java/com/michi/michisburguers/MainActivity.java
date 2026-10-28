package com.michi.michisburguers;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Credenciales de prueba
    private static final String USUARIO_VALIDO = "messi";
    private static final String CONTRASENIA_VALIDA = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.imageNavegador), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        /*static final String USUARIO_VALIDO = "messi";
        static final String CONTRASENIA_VALIDA = "1234";
         private boolean verifyUser(String username, String pass){
        * if(username.equals(USER_DEFAULT) && pass.equals(PASS_DEFAULT)){
        * return true;
        * }
        * else{
        * return false;
        * }
        * */
        Log.d("DAM", "Se ha ejecutado el onCreate");

        // Vinculamos los componentes del diseño XML
        EditText etUsuario = findViewById(R.id.EditTextUsuario);
        EditText etContrasenia = findViewById(R.id.EditTextContraseña);
        Button btnIniciarSesion = findViewById(R.id.iniciarSesion);
        Button btnOlvidarContrasenia = findViewById(R.id.olvidarContraseña);
        Button btnRegistrarte = findViewById(R.id.registrarte);

        // Valida y, si es correcto, abre la pantalla de Inicio
        btnIniciarSesion.setOnClickListener(v -> {
            String userInput = etUsuario.getText().toString().trim();
            String passwordInput = etContrasenia.getText().toString().trim();

            if (verificarCredenciales(userInput, passwordInput)) {
                Intent intent = new Intent(MainActivity.this, InicioActivity.class);
                intent.putExtra("Nickname", userInput);
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        });

        // Abre la pantalla para recuperar la contraseña
        btnOlvidarContrasenia.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RecuperarContrasenaActivity.class);
            startActivity(intent);
        });

        // Abre la pantalla de registro
        btnRegistrarte.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Register.class);
            startActivity(intent);
        });





    }

    private boolean verificarCredenciales(String usuario, String contrasenia) {
        return USUARIO_VALIDO.equals(usuario) && CONTRASENIA_VALIDA.equals(contrasenia);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("DAM", "Se ha ejecutado el onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("DAM", "Se ha ejecutado el onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("DAM", "Se ha ejecutado el onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("DAM", "Se ha ejecutado el onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("DAM", "Se ha ejecutado el onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("DAM", "Se ha ejecutado el onDestroy");
    }

/*public void createAlarm(String message, int hour, int minutes) {
    Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
            .putExtra(AlarmClock.EXTRA_MESSAGE, "message")
            .putExtra(AlarmClock.EXTRA_HOUR, 9)
            .putExtra(AlarmClock.EXTRA_MINUTES, 30);

        startActivity(intent);
        */

    }

