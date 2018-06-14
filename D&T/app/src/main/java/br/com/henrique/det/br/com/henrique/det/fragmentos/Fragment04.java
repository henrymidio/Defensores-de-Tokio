package br.com.henrique.det.br.com.henrique.det.fragmentos;


import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import br.com.henrique.det.Ficha;
import br.com.henrique.det.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment04 extends Fragment {



    public Fragment04() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment04, container, false);
    }

    public void setaItensEHistoria(Ficha personagem){

        String itens = ((EditText) getView().findViewById(R.id.exibeItens)).getText().toString();
        String historia = ((EditText) getView().findViewById(R.id.exibeHistoria)).getText().toString();


        personagem.setVida(personagem.getCaracteristicas()[3] * 5);
        personagem.setPm(personagem.getCaracteristicas()[3] * 5);
        personagem.setItensEHistoria(itens, historia);

    }
}
