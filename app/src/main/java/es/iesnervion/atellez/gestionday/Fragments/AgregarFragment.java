package es.iesnervion.atellez.gestionday.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import es.iesnervion.atellez.gestionday.R;

/**
 * Created by atellez on 8/02/17.
 */

public class AgregarFragment extends Fragment{

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
            return inflater.inflate(R.layout.fragment_agregar, container, false);

    }

}
