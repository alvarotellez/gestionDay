package es.iesnervion.atellez.gestionday.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.iesnervion.atellez.gestionday.R;

/**
 * Created by atellez on 8/02/17.
 */

public class AgregarFragment extends Fragment{

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        //miSpinner = (Spinner) getActivity().findViewById(R.id.spinnerTipo);

        return inflater.inflate(R.layout.fragment_agregar, container, false);

    }


}
