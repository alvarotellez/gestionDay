package es.iesnervion.atellez.gestionday.BaseDeDatos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import es.iesnervion.atellez.gestionday.Fragments.AgregarFragment;

/**
 * Created by alvarotellez on 15/2/17.
 */

public class AnotacionesSQLiteHelper extends SQLiteOpenHelper{

    String sqlCreate = "CREATE TABLE Anotaciones(codigo INTEGER PRIMARY KEY AUTOINCREMENT," +
            "cantidad FLOAT NOT NULL, " +
            "nota TEXT NOT NULL, " +
            "tipo TEXT NOT NULL, " +
            "fechaCreacion TEXT NOT NULL)";
    private static final String datosUnaAnotacion="datosUnaAnotacion";
    private SQLiteDatabase datos;
    //Formato fecha DATETIME '2007-01-01 10:00:00'
    public AnotacionesSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Anotaciones");

        //Creacion de la nueva version de la BD
        db.execSQL(sqlCreate);
    }

    public Cursor curso(){
        String [] columnas = {"codigo","cantidad","nota","tipo","fechaCreacion"};

        Cursor c = this.getReadableDatabase().query(datosUnaAnotacion, columnas, null, null, null, null,null);

        return c;
    }

    public Cursor buscardatos(int cod){
        Cursor fila = datos.rawQuery("SELECT cantidad, nota, tipo, fechaCreacion FROM Anotaciones where codigo =" + cod,null);
        return fila;
    }
}
