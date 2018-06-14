package br.com.henrique.det.br.com.henrique.det.fragmentos;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import br.com.henrique.det.Ficha;
import br.com.henrique.det.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTab03 extends Fragment {

    //Tipos de dano
    private String tdd1;
    private String tdd2;

    //Magias conhecidas
    private String magia1;
    private String magia2;
    private String magia3;
    private String magia4;
    private String magia5;

    private Spinner spinner;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    private Spinner spinner5;

    public FragmentTab03() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment03, container, false);

        spinner = (Spinner) view.findViewById(R.id.spinner);
        spinner2 = (Spinner) view.findViewById(R.id.spinner2);
        spinner3 = (Spinner) view.findViewById(R.id.spinner3);
        spinner4 = (Spinner) view.findViewById(R.id.spinner4);
        spinner5 = (Spinner) view.findViewById(R.id.spinner5);


        List<String> list = new ArrayList<String>();
        list.add("");
        list.add("Magia");
        list.add("Água");
        list.add("gdd");
        list.add("fgds");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (view.getContext(), R.layout.layout_custom_spinner, list);
        dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
        spinner2.setAdapter(dataAdapter);
        spinner3.setAdapter(dataAdapter);
        spinner4.setAdapter(dataAdapter);
        spinner5.setAdapter(dataAdapter);

        return view;
    }

    public void setaTiposDeDanoEMagiasConhecidas(Ficha personagem){

        tdd1 = ((EditText) getView().findViewById(R.id.exibeTDDForca)).getText().toString();
        tdd2 = ((EditText) getView().findViewById(R.id.exibeTDDPDF)).getText().toString();

        magia1 = spinner.getSelectedItem().toString();
        magia2 = spinner2.getSelectedItem().toString();
        magia3 = spinner3.getSelectedItem().toString();
        magia4 = spinner4.getSelectedItem().toString();
        magia5 = spinner5.getSelectedItem().toString();

        personagem.setTiposDeDanoEMagiasConhecidas(tdd1, tdd2, magia1, magia2, magia3, magia4, magia5);

    }


}
