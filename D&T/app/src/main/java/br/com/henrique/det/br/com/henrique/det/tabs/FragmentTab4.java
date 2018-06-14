package br.com.henrique.det.br.com.henrique.det.tabs;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import br.com.henrique.det.Ficha;
import br.com.henrique.det.InternalStorage;
import br.com.henrique.det.R;



public class FragmentTab4 extends Fragment {

    private final Ficha character;
    private View v;

    public FragmentTab4(Ficha character) {
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


        v =  inflater.inflate(R.layout.fragment_tab4, container, false);

        exibeDinheiroEItens();

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
        String di = ((EditText) v.findViewById(R.id.exibeItens)).getText().toString();

        character.setItensEHistoria(di, character.getHistoria());
        InternalStorage.replaceFicha(getActivity(), character);
        Toast.makeText(getActivity(), "Alterações Salvas", Toast.LENGTH_SHORT).show();
    }

    public void exibeDinheiroEItens(){

        ((EditText) v.findViewById(R.id.exibeItens)).setText(character.getItens());
        ((EditText) v.findViewById(R.id.exibeHistoria)).setText(character.getHistoria());

    }

}
