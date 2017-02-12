package es.iesnervion.atellez.gestionday.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by alvarotellez on 12/2/17.
 */

public class AnotacionDataBaseHelper extends SQLiteOpenHelper {

    String sqlCreacion = "CREATE TABLE Anotacion (Identificador INTEGER, Cantidad REAL, Tipo TEXT, Nota TEXT, FechaCreacion TEXT)";

    public AnotacionDataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreacion);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Anotacion");
        db.execSQL(sqlCreacion);
    }
}
