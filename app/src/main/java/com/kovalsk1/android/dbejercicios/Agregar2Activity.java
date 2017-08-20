package com.kovalsk1.android.dbejercicios;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import BSHELPER.sqlite;

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

            // Voy a comentar este Toast porque ya tengo el que me dice lo del registro insertado.
            // Toast.makeText(this, "no hay campos vacíos", Toast.LENGTH_LONG).show();

            String nom, ape;
            int ed;

            nom = nombre.getText().toString();
            ape = apellidos.getText().toString();
            ed = Integer.parseInt(edad.getText().toString());

            sqlite bh = new sqlite(this, "usuarios", null, 1);

            if (bh != null){

                SQLiteDatabase db = bh.getWritableDatabase();

                ContentValues con = new ContentValues();
                con.put("nombre", nom);
                con.put("apellidos", ape);
                con.put("edad", ed);
                long insertar = db.insert("usuarios", null, con);
                if (insertar > 0){

                    Toast.makeText(this, "Se ha insertado un nuevo registro", Toast.LENGTH_LONG).show();

                    nombre.setText("");
                    apellidos.setText("");
                    edad.setText("");

                } else {

                    Toast.makeText(this, "Ha habido un imprevisto, NO SE HA " +
                            "INSERTADO NINGÚN REGISTRO", Toast.LENGTH_LONG).show();

                }

            }

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


















