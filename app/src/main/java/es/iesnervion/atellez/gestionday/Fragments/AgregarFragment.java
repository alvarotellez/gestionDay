package es.iesnervion.atellez.gestionday.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import es.iesnervion.atellez.gestionday.R;

/**
 * Created by atellez on 8/02/17.
 */

public class AgregarFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        //miSpinner = (Spinner) getActivity().findViewById(R.id.spinnerTipo);
        //Spinner spinner = (Spinner) getActivity().findViewById(R.id.spinnerTipo);
        // Create an ArrayAdapter using the string array and a default spinner layout
       // ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getActivity(),
                //R.array.planets_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        //spinner.setAdapter(adapter);
        return inflater.inflate(R.layout.fragment_agregar, container, false);

    }
}
