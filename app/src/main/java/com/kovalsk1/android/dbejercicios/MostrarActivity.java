package com.kovalsk1.android.dbejercicios;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import BSHELPER.sqlite;
import BSHELPER.usuarios;

public class MostrarActivity extends AppCompatActivity {

    private ArrayList<BSHELPER.usuarios> usuarios = new ArrayList<>();
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
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

        lista = (ListView) findViewById(R.id.listViewMostrar);
        llenarLista();
    }

    public void llenarLista(){

        sqlite bh = new sqlite(MostrarActivity.this, "usuarios", null, 1);
        if (bh != null){
            SQLiteDatabase db = bh.getReadableDatabase();
            Cursor c = db.rawQuery("SELECT * FROM usuarios", null);
            if (c.moveToFirst()) {
                do{
                    usuarios.add(new usuarios(c.getInt(0), c.getString(1), c.getString(2), c.getInt(3)));
                }while (c.moveToNext());
            }
        }

        String[] arreglo = new String[usuarios.size()];
        for (int i = 0 ; i < arreglo.length; i++) {

            arreglo[i] = usuarios.get(i).getNombre();

        }

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(MostrarActivity.this, android.R.layout.simple_list_item_1, arreglo);
        lista.setAdapter(adaptador);

    }

}








