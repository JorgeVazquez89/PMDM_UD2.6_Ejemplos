package com.example.apppreferencias;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnPreferencias = (Button) findViewById(R.id.btnPreferencias);
        btnPreferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Preferencias.class);
                startActivity(i);
            }
        });

        Button btnMostrarPreferencias = (Button) findViewById(R.id.btnMostrarPreferencias);
        TextView txtPreferencias = (TextView) findViewById(R.id.txtPreferencias);

        btnMostrarPreferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Set<String> opciones = null;
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                txtPreferencias.append("Opción 1 " + pref.getBoolean("clave1",false));
                txtPreferencias.append("Opción 2 " + pref.getString("clave2","No asignada"));
                txtPreferencias.append("Opción 3 " + pref.getString("clave3","No asignada"));
                txtPreferencias.append("Opción 4 " + pref.getStringSet("clave4", opciones));
            }
        });
    }


}

