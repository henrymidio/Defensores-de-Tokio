package br.com.henrique.det.br.com.henrique.det.fragmentos;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import br.com.henrique.det.Ficha;
import br.com.henrique.det.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTab02 extends Fragment {

    private String vantagem1;
    private String vantagem2;
    private String vantagem3;
    private String vantagem4;
    private String desvantagem1;
    private String desvantagem2;
    private String desvantagem3;
    private String desvantagem4;
    private Spinner spinner;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    private Spinner spinner5;
    private Spinner spinner6;
    private Spinner spinner7;
    private Spinner spinner8;


    public FragmentTab02() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment02, container, false);
        spinner = (Spinner) view.findViewById(R.id.spinner);
        spinner2 = (Spinner) view.findViewById(R.id.spinner2);
        spinner3 = (Spinner) view.findViewById(R.id.spinner3);
        spinner4 = (Spinner) view.findViewById(R.id.spinner4);
        spinner5 = (Spinner) view.findViewById(R.id.spinner5);
        spinner6 = (Spinner) view.findViewById(R.id.spinner6);
        spinner7 = (Spinner) view.findViewById(R.id.spinner7);
        spinner8 = (Spinner) view.findViewById(R.id.spinner8);

        List<String> list = new ArrayList<String>();
        list.add("");
        list.add("Java");
        list.add("Spinner Data");
        list.add("Spinner Adapter");
        list.add("Spinner Example");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (view.getContext(), R.layout.layout_custom_spinner, list);
        dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

         spinner.setAdapter(dataAdapter);
        spinner2.setAdapter(dataAdapter);
        spinner3.setAdapter(dataAdapter);
        spinner4.setAdapter(dataAdapter);

        spinner5.setAdapter(dataAdapter);
        spinner6.setAdapter(dataAdapter);
        spinner7.setAdapter(dataAdapter);
        spinner8.setAdapter(dataAdapter);

        return (view);
    }

    public void salvaVantagensEDesvantagens(Ficha personagem){

        String v1 = spinner.getSelectedItem().toString();
        String v2 = spinner2.getSelectedItem().toString();
        String v3 = spinner3.getSelectedItem().toString();
        String v4 = spinner4.getSelectedItem().toString();

        String d1 = spinner5.getSelectedItem().toString();
        String d2 = spinner6.getSelectedItem().toString();
        String d3 = spinner7.getSelectedItem().toString();
        String d4 = spinner8.getSelectedItem().toString();

        Log.e("TESTE", v1);
        Log.e("TESTE", v2);

        personagem.setVantagensEDesvantagens(v1, v2, v3, v4, d1, d2, d3, d4);

    }

   }

