package com.kovalsk1.android.dbejercicios;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Agregar2Activity extends AppCompatActivity {

    // Declaramos las variables para recoger la información de los editText
    private TextView nombre, apellidos, edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        // relacionamos las variables con los editText
        nombre = (TextView) findViewById(R.id.editTextNombre);
        apellidos = (TextView) findViewById(R.id.editTextApellido);
        edad = (TextView) findViewById(R.id.editTextEdad);

    }

    // Creamos este método , agregar, y el , ComprobarCampos , y
    // lo comprobamos que funciona lanzando los toast
    public void agregar(View view){

        if (ComprobarCampos()) {
            Toast.makeText(this, "no hay campos vacíos", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "existen campos que están vacíos", Toast.LENGTH_LONG).show();
        }
    }

    public boolean ComprobarCampos () {
        if (nombre.getText().toString().isEmpty() || apellidos.getText().toString().isEmpty()
                || edad.getText().toString().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

}


















