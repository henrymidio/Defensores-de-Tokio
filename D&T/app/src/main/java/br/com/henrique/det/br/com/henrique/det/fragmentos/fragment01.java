package br.com.henrique.det.br.com.henrique.det.fragmentos;


import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import br.com.henrique.det.Ficha;
import br.com.henrique.det.MainActivity;
import br.com.henrique.det.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragment01 extends Fragment {

    Ficha personagem;

    private String nome;
    private int forca;
    private int habilidade;
    private int resistencia;
    private int armadura;
    private int pdf;


    //Verifica se o fragment1 está sendo chamado do fragment2
    private boolean p = false;

    private int resto;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment01, container, false);
    }


    @Override
    public void onPause() {
        super.onPause();
        p = true;
        resto = MainActivity.pontos;
    }

    public boolean salvarCaracteristicas(Ficha personagem){

        this.personagem = personagem;

        String etForca = ((EditText) getView().findViewById(R.id.editForca)).getText().toString();
        String etHabilidade = ((EditText) getView().findViewById(R.id.editHabilidade)).getText().toString();
        String etResistencia = ((EditText) getView().findViewById(R.id.editResistencia)).getText().toString();
        String etArmadura = ((EditText) getView().findViewById(R.id.editArmadura)).getText().toString();
        String etPDF = ((EditText) getView().findViewById(R.id.editPDF)).getText().toString();


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


        nome = ((EditText) getView().findViewById(R.id.editNome)).getText().toString();
        forca = Integer.parseInt(etForca);
        habilidade = Integer.parseInt(etHabilidade);
        resistencia = Integer.parseInt(etResistencia);
        armadura = Integer.parseInt(etArmadura);
        pdf = Integer.parseInt(etPDF);


        if(p == true){
            //Restaura o valor dos pontos
            MainActivity.pontos += getActivity().getIntent().getExtras().getInt("pontos");
            MainActivity.pontos -= resto;
            Log.e("pontos10", "" + MainActivity.pontos);
            p = false;
        }
        int soma = forca + habilidade + resistencia + armadura + pdf;
        Log.e("pontos2", "" + MainActivity.pontos);
        MainActivity.pontos -= soma;
        Log.e("soma", "" + soma);
        Log.e("pontos5", "" + MainActivity.pontos);

        if (MainActivity.pontos < 0){
            //Exibe mensagem dizendo que os pontos foram ultrapassadoss
            MainActivity.pontos += soma;
            return false;
        } else {
            personagem.setCaracteristicas(nome, forca, habilidade, resistencia, armadura, pdf);
           // MainActivity.pontos -= soma;
            Log.e("pontos6", "" + MainActivity.pontos);
            return true;
        }
    }




}
