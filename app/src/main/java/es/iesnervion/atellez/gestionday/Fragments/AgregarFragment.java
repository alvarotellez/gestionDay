package es.iesnervion.atellez.gestionday.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import es.iesnervion.atellez.gestionday.R;
import es.iesnervion.atellez.gestionday.UI.ToggleSwitch;

/**
 * Created by atellez on 8/02/17.
 */

public class AgregarFragment extends Fragment implements View.OnClickListener {

    Button btnAceptar, btnCancelar;
    EditText editCantidad, editNota;
    ToggleSwitch toggleSwitch;
    String nota, cantidad, tipo;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        toggleSwitch = (ToggleSwitch) getActivity().findViewById(R.id.swGI);
        btnAceptar = (Button) getActivity().findViewById(R.id.btnAceptar);
        btnCancelar = (Button) getActivity().findViewById(R.id.btnCancelar);

        btnAceptar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);


        editCantidad = (EditText) getActivity().findViewById(R.id.txtCantidad);
        editNota = (EditText) getActivity().findViewById(R.id.txtNota);

        return inflater.inflate(R.layout.fragment_agregar, container, false);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAceptar:

                cantidad = editCantidad.getText().toString();
                nota = editNota.getText().toString();

                int position = toggleSwitch.getCheckedTogglePosition();

                if(position == 1){
                    tipo = "Gasto";
                }else if(position == 2){
                    tipo = "Ingreso";
                }
                break;
            case R.id.btnCancelar:

                break;
        }
    }
}
