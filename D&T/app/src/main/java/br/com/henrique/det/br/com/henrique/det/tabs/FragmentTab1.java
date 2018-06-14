package br.com.henrique.det.br.com.henrique.det.tabs;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.henrique.det.Ficha;
import br.com.henrique.det.InternalStorage;
import br.com.henrique.det.R;


public class FragmentTab1 extends Fragment {

    Ficha personagem;
    View v;

    public FragmentTab1(){


    }

    public FragmentTab1(Ficha personagem){

        this.personagem = personagem;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_tab1, container, false);

        exibeCaracteristicas();



        return v;

           }

    public void exibeCaracteristicas(){

        int[] caracteristicas = personagem.getCaracteristicas();
        String[] ats= personagem.getAtualizacoes();

        ((TextView) v.findViewById(R.id.exibeNome)).setText(personagem.getNome());

        ((EditText) v.findViewById(R.id.editForca)).setText(ats[0]);
        ((TextView) v.findViewById(R.id.textForca)).setText(String.valueOf(caracteristicas[0]));

        ((EditText) v.findViewById(R.id.exibeHabilidade)).setText(ats[1]);
        ((TextView) v.findViewById(R.id.textHabilidade)).setText(String.valueOf(caracteristicas[1]));

        ((EditText) v.findViewById(R.id.exibeResistencia)).setText(ats[3]);
        ((TextView) v.findViewById(R.id.textResistencia)).setText(String.valueOf(caracteristicas[3]));

        ((EditText) v.findViewById(R.id.editArmadura)).setText(ats[2]);
        ((TextView) v.findViewById(R.id.textArmadura)).setText(String.valueOf(caracteristicas[2]));

        ((EditText) v.findViewById(R.id.editPDF)).setText(ats[4]);
        ((TextView) v.findViewById(R.id.textPDF)).setText(String.valueOf(caracteristicas[4]));

        ((EditText) v.findViewById(R.id.editPM)).setText(ats[5]);
        ((TextView) v.findViewById(R.id.textPM)).setText(String.valueOf(caracteristicas[5]));

        ((EditText) v.findViewById(R.id.editPV)).setText(ats[6]);
        ((TextView) v.findViewById(R.id.textPV)).setText(String.valueOf(personagem.getVida()));

        ((EditText) v.findViewById(R.id.editEX)).setText(String.valueOf(personagem.getExperiencia()));
    }

    public void salvaAlteracoes(){
        String etForca = ((EditText) v.findViewById(R.id.editForca)).getText().toString();
        String etHabilidade = ((EditText) v.findViewById(R.id.exibeHabilidade)).getText().toString();
        String etResistencia = ((EditText) v.findViewById(R.id.exibeResistencia)).getText().toString();
        String etArmadura = ((EditText) v.findViewById(R.id.editArmadura)).getText().toString();
        String etPDF = ((EditText) v.findViewById(R.id.editPDF)).getText().toString();
        String etMagia = ((EditText) v.findViewById(R.id.editPM)).getText().toString();
        String etVida = ((EditText) v.findViewById(R.id.editPV)).getText().toString();
        String ex = ((EditText) v.findViewById(R.id.editEX)).getText().toString();

        personagem.setAtualizacoes(etForca, etHabilidade, etResistencia, etArmadura, etPDF, etMagia, etVida);
        personagem.setExperiencia(Integer.parseInt(ex));
        InternalStorage.replaceFicha(getActivity(), personagem);
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
                                    salvaAlteracoes();
                                    Toast.makeText(getActivity(), "Alterações Salvas", Toast.LENGTH_SHORT).show();

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

}
