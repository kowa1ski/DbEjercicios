package BSHELPER;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Usuario on 20/08/2017.
 */
/*
Creamos esto como sabemos con Alt+ intro
 */
public class sqlite extends SQLiteOpenHelper {

    // Primero Creamos una variable para crear la tabla
    public String usuarios = "CREATE TABLE usuarios(idusuario INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, apellidos TEXT, "
            + "edad INTEGER);";

    public sqlite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Y después creamos la tabla con la sentencia , db.execSQL() , .
        db.execSQL(usuarios);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
