package es.iesnervion.atellez.gestionday.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Calendar;
import es.iesnervion.atellez.gestionday.BaseDeDatos.AnotacionesSQLiteHelper;
import es.iesnervion.atellez.gestionday.R;
import belka.us.androidtoggleswitch.widgets.ToggleSwitch;

/**
 * Created by atellez on 8/02/17.
 */

public class AgregarFragment extends Fragment implements View.OnClickListener {
    EditText edCantidad, edNota, edTipo;
    ToggleSwitch toggleSwitch;
    Button btnGuardar, btnCancelar;
    Float cantidad;
    String nota, tipo, fechaCreacion;
    SQLiteDatabase db;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_agregar, container, false);
    }

    public void onStart(){
        super.onStart();
        edCantidad = (EditText) getActivity().findViewById(R.id.txtCantidad);
        edNota = (EditText) getActivity().findViewById(R.id.txtNota);

        btnGuardar = (Button) getActivity().findViewById(R.id.btnGuardar);
        btnCancelar = (Button) getActivity().findViewById(R.id.btnCancelar);
        toggleSwitch = (ToggleSwitch) getActivity().findViewById(R.id.swGI);

        btnGuardar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);
        AnotacionesSQLiteHelper nuevaAnotacion = new AnotacionesSQLiteHelper(getActivity(), "DBAnotacion", null, 1);

        db = nuevaAnotacion.getWritableDatabase();

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGuardar:
                cantidad =  Float.parseFloat(edCantidad.getText().toString()) ;
                nota = edNota.getText().toString();

                //Obtenemos la fecha actual del sistema
                Calendar cc = Calendar.getInstance();
                int year=cc.get(Calendar.YEAR);
                //Ojo!!! Enero en java es 0 por eso hay que incrementarlo en 1
                int month=cc.get(Calendar.MONTH)+1;
                int mDay = cc.get(Calendar.DAY_OF_MONTH);
                fechaCreacion = mDay +":"+month+":"+year;

                int posicionToggle = toggleSwitch.getCheckedTogglePosition();
                //Posicion 0 --> Gasto
                //Posicion 1 --> Ingreso

                if(posicionToggle ==0){
                    tipo = "GASTO";
                }else{
                    tipo = "INGRESO";
                }

                if (!(cantidad>0 && tipo.isEmpty() && fechaCreacion.isEmpty())){

                    String inserccion = "INSERT INTO Anotaciones (cantidad, nota, tipo, fechaCreacion) VALUES('"+cantidad+"','"+nota+"','"+tipo+"','"+fechaCreacion+"')";
                    db.execSQL(inserccion);
                    db.close();
                    Toast.makeText(getActivity(), "La anotación se ha guardado con exito",Toast.LENGTH_SHORT).show();
                    edCantidad.setText(" ");
                    edNota.setText(" ");
                }else {
                    Toast.makeText(getActivity(), "La anotación no se ha podido guardar",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnCancelar:
                edCantidad.setText(" ");
                edNota.setText(" ");
                break;
        }
    }
}
