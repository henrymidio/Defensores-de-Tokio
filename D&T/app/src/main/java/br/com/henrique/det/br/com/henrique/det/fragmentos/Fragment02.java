package br.com.henrique.det.br.com.henrique.det.fragmentos;


import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.henrique.det.Ficha;
import br.com.henrique.det.MainActivity;
import br.com.henrique.det.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment02 extends Fragment {

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

    private int pontosDeVantagem = 0;
    private int pontosDesvantagens = 0;
    private String d1;
    private String d2;
    private String d3;
    private String d4;

    public Fragment02() {
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


        List<String> listaVantagens = new ArrayList<String>();
        listaVantagens.add("");
        listaVantagens.add("Aceleração [1 ponto]");
        listaVantagens.add("Adaptador [1 ponto]");
        listaVantagens.add("1 Aliado [1 ponto]");
        listaVantagens.add("2 Aliados [2 pontos]");
        listaVantagens.add("3 Aliados [3 pontos]");
        listaVantagens.add("Alquimista [1 ponto]");
        listaVantagens.add("Aparência Inofensiva [1 ponto]");
        listaVantagens.add("Arcano [4 pontos]");
        listaVantagens.add("Área de Batalha [2 pontos]");
        listaVantagens.add("Arena [1 ponto]");
        listaVantagens.add("Ataque Múltiplo [1 ponto]");
        listaVantagens.add("Boa Fama [1 ponto]");
        listaVantagens.add("Clericato [1 ponto]");
        listaVantagens.add("Deflexão [1 ponto]");
        listaVantagens.add("Elementalista [1 ponto cada]");
        listaVantagens.add("Energia Extra [1 ponto]");
        listaVantagens.add("Energia Extra [2 pontos]");
        listaVantagens.add("Energia Vital [2 pontos]");
        listaVantagens.add("Familiar [1 ponto]");
        listaVantagens.add("1 Forma Alternativa [2 pontos]");
        listaVantagens.add("2 Formas Alternativas [4 pontos]");
        listaVantagens.add("3 Formas Alternativas [6 pontos]");
        listaVantagens.add("Genialidade [1 ponto]");
        listaVantagens.add("Imortal [1 ponto]");
        listaVantagens.add("Imortal [2 pontos]");
        listaVantagens.add("1 Inimigo [1 ponto]");
        listaVantagens.add("2 Inimigos [2 pontos]");
        listaVantagens.add("3 Inimigos [3 pontos]");
        listaVantagens.add("Invisibilidade [2 pontos]");
        listaVantagens.add("Ligação Natural [1 ponto]");
        listaVantagens.add("Magia Branca [2 pontos]");
        listaVantagens.add("Magia Elemental [2 pontos]");
        listaVantagens.add("Magia Negra [2 pontos]");
        listaVantagens.add("Magia Irresistível [1 ponto]");
        listaVantagens.add("Magia Irresistível [2 pontos]");
        listaVantagens.add("Magia Irresistível [3 pontoss]");
        listaVantagens.add("Membros Elásticos [1 ponto]");
        listaVantagens.add("1 Membro Extra [2 pontos]");
        listaVantagens.add("2 Membros Extras [4 pontos]");
        listaVantagens.add("3 Membros Extras [6 pontos]");
        listaVantagens.add("Memória Expandida [2 pontos]");
        listaVantagens.add("Mentor [1 ponto]");
        listaVantagens.add("Paladino [1 ponto]");
        listaVantagens.add("Paralisia [1 ponto]");
        listaVantagens.add("1 Parceiro [1 ponto]");
        listaVantagens.add("2 Parceiros [2 pontos]");
        listaVantagens.add("3 Parceiros [3 pontos]");
        listaVantagens.add("Patrono [1 ponto]");
        listaVantagens.add("Poder Oculto [1 ponto]");
        listaVantagens.add("1 Ponto de Magia Extra [1 ponto]");
        listaVantagens.add("2 Pontos de Magia Extras [2 pontos]");
        listaVantagens.add("3 Pontos de Magia Extras [3 pontos]");
        listaVantagens.add("1 Ponto de Vida Extra [1 ponto]");
        listaVantagens.add("2 Pontos de Vida Extras [2 pontos]");
        listaVantagens.add("3 Pontos de Vida Extras [3 pontos]");
        listaVantagens.add("Possessão [2 pontos]");
        listaVantagens.add("Reflexão [2 pontos]");
        listaVantagens.add("Regeneração [3 pontos]");
        listaVantagens.add("Resistência à Magia [1 ponto]");
        listaVantagens.add("Riqueza [2 pontos]");
        listaVantagens.add("Sentidos Especiais [1 ponto]");
        listaVantagens.add("Sentidos Especiais [2 pontos]");
        listaVantagens.add("Separação [2 pontos]");
        listaVantagens.add("Telepatia [1 ponto]");
        listaVantagens.add("Teleporte [2 pontos]");
        listaVantagens.add("Tiro Carregável [1 ponto]");
        listaVantagens.add("Tiro Múltiplo [2 pontos]");
        listaVantagens.add("Toque de Energia [1 ponto]");
        listaVantagens.add("2 Toques de Energia [2 pontos]");
        listaVantagens.add("3 Toques de Energia [3 pontos]");
        listaVantagens.add("Torcida [1 ponto]");
        listaVantagens.add("Voo [2 pontos]");
        listaVantagens.add("Xamã [1 ponto]");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (view.getContext(), R.layout.layout_custom_spinner, listaVantagens);
        dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
        spinner2.setAdapter(dataAdapter);
        spinner3.setAdapter(dataAdapter);
        spinner4.setAdapter(dataAdapter);

        List<String> listaDesvantagens = new ArrayList();
        listaDesvantagens.add("");
        listaDesvantagens.add("Ambiente Especial [-1 ponto]");
        listaDesvantagens.add("Assombrado [-2 pontos]");
        listaDesvantagens.add("Bateria [-1 ponto]");
        listaDesvantagens.add("Código de Honra [-1 ponto]");
        listaDesvantagens.add("Deficiência Física [-1 ponto]");
        listaDesvantagens.add("Deficiência Física [-2 pontos]");
        listaDesvantagens.add("Dependência [-2 pontos]");
        listaDesvantagens.add("Devoção [-1 ponto]");
        listaDesvantagens.add("Fetiche [-1 ponto]");
        listaDesvantagens.add("Fúria [-1 ponto]");
        listaDesvantagens.add("Inculto [-1 ponto]");
        listaDesvantagens.add("Insano [-1 ponto]");
        listaDesvantagens.add("Insano [-2 pontos]");
        listaDesvantagens.add("Insano [-3 pontos]");
        listaDesvantagens.add("Interferência [0 pontos]");
        listaDesvantagens.add("Interferência Mágica [0 pontos]");
        listaDesvantagens.add("Má Fama [-1 ponto]");
        listaDesvantagens.add("Maldição [-1 ponto]");
        listaDesvantagens.add("Maldição [-2 pontos]");
        listaDesvantagens.add("Modelo Especial [-1 ponto]");
        listaDesvantagens.add("Monstruoso [-1 ponto]");
        listaDesvantagens.add("Munição Limitada [-1 ponto]");
        listaDesvantagens.add("Poder Vergonhoso -Agradável [-1 ponto]");
        listaDesvantagens.add("Poder Vergonhoso -Constrangedor [-1 ponto]");
        listaDesvantagens.add("Poder Vergonhoso -Exagerado [-1 ponto]");
        listaDesvantagens.add("Poder Vergonhoso -Hentai [0 pontos]");
        listaDesvantagens.add("Poder Vingativo [-1 ponto]");
        listaDesvantagens.add("Ponto Fraco [-1 ponto]");
        listaDesvantagens.add("Protegido Indefeso [-1 ponto]");
        listaDesvantagens.add("Restrição de Poder -Incomum [-1 ponto]");
        listaDesvantagens.add("Restrição de Poder -Comum [-2 pontos]");
        listaDesvantagens.add("Restrição de Poder -Muito Comum [-3 pontos]");

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>
                (view.getContext(), R.layout.layout_custom_spinner, listaDesvantagens);
        dataAdapter2.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        spinner5.setAdapter(dataAdapter2);
        spinner6.setAdapter(dataAdapter2);
        spinner7.setAdapter(dataAdapter2);
        spinner8.setAdapter(dataAdapter2);

        return (view);
    }

       public boolean salvaVantagensEDesvantagens(Ficha personagem){

        String v1 = spinner.getSelectedItem().toString();
        String v2 = spinner2.getSelectedItem().toString();
        String v3 = spinner3.getSelectedItem().toString();
        String v4 = spinner4.getSelectedItem().toString();

        d1 = spinner5.getSelectedItem().toString();
        d2 = spinner6.getSelectedItem().toString();
        d3 = spinner7.getSelectedItem().toString();
        d4 = spinner8.getSelectedItem().toString();


        somaDesvantagens(d1, d2, d3, d4);
           somaVantagens(v1, v2, v3, v4);

        if(MainActivity.pontos < 0){
            //Reseta pontuação
            Log.e("pontos3", ""+MainActivity.pontos);
            MainActivity.pontos += pontosDeVantagem;

            return false;
        } else
        personagem.setVantagensEDesvantagens(v1, v2, v3, v4, d1, d2, d3, d4);
           return true;

    }

    public void somaVantagens(String a1, String a2, String a3, String a4) {

        verificaV(a1);
        verificaV(a2);
        verificaV(a3);
        verificaV(a4);
    }

    public boolean verificaV(String s){
        if(s.contains("1")){
            pontosDeVantagem +=1;
            MainActivity.pontos -= 1;
            return true;
        }
        if(s.contains("2")){
            pontosDeVantagem +=2;
            MainActivity.pontos -= 2;
            return true;
        }
        if(s.contains("3")){
            pontosDeVantagem +=3;
            MainActivity.pontos -= 3;
            return true;
        }
        if(s.contains("4")){
            pontosDeVantagem +=4;
            MainActivity.pontos -= 4;
            return true;
        }

        return false;
    }

    public void somaDesvantagens(String a1, String a2, String a3, String a4) {

        verificaD(a1);
        verificaD(a2);
        verificaD(a3);
        verificaD(a4);
    }

       public boolean verificaD(String s){
        if(s.contains("1")){
            pontosDesvantagens +=1;
            MainActivity.pontos += 1;

            return true;
        }
        if(s.contains("2")){
            pontosDesvantagens +=2;
            MainActivity.pontos += 2;
            return true;
        }
        if(s.contains("3")){
            pontosDesvantagens +=3;
            MainActivity.pontos += 3;
            return true;
        }
        if(s.contains("4")){
            pontosDesvantagens +=4;
            MainActivity.pontos += 4;
            return true;
        }
           return false;
    }

    @Override
    public void onPause() {
        super.onPause();
        d1 = spinner5.getSelectedItem().toString();
        d2 = spinner6.getSelectedItem().toString();
        d3 = spinner7.getSelectedItem().toString();
        d4 = spinner8.getSelectedItem().toString();

        somaDesvantagens(d1, d2, d3, d4);

    }


}

