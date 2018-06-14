package br.com.henrique.det.br.com.henrique.det.fragmentos;


import android.os.Bundle;
import android.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import br.com.henrique.det.Ficha;
import br.com.henrique.det.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMain extends Fragment {

    private String nome;
    private int forca;
    private int habilidade;
    private int resistencia;
    private int armadura;
    private int pdf;
    private int pm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    public void salvarCaracteristicas(Ficha personagem){

        String etForca = ((EditText) getView().findViewById(R.id.editForca)).getText().toString();
        String etHabilidade = ((EditText) getView().findViewById(R.id.editHabilidade)).getText().toString();
        String etResistencia = ((EditText) getView().findViewById(R.id.editResistencia)).getText().toString();
        String etArmadura = ((EditText) getView().findViewById(R.id.editArmadura)).getText().toString();
        String etPDF = ((EditText) getView().findViewById(R.id.editPDF)).getText().toString();
        String etPM = ((EditText) getView().findViewById(R.id.editPM)).getText().toString();

        if(TextUtils.isEmpty(etForca)){
            etForca = "0";
        }
        if(TextUtils.isEmpty(etHabilidade)){
            etHabilidade = "0";
        }
        if(TextUtils.isEmpty(etResistencia)){
            etResistencia = "0";
        }
        if(TextUtils.isEmpty(etArmadura)){
            etArmadura = "0";
        }
        if(TextUtils.isEmpty(etPDF)){
            etPDF = "0";
        }
        if(TextUtils.isEmpty(etPM)){
            etPM = "0";
        }

        nome = ((EditText) getView().findViewById(R.id.editNome)).getText().toString();
        forca = Integer.parseInt(etForca);
        habilidade = Integer.parseInt(etHabilidade);
        resistencia = Integer.parseInt(etResistencia);
        armadura = Integer.parseInt(etArmadura);
        pdf = Integer.parseInt(etPDF);
        pm = Integer.parseInt(etPM);


            personagem.setCaracteristicas(nome, forca, habilidade, resistencia, armadura, pdf);

    }


}
