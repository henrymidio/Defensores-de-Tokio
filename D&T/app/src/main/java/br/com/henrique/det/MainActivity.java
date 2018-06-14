package br.com.henrique.det;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.com.henrique.det.br.com.henrique.det.fragmentos.Fragment02;
import br.com.henrique.det.br.com.henrique.det.fragmentos.fragment01;
import br.com.henrique.det.br.com.henrique.det.fragmentos.Fragment03;
import br.com.henrique.det.br.com.henrique.det.fragmentos.Fragment04;



public class MainActivity extends ActionBarActivity {

    //Marca posição do Fragment visualizado
    private int tab = 1;

    private FragmentManager fm = getFragmentManager();
    private Menu menu;

    public static int pontos;

    private fragment01 fragmentMain = new fragment01();
    private Fragment02 fragmentTab02 = new Fragment02();
    private Fragment03 fragmentTab03 = new Fragment03();
    private Fragment04 fragmentTab04 = new Fragment04();

    private Ficha ficha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar bar = getActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0d6ca0")));
        bar.setTitle("D&T");

        ficha = new Ficha();
        pontos = getIntent().getExtras().getInt("pontos");

        if (savedInstanceState == null) {
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.scroll, fragmentMain);
            ft.commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Alterna a posição dos fragments a medida que salva os dados do personagem
        //que está sendo criado

        int id = item.getItemId();

        if (id == R.id.avancar && tab == 1) {

            if (fragmentMain.salvarCaracteristicas(ficha)) {
                alternarFragment(fragmentTab02);
                return true;
            } else {
                Toast.makeText(this, "Você ultrapassou o limite de pontos", Toast.LENGTH_LONG).show();
            }
        }

        if (id == R.id.avancar && tab == 2) {
            if(fragmentTab02.salvaVantagensEDesvantagens(ficha)){
                alternarFragment(fragmentTab03);
                return true;
            } else {
                Toast.makeText(this, "Você ultrapassou o limite de pontos", Toast.LENGTH_LONG).show();
            }

        }

        if (id == R.id.avancar && tab == 3) {


            fragmentTab03.setaTiposDeDanoEMagiasConhecidas(ficha);
            alternarFragment(fragmentTab04);
            item.setIcon(R.drawable.ic_action_accept);
            return true;
        }

        //Finaliza criação do personagem e salva no storage
        if (id == R.id.avancar && tab == 4) {

            fragmentTab04.setaItensEHistoria(ficha);
            ficha.criaPersonagem();

            if (salvaFichaPersonagem()) {
                Intent intent = new Intent().setClass(this, Tabs.class);
                intent.putExtra("personagem", ficha);
                startActivity(intent);
            }

        }

        return super.onOptionsItemSelected(item);
    }

    public void alternarFragment(Fragment fragmento) {
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.scroll, fragmento);
        ft.addToBackStack(null);
        ft.commit();
        tab += 1;
    }

    @Override
    public void onBackPressed() {

        if (fm.getBackStackEntryCount() > 0) {
            tab -= 1;
            fm.popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    public boolean salvaFichaPersonagem() {

        List<Ficha> fichas = new ArrayList<Ficha>();

        if (InternalStorage.fileExistance(this)) {

            try {

                fichas = (List<Ficha>)InternalStorage.readObject(this, "personagens");
                fichas.add(ficha);
                InternalStorage.writeObject(this, "personagens", fichas);
                Toast.makeText(this, "Ficha Salva", Toast.LENGTH_LONG).show();
                return true;

            } catch (Exception c) {
                Toast.makeText(this, "Erro ao salvar ficha", Toast.LENGTH_LONG).show();
                c.printStackTrace();

                return false;
            }
        } else

            try {
                fichas.add(ficha);
                InternalStorage.writeObject(this, "personagens", fichas);
                Toast.makeText(this, "Ficha Salva 2", Toast.LENGTH_LONG).show();
                return true;
            } catch (Exception exc) {
                Toast.makeText(this, "Erro ao salvar ficha", Toast.LENGTH_LONG).show();
                exc.printStackTrace();

                return false;
            }

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}


