package br.com.henrique.det.br.com.henrique.det.tabs;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import br.com.henrique.det.Ficha;
import br.com.henrique.det.InternalStorage;
import br.com.henrique.det.R;

public class FragmentTab2 extends Fragment {

    private Ficha character;
    private View v;

    private Spinner spinner;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    private Spinner spinner5;
    private Spinner spinner6;
    private Spinner spinner7;
    private Spinner spinner8;


    public FragmentTab2(Ficha character) {

        this.character = character;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        v =  inflater.inflate(R.layout.fragment_tab2, container, false);

        exibeVans();
        exibeDes();

        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater mi) {
        // Inflate the menu; this adds items to the action bar if it is present.
        mi.inflate(R.menu.menu_tabs, menu);
        super.onCreateOptionsMenu(menu, mi);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.alterar) {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
            alertDialogBuilder.setTitle("Deseja salvar as alterações?");
            alertDialogBuilder
                    .setCancelable(false)
                    .setPositiveButton("Salvar",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int id) {
                                    salvarAlteracoes();


                                }
                            })
                    .setNegativeButton("Cancelar",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int id) {
                                    dialog.cancel();
                                }
                            });
            alertDialogBuilder.create().show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void salvarAlteracoes(){
        String v1 = spinner.getSelectedItem().toString();
        String v2 = spinner2.getSelectedItem().toString();
        String v3 = spinner3.getSelectedItem().toString();
        String v4 = spinner4.getSelectedItem().toString();

        String d1 = spinner5.getSelectedItem().toString();
        String d2 = spinner6.getSelectedItem().toString();
        String d3 = spinner7.getSelectedItem().toString();
        String d4 = spinner8.getSelectedItem().toString();

        character.setVantagensEDesvantagens(v1, v2, v3, v4, d1, d2, d3, d4);
        InternalStorage.replaceFicha(getActivity(), character);

        Toast.makeText(getActivity(), "Alterações Salvas", Toast.LENGTH_SHORT).show();
    }

    public void exibeVans(){

        String[] vans = character.getVantagens();

        spinner = (Spinner) v.findViewById(R.id.exibeV1);
        spinner2 = (Spinner) v.findViewById(R.id.exibeV2);
        spinner3 = (Spinner) v.findViewById(R.id.exibeV3);
        spinner4 = (Spinner) v.findViewById(R.id.exibeV4);

        List<String> list = new ArrayList<String>();
        list.add(vans[0]);
        List<String> list1 = new ArrayList<String>();
        list1.add(vans[1]);
        List<String> list2 = new ArrayList<String>();
        list2.add(vans[2]);
        List<String> list3 = new ArrayList<String>();
        list3.add(vans[3]);

        if(TextUtils.isEmpty(vans[0])){
            list = new ArrayList<String>();
            populaSpinnerVantagensVazio(list);
        }
        if(TextUtils.isEmpty(vans[1])){
            list1 = new ArrayList<String>();
            populaSpinnerVantagensVazio(list1);
        }
        if(TextUtils.isEmpty(vans[2])){
            list2 = new ArrayList<String>();
            populaSpinnerVantagensVazio(list2);
        }
        if(TextUtils.isEmpty(vans[3])){
            list3 = new ArrayList<String>();
            populaSpinnerVantagensVazio(list3);
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (v.getContext(), R.layout.layout_custom_spinner, list);
        dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>
                (v.getContext(), R.layout.layout_custom_spinner, list1);
        dataAdapter1.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>
                (v.getContext(), R.layout.layout_custom_spinner, list2);
        dataAdapter2.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>
                (v.getContext(), R.layout.layout_custom_spinner, list3);
        dataAdapter3.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
        spinner2.setAdapter(dataAdapter1);
        spinner3.setAdapter(dataAdapter2);
        spinner4.setAdapter(dataAdapter3);

    }

    public void populaSpinnerDesvantagensVazio(List<String> listaDesvantagens){
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
    }

    public void populaSpinnerVantagensVazio(List<String> listaVantagens){
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
    }

    public void exibeDes(){

        String[] des = character.getDesvantagens();

        spinner5 = (Spinner) v.findViewById(R.id.exibeD1);
        spinner6 = (Spinner) v.findViewById(R.id.exibeD2);
        spinner7 = (Spinner) v.findViewById(R.id.exibeD3);
        spinner8 = (Spinner) v.findViewById(R.id.exibeD4);

        List<String> list = new ArrayList<String>();
        list.add(des[0]);
        List<String> list1 = new ArrayList<String>();
        list1.add(des[1]);
        List<String> list2 = new ArrayList<String>();
        list2.add(des[2]);
        List<String> list3 = new ArrayList<String>();
        list3.add(des[3]);

        if(TextUtils.isEmpty(des[0])){
            list = new ArrayList<String>();
            populaSpinnerDesvantagensVazio(list);
        }
        if(TextUtils.isEmpty(des[1])){
            list1 = new ArrayList<String>();
            populaSpinnerDesvantagensVazio(list1);
        }
        if(TextUtils.isEmpty(des[2])){
            list2 = new ArrayList<String>();
            populaSpinnerDesvantagensVazio(list2);
        }
        if(TextUtils.isEmpty(des[3])){
            list3 = new ArrayList<String>();
            populaSpinnerDesvantagensVazio(list3);
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (v.getContext(), R.layout.layout_custom_spinner, list);
        dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>
                (v.getContext(), R.layout.layout_custom_spinner, list1);
        dataAdapter1.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>
                (v.getContext(), R.layout.layout_custom_spinner, list2);
        dataAdapter2.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>
                (v.getContext(), R.layout.layout_custom_spinner, list3);
        dataAdapter3.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        spinner5.setAdapter(dataAdapter);
        spinner6.setAdapter(dataAdapter1);
        spinner7.setAdapter(dataAdapter2);
        spinner8.setAdapter(dataAdapter3);
    }


}
